package de.powerproject.lohnpap.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Marcel Lehmann
 * @date 2010-01-01
 *
 */

public class Generator {

	public static void main(String[] args) throws Exception {

		String projectDir = new File(".").getCanonicalPath();
		String srcDir = getFilePath(projectDir, "src", "de", "powerproject",
				"lohnpap");

		File xml = new File(srcDir + "Lohnsteuer2015.xml");
		File path = new File(srcDir);

		System.out.println(srcDir);
		System.out.println(xml);

		Generator g = new Generator(xml, path);
		g.parse();
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

		SAXParserFactory f = SAXParserFactory.newInstance();
		SAXParser p = f.newSAXParser();
		PapHandler h = new PapHandler();
		p.parse(xml, h);
		if (failed) {
			throw new IOException("error occurred");
		}
	}

	class PapHandler extends DefaultHandler {

		private boolean variable, constants, methods;

		private int indent = 0;

		private void writeln(String s) {
			write(s, true, true);
		}

		private void write(String s) {
			write(s, true, false);
		}

		private void append(String s) {
			write(s, false, false);
		}

		private void appendln(String s) {
			write(s, false, true);
		}

		private void write(String s, boolean tab, boolean newLine) {

			try {

				if (tab) {
					for (int i = 0; i < indent; i++) {
						fw.append('\t');
					}
				}

				fw.append(s);

				if (newLine) {
					fw.append('\n');
				}

			} catch (IOException e) {
				e.printStackTrace();
				failed = true;
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

			try {
				if ("PAP".equals(qName)) {
					String name = attributes.getValue("name");
					fw = new FileWriter(path + File.separator + name + ".java");
					writeln("package de.powerproject.lohnpap;");
					writeln("");
					writeln("import java.math.BigDecimal;");
					writeln("");
					writeln("/**");
					writeln(" * ");
					writeln(" * @author Lohnsteuer Generator by Marcel Lehmann (power-project.de) ");
					writeln(" * @date " + new Date());
					writeln(" * ");
					writeln(" */");
					writeln("");
					writeln("public class " + attributes.getValue("name")
							+ " {");
					indent++;
				} else if ("VARIABLES".equals(qName)) {
					variable = true;
				} else if ("CONSTANTS".equals(qName)) {
					constants = true;
				} else if ("METHODS".equals(qName)) {
					methods = true;
				} else if ("INPUT".equals(qName) || "OUTPUT".equals(qName)
						|| "INTERNAL".equals(qName)) {
					if (variable) {
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
						appendln("");
						write("public " + type + " " + name + " = " + def + ";");
					}
				} else if ("CONSTANT".equals(qName)) {
					if (constants) {
						String type = attributes.getValue("type");
						String name = attributes.getValue("name");
						String value = attributes.getValue("value");
						appendln("");
						write("private static final " + type + " " + name
								+ " = " + value + ";");
					}
				} else if ("MAIN".equals(qName)) {
					if (methods) {
						appendln("");
						writeln("public void main() {");
						indent++;
					}
				} else if ("EXECUTE".equals(qName)) {
					String method = attributes.getValue("method");
					appendln("");
					write(method + "();");
				} else if ("METHOD".equals(qName)) {
					String method = attributes.getValue("name");
					appendln("");
					writeln("private void " + method + "() {");
					indent++;
				} else if ("EVAL".equals(qName)) {
					String exec = attributes.getValue("exec");
					appendln("");
					write(exec + ";");
				} else if ("IF".equals(qName)) {
					String expr = attributes.getValue("expr");
					appendln("");
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
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			try {
				if ("PAP".equals(qName)) {
					indent--;
					write("}");
					fw.close();
				} else if ("VARIABLES".equals(qName)) {
					appendln("");
					variable = false;
				} else if ("CONSTANTS".equals(qName)) {
					appendln("");
					constants = false;
				} else if ("METHODS".equals(qName)) {
					appendln("");
					methods = false;
				} else if ("METHOD".equals(qName)) {
					indent--;
					appendln("");
					writeln("}");
				} else if ("MAIN".equals(qName)) {
					indent--;
					appendln("");
					writeln("}");
					methods = false;
				} else if ("THEN".equals(qName) || "ELSE".equals(qName)) {
					indent--;
					appendln("");
					write("}");
				}
			} catch (Exception e) {
				e.printStackTrace();
				failed = true;
			}
		}
	}
}