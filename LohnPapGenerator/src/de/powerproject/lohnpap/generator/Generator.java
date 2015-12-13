package de.powerproject.lohnpap.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Marcel Lehmann
 *
 */

public class Generator {

	public static void main(String[] args) throws Exception {

		String projectDir = new File(".").getCanonicalPath();

		File xmlDir = new File(getFilePath(projectDir, "src", "de", "powerproject", "lohnpap", "xml"));
		File targetDir = new File(getFilePath(projectDir, "src", "de", "powerproject", "lohnpap"));

		File[] files = xmlDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name != null && name.endsWith(".xml");
			}
		});

		for (File xml : files) {
			Generator g = new Generator(xml, targetDir);
			g.parse();
		}
	}

	private static String getFilePath(String... elems) {

		StringBuilder sb = new StringBuilder();
		for (String e : elems) {
			sb.append(e);
			sb.append(File.separatorChar);
		}
		return sb.toString();
	}

	protected File xml, path;
	protected FileWriter fw;
	protected boolean failed = false;

	public Generator(File xml, File path) throws IOException {
		this.xml = xml;
		this.path = path;
	}

	private void parse() throws Exception {

		System.out.println("parse file " + xml.getName());

		SAXParserFactory f = SAXParserFactory.newInstance();
		SAXParser p = f.newSAXParser();

		p.setProperty("http://xml.org/sax/properties/lexical-handler", new PAPCommentReader());

		PapHandler h = new PapHandler();
		p.parse(xml, h);
		if (failed) {
			throw new IOException("error occurred");
		}
	}

	private void writeln() {
		write(null, true, true);
	}

	private void writeln(String s) {
		write(s, true, true);
	}

	private void write(String s) {
		write(s, true, false);
	}

	private void append(String s) {
		write(s, false, false);
	}

	private void appendln() {
		write(null, false, true);
	}

	private void write(String s, boolean tab, boolean newLine) {

		try {

			if (tab) {
				for (int i = 0; i < indent; i++) {
					fw.append('\t');
				}
			}

			if (s != null) {
				fw.append(s);
			}

			if (newLine) {
				fw.append('\n');
			}

		} catch (IOException e) {
			e.printStackTrace();
			failed = true;
		}
	}

	private int indent = 0;
	private boolean variables, constants, methods, method;

	class PapHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {

			try {
				if ("PAP".equals(qName)) {
					String name = attributes.getValue("name");
					fw = new FileWriter(path + File.separator + name + ".java");
					writeln("package de.powerproject.lohnpap;");
					writeln();
					writeln("import java.math.BigDecimal;");
					writeln();
					writeln("/**");
					writeln(" * ");
					writeln(" * @author Lohnsteuer Generator by Marcel Lehmann (power-project.de) ");
					writeln(" * @date " + new Date());
					writeln(" * ");
					writeln(" */");
					writeln();
					writeln("public class " + attributes.getValue("name") + " {");
					appendln();
					indent++;
				} else if ("VARIABLES".equals(qName)) {
					variables = true;
				} else if ("CONSTANTS".equals(qName)) {
					constants = true;
				} else if ("METHODS".equals(qName)) {
					methods = true;
				} else if ("INPUT".equals(qName) || "OUTPUT".equals(qName) || "INTERNAL".equals(qName)) {
					if (variables) {
						String type = attributes.getValue("type");
						String name = attributes.getValue("name");
						String def = attributes.getValue("default");
						if (def == null) {
							if ("BigDecimal".equals(type)) {
								def = "new BigDecimal(0)";
							} else {
								def = "0";
							}
						}
						if ("int".equals(type)) {
							def = "" + Double.valueOf(def).intValue();
						}

						writeln("public " + type + " " + name + " = " + def + ";");
					}
				} else if ("CONSTANT".equals(qName)) {
					if (constants) {
						String type = attributes.getValue("type");
						String name = attributes.getValue("name");
						String value = attributes.getValue("value");
						writeln("private static final " + type + " " + name + " = " + value + ";");
					}
				} else if ("MAIN".equals(qName)) {
					if (methods) {
						writeln("public void main() {");
						indent++;
					}
				} else if ("EXECUTE".equals(qName)) {
					String method = attributes.getValue("method");
					appendln();
					write(method + "();");
				} else if ("METHOD".equals(qName)) {
					String methodName = attributes.getValue("name");
					writeln("private void " + methodName + "() {");
					method = true;
					indent++;
				} else if ("EVAL".equals(qName)) {
					String exec = attributes.getValue("exec");
					appendln();
					write(exec + ";");
				} else if ("IF".equals(qName)) {
					String expr = attributes.getValue("expr");
					appendln();
					write("if(" + expr + ") ");
				} else if ("THEN".equals(qName)) {
					append("{");
					indent++;
				} else if ("ELSE".equals(qName)) {
					append(" else {");
					indent++;
				}

			} catch (Exception e) {
				e.printStackTrace();
				failed = true;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			try {
				if ("PAP".equals(qName)) {
					indent--;
					write("}");
					fw.close();
				} else if ("VARIABLES".equals(qName)) {
					variables = false;
				} else if ("CONSTANTS".equals(qName)) {
					constants = false;
					appendln();
				} else if ("METHODS".equals(qName)) {
					methods = false;
				} else if ("METHOD".equals(qName)) {
					indent--;
					method = false;
					appendln();
					writeln("}");
					appendln();
				} else if ("MAIN".equals(qName)) {
					indent--;
					appendln();
					writeln("}");
					appendln();
					methods = false;
				} else if ("THEN".equals(qName) || "ELSE".equals(qName)) {
					indent--;
					appendln();
					write("}");
				}
			} catch (Exception e) {
				e.printStackTrace();
				failed = true;
			}
		}
	}

	class PAPCommentReader implements LexicalHandler {

		private int count = 0;

		@Override
		public void startDTD(String name, String publicId, String systemId) throws SAXException {
		}

		@Override
		public void endDTD() throws SAXException {
		}

		@Override
		public void startEntity(String name) throws SAXException {
		}

		@Override
		public void endEntity(String name) throws SAXException {
		}

		@Override
		public void startCDATA() throws SAXException {
		}

		@Override
		public void endCDATA() throws SAXException {
		}

		@Override
		public void comment(char[] ch, int start, int length) throws SAXException {

			count++;

			if (count > 2 && (variables || constants)) {
				appendln();
			}

			String comment = new String(ch, start, length);
			comment = comment.replace("\n", "<br>\n");

			if (method) {
				append("/** " + comment + "*/");
			} else {
				writeln("/** " + comment + "*/");
			}
		}
	}
}