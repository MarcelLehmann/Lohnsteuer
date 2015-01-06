package de.powerproject.lohnpap;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestAufruf extends TestCase {

	public void testLohnsteuer() throws Exception {

		for (int i = 5000; i <= 80000; i += 2500) {

			check(1, new BigDecimal(i * 100), 1);

		}
	}

	/**
	 * 
	 * @param lzz
	 *            (Lohnzahlungszeitraum 1=Jahr, 2=Monat, 3=Woche, 4 = tag)
	 * @param re4
	 *            (Vorrausichtlicher Jahresarbeitslohn)
	 * @param stkl
	 *            (Steuerklasse)
	 * 
	 * @throws Exception
	 */

	private void check(int lzz, BigDecimal re4, int stkl) throws Exception {

		URL url = new URL(
				"http://www.bmf-steuerrechner.de/interface/2015.jsp?LZZ=" + lzz
						+ "&RE4=" + re4 + "&STKL=" + stkl);
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setNamespaceAware(false);
		f.setIgnoringElementContentWhitespace(false);
		DocumentBuilder b = f.newDocumentBuilder();
		Document d = b.parse(is);

		Lohnsteuer2015Big ls = new Lohnsteuer2015Big();
		ls.LZZ = lzz;
		ls.RE4 = re4;
		ls.STKL = stkl;

		NodeList ausgaben = d.getElementsByTagName("ausgabe");

		for (int i = 0; i < ausgaben.getLength(); i++) {
			Element n = (Element) ausgaben.item(i);
			String name = n.getAttribute("name");
			String value = n.getAttribute("value");

			Field field = ls.getClass().getDeclaredField(name);
			Object o = field.get(ls);
			if (o != null) {
				o = o.toString();
			}
			assertEquals(value, o);

		}
	}
}