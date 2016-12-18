package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) 
 * @date Sun Dec 18 22:36:03 CET 2016
 * 
 */

public class Lohnsteuer2017 implements LohnsteuerInterface {

	/** Stand: 2016-11-08 */
	/** ITZBund Düsseldorf */

	/* EINGABEPARAMETER*/

	protected int af = 1;
	protected int AJAHR = 0;
	protected int ALTER1 = 0;
	protected BigDecimal ENTSCH = new BigDecimal(0);
	protected double f = 1.0;
	protected BigDecimal JFREIB = new BigDecimal(0);
	protected BigDecimal JHINZU = new BigDecimal(0);
	protected BigDecimal JRE4 = new BigDecimal(0);
	protected BigDecimal JVBEZ = new BigDecimal(0);
	protected int KRV = 0;
	protected BigDecimal KVZ = new BigDecimal(0);
	protected int LZZ = 0;
	protected BigDecimal LZZFREIB = new BigDecimal(0);
	protected BigDecimal LZZHINZU = new BigDecimal(0);
	protected BigDecimal PKPV = new BigDecimal(0);
	protected int PKV = 0;
	protected int PVS = 0;
	protected int PVZ = 0;
	protected int R = 0;
	protected BigDecimal RE4 = new BigDecimal(0);
	protected BigDecimal SONSTB = new BigDecimal(0);
	protected BigDecimal STERBE = new BigDecimal(0);
	protected int STKL = 0;
	protected BigDecimal VBEZ = new BigDecimal(0);
	protected BigDecimal VBEZM = new BigDecimal(0);
	protected BigDecimal VBEZS = new BigDecimal(0);
	protected BigDecimal VBS = new BigDecimal(0);
	protected int VJAHR = 0;
	protected BigDecimal VKAPA = new BigDecimal(0);
	protected BigDecimal VMT = new BigDecimal(0);
	protected BigDecimal ZKF = new BigDecimal(0);
	protected int ZMVB = 0;
	protected BigDecimal JRE4ENT = BigDecimal.ZERO;
	protected BigDecimal SONSTENT = BigDecimal.ZERO;

	/* AUSGABEPARAMETER*/

	protected BigDecimal BK = new BigDecimal(0);
	protected BigDecimal BKS = new BigDecimal(0);
	protected BigDecimal BKV = new BigDecimal(0);
	protected BigDecimal LSTLZZ = new BigDecimal(0);
	protected BigDecimal SOLZLZZ = new BigDecimal(0);
	protected BigDecimal SOLZS = new BigDecimal(0);
	protected BigDecimal SOLZV = new BigDecimal(0);
	protected BigDecimal STS = new BigDecimal(0);
	protected BigDecimal STV = new BigDecimal(0);
	protected BigDecimal VKVLZZ = new BigDecimal(0);
	protected BigDecimal VKVSONST = new BigDecimal(0);

	/* AUSGABEPARAMETER DBA*/

	protected BigDecimal VFRB = new BigDecimal(0);
	protected BigDecimal VFRBS1 = new BigDecimal(0);
	protected BigDecimal VFRBS2 = new BigDecimal(0);
	protected BigDecimal WVFRB = new BigDecimal(0);
	protected BigDecimal WVFRBO = new BigDecimal(0);
	protected BigDecimal WVFRBM = new BigDecimal(0);

	/* INTERNE FELDER*/

	/** Altersentlastungsbetrag nach Alterseinkünftegesetz in €,<br>
		             Cent (2 Dezimalstellen) */
	protected BigDecimal ALTE = new BigDecimal(0);

	/** Arbeitnehmer-Pauschbetrag in EURO */
	protected BigDecimal ANP = new BigDecimal(0);

	/** Auf den Lohnzahlungszeitraum entfallender Anteil von Jahreswerten<br>
		             auf ganze Cents abgerundet */
	protected BigDecimal ANTEIL1 = new BigDecimal(0);

	/** Bemessungsgrundlage für Altersentlastungsbetrag in €, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal BMG = new BigDecimal(0);

	/** Beitragsbemessungsgrenze in der gesetzlichen Krankenversicherung <br>
		        	und der sozialen Pflegeversicherung in Euro */
	protected BigDecimal BBGKVPV = new BigDecimal(0);

	/** allgemeine Beitragsbemessungsgrenze in der allgemeinen Renten-versicherung in Euro */
	protected BigDecimal BBGRV = new BigDecimal(0);

	/** Differenz zwischen ST1 und ST2 in EURO */
	protected BigDecimal DIFF = new BigDecimal(0);

	/** Entlastungsbetrag fuer Alleinerziehende in EURO */
	protected BigDecimal EFA = new BigDecimal(0);

	/** Versorgungsfreibetrag in €, Cent (2 Dezimalstellen) */
	protected BigDecimal FVB = new BigDecimal(0);

	/** Versorgungsfreibetrag in €, Cent (2 Dezimalstellen) für die Berechnung<br>
		             der Lohnsteuer für den sonstigen Bezug */
	protected BigDecimal FVBSO = new BigDecimal(0);

	/** Zuschlag zum Versorgungsfreibetrag in EURO */
	protected BigDecimal FVBZ = new BigDecimal(0);

	/** Zuschlag zum Versorgungsfreibetrag in EURO fuer die Berechnung<br>
		             der Lohnsteuer beim sonstigen Bezug */
	protected BigDecimal FVBZSO = new BigDecimal(0);

	/** Grundfreibetrag in Euro */
	protected BigDecimal GFB = new BigDecimal(0);

	/** Maximaler Altersentlastungsbetrag in € */
	protected BigDecimal HBALTE = new BigDecimal(0);

	/** Massgeblicher maximaler Versorgungsfreibetrag in € */
	protected BigDecimal HFVB = new BigDecimal(0);

	/** Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in €,Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal HFVBZ = new BigDecimal(0);

	/** Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in €, Cent<br>
		             (2 Dezimalstellen) für die Berechnung der Lohnsteuer für den<br>
		             sonstigen Bezug */
	protected BigDecimal HFVBZSO = new BigDecimal(0);

	/** Nummer der Tabellenwerte fuer Versorgungsparameter */
	protected int J = 0;

	/** Jahressteuer nach § 51a EStG, aus der Solidaritaetszuschlag und<br>
		             Bemessungsgrundlage fuer die Kirchenlohnsteuer ermittelt werden in EURO */
	protected BigDecimal JBMG = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechneter LZZFREIB in €, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal JLFREIB = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnete LZZHINZU in €, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal JLHINZU = new BigDecimal(0);

	/** Jahreswert, dessen Anteil fuer einen Lohnzahlungszeitraum in<br>
		             UPANTEIL errechnet werden soll in Cents */
	protected BigDecimal JW = new BigDecimal(0);

	/** Nummer der Tabellenwerte fuer Parameter bei Altersentlastungsbetrag */
	protected int K = 0;

	/** Merker für Berechnung Lohnsteuer für mehrjährige Tätigkeit.<br>
					 0 = normale Steuerberechnung<br>
					 1 = Steuerberechnung für mehrjährige Tätigkeit<br>
					 2 = entfällt */
	protected int KENNVMT = 0;

	/** Summe der Freibetraege fuer Kinder in EURO */
	protected BigDecimal KFB = new BigDecimal(0);

	/** Beitragssatz des Arbeitgebers zur Krankenversicherung */
	protected BigDecimal KVSATZAG = new BigDecimal(0);

	/** Beitragssatz des Arbeitnehmers zur Krankenversicherung */
	protected BigDecimal KVSATZAN = new BigDecimal(0);

	/** Kennzahl fuer die Einkommensteuer-Tabellenart:<br>
		             1 = Grundtabelle<br>
		             2 = Splittingtabelle */
	protected int KZTAB = 0;

	/** Jahreslohnsteuer in EURO */
	protected BigDecimal LSTJAHR = new BigDecimal(0);

	/** Zwischenfelder der Jahreslohnsteuer in Cent */
	protected BigDecimal LST1 = new BigDecimal(0);
	protected BigDecimal LST2 = new BigDecimal(0);
	protected BigDecimal LST3 = new BigDecimal(0);
	protected BigDecimal LSTOSO = new BigDecimal(0);
	protected BigDecimal LSTSO = new BigDecimal(0);

	/** Mindeststeuer fuer die Steuerklassen V und VI in EURO */
	protected BigDecimal MIST = new BigDecimal(0);

	/** Beitragssatz des Arbeitgebers zur Pflegeversicherung */
	protected BigDecimal PVSATZAG = new BigDecimal(0);

	/** Beitragssatz des Arbeitnehmers zur Pflegeversicherung */
	protected BigDecimal PVSATZAN = new BigDecimal(0);

	/** Beitragssatz des Arbeitnehmers in der allgemeinen gesetzlichen Rentenversicherung (4 Dezimalstellen) */
	protected BigDecimal RVSATZAN = new BigDecimal(0);

	/** Rechenwert in Gleitkommadarstellung */
	protected BigDecimal RW = new BigDecimal(0);

	/** Sonderausgaben-Pauschbetrag in EURO */
	protected BigDecimal SAP = new BigDecimal(0);

	/** Freigrenze fuer den Solidaritaetszuschlag in EURO */
	protected BigDecimal SOLZFREI = new BigDecimal(0);

	/** Solidaritaetszuschlag auf die Jahreslohnsteuer in EURO, C (2 Dezimalstellen) */
	protected BigDecimal SOLZJ = new BigDecimal(0);

	/** Zwischenwert fuer den Solidaritaetszuschlag auf die Jahreslohnsteuer<br>
		             in EURO, C (2 Dezimalstellen) */
	protected BigDecimal SOLZMIN = new BigDecimal(0);

	/** Tarifliche Einkommensteuer in EURO */
	protected BigDecimal ST = new BigDecimal(0);

	/** Tarifliche Einkommensteuer auf das 1,25-fache ZX in EURO */
	protected BigDecimal ST1 = new BigDecimal(0);

	/** Tarifliche Einkommensteuer auf das 0,75-fache ZX in EURO */
	protected BigDecimal ST2 = new BigDecimal(0);

	/** Zwischenfeld zur Ermittlung der Steuer auf Vergütungen für mehrjährige Tätigkeit */
	protected BigDecimal STOVMT = new BigDecimal(0);

	/** Teilbetragssatz der Vorsorgepauschale für die Rentenversicherung (2 Dezimalstellen) */
	protected BigDecimal TBSVORV = new BigDecimal(0);

	/** Bemessungsgrundlage fuer den Versorgungsfreibetrag in Cents */
	protected BigDecimal VBEZB = new BigDecimal(0);

	/** Bemessungsgrundlage für den Versorgungsfreibetrag in Cent für<br>
		             den sonstigen Bezug */
	protected BigDecimal VBEZBSO = new BigDecimal(0);

	/** Hoechstbetrag der Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
	protected BigDecimal VHB = new BigDecimal(0);

	/** Vorsorgepauschale in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSP = new BigDecimal(0);

	/** Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
	protected BigDecimal VSPN = new BigDecimal(0);

	/** Zwischenwert 1 bei der Berechnung der Vorsorgepauschale nach<br>
		             dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSP1 = new BigDecimal(0);

	/** Zwischenwert 2 bei der Berechnung der Vorsorgepauschale nach<br>
		             dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSP2 = new BigDecimal(0);

	/** Vorsorgepauschale mit Teilbeträgen für die gesetzliche Kranken- und <br>
					 soziale Pflegeversicherung nach fiktiven Beträgen oder ggf. für die<br>
					 private Basiskrankenversicherung und private Pflege-Pflichtversicherung <br>
					 in Euro, Cent (2 Dezimalstellen) */
	protected BigDecimal VSP3 = new BigDecimal(0);

	/** Erster Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W1STKL5 = new BigDecimal(0);

	/** Zweiter Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W2STKL5 = new BigDecimal(0);

	/** Dritter Grenzwert in Steuerklasse V/VI in Euro */
	protected BigDecimal W3STKL5 = new BigDecimal(0);

	/** Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 2 EStG in EURO */
	protected BigDecimal VSPMAX1 = new BigDecimal(0);

	/** Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 3 EStG in EURO */
	protected BigDecimal VSPMAX2 = new BigDecimal(0);

	/** Vorsorgepauschale nach § 10c Abs. 2 Satz 2 EStG vor der Hoechstbetragsberechnung<br>
		             in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSPO = new BigDecimal(0);

	/** Fuer den Abzug nach § 10c Abs. 2 Nrn. 2 und 3 EStG verbleibender<br>
		             Rest von VSPO in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSPREST = new BigDecimal(0);

	/** Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 1 EStG<br>
		             in EURO, C (2 Dezimalstellen) */
	protected BigDecimal VSPVOR = new BigDecimal(0);

	/** Zu versteuerndes Einkommen gem. § 32a Abs. 1 und 2 EStG €, C<br>
		             (2 Dezimalstellen) */
	protected BigDecimal X = new BigDecimal(0);

	/** gem. § 32a Abs. 1 EStG (6 Dezimalstellen) */
	protected BigDecimal Y = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen)<br>
		             nach Abzug der Freibeträge nach § 39 b Abs. 2 Satz 3 und 4. */
	protected BigDecimal ZRE4 = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen) */
	protected BigDecimal ZRE4J = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen)<br>
		             nach Abzug des Versorgungsfreibetrags und des Alterentlastungsbetrags<br>
		             zur Berechnung der Vorsorgepauschale in €, Cent (2 Dezimalstellen) */
	protected BigDecimal ZRE4VP = new BigDecimal(0);

	/** Feste Tabellenfreibeträge (ohne Vorsorgepauschale) in €, Cent<br>
		             (2 Dezimalstellen) */
	protected BigDecimal ZTABFB = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnetes (VBEZ abzueglich FVB) in<br>
		             EURO, C (2 Dezimalstellen) */
	protected BigDecimal ZVBEZ = new BigDecimal(0);

	/** Auf einen Jahreslohn hochgerechnetes VBEZ in €, C (2 Dezimalstellen) */
	protected BigDecimal ZVBEZJ = new BigDecimal(0);

	/** Zu versteuerndes Einkommen in €, C (2 Dezimalstellen) */
	protected BigDecimal ZVE = new BigDecimal(0);

	/** Zwischenfelder zu X fuer die Berechnung der Steuer nach § 39b<br>
		             Abs. 2 Satz 7 EStG in € */
	protected BigDecimal ZX = new BigDecimal(0);
	protected BigDecimal ZZX = new BigDecimal(0);
	protected BigDecimal HOCH = new BigDecimal(0);
	protected BigDecimal VERGL = new BigDecimal(0);

	/** Jahreswert der berücksichtigten Beiträge zur privaten Basis-Krankenversicherung und <br>
					  privaten Pflege-Pflichtversicherung (ggf. auch die Mindestvorsorgepauschale) in Cent. */
	protected BigDecimal VKV = new BigDecimal(0);

	/* KONSTANTEN */

	/** Tabelle fuer die Vomhundertsaetze des Versorgungsfreibetrags */
	protected static final BigDecimal[] TAB1 = {BigDecimal.valueOf (0.0), BigDecimal.valueOf (0.4), BigDecimal.valueOf (0.384), BigDecimal.valueOf (0.368),                  BigDecimal.valueOf (0.352), BigDecimal.valueOf (0.336), BigDecimal.valueOf (0.32), BigDecimal.valueOf (0.304),                  BigDecimal.valueOf (0.288), BigDecimal.valueOf (0.272), BigDecimal.valueOf (0.256), BigDecimal.valueOf (0.24),                   BigDecimal.valueOf (0.224), BigDecimal.valueOf (0.208), BigDecimal.valueOf (0.192), BigDecimal.valueOf (0.176),                  BigDecimal.valueOf (0.16), BigDecimal.valueOf (0.152),  BigDecimal.valueOf (0.144), BigDecimal.valueOf (0.136),                  BigDecimal.valueOf (0.128), BigDecimal.valueOf (0.12),  BigDecimal.valueOf (0.112), BigDecimal.valueOf (0.104),                  BigDecimal.valueOf (0.096), BigDecimal.valueOf (0.088), BigDecimal.valueOf (0.08), BigDecimal.valueOf (0.072),                  BigDecimal.valueOf (0.064), BigDecimal.valueOf (0.056), BigDecimal.valueOf (0.048), BigDecimal.valueOf (0.04),                  BigDecimal.valueOf (0.032), BigDecimal.valueOf (0.024), BigDecimal.valueOf (0.016), BigDecimal.valueOf (0.008),                  BigDecimal.valueOf (0.0)};

	/** Tabelle fuer die Hoechstbetrage des Versorgungsfreibetrags */
	protected static final BigDecimal[] TAB2 = {BigDecimal.valueOf (0), BigDecimal.valueOf (3000), BigDecimal.valueOf (2880),            BigDecimal.valueOf (2760), BigDecimal.valueOf (2640), BigDecimal.valueOf (2520), BigDecimal.valueOf (2400),             BigDecimal.valueOf (2280), BigDecimal.valueOf (2160), BigDecimal.valueOf (2040), BigDecimal.valueOf (1920),             BigDecimal.valueOf (1800), BigDecimal.valueOf (1680), BigDecimal.valueOf (1560), BigDecimal.valueOf (1440),             BigDecimal.valueOf (1320), BigDecimal.valueOf (1200), BigDecimal.valueOf (1140), BigDecimal.valueOf (1080),             BigDecimal.valueOf (1020), BigDecimal.valueOf (960), BigDecimal.valueOf (900), BigDecimal.valueOf (840),             BigDecimal.valueOf (780),  BigDecimal.valueOf (720), BigDecimal.valueOf (660), BigDecimal.valueOf (600),             BigDecimal.valueOf (540),  BigDecimal.valueOf (480), BigDecimal.valueOf (420), BigDecimal.valueOf (360),             BigDecimal.valueOf (300),  BigDecimal.valueOf (240), BigDecimal.valueOf (180), BigDecimal.valueOf (120),             BigDecimal.valueOf (60),   BigDecimal.valueOf (0)};

	/** Tabelle fuer die Zuschlaege zum Versorgungsfreibetrag */
	protected static final BigDecimal[] TAB3 = {BigDecimal.valueOf (0), BigDecimal.valueOf (900), BigDecimal.valueOf (864),           BigDecimal.valueOf (828), BigDecimal.valueOf (792), BigDecimal.valueOf (756), BigDecimal.valueOf (720),           BigDecimal.valueOf (684), BigDecimal.valueOf (648), BigDecimal.valueOf (612), BigDecimal.valueOf (576),           BigDecimal.valueOf (540), BigDecimal.valueOf (504), BigDecimal.valueOf (468), BigDecimal.valueOf (432),           BigDecimal.valueOf (396), BigDecimal.valueOf (360), BigDecimal.valueOf (342), BigDecimal.valueOf (324),           BigDecimal.valueOf (306), BigDecimal.valueOf (288), BigDecimal.valueOf (270), BigDecimal.valueOf (252),           BigDecimal.valueOf (234), BigDecimal.valueOf (216), BigDecimal.valueOf (198), BigDecimal.valueOf (180),           BigDecimal.valueOf (162), BigDecimal.valueOf (144), BigDecimal.valueOf (126), BigDecimal.valueOf (108),           BigDecimal.valueOf (90),  BigDecimal.valueOf (72), BigDecimal.valueOf (54), BigDecimal.valueOf (36),           BigDecimal.valueOf (18),  BigDecimal.valueOf (0)};

	/** Tabelle fuer die Vomhundertsaetze des Altersentlastungsbetrags */
	protected static final BigDecimal[] TAB4 = {BigDecimal.valueOf (0.0), BigDecimal.valueOf (0.4), BigDecimal.valueOf (0.384),           BigDecimal.valueOf (0.368), BigDecimal.valueOf (0.352), BigDecimal.valueOf (0.336), BigDecimal.valueOf (0.32),            BigDecimal.valueOf (0.304), BigDecimal.valueOf (0.288), BigDecimal.valueOf (0.272), BigDecimal.valueOf (0.256),            BigDecimal.valueOf (0.24),  BigDecimal.valueOf (0.224), BigDecimal.valueOf (0.208), BigDecimal.valueOf (0.192),            BigDecimal.valueOf (0.176), BigDecimal.valueOf (0.16), BigDecimal.valueOf (0.152),  BigDecimal.valueOf (0.144),            BigDecimal.valueOf (0.136), BigDecimal.valueOf (0.128), BigDecimal.valueOf (0.12),  BigDecimal.valueOf (0.112),            BigDecimal.valueOf (0.104), BigDecimal.valueOf (0.096), BigDecimal.valueOf (0.088), BigDecimal.valueOf (0.08),            BigDecimal.valueOf (0.072), BigDecimal.valueOf (0.064), BigDecimal.valueOf (0.056), BigDecimal.valueOf (0.048),            BigDecimal.valueOf (0.04),  BigDecimal.valueOf (0.032), BigDecimal.valueOf (0.024), BigDecimal.valueOf (0.016),            BigDecimal.valueOf (0.008), BigDecimal.valueOf (0.0)};

	/** Tabelle fuer die Hoechstbetraege des Altersentlastungsbetrags */
	protected static final BigDecimal[] TAB5 = {BigDecimal.valueOf (0), BigDecimal.valueOf (1900), BigDecimal.valueOf (1824),           BigDecimal.valueOf (1748), BigDecimal.valueOf (1672), BigDecimal.valueOf (1596), BigDecimal.valueOf (1520),           BigDecimal.valueOf (1444), BigDecimal.valueOf (1368), BigDecimal.valueOf (1292), BigDecimal.valueOf (1216),           BigDecimal.valueOf (1140), BigDecimal.valueOf (1064), BigDecimal.valueOf (988),  BigDecimal.valueOf (912),           BigDecimal.valueOf (836),  BigDecimal.valueOf (760), BigDecimal.valueOf (722), BigDecimal.valueOf (684),           BigDecimal.valueOf (646),  BigDecimal.valueOf (608), BigDecimal.valueOf (570), BigDecimal.valueOf (532),           BigDecimal.valueOf (494),  BigDecimal.valueOf (456), BigDecimal.valueOf (418), BigDecimal.valueOf (380),           BigDecimal.valueOf (342),  BigDecimal.valueOf (304), BigDecimal.valueOf (266), BigDecimal.valueOf (228),           BigDecimal.valueOf (190),  BigDecimal.valueOf (152), BigDecimal.valueOf (114), BigDecimal.valueOf (76),           BigDecimal.valueOf (38),   BigDecimal.valueOf (0)};

	/** Zahlenkonstanten fuer im Plan oft genutzte BigDecimal Werte */
	protected static final BigDecimal ZAHL1 = BigDecimal.ONE;
	protected static final BigDecimal ZAHL2 = new BigDecimal(2);
	protected static final BigDecimal ZAHL5 = new BigDecimal(5);
	protected static final BigDecimal ZAHL7 = new BigDecimal(7);
	protected static final BigDecimal ZAHL12 = new BigDecimal(12);
	protected static final BigDecimal ZAHL100 = new BigDecimal(100);
	protected static final BigDecimal ZAHL360 = new BigDecimal(360);
	protected static final BigDecimal ZAHL500 = new BigDecimal(500);
	protected static final BigDecimal ZAHL700 = new BigDecimal(700);
	protected static final BigDecimal ZAHL1000 = new BigDecimal(1000);
	protected static final BigDecimal ZAHL10000 = new BigDecimal(10000);

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
	public void setEntsch(BigDecimal arg0) { this.ENTSCH = arg0; }

	@Override
	public void setJfreib(BigDecimal arg0) { this.JFREIB = arg0; }

	@Override
	public void setVkapa(BigDecimal arg0) { this.VKAPA = arg0; }

	@Override
	public void setJre4(BigDecimal arg0) { this.JRE4 = arg0; }

	@Override
	public void setZkf(BigDecimal arg0) { this.ZKF = arg0; }

	@Override
	public void setLzzfreib(BigDecimal arg0) { this.LZZFREIB = arg0; }

	@Override
	public void setPkv(int arg0) { this.PKV = arg0; }

	@Override
	public void setVjahr(int arg0) { this.VJAHR = arg0; }

	@Override
	public void setVbezs(BigDecimal arg0) { this.VBEZS = arg0; }

	@Override
	public void setVmt(BigDecimal arg0) { this.VMT = arg0; }

	/* GETTER */

	@Override
	public BigDecimal getLstlzz() { return this.LSTLZZ; }

	@Override
	public BigDecimal getVfrb() { return this.VFRB; }

	@Override
	public BigDecimal getBk() { return this.BK; }

	@Override
	public BigDecimal getSolzv() { return this.SOLZV; }

	@Override
	public BigDecimal getBks() { return this.BKS; }

	@Override
	public BigDecimal getBkv() { return this.BKV; }

	@Override
	public BigDecimal getSolzs() { return this.SOLZS; }

	@Override
	public BigDecimal getVfrbs2() { return this.VFRBS2; }

	@Override
	public BigDecimal getVfrbs1() { return this.VFRBS1; }

	@Override
	public BigDecimal getVkvlzz() { return this.VKVLZZ; }

	@Override
	public BigDecimal getWvfrbm() { return this.WVFRBM; }

	@Override
	public BigDecimal getSts() { return this.STS; }

	@Override
	public BigDecimal getStv() { return this.STV; }

	@Override
	public BigDecimal getVkvsonst() { return this.VKVSONST; }

	@Override
	public BigDecimal getWvfrb() { return this.WVFRB; }

	@Override
	public BigDecimal getSolzlzz() { return this.SOLZLZZ; }

	@Override
	public BigDecimal getWvfrbo() { return this.WVFRBO; }

	/** PROGRAMMABLAUFPLAN, PAP Seite 13 */
	@Override
	public void main() {

		MPARA();
		MRE4JL();
		VBEZBSO= BigDecimal.ZERO;
		KENNVMT= 0;
		MRE4();
		MRE4ABZ();
		MBERECH();
		MSONST();
		MVMT();
	}

	/** Zuweisung von Werten für bestimmte Sozialversicherungsparameter  PAP Seite 14 */
	protected void MPARA() {

		if(KRV < 2) /** &lt; = < */{
			if(KRV == 0) {
				BBGRV = new BigDecimal(76200);/** Neu 2017 */
			} else {
				BBGRV = new BigDecimal(68400);/** Neu 2017 */
			}
			RVSATZAN = BigDecimal.valueOf(0.0935);
			TBSVORV = BigDecimal.valueOf(0.68);/** Neu 2017 */
		} else {/** Nichts zu tun */
		}
		BBGKVPV = new BigDecimal(52200);/** Neu 2017 */
		KVSATZAN = (KVZ.divide(ZAHL100)).add(BigDecimal.valueOf(0.07));
		KVSATZAG = BigDecimal.valueOf(0.07);
		if(PVS == 1) {
			PVSATZAN = BigDecimal.valueOf(0.01775);/** Neu 2017 */
			PVSATZAG = BigDecimal.valueOf(0.00775);/** Neu 2017 */
		} else {
			PVSATZAN =  BigDecimal.valueOf(0.01275);/** Neu 2017 */
			PVSATZAG =  BigDecimal.valueOf(0.01275);/** Neu 2017 */
		}
		if(PVZ == 1) {
			PVSATZAN = PVSATZAN.add(BigDecimal.valueOf(0.0025));
		}/** Anfang Neu 2017 */
		W1STKL5 = new BigDecimal(10240);
		W2STKL5 = new BigDecimal(27029);
		W3STKL5 = new BigDecimal(205043);
		GFB = new BigDecimal(8820);/** Ende Neu 2017 */
		SOLZFREI = new BigDecimal(972);
	}

	/** Ermittlung des Jahresarbeitslohns nach § 39 b Abs. 2 Satz 2 EStG, PAP Seite 15 */
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

	/** Freibeträge für Versorgungsbezüge, Altersentlastungsbetrag (§ 39b Abs. 2 Satz 3 EStG), PAP Seite 16 */
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
				if(VJAHR < 2040) {
					J= VJAHR - 2004;
				} else {
					J= 36;
				}
			}
			if(LZZ == 1) {
				VBEZB= (VBEZM.multiply (BigDecimal.valueOf (ZMVB))).add (VBEZS);
				HFVB= TAB2[J].divide (ZAHL12).multiply (BigDecimal.valueOf (ZMVB));
				FVBZ= TAB3[J].divide (ZAHL12).multiply (BigDecimal.valueOf (ZMVB)).setScale (0, BigDecimal.ROUND_UP);
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

	/** Altersentlastungsbetrag (§ 39b Abs. 2 Satz 3 EStG), PAP Seite 17 */
	protected void MRE4ALTE() {

		if(ALTER1 == 0) {
			ALTE= BigDecimal.ZERO;
		} else {
			if(AJAHR < 2006) {
				K= 1;
			} else {
				if(AJAHR < 2040) {
					K= AJAHR - 2004;
				} else {
					K= 36;
				}
			}
			BMG= ZRE4J.subtract (ZVBEZJ);/** Lt. PAP muss hier auf ganze EUR gerundet werden */
			ALTE = (BMG.multiply(TAB4[K])).setScale(0, BigDecimal.ROUND_UP);
			HBALTE= TAB5[K];
			if(ALTE.compareTo (HBALTE) == 1) {
				ALTE= HBALTE;
			}
		}
	}

	/** Ermittlung des Jahresarbeitslohns nach Abzug der Freibeträge nach § 39 b Abs. 2 Satz 3 und 4 EStG, PAP Seite 19 */
	protected void MRE4ABZ() {

		ZRE4= (ZRE4J.subtract (FVB).subtract   (ALTE).subtract (JLFREIB).add (JLHINZU)).setScale (2, BigDecimal.ROUND_DOWN);
		if(ZRE4.compareTo (BigDecimal.ZERO) == -1) {
			ZRE4= BigDecimal.ZERO;
		}
		ZRE4VP= ZRE4J;
		if(KENNVMT == 2) {
			ZRE4VP = ZRE4VP.subtract(ENTSCH.divide(ZAHL100)).setScale(2,BigDecimal.ROUND_DOWN);
		}
		ZVBEZ = ZVBEZJ.subtract(FVB).setScale(2, BigDecimal.ROUND_DOWN);
		if(ZVBEZ.compareTo(BigDecimal.ZERO) == -1) {
			ZVBEZ = BigDecimal.ZERO;
		}
	}

	/** Berechnung fuer laufende Lohnzahlungszeitraueme Seite 20 */
	protected void MBERECH() {

		MZTABFB();
		VFRB = ((ANP.add(FVB.add(FVBZ))).multiply(ZAHL100)).setScale(0, BigDecimal.ROUND_DOWN);
		MLSTJAHR();
		WVFRB = ((ZVE.subtract(GFB)).multiply(ZAHL100)).setScale(0, BigDecimal.ROUND_DOWN);
		if(WVFRB.compareTo(BigDecimal.ZERO) == -1) /** WVFRB < 0 */{
			WVFRB = BigDecimal.valueOf(0);
		}
		LSTJAHR = (ST.multiply(BigDecimal.valueOf(f))).setScale(0,BigDecimal.ROUND_DOWN);
		UPLSTLZZ();
		UPVKVLZZ();
		if(ZKF.compareTo(BigDecimal.ZERO) == 1) /** ZKF > 0 */{
			ZTABFB = ZTABFB.add(KFB);
			MRE4ABZ();
			MLSTJAHR();
			JBMG = (ST.multiply(BigDecimal.valueOf(f))).setScale(0,BigDecimal.ROUND_DOWN);
		} else {
			JBMG = LSTJAHR;
		}
		MSOLZ();
	}

	/** Ermittlung der festen Tabellenfreibeträge (ohne Vorsorgepauschale), PAP Seite 21 */
	protected void MZTABFB() {

		ANP= BigDecimal.ZERO;
		if(ZVBEZ.compareTo (BigDecimal.ZERO) >= 0 && ZVBEZ.compareTo(FVBZ) == -1) {
			FVBZ = BigDecimal.valueOf(ZVBEZ.longValue());
		}
		if(STKL < 6) {
			if(ZVBEZ.compareTo (BigDecimal.ZERO) == 1) {
				if((ZVBEZ.subtract (FVBZ)).compareTo (BigDecimal.valueOf (102)) == -1) {
					ANP= (ZVBEZ.subtract (FVBZ)).setScale (0, BigDecimal.ROUND_UP);
				} else {
					ANP= BigDecimal.valueOf (102);
				}
			}
		} else {
			FVBZ= BigDecimal.valueOf (0);
			FVBZSO= BigDecimal.valueOf (0);
		}
		if(STKL < 6) {
			if(ZRE4.compareTo(ZVBEZ) == 1) {
				if(ZRE4.subtract(ZVBEZ).compareTo(ZAHL1000) == -1) {
					ANP = ANP.add(ZRE4).subtract(ZVBEZ).setScale(0,BigDecimal.ROUND_UP);
				} else {
					ANP = ANP.add(ZAHL1000);
				}
			}
		}
		KZTAB= 1;
		if(STKL == 1) {
			SAP= BigDecimal.valueOf (36);
			KFB= (ZKF.multiply (BigDecimal.valueOf (7356))).setScale (0, BigDecimal.ROUND_DOWN);/** Neu 2017 */
		} else {
			if(STKL == 2) {
				EFA= BigDecimal.valueOf (1908);
				SAP= BigDecimal.valueOf (36);
				KFB= (ZKF.multiply (BigDecimal.valueOf (7356))).setScale (0, BigDecimal.ROUND_DOWN);/** Neu 2017 */
			} else {
				if(STKL == 3) {
					KZTAB= 2;
					SAP= BigDecimal.valueOf (36);
					KFB= (ZKF.multiply (BigDecimal.valueOf (7356))).setScale (0, BigDecimal.ROUND_DOWN);/** Neu 2017 */
				} else {
					if(STKL == 4) {
						SAP= BigDecimal.valueOf (36);
						KFB= (ZKF.multiply (BigDecimal.valueOf (3678))).setScale (0, BigDecimal.ROUND_DOWN);/** Neu 2017 */
					} else {
						if(STKL == 5) {
							SAP= BigDecimal.valueOf (36);
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

	/** Ermittlung Jahreslohnsteuer, PAP Seite 22 */
	protected void MLSTJAHR() {

		UPEVP();
		if(KENNVMT != 1) {
			ZVE= (ZRE4.subtract (ZTABFB).subtract (VSP)).setScale (2, BigDecimal.ROUND_DOWN);
			UPMLST();
		} else {
			ZVE= (ZRE4.subtract (ZTABFB).subtract (VSP).subtract ((VMT).divide (ZAHL100)).subtract ((VKAPA).divide (ZAHL100))).setScale (2, BigDecimal.ROUND_DOWN);
			if(ZVE.compareTo (BigDecimal.ZERO) == -1) {
				 ZVE = ZVE.add(VMT.divide(ZAHL100)).add(VKAPA.divide(ZAHL100)).divide(ZAHL5).setScale(2,BigDecimal.ROUND_DOWN);
				UPMLST();
				ST= (ST.multiply (ZAHL5)).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				UPMLST();
				STOVMT= ST;
				ZVE= (ZVE.add(((VMT.add (VKAPA)).divide (ZAHL500)))).setScale (2, BigDecimal.ROUND_DOWN);
				UPMLST();
				ST= (((ST.subtract (STOVMT)).multiply (ZAHL5)).add (STOVMT)).setScale (0, BigDecimal.ROUND_DOWN);
			}
		}
	}

	/** PAP Seite 23 */
	protected void UPVKVLZZ() {

		UPVKV();
		JW = VKV;
		UPANTEIL();
		VKVLZZ = ANTEIL1;
	}

	/** PAP Seite 23 */
	protected void UPVKV() {

		if(PKV > 0) {
			if(VSP2.compareTo(VSP3) == 1) {
				VKV = VSP2.multiply(ZAHL100);
			} else {
				VKV = VSP3.multiply(ZAHL100);
			}
		} else {
			VKV = BigDecimal.ZERO;
		}
	}

	/** PAP Seite 24 */
	protected void UPLSTLZZ() {

		JW = LSTJAHR.multiply(ZAHL100);
		UPANTEIL();
		LSTLZZ = ANTEIL1;
	}

	/** Ermittlung der Jahreslohnsteuer aus dem Einkommensteuertarif. PAP Seite 25 */
	protected void UPMLST() {

		if(ZVE.compareTo (ZAHL1) == -1) {
			ZVE= BigDecimal.ZERO;
			X= BigDecimal.ZERO;
		} else {
			X= (ZVE.divide (BigDecimal.valueOf(KZTAB))).setScale (0, BigDecimal.ROUND_DOWN);
		}
		if(STKL < 5) {/** Neu 2017 */
			UPTAB17();
		} else {
			MST5_6();
		}
	}

	/** Vorsorgepauschale (§ 39b Absatz 2 Satz 5 Nummer 3 und Absatz 4 EStG)<br>
  			Achtung: Es wird davon ausgegangen, dass	<br>
  				a) Es wird davon ausge-gangen, dassa) für die BBG (Ost) 60.000 Euro und für die BBG (West) 71.400 Euro festgelegt wird sowie<br>
  				b) der Beitragssatz zur Rentenversicherung auf 18,9 % gesenkt wird.<br>
  			<br>
  			PAP Seite 26 */
	protected void UPEVP() {

		if(KRV > 1) /** &lt; = < &gt; = > */{
			VSP1= BigDecimal.ZERO;
		} else {
			if(ZRE4VP.compareTo(BBGRV) == 1) {
				ZRE4VP = BBGRV;
			}
			VSP1 = (TBSVORV.multiply(ZRE4VP)).setScale(2,BigDecimal.ROUND_DOWN);
			VSP1 = (VSP1.multiply(RVSATZAN)).setScale(2,BigDecimal.ROUND_DOWN);
		}
		VSP2 = (ZRE4VP.multiply(BigDecimal.valueOf(0.12))).setScale(2,BigDecimal.ROUND_DOWN);
		if(STKL == 3) {
			VHB = BigDecimal.valueOf(3000);
		} else {
			VHB = BigDecimal.valueOf(1900);
		}
		if(VSP2.compareTo (VHB) == 1) {
			VSP2= VHB;
		}
		VSPN= (VSP1.add (VSP2)).setScale (0, BigDecimal.ROUND_UP);
		MVSP();
		if(VSPN.compareTo (VSP) == 1) {
			VSP= VSPN.setScale (2, BigDecimal.ROUND_DOWN);
		}
	}

	/** Vorsorgepauschale (§39b Abs. 2 Satz 5 Nr 3 EStG) Vergleichsberechnung fuer Guenstigerpruefung, PAP Seite 27 */
	protected void MVSP() {

		if(ZRE4VP.compareTo(BBGKVPV) == 1) {
			ZRE4VP = BBGKVPV;
		}
		if(PKV > 0) {
			if(STKL == 6) {
				VSP3 = BigDecimal.ZERO;
			} else {
				VSP3 = PKPV.multiply(ZAHL12).divide(ZAHL100);
				if(PKV == 2) {
					VSP3 = VSP3.subtract( ZRE4VP.multiply( KVSATZAG.add(PVSATZAG))).setScale(2,BigDecimal.ROUND_DOWN);
				}
			}
		} else {
			VSP3 = ZRE4VP.multiply(KVSATZAN.add(PVSATZAN)).setScale(2, BigDecimal.ROUND_DOWN);
		}
		VSP = VSP3.add(VSP1).setScale(0, BigDecimal.ROUND_UP);
	}

	/** Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Abs. 2 Satz 7 EStG), PAP Seite 28 */
	protected void MST5_6() {

		ZZX= X;
		if(ZZX.compareTo(W2STKL5) == 1) {
			ZX= W2STKL5;
			UP5_6();
			if(ZZX.compareTo (W3STKL5) == 1) {
				ST= (ST.add ((W3STKL5.subtract (W2STKL5)).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
				ST= (ST.add ((ZZX.subtract (W3STKL5)).multiply (BigDecimal.valueOf (0.45)))).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				ST= (ST.add ((ZZX.subtract (W2STKL5)).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
			}
		} else {
			ZX= ZZX;
			UP5_6();
			if(ZZX.compareTo (W1STKL5) == 1) {
				VERGL= ST;
				ZX= W1STKL5;
				UP5_6();
				HOCH= (ST.add ((ZZX.subtract (W1STKL5)).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);/** Neuer Wert 2014 */
				if(HOCH.compareTo (VERGL) == -1) {
					ST= HOCH;
				} else {
					ST= VERGL;
				}
			}
		}
	}

	/** Unterprogramm zur Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Abs. 2 Satz 7 EStG), PAP Seite 29 */
	protected void UP5_6() {

		X= (ZX.multiply (BigDecimal.valueOf (1.25))).setScale (2, BigDecimal.ROUND_DOWN);/** Neu 2017 */
		UPTAB17();
		ST1= ST;
		X= (ZX.multiply (BigDecimal.valueOf (0.75))).setScale (2, BigDecimal.ROUND_DOWN);/** Neu 2017 */
		UPTAB17();
		ST2= ST;
		DIFF= (ST1.subtract (ST2)).multiply (ZAHL2);
		MIST= (ZX.multiply (BigDecimal.valueOf (0.14))).setScale (0, BigDecimal.ROUND_DOWN);
		if(MIST.compareTo (DIFF) == 1) {
			ST= MIST;
		} else {
			ST= DIFF;
		}
	}

	/** Solidaritaetszuschlag, PAP Seite 30 */
	protected void MSOLZ() {

		SOLZFREI = (SOLZFREI.multiply(BigDecimal.valueOf(KZTAB)));
		if(JBMG.compareTo (SOLZFREI) == 1) {
			SOLZJ= (JBMG.multiply (BigDecimal.valueOf (5.5))).divide(ZAHL100).setScale(2, BigDecimal.ROUND_DOWN);
			SOLZMIN= (JBMG.subtract (SOLZFREI)).multiply (BigDecimal.valueOf (20)).divide (ZAHL100).setScale (2, BigDecimal.ROUND_DOWN);
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

	/** Anteil von Jahresbetraegen fuer einen LZZ (§ 39b Abs. 2 Satz 9 EStG), PAP Seite 31 */
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

	/** Berechnung sonstiger Bezuege nach § 39b Abs. 3 Saetze 1 bis 8 EStG), PAP Seite 32 */
	protected void MSONST() {

		LZZ= 1;
		if(ZMVB == 0) {
			ZMVB= 12;
		}
		if(SONSTB.compareTo (BigDecimal.ZERO) == 0) {
			VKVSONST= BigDecimal.ZERO;
			LSTSO= BigDecimal.ZERO;
			STS= BigDecimal.ZERO;
			SOLZS= BigDecimal.ZERO;
			BKS= BigDecimal.ZERO;
		} else {
			MOSONST();
			UPVKV();
			VKVSONST = VKV;
			ZRE4J= ((JRE4.add (SONSTB)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= ((JVBEZ.add (VBS)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			VBEZBSO= STERBE;
			MRE4SONST();
			MLSTJAHR();
			WVFRBM = (ZVE.subtract(GFB)).multiply(ZAHL100).setScale(2,BigDecimal.ROUND_DOWN);
			if(WVFRBM.compareTo(BigDecimal.ZERO) == -1) /** WVFRBM < 0 */{
				WVFRBM = BigDecimal.ZERO;
			}
			UPVKV();
			VKVSONST = VKV.subtract(VKVSONST);
			LSTSO= ST.multiply (ZAHL100);/** lt. PAP muss hier auf ganze EUR aufgerundet werden, <br>
        			allerdings muss der Wert in Cent vorgehalten werden,<br>
        			deshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'<br>
        			wieder die Multiplikation mit 100 */
			STS = LSTSO.subtract(LSTOSO).multiply(BigDecimal.valueOf(f)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN).multiply(ZAHL100);
			if(STS.compareTo (BigDecimal.ZERO) == -1) {
				STS= BigDecimal.ZERO;
			}
			SOLZS= STS.multiply (BigDecimal.valueOf (5.5)).divide (ZAHL100, 0, BigDecimal.ROUND_DOWN);
			if(R > 0) {
				BKS= STS;
			} else {
				BKS= BigDecimal.ZERO;
			}
		}
	}

	/** Berechnung der Verguetung fuer mehrjaehrige Taetigkeit nach § 39b Abs. 3 Satz 9 und 10 EStG), PAP Seite 33 */
	protected void MVMT() {

		if(VKAPA.compareTo (BigDecimal.ZERO) == -1) {
			VKAPA= BigDecimal.ZERO;
		}
		if((VMT.add (VKAPA)).compareTo (BigDecimal.ZERO) == 1) {
			if(LSTSO.compareTo (BigDecimal.ZERO) == 0) {
				MOSONST();
				LST1= LSTOSO;
			} else {
				LST1= LSTSO;
			}
			VBEZBSO= STERBE.add (VKAPA);
			ZRE4J= ((JRE4.add (SONSTB).add (VMT).add (VKAPA)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= ((JVBEZ.add (VBS).add (VKAPA)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			KENNVMT = 2;
			MRE4SONST();
			MLSTJAHR();
			LST3= ST.multiply (ZAHL100);
			MRE4ABZ();
			ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100)).subtract(SONSTENT.divide(ZAHL100));
			KENNVMT= 1;
			MLSTJAHR();
			LST2= ST.multiply (ZAHL100);
			STV= LST2.subtract (LST1);
			LST3= LST3.subtract (LST1);
			if(LST3.compareTo (STV) == -1) {
				STV= LST3;
			}
			if(STV.compareTo (BigDecimal.ZERO) == -1) {
				STV= BigDecimal.ZERO;
			} else {/** lt. PAP muss hier auf ganze EUR abgerundet werden.<br>
   	        	Allerdings muss auch hier der Wert in Cent vorgehalten werden,<br>
        			weshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'<br>
        			wieder die Multiplikation mit 100 erfolgt. */
				STV = STV.multiply(BigDecimal.valueOf(f)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN).multiply(ZAHL100);
			}
			SOLZV= ((STV.multiply (BigDecimal.valueOf (5.5))).divide (ZAHL100)).setScale (0, BigDecimal.ROUND_DOWN);
			if(R > 0) {
				BKV= STV;
			} else {
				BKV= BigDecimal.ZERO;
			}
		} else {
			STV= BigDecimal.ZERO;
			SOLZV= BigDecimal.ZERO;
			BKV= BigDecimal.ZERO;
		}
	}

	/** Sonderberechnung ohne sonstige Bezüge für Berechnung bei sonstigen Bezügen oder Vergütung für mehrjährige Tätigkeit, PAP Seite 34 */
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

	/** Sonderberechnung mit sonstige Bezüge für Berechnung bei sonstigen Bezügen oder Vergütung für mehrjährige Tätigkeit, PAP Seite 35 */
	protected void MRE4SONST() {

		MRE4();
		FVB= FVBSO;
		MRE4ABZ();
		ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100)).subtract(SONSTENT.divide(ZAHL100));
		FVBZ= FVBZSO;
		MZTABFB();
		VFRBS2 = ((((ANP.add(FVB).add(FVBZ))).multiply(ZAHL100))).subtract(VFRBS1);
	}

	/** Komplett Neu 2017 */
	/** Tarifliche Einkommensteuer §32a EStG, PAP Seite 36 */
	protected void UPTAB17() {

		if(X.compareTo(GFB.add(ZAHL1)) == -1) {
			ST= BigDecimal.ZERO;
		} else {
			if(X.compareTo (BigDecimal.valueOf (13770)) == -1) {
				Y = (X.subtract(GFB)).divide(ZAHL10000, 6,BigDecimal.ROUND_DOWN);
				RW= Y.multiply (BigDecimal.valueOf (1007.27));
				RW= RW.add (BigDecimal.valueOf (1400));
				ST= (RW.multiply (Y)).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				if(X.compareTo (BigDecimal.valueOf (54058)) == -1) {
					Y= (X.subtract (BigDecimal.valueOf (13769))).divide (ZAHL10000, 6, BigDecimal.ROUND_DOWN);
					RW= Y.multiply (BigDecimal.valueOf (223.76));
					RW= RW.add (BigDecimal.valueOf (2397));
					RW= RW.multiply (Y);
					ST= (RW.add (BigDecimal.valueOf (939.57))).setScale (0, BigDecimal.ROUND_DOWN);
				} else {
					if(X.compareTo (BigDecimal.valueOf (256304)) == -1) {
						ST= ((X.multiply (BigDecimal.valueOf (0.42))).subtract (BigDecimal.valueOf (8475.44))).setScale (0, BigDecimal.ROUND_DOWN);
					} else {
						ST= ((X.multiply (BigDecimal.valueOf (0.45))).subtract (BigDecimal.valueOf (16164.53))).setScale (0, BigDecimal.ROUND_DOWN);
					}
				}
			}
		}
		ST= ST.multiply (BigDecimal.valueOf (KZTAB));
	}

}