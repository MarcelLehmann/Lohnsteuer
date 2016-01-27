package de.powerproject.lohnpap.generator;

public class PapFile {

	String xmlfileName, name;
	int year, from;
	Integer to;

	public PapFile(String xmlfileName, int year, int from, Integer to) {

		this.xmlfileName = xmlfileName;
		this.name = xmlfileName.replace(".xml", "");
		this.year = year;
		this.from = from;
		this.to = to;
	}

	public String getXmlfileName() {
		return xmlfileName;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getFrom() {
		return from;
	}

	public Integer getTo() {
		return to;
	}
}