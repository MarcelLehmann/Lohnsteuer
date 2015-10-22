package de.powerproject.lohnpap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import de.powerproject.lohnpap.Lohnsteuer2013Big;
import de.powerproject.lohnpap.Lohnsteuer2014Big;
import de.powerproject.lohnpap.Lohnsteuer2015Big;
import de.powerproject.lohnpap.Lohnsteuer2015DezemberBig;

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

public class LohnsteuerTest {

	File tmp;

	@BeforeClass
	public static void start() {
		System.out.println(".........................................................");
	}

	@AfterClass
	public static void stop() {
		System.out.println(".........................................................");
	}

	@Before
	public void setUp() throws Exception {
		tmp = File.createTempFile("bmf.test.", ".xml");
	}

	@After
	public void tearDown() throws Exception {
		tmp.delete();
		System.out.println();
	}

	@Test
	public void check2013() throws Exception {
		checkLohnsteuer(Lohnsteuer2013Big.class, "2013");
	}

	@Test
	public void check2014() throws Exception {
		checkLohnsteuer(Lohnsteuer2014Big.class, "2014");
	}

	@Test
	public void check2015() throws Exception {
		checkLohnsteuer(Lohnsteuer2015Big.class, "2015bisNov");
	}

	@Test
	public void check2015Dezember() throws Exception {
		checkLohnsteuer(Lohnsteuer2015DezemberBig.class, "2015Dez");
	}

	private void printBlank(String jsp) {
		for (int i = 0; i < (15 - jsp.length()); i++) {
			System.out.print(" ");
		}
	}

	private void checkLohnsteuer(Class<?> c, String jsp) throws Exception {

		System.out.print("Lohnsteuer " + jsp);
		printBlank(jsp);

		for (int lohn = 5000; lohn <= 80000; lohn += 2500) {

			System.out.print(".");

			BigDecimal re4 = new BigDecimal(lohn * 100); // Angabe in Cent

			for (int stkl = 1; stkl <= 6; stkl++) {
				check(c, jsp, 1, re4, stkl);
			}
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

	private void check(Class<?> c, String jsp, int lzz, BigDecimal re4, int stkl) throws Exception {

		URL url = new URL("https://www.bmf-steuerrechner.de/interface/" + jsp + ".jsp?LZZ=" + lzz + "&RE4="
				+ re4.intValue() + "&STKL=" + stkl);

		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();

		Files.copy(is, tmp.toPath(), StandardCopyOption.REPLACE_EXISTING);

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setNamespaceAware(false);
		f.setIgnoringElementContentWhitespace(false);
		DocumentBuilder b = f.newDocumentBuilder();
		Document d = b.parse(tmp);

		// create instance of class
		Constructor<?> constructor = c.getConstructor();
		Object ls = constructor.newInstance();

		// fill instance
		c.getDeclaredField("LZZ").set(ls, lzz);
		c.getDeclaredField("RE4").set(ls, re4);
		c.getDeclaredField("STKL").set(ls, stkl);

		// invoke main
		c.getMethod("main").invoke(ls);

		// parse web service and verify with result
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