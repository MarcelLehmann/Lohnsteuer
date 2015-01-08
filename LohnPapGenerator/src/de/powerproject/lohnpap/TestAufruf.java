package de.powerproject.lohnpap;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 * Test des generierten Lohnsteuerrechners gegen die externe
 * Programmierschnittstelle des Bundesministerium für Finanzen (BMF)
 * 
 * Infos unter https://www.bmf-steuerrechner.de/interface/
 * 
 * @author Marcel Lehmann
 * 
 */

public class TestAufruf extends TestCase {

	File tmp;

	@Override
	protected void setUp() throws Exception {
		tmp = File.createTempFile("bmf.test.", ".xml");
	}

	@Override
	protected void tearDown() throws Exception {
		tmp.delete();
	}

	public void testLohnsteuer() throws Exception {

		for (int lohn = 5000; lohn <= 80000; lohn += 2500) {

			System.out.print("Jahresarbeitslohn " + lohn + " ");

			BigDecimal re4 = new BigDecimal(lohn * 100); // Angabe in Cent

			for (int stkl = 1; stkl <= 6; stkl++) {
				check(1, re4, stkl);
			}

			System.out.println(" ok");

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
				"https://www.bmf-steuerrechner.de/interface/2015.jsp?LZZ="
						+ lzz + "&RE4=" + re4.intValue() + "&STKL=" + stkl);

		System.out.print(stkl);

		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();

		Files.copy(is, tmp.toPath(), StandardCopyOption.REPLACE_EXISTING);

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setNamespaceAware(false);
		f.setIgnoringElementContentWhitespace(false);
		DocumentBuilder b = f.newDocumentBuilder();
		Document d = b.parse(tmp);

		Lohnsteuer2015Big ls = new Lohnsteuer2015Big();
		ls.LZZ = lzz;
		ls.RE4 = re4;
		ls.STKL = stkl;
		ls.main();

		NodeList ausgaben = d.getElementsByTagName("ausgabe");

		assertNotNull(ausgaben);
		assertTrue(ausgaben.getLength() > 0);

		for (int i = 0; i < ausgaben.getLength(); i++) {
			Element n = (Element) ausgaben.item(i);
			String name = n.getAttribute("name");
			String value = n.getAttribute("value");

			Field field = ls.getClass().getDeclaredField(name);
			Object o = field.get(ls);
			if (o != null) {
				o = o.toString();
			}
			assertEquals("Wert " + name, value, o);

		}
	}
}