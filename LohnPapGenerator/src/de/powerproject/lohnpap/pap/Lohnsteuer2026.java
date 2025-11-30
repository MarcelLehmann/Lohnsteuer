package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) 
 * @date Sun Nov 30 15:13:33 CET 2025
 * 
 */

public class Lohnsteuer2026 implements LohnsteuerInterface {

	/** Stand: 2025-10-23 12:40 */
	/** ITZBund Berlin */

	/* EINGABEPARAMETER*/

	protected int af = 1;
	protected int AJAHR = 0;
	protected int ALTER1 = 0;
	protected int ALV = 0;
	protected double f = 1.0;
	protected BigDecimal JFREIB = BigDecimal.ZERO;
	protected BigDecimal JHINZU = BigDecimal.ZERO;
	protected BigDecimal JRE4 = BigDecimal.ZERO;
	protected BigDecimal JRE4ENT = BigDecimal.ZERO;
	protected BigDecimal JVBEZ = BigDecimal.ZERO;
	protected int KRV = 0;
	protected BigDecimal KVZ = BigDecimal.ZERO;
	protected int LZZ = 1;
	protected BigDecimal LZZFREIB = BigDecimal.ZERO;
	protected BigDecimal LZZHINZU = BigDecimal.ZERO;
	protected BigDecimal MBV = BigDecimal.ZERO;
	protected BigDecimal PKPV = BigDecimal.ZERO;
	protected BigDecimal PKPVAGZ = BigDecimal.ZERO;
	protected int PKV = 0;
	protected BigDecimal PVA = BigDecimal.ZERO;
	protected int PVS = 0;
	protected int PVZ = 0;
	protected int R = 0;
	protected BigDecimal RE4 = BigDecimal.ZERO;
	protected BigDecimal SONSTB = BigDecimal.ZERO;
	protected BigDecimal SONSTENT = BigDecimal.ZERO;
	protected BigDecimal STERBE = BigDecimal.ZERO;
	protected int STKL = 1;
	protected BigDecimal VBEZ = BigDecimal.ZERO;
	protected BigDecimal VBEZM = BigDecimal.ZERO;
	protected BigDecimal VBEZS = BigDecimal.ZERO;
	protected BigDecimal VBS = BigDecimal.ZERO;
	protected int VJAHR = 0;
	protected BigDecimal ZKF = BigDecimal.ZERO;
	protected int ZMVB = 0;

	/* AUSGABEPARAMETER*/

	protected BigDecimal BK = BigDecimal.ZERO;
	protected BigDecimal BKS = BigDecimal.ZERO;
	protected BigDecimal LSTLZZ = BigDecimal.ZERO;
	protected BigDecimal SOLZLZZ = BigDecimal.ZERO;
	protected BigDecimal SOLZS = BigDecimal.ZERO;
	protected BigDecimal STS = BigDecimal.ZERO;

	/* AUSGABEPARAMETER DBA*/

	protected BigDecimal VFRB = BigDecimal.ZERO;
	protected BigDecimal VFRBS1 = BigDecimal.ZERO;
	protected BigDecimal VFRBS2 = BigDecimal.ZERO;
	protected BigDecimal WVFRB = BigDecimal.ZERO;
	protected BigDecimal WVFRBO = BigDecimal.ZERO;
	protected BigDecimal WVFRBM = BigDecimal.ZERO;

	/* INTERNE FELDER*/

	/** Altersentlastungsbetrag in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal ALTE = BigDecimal.ZERO;

	/** Arbeitnehmer-Pauschbetrag/Werbungskosten-Pauschbetrag in Euro */
	protected BigDecimal ANP = BigDecimal.ZERO;

	/** Auf den Lohnzahlungszeitraum entfallender Anteil von Jahreswerten<br>
		             auf ganze Cent abgerundet */
	protected BigDecimal ANTEIL1 = BigDecimal.ZERO;

	/** Beitragssatz des Arbeitnehmers zur Arbeitslosenversicherung (4 Dezimalstellen) */
	protected BigDecimal AVSATZAN = BigDecimal.ZERO;

	/** Beitragsbemessungsgrenze in der gesetzlichen Krankenversicherung <br>
		        	 und der sozialen Pflegeversicherung in Euro */
	protected BigDecimal BBGKVPV = BigDecimal.ZERO;

	/** Allgemeine Beitragsbemessungsgrenze in der allgemeinen Rentenversicherung und Arbeitslosenversicherung in Euro */
	protected BigDecimal BBGRVALV = BigDecimal.ZERO;

	/** Bemessungsgrundlage für Altersentlastungsbetrag in Euro, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal BMG = BigDecimal.ZERO;

	/** Differenz zwischen ST1 und ST2 in Euro */
	protected BigDecimal DIFF = BigDecimal.ZERO;

	/** Entlastungsbetrag für Alleinerziehende in Euro */
	protected BigDecimal EFA = BigDecimal.ZERO;

	/** Versorgungsfreibetrag in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal FVB = BigDecimal.ZERO;

	/** Versorgungsfreibetrag in Euro, Cent (2 Dezimalstellen) für die Berechnung<br>
		             der Lohnsteuer beim sonstigen Bezug */
	protected BigDecimal FVBSO = BigDecimal.ZERO;

	/** Zuschlag zum Versorgungsfreibetrag in Euro */
	protected BigDecimal FVBZ = BigDecimal.ZERO;

	/** Zuschlag zum Versorgungsfreibetrag in Euro für die Berechnung<br>
		             der Lohnsteuer beim sonstigen Bezug */
	protected BigDecimal FVBZSO = BigDecimal.ZERO;

	/** Grundfreibetrag in Euro */
	protected BigDecimal GFB = BigDecimal.ZERO;

	/** Maximaler Altersentlastungsbetrag in Euro */
	protected BigDecimal HBALTE = BigDecimal.ZERO;

	/** Maßgeblicher maximaler Versorgungsfreibetrag in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal HFVB = BigDecimal.ZERO;

	/** Maßgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in Euro, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal HFVBZ = BigDecimal.ZERO;

	/** Maßgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in Euro, Cent (2 Dezimalstellen) <br>
		             für die Berechnung der Lohnsteuer für den sonstigen Bezug */
	protected BigDecimal HFVBZSO = BigDecimal.ZERO;

	/** Zwischenfeld zu X für die Berechnung der Steuer nach § 39b<br>
		             Absatz 2 Satz 7 EStG in Euro */
	protected BigDecimal HOCH = BigDecimal.ZERO;

	/** Nummer der Tabellenwerte für Versorgungsparameter */
	protected int J = 0;

	/** Jahressteuer nach § 51a EStG, aus der Solidaritätszuschlag und<br>
		             Bemessungsgrundlage für die Kirchenlohnsteuer ermittelt werden in Euro */
	protected BigDecimal JBMG = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechneter LZZFREIB in Euro, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal JLFREIB = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnete LZZHINZU in Euro, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal JLHINZU = BigDecimal.ZERO;

	/** Jahreswert, dessen Anteil für einen Lohnzahlungszeitraum in<br>
		             UPANTEIL errechnet werden soll in Cent */
	protected BigDecimal JW = BigDecimal.ZERO;

	/** Nummer der Tabellenwerte für Parameter bei Altersentlastungsbetrag */
	protected int K = 0;

	/** Summe der Freibeträge für Kinder in Euro */
	protected BigDecimal KFB = BigDecimal.ZERO;

	/** Beitragssatz des Arbeitnehmers zur Krankenversicherung<br>
					 (5 Dezimalstellen) */
	protected BigDecimal KVSATZAN = BigDecimal.ZERO;

	/** Kennzahl für die Einkommensteuer-Tabellenart:<br>
		             1 = Grundtarif<br>
		             2 = Splittingverfahren */
	protected int KZTAB = 0;

	/** Jahreslohnsteuer in Euro */
	protected BigDecimal LSTJAHR = BigDecimal.ZERO;

	/** Zwischenfelder der Jahreslohnsteuer in Cent */
	protected BigDecimal LSTOSO = BigDecimal.ZERO;
	protected BigDecimal LSTSO = BigDecimal.ZERO;

	/** Mindeststeuer für die Steuerklassen V und VI in Euro */
	protected BigDecimal MIST = BigDecimal.ZERO;

	/** Auf einen Jahreswert hochgerechneter Arbeitgeberzuschuss für eine private Basiskranken- <br>
		             bzw. Pflege-Pflichtversicherung im Sinne des § 10 Absatz 1 Nummer 3 EStG in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal PKPVAGZJ = BigDecimal.ZERO;

	/** Beitragssatz des Arbeitnehmers zur Pflegeversicherung (6 Dezimalstellen) */
	protected BigDecimal PVSATZAN = BigDecimal.ZERO;

	/** Beitragssatz des Arbeitnehmers in der allgemeinen gesetzlichen Rentenversicherung (4 Dezimalstellen) */
	protected BigDecimal RVSATZAN = BigDecimal.ZERO;

	/** Rechenwert in Gleitkommadarstellung */
	protected BigDecimal RW = BigDecimal.ZERO;

	/** Sonderausgaben-Pauschbetrag in Euro */
	protected BigDecimal SAP = BigDecimal.ZERO;

	/** Freigrenze für den Solidaritätszuschlag in Euro */
	protected BigDecimal SOLZFREI = BigDecimal.ZERO;

	/** Solidaritätszuschlag auf die Jahreslohnsteuer in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal SOLZJ = BigDecimal.ZERO;

	/** Zwischenwert für den Solidaritätszuschlag auf die Jahreslohnsteuer<br>
		             in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal SOLZMIN = BigDecimal.ZERO;

	/** Bemessungsgrundlage des Solidaritätszuschlags zur Prüfung der Freigrenze beim Solidaritätszuschlag für sonstige Bezüge in Euro */
	protected BigDecimal SOLZSBMG = BigDecimal.ZERO;

	/** Zu versteuerndes Einkommen für die Ermittlung der<br>
		        	 Bemessungsgrundlage des Solidaritätszuschlags zur Prüfung der<br>
		        	 Freigrenze beim Solidaritätszuschlag für sonstige Bezüge in Euro,<br>
		        	 Cent (2 Dezimalstellen) */
	protected BigDecimal SOLZSZVE = BigDecimal.ZERO;

	/** Tarifliche Einkommensteuer in Euro */
	protected BigDecimal ST = BigDecimal.ZERO;

	/** Tarifliche Einkommensteuer auf das 1,25-fache ZX in Euro */
	protected BigDecimal ST1 = BigDecimal.ZERO;

	/** Tarifliche Einkommensteuer auf das 0,75-fache ZX in Euro */
	protected BigDecimal ST2 = BigDecimal.ZERO;

	/** Bemessungsgrundlage für den Versorgungsfreibetrag in Cent */
	protected BigDecimal VBEZB = BigDecimal.ZERO;

	/** Bemessungsgrundlage für den Versorgungsfreibetrag in Cent für<br>
		             den sonstigen Bezug */
	protected BigDecimal VBEZBSO = BigDecimal.ZERO;

	/** Zwischenfeld zu X für die Berechnung der Steuer nach § 39b<br>
		             Absatz 2 Satz 7 EStG in Euro */
	protected BigDecimal VERGL = BigDecimal.ZERO;

	/** Auf den Höchstbetrag begrenzte Beiträge zur Arbeitslosenversicherung <br>
		             einschließlich Kranken- und Pflegeversicherung in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSPHB = BigDecimal.ZERO;

	/** Vorsorgepauschale mit Teilbeträgen für die Rentenversicherung<br>
					 sowie die gesetzliche Kranken- und soziale Pflegeversicherung nach<br>
					 fiktiven Beträgen oder ggf. für die private Basiskrankenversicherung<br>
					 und private Pflege-Pflichtversicherung in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSP = BigDecimal.ZERO;

	/** Vorsorgepauschale mit Teilbeträgen für die Rentenversicherung sowie auf den Höchstbetrag <br>
		             begrenzten Teilbeträgen für die Arbeitslosen-, Kranken- und Pflegeversicherung in <br>
		             Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSPN = BigDecimal.ZERO;

	/** Teilbetrag für die Arbeitslosenversicherung bei der Berechnung der<br>
		             Vorsorgepauschale in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSPALV = BigDecimal.ZERO;

	/** Vorsorgepauschale mit Teilbeträgen für die gesetzliche Kranken- und soziale Pflegeversicherung <br>
		             nach fiktiven Beträgen oder ggf. für die private Basiskrankenversicherung und private <br>
		             Pflege-Pflichtversicherung in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSPKVPV = BigDecimal.ZERO;

	/** Teilbetrag für die Rentenversicherung bei der Berechnung der Vorsorgepauschale <br>
				     in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSPR = BigDecimal.ZERO;

	/** Erster Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W1STKL5 = BigDecimal.ZERO;

	/** Zweiter Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W2STKL5 = BigDecimal.ZERO;

	/** Dritter Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W3STKL5 = BigDecimal.ZERO;

	/** Zu versteuerndes Einkommen gem. § 32a Absatz 1 und 5 EStG in Euro, Cent <br>
		             (2 Dezimalstellen) */
	protected BigDecimal X = BigDecimal.ZERO;

	/** Gem. § 32a Absatz 1 EStG (6 Dezimalstellen) */
	protected BigDecimal Y = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnetes RE4 in Euro, Cent (2 Dezimalstellen)<br>
		             nach Abzug der Freibeträge nach § 39 b Absatz 2 Satz 3 und 4 EStG */
	protected BigDecimal ZRE4 = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnetes RE4 in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal ZRE4J = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnetes RE4, ggf. nach Abzug der<br>
					 Entschädigungen i.S.d. § 24 Nummer 1 EStG in Euro, Cent<br>
					 (2 Dezimalstellen) */
	protected BigDecimal ZRE4VP = BigDecimal.ZERO;

	/** Zwischenfeld zu ZRE4VP für die Begrenzung auf die jeweilige <br>
		             Beitragsbemessungsgrenze in Euro, Cent (2 Dezimalstellen)" */
	protected BigDecimal ZRE4VPR = BigDecimal.ZERO;

	/** Feste Tabellenfreibeträge (ohne Vorsorgepauschale) in Euro, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal ZTABFB = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnetes VBEZ abzüglich FVB in<br>
					 Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal ZVBEZ = BigDecimal.ZERO;

	/** Auf einen Jahreslohn hochgerechnetes VBEZ in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal ZVBEZJ = BigDecimal.ZERO;

	/** Zu versteuerndes Einkommen in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal ZVE = BigDecimal.ZERO;

	/** Zwischenfeld zu X für die Berechnung der Steuer nach § 39b<br>
		             Absatz 2 Satz 7 EStG in Euro */
	protected BigDecimal ZX = BigDecimal.ZERO;

	/** Zwischenfeld zu X für die Berechnung der Steuer nach § 39b<br>
		             Absatz 2 Satz 7 EStG in Euro */
	protected BigDecimal ZZX = BigDecimal.ZERO;

	/* KONSTANTEN */

	/** Tabelle für die Prozentsätze des Versorgungsfreibetrags */
	protected static final BigDecimal[] TAB1 = {BigDecimal.ZERO, BigDecimal.valueOf( 0.4), BigDecimal.valueOf( 0.384), BigDecimal.valueOf( 0.368), BigDecimal.valueOf( 0.352), BigDecimal.valueOf( 0.336), BigDecimal.valueOf( 0.32), BigDecimal.valueOf( 0.304), BigDecimal.valueOf( 0.288), BigDecimal.valueOf( 0.272), BigDecimal.valueOf( 0.256), BigDecimal.valueOf( 0.24), BigDecimal.valueOf( 0.224), BigDecimal.valueOf( 0.208), BigDecimal.valueOf( 0.192), BigDecimal.valueOf( 0.176), BigDecimal.valueOf( 0.16), BigDecimal.valueOf( 0.152), BigDecimal.valueOf( 0.144), BigDecimal.valueOf( 0.14), BigDecimal.valueOf( 0.136), BigDecimal.valueOf( 0.132), BigDecimal.valueOf( 0.128), BigDecimal.valueOf( 0.124), BigDecimal.valueOf( 0.12), BigDecimal.valueOf( 0.116), BigDecimal.valueOf( 0.112), BigDecimal.valueOf( 0.108), BigDecimal.valueOf( 0.104), BigDecimal.valueOf( 0.1), BigDecimal.valueOf( 0.096), BigDecimal.valueOf( 0.092), BigDecimal.valueOf( 0.088), BigDecimal.valueOf( 0.084), BigDecimal.valueOf( 0.08), BigDecimal.valueOf( 0.076), BigDecimal.valueOf( 0.072), BigDecimal.valueOf( 0.068), BigDecimal.valueOf( 0.064), BigDecimal.valueOf( 0.06), BigDecimal.valueOf( 0.056), BigDecimal.valueOf( 0.052), BigDecimal.valueOf( 0.048), BigDecimal.valueOf( 0.044), BigDecimal.valueOf( 0.04), BigDecimal.valueOf( 0.036), BigDecimal.valueOf( 0.032), BigDecimal.valueOf( 0.028), BigDecimal.valueOf( 0.024), BigDecimal.valueOf( 0.02), BigDecimal.valueOf( 0.016), BigDecimal.valueOf( 0.012), BigDecimal.valueOf( 0.008), BigDecimal.valueOf( 0.004), BigDecimal.valueOf( 0)};

	/** Tabelle für die Höchstbeträge des Versorgungsfreibetrags */
	protected static final BigDecimal[] TAB2 = {BigDecimal.ZERO, BigDecimal.valueOf( 3000), BigDecimal.valueOf( 2880), BigDecimal.valueOf( 2760), BigDecimal.valueOf( 2640), BigDecimal.valueOf( 2520), BigDecimal.valueOf( 2400), BigDecimal.valueOf( 2280), BigDecimal.valueOf( 2160), BigDecimal.valueOf( 2040), BigDecimal.valueOf( 1920), BigDecimal.valueOf( 1800), BigDecimal.valueOf( 1680), BigDecimal.valueOf( 1560), BigDecimal.valueOf( 1440), BigDecimal.valueOf( 1320), BigDecimal.valueOf( 1200), BigDecimal.valueOf( 1140), BigDecimal.valueOf( 1080), BigDecimal.valueOf( 1050), BigDecimal.valueOf( 1020), BigDecimal.valueOf( 990), BigDecimal.valueOf( 960), BigDecimal.valueOf( 930), BigDecimal.valueOf( 900), BigDecimal.valueOf( 870), BigDecimal.valueOf( 840), BigDecimal.valueOf( 810), BigDecimal.valueOf( 780), BigDecimal.valueOf( 750), BigDecimal.valueOf( 720), BigDecimal.valueOf( 690), BigDecimal.valueOf( 660), BigDecimal.valueOf( 630), BigDecimal.valueOf( 600), BigDecimal.valueOf( 570), BigDecimal.valueOf( 540), BigDecimal.valueOf( 510), BigDecimal.valueOf( 480), BigDecimal.valueOf( 450), BigDecimal.valueOf( 420), BigDecimal.valueOf( 390), BigDecimal.valueOf( 360), BigDecimal.valueOf( 330), BigDecimal.valueOf( 300), BigDecimal.valueOf( 270), BigDecimal.valueOf( 240), BigDecimal.valueOf( 210), BigDecimal.valueOf( 180), BigDecimal.valueOf( 150), BigDecimal.valueOf( 120), BigDecimal.valueOf( 90), BigDecimal.valueOf( 60), BigDecimal.valueOf( 30), BigDecimal.valueOf( 0) };

	/** Tabelle für die Zuschläge zum Versorgungsfreibetrag */
	protected static final BigDecimal[] TAB3 = {BigDecimal.ZERO, BigDecimal.valueOf( 900), BigDecimal.valueOf( 864), BigDecimal.valueOf( 828), BigDecimal.valueOf( 792), BigDecimal.valueOf( 756), BigDecimal.valueOf( 720), BigDecimal.valueOf( 684), BigDecimal.valueOf( 648), BigDecimal.valueOf( 612), BigDecimal.valueOf( 576), BigDecimal.valueOf( 540), BigDecimal.valueOf( 504), BigDecimal.valueOf( 468), BigDecimal.valueOf( 432), BigDecimal.valueOf( 396), BigDecimal.valueOf( 360), BigDecimal.valueOf( 342), BigDecimal.valueOf( 324), BigDecimal.valueOf( 315), BigDecimal.valueOf( 306), BigDecimal.valueOf( 297), BigDecimal.valueOf( 288), BigDecimal.valueOf( 279), BigDecimal.valueOf( 270), BigDecimal.valueOf( 261), BigDecimal.valueOf( 252), BigDecimal.valueOf( 243), BigDecimal.valueOf( 234), BigDecimal.valueOf( 225), BigDecimal.valueOf( 216), BigDecimal.valueOf( 207), BigDecimal.valueOf( 198), BigDecimal.valueOf( 189), BigDecimal.valueOf( 180), BigDecimal.valueOf( 171), BigDecimal.valueOf( 162), BigDecimal.valueOf( 153), BigDecimal.valueOf( 144), BigDecimal.valueOf( 135), BigDecimal.valueOf( 126), BigDecimal.valueOf( 117), BigDecimal.valueOf( 108), BigDecimal.valueOf( 99), BigDecimal.valueOf( 90), BigDecimal.valueOf( 81), BigDecimal.valueOf( 72), BigDecimal.valueOf( 63), BigDecimal.valueOf( 54), BigDecimal.valueOf( 45), BigDecimal.valueOf( 36), BigDecimal.valueOf( 27), BigDecimal.valueOf( 18), BigDecimal.valueOf( 9), BigDecimal.valueOf( 0)};

	/** Tabelle für die Höchstbeträge des Altersentlastungsbetrags */
	protected static final BigDecimal[] TAB4 = {BigDecimal.ZERO, BigDecimal.valueOf( 0.4), BigDecimal.valueOf( 0.384), BigDecimal.valueOf( 0.368), BigDecimal.valueOf( 0.352), BigDecimal.valueOf( 0.336), BigDecimal.valueOf( 0.32), BigDecimal.valueOf( 0.304), BigDecimal.valueOf( 0.288), BigDecimal.valueOf( 0.272), BigDecimal.valueOf( 0.256), BigDecimal.valueOf( 0.24), BigDecimal.valueOf( 0.224), BigDecimal.valueOf( 0.208), BigDecimal.valueOf( 0.192), BigDecimal.valueOf( 0.176), BigDecimal.valueOf( 0.16), BigDecimal.valueOf( 0.152), BigDecimal.valueOf( 0.144), BigDecimal.valueOf( 0.14), BigDecimal.valueOf( 0.136), BigDecimal.valueOf( 0.132), BigDecimal.valueOf( 0.128), BigDecimal.valueOf( 0.124), BigDecimal.valueOf( 0.12), BigDecimal.valueOf( 0.116), BigDecimal.valueOf( 0.112), BigDecimal.valueOf( 0.108), BigDecimal.valueOf( 0.104), BigDecimal.valueOf( 0.1), BigDecimal.valueOf( 0.096), BigDecimal.valueOf( 0.092), BigDecimal.valueOf( 0.088), BigDecimal.valueOf( 0.084), BigDecimal.valueOf( 0.08), BigDecimal.valueOf( 0.076), BigDecimal.valueOf( 0.072), BigDecimal.valueOf( 0.068), BigDecimal.valueOf( 0.064), BigDecimal.valueOf( 0.06), BigDecimal.valueOf( 0.056), BigDecimal.valueOf( 0.052), BigDecimal.valueOf( 0.048), BigDecimal.valueOf( 0.044), BigDecimal.valueOf( 0.04), BigDecimal.valueOf( 0.036), BigDecimal.valueOf( 0.032), BigDecimal.valueOf( 0.028), BigDecimal.valueOf( 0.024), BigDecimal.valueOf( 0.02), BigDecimal.valueOf( 0.016), BigDecimal.valueOf( 0.012), BigDecimal.valueOf( 0.008), BigDecimal.valueOf( 0.004), BigDecimal.valueOf( 0)};

	/** Tabelle fuer die Hächstbeträge des Altersentlastungsbetrags */
	protected static final BigDecimal[] TAB5 = {BigDecimal.ZERO, BigDecimal.valueOf( 1900), BigDecimal.valueOf( 1824), BigDecimal.valueOf( 1748), BigDecimal.valueOf( 1672), BigDecimal.valueOf( 1596), BigDecimal.valueOf( 1520), BigDecimal.valueOf( 1444), BigDecimal.valueOf( 1368), BigDecimal.valueOf( 1292), BigDecimal.valueOf( 1216), BigDecimal.valueOf( 1140), BigDecimal.valueOf( 1064), BigDecimal.valueOf( 988), BigDecimal.valueOf( 912), BigDecimal.valueOf( 836), BigDecimal.valueOf( 760), BigDecimal.valueOf( 722), BigDecimal.valueOf( 684), BigDecimal.valueOf( 665), BigDecimal.valueOf( 646), BigDecimal.valueOf( 627), BigDecimal.valueOf( 608), BigDecimal.valueOf( 589), BigDecimal.valueOf( 570), BigDecimal.valueOf( 551), BigDecimal.valueOf( 532), BigDecimal.valueOf( 513), BigDecimal.valueOf( 494), BigDecimal.valueOf( 475), BigDecimal.valueOf( 456), BigDecimal.valueOf( 437), BigDecimal.valueOf( 418), BigDecimal.valueOf( 399), BigDecimal.valueOf( 380), BigDecimal.valueOf( 361), BigDecimal.valueOf( 342), BigDecimal.valueOf( 323), BigDecimal.valueOf( 304), BigDecimal.valueOf( 285), BigDecimal.valueOf( 266), BigDecimal.valueOf( 247), BigDecimal.valueOf( 228), BigDecimal.valueOf( 209), BigDecimal.valueOf( 190), BigDecimal.valueOf( 171), BigDecimal.valueOf( 152), BigDecimal.valueOf( 133), BigDecimal.valueOf( 114), BigDecimal.valueOf( 95), BigDecimal.valueOf( 76), BigDecimal.valueOf( 57), BigDecimal.valueOf( 38), BigDecimal.valueOf( 19), BigDecimal.valueOf( 0)};

	/** Zahlenkonstanten fuer im Plan oft genutzte BigDecimal Werte */
	protected static final BigDecimal ZAHL1 = BigDecimal.ONE;
	protected static final BigDecimal ZAHL2 = BigDecimal.valueOf(2);
	protected static final BigDecimal ZAHL5 = BigDecimal.valueOf(5);
	protected static final BigDecimal ZAHL7 = BigDecimal.valueOf(7);
	protected static final BigDecimal ZAHL12 = BigDecimal.valueOf(12);
	protected static final BigDecimal ZAHL100 = BigDecimal.valueOf(100);
	protected static final BigDecimal ZAHL360 = BigDecimal.valueOf(360);
	protected static final BigDecimal ZAHL500 = BigDecimal.valueOf(500);
	protected static final BigDecimal ZAHL700 = BigDecimal.valueOf(700);
	protected static final BigDecimal ZAHL1000 = BigDecimal.valueOf(1000);
	protected static final BigDecimal ZAHL10000 = BigDecimal.valueOf(10000);

	/* SETTER */

	@Override
	public void setRe4(BigDecimal arg0) { this.RE4 = arg0; }

	@Override
	public void setPkpv(BigDecimal arg0) { this.PKPV = arg0; }

	@Override
	public void setAf(int arg0) { this.af = arg0; }

	@Override
	public void setSterbe(BigDecimal arg0) { this.STERBE = arg0; }

	@Override
	public void setStkl(int arg0) { this.STKL = arg0; }

	@Override
	public void setF(double arg0) { this.f = arg0; }

	@Override
	public void setAjahr(int arg0) { this.AJAHR = arg0; }

	@Override
	public void setAlv(int arg0) { this.ALV = arg0; }

	@Override
	public void setJre4ent(BigDecimal arg0) { this.JRE4ENT = arg0; }

	@Override
	public void setPvs(int arg0) { this.PVS = arg0; }

	@Override
	public void setLzz(int arg0) { this.LZZ = arg0; }

	@Override
	public void setKrv(int arg0) { this.KRV = arg0; }

	@Override
	public void setKvz(BigDecimal arg0) { this.KVZ = arg0; }

	@Override
	public void setJhinzu(BigDecimal arg0) { this.JHINZU = arg0; }

	@Override
	public void setR(int arg0) { this.R = arg0; }

	@Override
	public void setPvz(int arg0) { this.PVZ = arg0; }

	@Override
	public void setZmvb(int arg0) { this.ZMVB = arg0; }

	@Override
	public void setLzzhinzu(BigDecimal arg0) { this.LZZHINZU = arg0; }

	@Override
	public void setSonstb(BigDecimal arg0) { this.SONSTB = arg0; }

	@Override
	public void setMbv(BigDecimal arg0) { this.MBV = arg0; }

	@Override
	public void setJvbez(BigDecimal arg0) { this.JVBEZ = arg0; }

	@Override
	public void setVbezm(BigDecimal arg0) { this.VBEZM = arg0; }

	@Override
	public void setVbs(BigDecimal arg0) { this.VBS = arg0; }

	@Override
	public void setAlter1(int arg0) { this.ALTER1 = arg0; }

	@Override
	public void setVbez(BigDecimal arg0) { this.VBEZ = arg0; }

	@Override
	public void setSonstent(BigDecimal arg0) { this.SONSTENT = arg0; }

	@Override
	public void setJfreib(BigDecimal arg0) { this.JFREIB = arg0; }

	@Override
	public void setJre4(BigDecimal arg0) { this.JRE4 = arg0; }

	@Override
	public void setZkf(BigDecimal arg0) { this.ZKF = arg0; }

	@Override
	public void setLzzfreib(BigDecimal arg0) { this.LZZFREIB = arg0; }

	@Override
	public void setPkpvagz(BigDecimal arg0) { this.PKPVAGZ = arg0; }

	@Override
	public void setPkv(int arg0) { this.PKV = arg0; }

	@Override
	public void setPva(BigDecimal arg0) { this.PVA = arg0; }

	@Override
	public void setVjahr(int arg0) { this.VJAHR = arg0; }

	@Override
	public void setVbezs(BigDecimal arg0) { this.VBEZS = arg0; }

	/* GETTER */

	@Override
	public BigDecimal getWvfrbm() { return this.WVFRBM; }

	@Override
	public BigDecimal getSts() { return this.STS; }

	@Override
	public BigDecimal getLstlzz() { return this.LSTLZZ; }

	@Override
	public BigDecimal getWvfrb() { return this.WVFRB; }

	@Override
	public BigDecimal getSolzlzz() { return this.SOLZLZZ; }

	@Override
	public BigDecimal getVfrb() { return this.VFRB; }

	@Override
	public BigDecimal getBk() { return this.BK; }

	@Override
	public BigDecimal getBks() { return this.BKS; }

	@Override
	public BigDecimal getSolzs() { return this.SOLZS; }

	@Override
	public BigDecimal getVfrbs2() { return this.VFRBS2; }

	@Override
	public BigDecimal getWvfrbo() { return this.WVFRBO; }

	@Override
	public BigDecimal getVfrbs1() { return this.VFRBS1; }

	/** PROGRAMMABLAUFPLAN 2026 <br>
       Steueruung, PAP Seite 13 */
	@Override
	public void main() {

		MPARA();
		MRE4JL();
		VBEZBSO= BigDecimal.ZERO;
		MRE4();
		MRE4ABZ();
		MBERECH();
		MSONST();
	}

	/** Zuweisung von Werten für bestimmte Steuer- und Sozialversicherungsparameter  PAP Seite 14 */
	protected void MPARA() {

		BBGRVALV = BigDecimal.valueOf(101400);
		AVSATZAN = BigDecimal.valueOf(0.013);
		RVSATZAN = BigDecimal.valueOf(0.093);
		BBGKVPV = BigDecimal.valueOf(69750);
		KVSATZAN = (KVZ.divide(ZAHL2).divide(ZAHL100)).add(BigDecimal.valueOf(0.07));
		if(PVS == 1) {
			PVSATZAN = BigDecimal.valueOf(0.023);
		} else {
			PVSATZAN =  BigDecimal.valueOf(0.018);
		}
		if(PVZ == 1) {
			PVSATZAN = PVSATZAN.add(BigDecimal.valueOf(0.006));
		} else {
			PVSATZAN = PVSATZAN.subtract(PVA.multiply(BigDecimal.valueOf(0.0025)));
		}
		W1STKL5 = BigDecimal.valueOf(14071);
		W2STKL5 = BigDecimal.valueOf(34939);
		W3STKL5 = BigDecimal.valueOf(222260);
		GFB = BigDecimal.valueOf(12348);
		SOLZFREI = BigDecimal.valueOf(20350);
	}

	/** Ermittlung des Jahresarbeitslohns nach § 39 b Absatz 2 Satz 2 EStG, PAP Seite 15 */
	protected void MRE4JL() {

		if(LZZ == 1) {
			ZRE4J= RE4.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= VBEZ.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			JLFREIB= LZZFREIB.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			JLHINZU= LZZHINZU.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		} else {
			if(LZZ == 2) {
				ZRE4J= (RE4.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				ZVBEZJ= (VBEZ.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				JLFREIB= (LZZFREIB.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				JLHINZU= (LZZHINZU.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			} else {
				if(LZZ == 3) {
					ZRE4J= (RE4.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					ZVBEZJ= (VBEZ.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					JLFREIB= (LZZFREIB.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					JLHINZU= (LZZHINZU.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
				} else {
					ZRE4J= (RE4.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					ZVBEZJ= (VBEZ.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					JLFREIB= (LZZFREIB.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					JLHINZU= (LZZHINZU.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				}
			}
		}
		if(af == 0) {
			f= 1;
		}
	}

	/** Freibeträge für Versorgungsbezüge, Altersentlastungsbetrag (§ 39b Absatz 2 Satz 3 EStG), PAP Seite 16 */
	protected void MRE4() {

		if(ZVBEZJ.compareTo (BigDecimal.ZERO) == 0) {
			FVBZ= BigDecimal.ZERO;
			FVB= BigDecimal.ZERO;
			FVBZSO= BigDecimal.ZERO;
			FVBSO= BigDecimal.ZERO;
		} else {
			if(VJAHR < 2006) {
				J= 1;
			} else {
				if(VJAHR < 2058) {
					J= VJAHR - 2004;
				} else {
					J= 54;
				}
			}
			if(LZZ == 1) {
				VBEZB= (VBEZM.multiply (BigDecimal.valueOf(ZMVB))).add (VBEZS);
				HFVB= TAB2[J].divide (ZAHL12).multiply (BigDecimal.valueOf(ZMVB)).setScale (0, BigDecimal.ROUND_UP);
				FVBZ= TAB3[J].divide (ZAHL12).multiply (BigDecimal.valueOf(ZMVB)).setScale (0, BigDecimal.ROUND_UP);
			} else {
				VBEZB= ((VBEZM.multiply (ZAHL12)).add (VBEZS)).setScale (2, BigDecimal.ROUND_DOWN);
				HFVB= TAB2[J];
				FVBZ= TAB3[J];
			}
			FVB= ((VBEZB.multiply (TAB1[J]))).divide (ZAHL100).setScale (2, BigDecimal.ROUND_UP);
			if(FVB.compareTo (HFVB) == 1) {
				FVB = HFVB;
			}
			if(FVB.compareTo (ZVBEZJ) == 1) {
				FVB = ZVBEZJ;
			}
			FVBSO= (FVB.add((VBEZBSO.multiply (TAB1[J])).divide (ZAHL100))).setScale (2, BigDecimal.ROUND_UP);
			if(FVBSO.compareTo (TAB2[J]) == 1) {
				FVBSO = TAB2[J];
			}
			HFVBZSO= (((VBEZB.add(VBEZBSO)).divide (ZAHL100)).subtract (FVBSO)).setScale (2, BigDecimal.ROUND_DOWN);
			FVBZSO= (FVBZ.add((VBEZBSO).divide (ZAHL100))).setScale (0, BigDecimal.ROUND_UP);
			if(FVBZSO.compareTo (HFVBZSO) == 1) {
				FVBZSO = HFVBZSO.setScale(0, BigDecimal.ROUND_UP);
			}
			if(FVBZSO.compareTo (TAB3[J]) == 1) {
				FVBZSO = TAB3[J];
			}
			HFVBZ= ((VBEZB.divide (ZAHL100)).subtract (FVB)).setScale (2, BigDecimal.ROUND_DOWN);
			if(FVBZ.compareTo (HFVBZ) == 1) {
				FVBZ = HFVBZ.setScale (0, BigDecimal.ROUND_UP);
			}
		}
		MRE4ALTE();
	}

	/** Altersentlastungsbetrag (§ 39b Absatz 2 Satz 3 EStG), PAP Seite 17 */
	protected void MRE4ALTE() {

		if(ALTER1 == 0) {
			ALTE= BigDecimal.ZERO;
		} else {
			if(AJAHR < 2006) {
				K= 1;
			} else {
				if(AJAHR < 2058) {
					K= AJAHR - 2004;
				} else {
					K= 54;
				}
			}
			BMG= ZRE4J.subtract (ZVBEZJ);
			ALTE = (BMG.multiply(TAB4[K])).setScale(0, BigDecimal.ROUND_UP);
			HBALTE= TAB5[K];
			if(ALTE.compareTo (HBALTE) == 1) {
				ALTE= HBALTE;
			}
		}
	}

	/** Ermittlung des Jahresarbeitslohns nach Abzug der Freibeträge nach § 39 b Absatz 2 Satz 3 und 4 EStG, PAP Seite 20 */
	protected void MRE4ABZ() {

		ZRE4= (ZRE4J.subtract (FVB).subtract   (ALTE).subtract (JLFREIB).add (JLHINZU)).setScale (2, BigDecimal.ROUND_DOWN);
		if(ZRE4.compareTo (BigDecimal.ZERO) == -1) {
			ZRE4= BigDecimal.ZERO;
		}
		ZRE4VP= ZRE4J;
		ZVBEZ = ZVBEZJ.subtract(FVB).setScale(2, BigDecimal.ROUND_DOWN);
		if(ZVBEZ.compareTo(BigDecimal.ZERO) == -1) {
			ZVBEZ = BigDecimal.ZERO;
		}
	}

	/** Berechnung fuer laufende Lohnzahlungszeitraueme Seite 21 */
	protected void MBERECH() {

		MZTABFB();
		VFRB = ((ANP.add(FVB.add(FVBZ))).multiply(ZAHL100)).setScale(0, BigDecimal.ROUND_DOWN);
		MLSTJAHR();
		WVFRB = ((ZVE.subtract(GFB)).multiply(ZAHL100)).setScale(0, BigDecimal.ROUND_DOWN);
		if(WVFRB.compareTo(BigDecimal.ZERO) == -1) {
			WVFRB = BigDecimal.ZERO;
		}
		LSTJAHR = (ST.multiply(BigDecimal.valueOf(f))).setScale(0,BigDecimal.ROUND_DOWN);
		UPLSTLZZ();
		if(ZKF.compareTo(BigDecimal.ZERO) == 1) {
			ZTABFB = ZTABFB.add(KFB);
			MRE4ABZ();
			MLSTJAHR();
			JBMG = (ST.multiply(BigDecimal.valueOf(f))).setScale(0,BigDecimal.ROUND_DOWN);
		} else {
			JBMG = LSTJAHR;
		}
		MSOLZ();
	}

	/** Ermittlung der festen Tabellenfreibeträge (ohne Vorsorgepauschale), PAP Seite 22 */
	protected void MZTABFB() {

		ANP= BigDecimal.ZERO;
		if(ZVBEZ.compareTo (BigDecimal.ZERO) >= 0 && ZVBEZ.compareTo(FVBZ) == -1) {
			FVBZ = BigDecimal.valueOf(ZVBEZ.longValue());
		}
		if(STKL < 6) {
			if(ZVBEZ.compareTo (BigDecimal.ZERO) == 1) {
				if((ZVBEZ.subtract (FVBZ)).compareTo (BigDecimal.valueOf(102)) == -1) {
					ANP= (ZVBEZ.subtract (FVBZ)).setScale (0, BigDecimal.ROUND_UP);
				} else {
					ANP= BigDecimal.valueOf(102);
				}
			}
		} else {
			FVBZ= BigDecimal.ZERO;
			FVBZSO= BigDecimal.ZERO;
		}
		if(STKL < 6) {
			if(ZRE4.compareTo(ZVBEZ) == 1) {
				if(ZRE4.subtract(ZVBEZ).compareTo(BigDecimal.valueOf(1230)) == -1) {
					ANP = ANP.add(ZRE4).subtract(ZVBEZ).setScale(0,BigDecimal.ROUND_UP);
				} else {
					ANP = ANP.add(BigDecimal.valueOf(1230));
				}
			}
		}
		KZTAB= 1;
		if(STKL == 1) {
			SAP= BigDecimal.valueOf(36);
			KFB= (ZKF.multiply (BigDecimal.valueOf(9756))).setScale (0, BigDecimal.ROUND_DOWN);
		} else {
			if(STKL == 2) {
				EFA= BigDecimal.valueOf(4260);
				SAP= BigDecimal.valueOf(36);
				KFB= (ZKF.multiply (BigDecimal.valueOf(9756))).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				if(STKL == 3) {
					KZTAB= 2;
					SAP= BigDecimal.valueOf(36);
					KFB= (ZKF.multiply (BigDecimal.valueOf(9756))).setScale (0, BigDecimal.ROUND_DOWN);
				} else {
					if(STKL == 4) {
						SAP= BigDecimal.valueOf(36);
						KFB= (ZKF.multiply (BigDecimal.valueOf(4878))).setScale (0, BigDecimal.ROUND_DOWN);
					} else {
						if(STKL == 5) {
							SAP= BigDecimal.valueOf(36);
							KFB= BigDecimal.ZERO;
						} else {
							KFB= BigDecimal.ZERO;
						}
					}
				}
			}
		}
		ZTABFB= (EFA.add (ANP).add (SAP).add (FVBZ)).setScale (2, BigDecimal.ROUND_DOWN);
	}

	/** Ermittlung Jahreslohnsteuer, PAP Seite 23 */
	protected void MLSTJAHR() {

		UPEVP();
		ZVE= ZRE4.subtract (ZTABFB).subtract(VSP);
		UPMLST();
	}

	/** PAP Seite 24 */
	protected void UPLSTLZZ() {

		JW = LSTJAHR.multiply(ZAHL100);
		UPANTEIL();
		LSTLZZ = ANTEIL1;
	}

	/** PAP Seite 25 */
	protected void UPMLST() {

		if(ZVE.compareTo (ZAHL1) == -1) {
			ZVE= BigDecimal.ZERO;
			X= BigDecimal.ZERO;
		} else {
			X= (ZVE.divide (BigDecimal.valueOf(KZTAB))).setScale (0, BigDecimal.ROUND_DOWN);
		}
		if(STKL < 5) {
			UPTAB26();
		} else {
			MST5_6();
		}
	}

	/** Vorsorgepauschale (§ 39b Absatz 2 Satz 5 Nummer 3 EStG) PAP Seite 26 */
	protected void UPEVP() {

		if(KRV == 1) {
			VSPR = BigDecimal.ZERO;
		} else {
			if(ZRE4VP.compareTo(BBGRVALV) == 1) {
				ZRE4VPR = BBGRVALV;
			} else {
				ZRE4VPR = ZRE4VP;
			}
			VSPR = (ZRE4VPR.multiply(RVSATZAN)).setScale(2,BigDecimal.ROUND_DOWN);
		}
		MVSPKVPV();
		if(ALV == 1) {/** NOP */
		} else {
			if(STKL == 6) {/** NOP */
			} else {
				MVSPHB();
			}
		}
	}

	/** Vorsorgepauschale (§ 39b Absatz 2 Satz 5 Nummer 3 Buchstaben b bis d EStG), PAP Seite 27 */
	protected void MVSPKVPV() {

		if(ZRE4VP.compareTo(BBGKVPV) == 1) {
			ZRE4VPR = BBGKVPV;
		} else {
			ZRE4VPR = ZRE4VP;
		}
		if(PKV > 0) {
			if(STKL == 6) {
				VSPKVPV = BigDecimal.ZERO;
			} else {
				PKPVAGZJ = PKPVAGZ.multiply(ZAHL12).divide(ZAHL100).setScale(2,BigDecimal.ROUND_DOWN);
				VSPKVPV = PKPV.multiply(ZAHL12).divide(ZAHL100).setScale(2, BigDecimal.ROUND_DOWN);
				VSPKVPV = VSPKVPV.subtract(PKPVAGZJ);
				if(VSPKVPV.compareTo(BigDecimal.ZERO) == -1) {
					VSPKVPV = BigDecimal.ZERO;
				}
			}
		} else {
			VSPKVPV = ZRE4VPR.multiply(KVSATZAN.add(PVSATZAN)).setScale(2, BigDecimal.ROUND_DOWN);
		}
		VSP = VSPKVPV.add(VSPR).setScale(0, BigDecimal.ROUND_UP);
	}

	/** Höchstbetragsberechnung zur Arbeitslosenversicherung (§ 39b Absatz 2 Satz 5 Nummer 3 Buchstabe e EStG), PAP Seite 28 */
	protected void MVSPHB() {

		if(ZRE4VP.compareTo(BBGRVALV) == 1) {
			ZRE4VPR = BBGRVALV;
		} else {
			ZRE4VPR = ZRE4VP;
		}
		VSPALV = AVSATZAN.multiply(ZRE4VPR).setScale(2, BigDecimal.ROUND_DOWN);
		VSPHB = VSPALV.add(VSPKVPV).setScale(2, BigDecimal.ROUND_DOWN);
		if(VSPHB.compareTo(BigDecimal.valueOf(1900)) == 1) {
			VSPHB = BigDecimal.valueOf(1900);
		}
		VSPN = VSPR.add(VSPHB).setScale(0, BigDecimal.ROUND_UP);
		if(VSPN.compareTo(VSP) == 1) {
			VSP = VSPN;
		}
	}

	/** Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Absatz 2 Satz 7 EStG), PAP Seite 29 */
	protected void MST5_6() {

		ZZX= X;
		if(ZZX.compareTo(W2STKL5) == 1) {
			ZX= W2STKL5;
			UP5_6();
			if(ZZX.compareTo (W3STKL5) == 1) {
				ST= (ST.add ((W3STKL5.subtract (W2STKL5)).multiply (BigDecimal.valueOf(0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
				ST= (ST.add ((ZZX.subtract (W3STKL5)).multiply (BigDecimal.valueOf(0.45)))).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				ST= (ST.add ((ZZX.subtract (W2STKL5)).multiply (BigDecimal.valueOf(0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
			}
		} else {
			ZX= ZZX;
			UP5_6();
			if(ZZX.compareTo (W1STKL5) == 1) {
				VERGL= ST;
				ZX= W1STKL5;
				UP5_6();
				HOCH= (ST.add ((ZZX.subtract (W1STKL5)).multiply (BigDecimal.valueOf(0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
				if(HOCH.compareTo (VERGL) == -1) {
					ST= HOCH;
				} else {
					ST= VERGL;
				}
			}
		}
	}

	/** Unterprogramm zur Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Absatz 2 Satz 7 EStG), PAP Seite 30 */
	protected void UP5_6() {

		X= (ZX.multiply (BigDecimal.valueOf(1.25))).setScale (0, BigDecimal.ROUND_DOWN);
		UPTAB26();
		ST1= ST;
		X= (ZX.multiply (BigDecimal.valueOf(0.75))).setScale (0, BigDecimal.ROUND_DOWN);
		UPTAB26();
		ST2= ST;
		DIFF= (ST1.subtract (ST2)).multiply (ZAHL2);
		MIST= (ZX.multiply (BigDecimal.valueOf(0.14))).setScale (0, BigDecimal.ROUND_DOWN);
		if(MIST.compareTo (DIFF) == 1) {
			ST= MIST;
		} else {
			ST= DIFF;
		}
	}

	/** Solidaritätszuschlag, PAP Seite 31 */
	protected void MSOLZ() {

		SOLZFREI = (SOLZFREI.multiply(BigDecimal.valueOf(KZTAB)));
		if(JBMG.compareTo (SOLZFREI) == 1) {
			SOLZJ= (JBMG.multiply (BigDecimal.valueOf(5.5))).divide(ZAHL100).setScale(2, BigDecimal.ROUND_DOWN);
			SOLZMIN= (JBMG.subtract (SOLZFREI)).multiply (BigDecimal.valueOf(11.9)).divide (ZAHL100).setScale (2, BigDecimal.ROUND_DOWN);
			if(SOLZMIN.compareTo (SOLZJ) == -1) {
				SOLZJ= SOLZMIN;
			}
			JW= SOLZJ.multiply (ZAHL100).setScale (0, BigDecimal.ROUND_DOWN);
			UPANTEIL();
			SOLZLZZ= ANTEIL1;
		} else {
			SOLZLZZ= BigDecimal.ZERO;
		}
		if(R > 0) {
			JW= JBMG.multiply (ZAHL100);
			UPANTEIL();
			BK= ANTEIL1;
		} else {
			BK= BigDecimal.ZERO;
		}
	}

	/** Anteil von Jahresbeträgen fuer einen LZZ (§ 39b Absatz 2 Satz 9 EStG), PAP Seite 32 */
	protected void UPANTEIL() {

		if(LZZ == 1) {
			ANTEIL1= JW;
		} else {
			if(LZZ == 2) {
				ANTEIL1= JW.divide (ZAHL12, 0, BigDecimal.ROUND_DOWN);
			} else {
				if(LZZ == 3) {
					ANTEIL1= (JW.multiply (ZAHL7)).divide (ZAHL360, 0, BigDecimal.ROUND_DOWN);
				} else {
					ANTEIL1= JW.divide (ZAHL360, 0, BigDecimal.ROUND_DOWN);
				}
			}
		}
	}

	/** Berechnung sonstiger Bezüge nach § 39b Absatz 3 Sätze 1 bis 8 EStG, PAP Seite 33 */
	protected void MSONST() {

		LZZ = 1;
		if(ZMVB == 0) {
			ZMVB = 12;
		}
		if(SONSTB.compareTo (BigDecimal.ZERO) == 0 && MBV.compareTo (BigDecimal.ZERO) == 0) {
			LSTSO= BigDecimal.ZERO;
			STS= BigDecimal.ZERO;
			SOLZS= BigDecimal.ZERO;
			BKS= BigDecimal.ZERO;
		} else {
			MOSONST();
			ZRE4J= ((JRE4.add (SONSTB)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= ((JVBEZ.add (VBS)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			VBEZBSO= STERBE;
			MRE4SONST();
			MLSTJAHR();
			WVFRBM = (ZVE.subtract(GFB)).multiply(ZAHL100).setScale(2,BigDecimal.ROUND_DOWN);
			if(WVFRBM.compareTo(BigDecimal.ZERO) == -1) /** WVFRBM < 0 */{
				WVFRBM = BigDecimal.ZERO;
			}
			LSTSO= ST.multiply (ZAHL100);/** lt. PAP:  "Hinweis: negative Zahlen werden nach ihrem Betrag gerundet!" *//** Fallunterscheidung bzgl. negativer Zahlen nicht nötig, da die Java-Klasse BigDecimal.ROUND_DOWN *//** die Ziffer und nicht die Zahl abrundet, also aus -4.5 wird -4 und aus 4.5 wird 4 */
			STS = LSTSO.subtract(LSTOSO).multiply(BigDecimal.valueOf(f)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN).multiply(ZAHL100);
			STSMIN();
		}
	}

	/** PAP Seite 34 */
	protected void STSMIN() {

		if(STS.compareTo(BigDecimal.ZERO) == -1) {
			if(MBV.compareTo(BigDecimal.ZERO) == 0) {/** NOP */
			} else {
				LSTLZZ = LSTLZZ.add(STS);
				if(LSTLZZ.compareTo(BigDecimal.ZERO) == -1) {
					LSTLZZ = BigDecimal.ZERO;
				}
				SOLZLZZ = SOLZLZZ.add(STS.multiply(BigDecimal.valueOf(5.5).divide(ZAHL100))).setScale(0, BigDecimal.ROUND_DOWN);
				if(SOLZLZZ.compareTo(BigDecimal.ZERO) == -1) {
					SOLZLZZ = BigDecimal.ZERO;
				}
				BK = BK.add(STS);
				if(BK.compareTo(BigDecimal.ZERO) == -1) {
					BK = BigDecimal.ZERO;
				}
			}
			STS = BigDecimal.ZERO;
			SOLZS = BigDecimal.ZERO;
		} else {
			MSOLZSTS();
		}
		if(R > 0) {
			BKS = STS;
		} else {
			BKS = BigDecimal.ZERO;
		}
	}

	/** Berechnung des SolZ auf sonstige Bezüge, PAP Seite 35 */
	protected void MSOLZSTS() {

		if(ZKF.compareTo(BigDecimal.ZERO) == 1) {
			SOLZSZVE= ZVE.subtract(KFB);
		} else {
			SOLZSZVE= ZVE;
		}
		if(SOLZSZVE.compareTo(BigDecimal.ONE) == -1) {
			SOLZSZVE= BigDecimal.ZERO;
			X= BigDecimal.ZERO;
		} else {
			X= SOLZSZVE.divide(BigDecimal.valueOf(KZTAB), 0, BigDecimal.ROUND_DOWN);
		}
		if(STKL < 5) {
			UPTAB26();
		} else {
			MST5_6();
		}
		SOLZSBMG= ST.multiply(BigDecimal.valueOf(f)).setScale(0,BigDecimal.ROUND_DOWN);
		if(SOLZSBMG.compareTo(SOLZFREI) == 1) {
			SOLZS= STS.multiply(BigDecimal.valueOf(5.5)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN);
		} else {
			SOLZS= BigDecimal.ZERO;
		}
	}

	/** Sonderberechnung ohne sonstige Bezüge für Berechnung bei sonstigen Bezügen, PAP Seite 36 */
	protected void MOSONST() {

		ZRE4J= (JRE4.divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
		ZVBEZJ= (JVBEZ.divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
		JLFREIB= JFREIB.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		JLHINZU= JHINZU.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		MRE4();
		MRE4ABZ();
		ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100));
		MZTABFB();
		VFRBS1 = ((ANP.add(FVB.add(FVBZ))).multiply(ZAHL100)).setScale(2,BigDecimal.ROUND_DOWN);
		MLSTJAHR();
		WVFRBO = ((ZVE.subtract(GFB)).multiply(ZAHL100)).setScale(2, BigDecimal.ROUND_DOWN);
		if(WVFRBO.compareTo(BigDecimal.ZERO) == -1 ) {
			WVFRBO = BigDecimal.ZERO;
		}
		LSTOSO= ST.multiply (ZAHL100);
	}

	/** Sonderberechnung mit sonstigen Bezüge für Berechnung bei sonstigen Bezügen, PAP Seite 37 */
	protected void MRE4SONST() {

		MRE4();
		FVB= FVBSO;
		MRE4ABZ();
		ZRE4VP = ZRE4VP.add(MBV.divide(ZAHL100)).subtract(JRE4ENT.divide(ZAHL100)).subtract(SONSTENT.divide(ZAHL100));
		FVBZ= FVBZSO;
		MZTABFB();
		VFRBS2 = ((((ANP.add(FVB).add(FVBZ))).multiply(ZAHL100))).subtract(VFRBS1);
	}

	/** Tarifliche Einkommensteuer §32a EStG, PAP Seite 38 */
	protected void UPTAB26() {

		if(X.compareTo(GFB.add(ZAHL1)) == -1) {
			ST= BigDecimal.ZERO;
		} else {
			if(X.compareTo (BigDecimal.valueOf(17800)) == -1) {
				Y = (X.subtract(GFB)).divide(ZAHL10000, 6,BigDecimal.ROUND_DOWN);
				RW= Y.multiply (BigDecimal.valueOf(914.51));
				RW= RW.add (BigDecimal.valueOf(1400));
				ST= (RW.multiply (Y)).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				if(X.compareTo (BigDecimal.valueOf(69879)) == -1) {
					Y= (X.subtract (BigDecimal.valueOf(17799))).divide (ZAHL10000, 6, BigDecimal.ROUND_DOWN);
					RW= Y.multiply (BigDecimal.valueOf(173.1));
					RW= RW.add (BigDecimal.valueOf(2397));
					RW= RW.multiply (Y);
					ST= (RW.add (BigDecimal.valueOf(1034.87))).setScale (0, BigDecimal.ROUND_DOWN);
				} else {
					if(X.compareTo (BigDecimal.valueOf(277826)) == -1) {
						ST= ((X.multiply (BigDecimal.valueOf(0.42))).subtract (BigDecimal.valueOf(11135.63))).setScale (0, BigDecimal.ROUND_DOWN);
					} else {
						ST= ((X.multiply (BigDecimal.valueOf(0.45))).subtract (BigDecimal.valueOf(19470.38))).setScale (0, BigDecimal.ROUND_DOWN);
					}
				}
			}
		}
		ST= ST.multiply (BigDecimal.valueOf(KZTAB));
	}

}