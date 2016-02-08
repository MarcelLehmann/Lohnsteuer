package de.powerproject.lohnpap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

import de.powerproject.lohnpap.generator.Generator;
import de.powerproject.lohnpap.generator.PapFile;
import de.powerproject.lohnpap.pap.Lohnsteuer;
import de.powerproject.lohnpap.pap.Lohnsteuer2006;
import de.powerproject.lohnpap.pap.Lohnsteuer2007;
import de.powerproject.lohnpap.pap.Lohnsteuer2008;
import de.powerproject.lohnpap.pap.Lohnsteuer2009;
import de.powerproject.lohnpap.pap.Lohnsteuer2010;
import de.powerproject.lohnpap.pap.Lohnsteuer2011;
import de.powerproject.lohnpap.pap.Lohnsteuer2011Dezember;
import de.powerproject.lohnpap.pap.Lohnsteuer2012;
import de.powerproject.lohnpap.pap.Lohnsteuer2013;
import de.powerproject.lohnpap.pap.Lohnsteuer2014;
import de.powerproject.lohnpap.pap.Lohnsteuer2015;
import de.powerproject.lohnpap.pap.Lohnsteuer2015Dezember;
import de.powerproject.lohnpap.pap.Lohnsteuer2016;
import de.powerproject.lohnpap.pap.LohnsteuerInterface;

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

	private static final Class<?> CURRENT = Lohnsteuer2016.class;;

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
	public void checkDuplicateEntry() {

		Set<String> values = new HashSet<>();

		boolean first = true;

		for (PapFile pf : Generator.PAP_FILES) {

			if (first) {

				first = false;

			} else {

				assertNotNull("only first entry can be null", pf.getTo());

				for (int i = pf.getFrom(); i <= pf.getTo(); i++) {

					String id = pf.getYear() + " " + i;
					assertTrue("duplicate entry " + id, values.add(id));
				}
			}
		}
	}

	@Test
	public void check2006() throws Exception {
		checkLohnsteuer(Lohnsteuer2006.class, "2006", getDate(2006, 1, 1));
	}

	@Test
	public void check2007() throws Exception {
		checkLohnsteuer(Lohnsteuer2007.class, "2007", getDate(2007, 1, 1));
	}

	@Test
	public void check2008() throws Exception {
		checkLohnsteuer(Lohnsteuer2008.class, "2008", getDate(2008, 1, 1));
	}

	@Test
	public void check2009() throws Exception {
		checkLohnsteuer(Lohnsteuer2009.class, "2009", getDate(2009, 1, 1));
	}

	@Test
	public void check2010() throws Exception {
		checkLohnsteuer(Lohnsteuer2010.class, "2010", getDate(2010, 1, 1));
	}

	@Test
	public void check2011() throws Exception {
		checkLohnsteuer(Lohnsteuer2011.class, "2011bisNov", getDate(2011, 1, 1));
	}

	@Test
	public void check2011Dezember() throws Exception {
		checkLohnsteuer(Lohnsteuer2011Dezember.class, "2011Dez", getDate(2011, 12, 1));
	}

	@Test
	public void check2012() throws Exception {
		checkLohnsteuer(Lohnsteuer2012.class, "2012", getDate(2012, 1, 1));
	}

	@Test
	public void check2013() throws Exception {
		checkLohnsteuer(Lohnsteuer2013.class, "2013", getDate(2013, 1, 1));
	}

	@Test
	public void check2014() throws Exception {
		checkLohnsteuer(Lohnsteuer2014.class, "2014", getDate(2014, 1, 1));
	}

	@Test
	public void check2015() throws Exception {
		checkLohnsteuer(Lohnsteuer2015.class, "2015bisNov", getDate(2015, 1, 1));
	}

	@Test
	public void check2015Dezember() throws Exception {
		checkLohnsteuer(Lohnsteuer2015Dezember.class, "2015Dez", getDate(2015, 12, 1));
	}

	@Test
	public void check2016() throws Exception {
		checkLohnsteuer(Lohnsteuer2016.class, "2016V1", getDate(2016, 1, 1));
	}

	@Test
	public void checkCurrent() throws Exception {

		System.out.print("Lohnsteuer current");
		printBlank("current");

		PapFile pf = Generator.PAP_FILES.get(0);
		assertTrue("first entry must be null", pf.getTo() == null);
		assertEquals(CURRENT, Class.forName("de.powerproject.lohnpap.pap." + pf.getName()));
		assertEquals(CURRENT, Lohnsteuer.getInstance().getClass());

		System.out.print("...............................");
	}

	@Test
	public void checkFuture() {

		System.out.print("Lohnsteuer future");
		printBlank("future");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, +3);
		int year = cal.get(Calendar.YEAR);

		assertEquals(CURRENT, Lohnsteuer.getInstance(getDate(year, 1, 1)).getClass());

		System.out.print("...............................");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkInvalidDate() {

		System.out.print("Lohnsteuer invalid");
		printBlank("invalid");
		System.out.print("...............................");

		Lohnsteuer.getInstance(getDate(2000, 1, 1));
	}

	private void printBlank(String jsp) {
		for (int i = 0; i < (15 - jsp.length()); i++) {
			System.out.print(" ");
		}
	}

	private void checkLohnsteuer(Class<?> c, String jsp, Date testDate) throws Exception {

		System.out.print("Lohnsteuer " + jsp);

		printBlank(jsp);

		LohnsteuerInterface li = Lohnsteuer.getInstance(testDate);
		assertNotNull(li);
		assertEquals(c, li.getClass());

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

		double anzKinder = stkl == 2 ? 1.5 : 0;

		URL url = new URL("https://www.bmf-steuerrechner.de/interface/" + jsp + ".jsp?LZZ=" + lzz + "&RE4="
				+ re4.intValue() + "&STKL=" + stkl + "&ZKF=" + anzKinder);

		URLConnection con = url.openConnection();
		try (InputStream is = con.getInputStream()) {
			Files.copy(is, tmp.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setNamespaceAware(false);
		f.setIgnoringElementContentWhitespace(false);
		DocumentBuilder b = f.newDocumentBuilder();
		Document d = b.parse(tmp);

		// create instance of class
		Constructor<?> constructor = c.getConstructor();
		LohnsteuerInterface ls = (LohnsteuerInterface) constructor.newInstance();

		// fill instance
		ls.setLzz(lzz);
		ls.setRe4(re4);
		ls.setStkl(stkl);
		ls.setZkf(new BigDecimal(anzKinder));

		// invoke main
		ls.main();

		// parse web service and verify with result
		NodeList ausgaben = d.getElementsByTagName("ausgabe");

		assertNotNull(ausgaben);
		assertTrue(ausgaben.getLength() > 0);

		for (int i = 0; i < ausgaben.getLength(); i++) {

			Element n = (Element) ausgaben.item(i);
			String name = n.getAttribute("name");
			String value = n.getAttribute("value");

			try {

				Method m = c.getDeclaredMethod("get" + Generator.firstUpper(name));
				Object o = m.invoke(ls);
				if (o != null) {
					o = o.toString();
				}

				assertEquals("Wert " + name, value, o);

			} catch (IllegalAccessException e) {
				System.err.print("field " + name + " missing!");
				throw e;
			}
		}
	}

	private Date getDate(int year, int month, int day) {

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.getTime();
	}
}