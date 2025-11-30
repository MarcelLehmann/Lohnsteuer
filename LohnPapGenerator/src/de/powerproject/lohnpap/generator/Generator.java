package de.powerproject.lohnpap.generator;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * Copyright 2015-2016 Marcel Lehmann
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * 
 * @author Marcel Lehmann
 */

public class Generator {

	public static final List<PapFile> PAP_FILES;

	static {
		PAP_FILES = new ArrayList<>();
		// neueste Eintrag immer oben und Ende = null
		PAP_FILES.add(new PapFile("Lohnsteuer2026.xml", 2026, 1, null));
		PAP_FILES.add(new PapFile("Lohnsteuer2025.xml", 2025, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2024Dezember.xml", 2024, 12, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2024.xml", 2024, 1, 11));
		PAP_FILES.add(new PapFile("Lohnsteuer2023AbJuli.xml", 2023, 7, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2023.xml", 2023, 1, 6));
		PAP_FILES.add(new PapFile("Lohnsteuer2022.xml", 2022, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2021.xml", 2021, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2020.xml", 2020, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2019.xml", 2019, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2018.xml", 2018, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2017.xml", 2017, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2016.xml", 2016, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2015Dezember.xml", 2015, 12, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2015.xml", 2015, 1, 11));
		PAP_FILES.add(new PapFile("Lohnsteuer2014.xml", 2014, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2013.xml", 2013, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2012.xml", 2012, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2011Dezember.xml", 2011, 12, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2011.xml", 2011, 1, 11));
		PAP_FILES.add(new PapFile("Lohnsteuer2010.xml", 2010, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2009.xml", 2009, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2008.xml", 2008, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2007.xml", 2007, 1, 12));
		PAP_FILES.add(new PapFile("Lohnsteuer2006.xml", 2006, 1, 12));
	}

	private static final Map<String, String> inputInterfaceVars = new HashMap<>();
	private static final Map<String, String> outputInterfaceVars = new HashMap<>();
	private static boolean interfaceGenerated = false;

	public static void main(String[] args) throws Exception {

		String projectDir = new File(".").getCanonicalPath();
		File targetDir = getFile(projectDir, "src", "de", "powerproject", "lohnpap");

		for (PapFile pf : PAP_FILES) {

			Generator g = new Generator(pf, targetDir);
			g.parse();
		}

		PapWrapperWriter pw = new PapWrapperWriter(getFilePath(targetDir.getCanonicalPath(), "pap", "Lohnsteuer.java"));
		pw.close();
	}

	private static String getFilePath(String... elems) {

		StringBuilder sb = new StringBuilder();
		for (String e : elems) {
			sb.append(e);
			sb.append(File.separatorChar);
		}
		return sb.toString();
	}

	private static File getFile(String... elems) {

		return new File(getFilePath(elems));
	}

	public static String firstUpper(String s) {

		if (s != null) {
			if (s.length() == 1) {
				return s.toUpperCase();
			} else if (s.length() > 1) {
				return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
			}
		}
		return s;
	}

	protected File path;
	protected PapFile pf;
	protected PapWriter pw;
	protected PapInterfaceWriter piw;

	protected boolean failed = false;

	public Generator(PapFile pf, File path) throws Exception {

		this.pf = pf;
		this.path = path;

		if (pf.to == null) {

			if (interfaceGenerated) {
				throw new Exception("interface generation only for current version! check config");
			}

			// generate interface for current version
			interfaceGenerated = true;
			piw = new PapInterfaceWriter(getFilePath(path.getCanonicalPath(), "pap", "LohnsteuerInterface.java"));
		}
	}

	private void parse() throws Exception {

		System.out.println("parse file " + pf.xmlfileName);

		File file = getFile(path.getCanonicalPath(), "xml", pf.xmlfileName);

		SAXParserFactory f = SAXParserFactory.newInstance();
		SAXParser p = f.newSAXParser();

		p.setProperty("http://xml.org/sax/properties/lexical-handler", new PAPCommentReader());

		PapHandler h = new PapHandler();
		p.parse(file, h);

		if (piw != null) {
			piw.close();
		}

		if (failed) {
			throw new IOException("error occurred");
		}
	}

	private boolean variables, constants, methods, method;
	private Map<String, String> inputVars = new HashMap<>();
	private Map<String, String> outputVars = new HashMap<>();
	private Map<String, String> internalVars = new HashMap<>();
	private String lastComment = null;

	protected void printLastComment(AbstractWriter writer) throws IOException {

		if (lastComment != null) {
			if (writer != null && !lastComment.isEmpty()) {
				writer.appendln();
				writer.writeln("/** " + lastComment + " */");
			}
			lastComment = null;
		}
	}

	class PapHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {

			try {
				if ("PAP".equals(qName)) {
					String internalName = attributes.getValue("name");
					pw = new PapWriter(pf, path, internalName);
				} else if ("VARIABLES".equals(qName)) {
					variables = true;
				} else if ("CONSTANTS".equals(qName)) {
					constants = true;
					pw.appendln();
					pw.writeln("/* KONSTANTEN */");
				} else if ("METHODS".equals(qName)) {
					methods = true;

					pw.writeln("/* SETTER */");

					for (Entry<String, String> e : inputVars.entrySet()) {
						pw.appendln();
						if (inputInterfaceVars.containsKey(e.getKey())) {
							pw.writeln("@Override");
						}
						pw.writeln(e.getValue());
					}
					for (Entry<String, String> e : inputInterfaceVars.entrySet()) {
						String name = e.getKey();
						if (!inputVars.containsKey(name)) {
							pw.appendln();
							pw.writeln("@Override");
							if (internalVars.containsKey(name)) {
								pw.writeln(e.getValue() + " { this." + internalVars.get(name) + " = arg0 }");
							} else {
								pw.writeln(e.getValue() + " { /* required for newer calculator */ }");
							}
						}
					}

					pw.appendln();
					pw.writeln("/* GETTER */");

					for (Entry<String, String> e : outputVars.entrySet()) {
						pw.appendln();
						if (outputInterfaceVars.containsKey(e.getKey())) {
							pw.writeln("@Override");
						}
						pw.writeln(e.getValue());
					}
					for (Entry<String, String> e : outputInterfaceVars.entrySet()) {
						String name = e.getKey();
						if (!outputVars.containsKey(name)) {
							pw.appendln();
							pw.writeln("@Override");
							if (internalVars.containsKey(name)) {
								pw.writeln(e.getValue() + " { return " + internalVars.get(name) + "; }");
							} else {
								pw.writeln(e.getValue() + " { /* required for newer calculator */ return null; }");
							}
						}
					}

					pw.appendln();

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
						if ("BigDecimal".equals(type)) {
							if (!def.contains("BigDecimal")) {
								def = "new BigDecimal(" + def + ")";
							}
						} else if ("int".equals(type)) {
							def = String.valueOf(Double.valueOf(def).intValue());
						}

						if ("INTERNAL".equals(qName)) {
							internalVars.put(firstUpper(name), name);
							printLastComment(pw);
						}

						pw.writeln("protected " + type + " " + name + " = " + def + ";");

						if ("INPUT".equals(qName)) {
							String uname = firstUpper(name);
							String pre = "public void set" + uname + "(" + type + " arg0)";
							inputVars.put(uname, pre + " { this." + name + " = arg0" + "; }");
							printLastComment(piw);
							if (piw != null) {
								piw.writeln(pre + ";");
								inputInterfaceVars.put(uname, pre);
							}
						} else if ("OUTPUT".equals(qName)) {
							String uname = firstUpper(name);
							String pre = "public " + type + " get" + uname + "()";
							outputVars.put(uname, pre + " { return this." + name + "; }");
							printLastComment(piw);
							if (piw != null) {
								piw.writeln(pre + ";");
								outputInterfaceVars.put(uname, pre);
							}
						}
					}
				} else if ("CONSTANT".equals(qName)) {
					if (constants) {
						String type = attributes.getValue("type");
						String name = attributes.getValue("name");
						String value = attributes.getValue("value");
						pw.writeln("protected static final " + type + " " + name + " = " + value + ";");
					}
				} else if ("MAIN".equals(qName)) {
					if (methods) {
						pw.writeln("@Override");
						pw.writeln("public void main() {");
						pw.incIndent();
					}
				} else if ("EXECUTE".equals(qName)) {
					String method = attributes.getValue("method");
					pw.appendln();
					pw.write(method + "();");
				} else if ("METHOD".equals(qName)) {
					String methodName = attributes.getValue("name");
					pw.writeln("protected void " + methodName + "() {");
					method = true;
					pw.incIndent();
				} else if ("EVAL".equals(qName)) {
					String exec = attributes.getValue("exec");
					pw.appendln();
					pw.write(exec + ";");
				} else if ("IF".equals(qName)) {
					String expr = attributes.getValue("expr");
					pw.appendln();
					pw.write("if(" + expr + ") ");
				} else if ("THEN".equals(qName)) {
					pw.append("{");
					pw.incIndent();
				} else if ("ELSE".equals(qName)) {
					pw.append(" else {");
					pw.incIndent();
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
					pw.close();
				} else if ("VARIABLES".equals(qName)) {
					variables = false;
				} else if ("CONSTANTS".equals(qName)) {
					constants = false;
					pw.appendln();
				} else if ("METHODS".equals(qName)) {
					methods = false;
				} else if ("METHOD".equals(qName)) {
					pw.decIndent();
					method = false;
					pw.appendln();
					pw.writeln("}");
					pw.appendln();
				} else if ("MAIN".equals(qName)) {
					pw.decIndent();
					pw.appendln();
					pw.writeln("}");
					pw.appendln();
					methods = false;
				} else if ("THEN".equals(qName) || "ELSE".equals(qName)) {
					pw.decIndent();
					pw.appendln();
					pw.write("}");
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

			try {

				String comment = new String(ch, start, length).trim();

				if (!comment.isEmpty()) {

					count++;

					if (lastComment != null) {

						printComment(lastComment);
						lastComment = null;
					}

					comment = comment.replace("\n", "<br>\n");

					if (count > 1) {
						if (variables) {
							lastComment = comment;
							return;
						}
					}

					printComment(comment);

				}

			} catch (Exception e) {
				e.printStackTrace();
				failed = true;
			}
		}

		private void printComment(String comment) throws IOException {

			if ("EINGABEPARAMETER".equals(comment) || "AUSGABEPARAMETER".equals(comment)
					|| "AUSGABEPARAMETER DBA".equals(comment)) {
				pw.appendln();
				pw.writeln("/* " + comment + "*/");
				pw.appendln();
			} else if ("INTERNE FELDER".equals(comment)) {
				pw.appendln();
				pw.writeln("/* " + comment + "*/");
			} else if (method) {
				pw.append("/** " + comment + " */");
			} else if (constants) {
				pw.appendln();
				pw.writeln("/** " + comment + " */");
			} else {
				pw.writeln("/** " + comment + " */");
			}
		}
	}
}

class PapInterfaceWriter extends AbstractWriter {

	public PapInterfaceWriter(String fileName) throws IOException {

		super(fileName);

		writeln("package de.powerproject.lohnpap.pap;");
		writeln();
		writeln("import java.math.BigDecimal;");
		writeln();
		writeln("/**");
		writeln(" * ");
		writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) ");
		writeln(" * @date " + new Date());
		writeln(" * ");
		writeln(" */");
		writeln();
		writeln("public interface LohnsteuerInterface {");

		incIndent();

		writeln();
		writeln("public void main();");
	}

	@Override
	public void close() throws IOException {

		decIndent();

		writeln("}");

		super.close();
	}
}

class PapWrapperWriter extends AbstractWriter {

	public PapWrapperWriter(String fileName) throws IOException {

		super(fileName);

		writeln("package de.powerproject.lohnpap.pap;");
		writeln();
		writeln("import java.util.Date;");
		writeln("import java.util.Calendar;");
		writeln();
		writeln("/**");
		writeln(" * ");
		writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer)");
		writeln(" * @date " + new Date());
		writeln(" * ");
		writeln(" */");
		writeln();
		writeln("public class Lohnsteuer {");
		appendln();
		incIndent();

		writeln("public static LohnsteuerInterface getInstance() {");
		writeln("	return getInstance(null);");
		writeln("}");

		appendln();

		writeln("public static LohnsteuerInterface getInstance(Date date) {");
		incIndent();
		appendln();

		writeln("Calendar cal = Calendar.getInstance();");
		writeln("if (date != null) {");
		incIndent();
		writeln("cal.setTime(date);");
		decIndent();
		writeln("}");
		writeln("int year = cal.get(Calendar.YEAR);");
		writeln("int month = cal.get(Calendar.MONTH) + 1;");

		appendln();

		PapFile last = null;

		for (PapFile pap : Generator.PAP_FILES) {

			if (pap.to == null) {

				last = pap;

				writeln("if ((year == " + pap.year + " && month >= " + pap.from + ") || year > " + pap.year + ") {");
				writeln("	return new " + pap.name + "();");
				writeln("}");

			} else if (pap.from == pap.to) {

				writeln("if (year == " + pap.year + " && month == " + pap.from + ") {");
				writeln("	return new " + pap.name + "();");
				writeln("}");

			} else {

				writeln("if (year == " + pap.year + " && month >= " + pap.from + " && month <= " + pap.to + ") {");
				writeln("	return new " + pap.name + "();");
				writeln("}");

			}
		}

		writeln("throw new IllegalArgumentException(\"Illegal Date \" + date + \"\");");

		decIndent();
		writeln("}");
	}

	@Override
	public void close() throws IOException {

		decIndent();

		write("}");

		super.close();
	}
}

class PapWriter extends AbstractWriter {

	private String className, internalName;

	public PapWriter(PapFile p, File targetDir, String internalName) throws IOException {

		super(targetDir + File.separator + "pap" + File.separator + p.name + ".java");
		this.className = p.name;
		this.internalName = internalName;

		writeln("package de.powerproject.lohnpap.pap;");
		writeln();
		writeln("import java.math.BigDecimal;");
		writeln();
		writeln("/**");
		writeln(" * ");
		writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) ");
		writeln(" * @date " + new Date());
		writeln(" * ");
		writeln(" */");
		writeln();
		writeln("public class " + p.name + " implements LohnsteuerInterface {");
		appendln();
		incIndent();
	}

	@Override
	protected void write(String s, boolean tab, boolean newLine) throws IOException {

		if (s != null && internalName != null) {
			s = s.replace(internalName, className);
		}

		super.write(s, tab, newLine);
	}

	@Override
	public void close() throws IOException {

		decIndent();

		write("}");

		super.close();
	}
}

abstract class AbstractWriter implements Closeable {

	private FileWriter fw;
	private int indent = 0;

	public AbstractWriter(String fileName) throws IOException {
		this.fw = new FileWriter(fileName);
	}

	public void writeln() throws IOException {
		write(null, true, true);
	}

	public void writeln(String s) throws IOException {
		write(s, true, true);
	}

	public void write(String s) throws IOException {
		write(s, true, false);
	}

	public void append(String s) throws IOException {
		write(s, false, false);
	}

	public void appendln() throws IOException {
		write(null, false, true);
	}

	protected void write(String s, boolean tab, boolean newLine) throws IOException {

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
	}

	public void incIndent() {
		this.indent++;
	}

	public void decIndent() {
		this.indent--;
	}

	@Override
	public void close() throws IOException {
		fw.close();
	}
}
