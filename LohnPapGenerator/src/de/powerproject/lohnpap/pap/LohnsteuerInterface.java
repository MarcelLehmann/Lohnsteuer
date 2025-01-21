package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) 
 * @date Tue Jan 21 19:46:29 CET 2025
 * 
 */

public interface LohnsteuerInterface {
	
	public void main();

	/** 1, wenn die Anwendung des Faktorverfahrens gewählt wurden (nur in Steuerklasse IV) */
	public void setAf(int arg0);

	/** Auf die Vollendung des 64. Lebensjahres folgende<br>
	             Kalenderjahr (erforderlich, wenn ALTER1=1) */
	public void setAjahr(int arg0);

	/** 1, wenn das 64. Lebensjahr zu Beginn des Kalenderjahres vollendet wurde, in dem<br>
	             der Lohnzahlungszeitraum endet (§ 24 a EStG), sonst = 0 */
	public void setAlter1(int arg0);

	/** eingetragener Faktor mit drei Nachkommastellen */
	public void setF(double arg0);

	/** Jahresfreibetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge <br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung <br>
	             auf der Bescheinigung für den Lohnsteuerabzug 2025 in Cent (ggf. 0) */
	public void setJfreib(BigDecimal arg0);

	/** Jahreshinzurechnungsbetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge<br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung auf der <br>
	             Bescheinigung für den Lohnsteuerabzug 2025 in Cent (ggf. 0) */
	public void setJhinzu(BigDecimal arg0);

	/** Voraussichtlicher Jahresarbeitslohn ohne sonstige Bezüge (d.h. auch ohne <br>
	             die zu besteuernden Vorteile bei Vermögensbeteiligungen,<br>
	             § 19a Absatz 4 EStG) in Cent. <br>
	             Anmerkung: Die Eingabe dieses Feldes (ggf. 0) ist erforderlich bei Eingaben zu sonstigen <br>
	             Bezügen (Feld SONSTB). <br>
	             Sind in einem vorangegangenen Abrechnungszeitraum bereits sonstige Bezüge gezahlt worden,<br>
	             so sind sie dem voraussichtlichen Jahresarbeitslohn hinzuzurechnen. Gleiches gilt für zu <br>
	             besteuernde Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 EStG). */
	public void setJre4(BigDecimal arg0);

	/** In JRE4 enthaltene Entschädigungen nach § 24 Nummer 1 EStG und zu besteuernde <br>
	             Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 EStG in Cent */
	public void setJre4ent(BigDecimal arg0);

	/** In JRE4 enthaltene Versorgungsbezuege in Cents (ggf. 0) */
	public void setJvbez(BigDecimal arg0);

	/** Merker für die Vorsorgepauschale<br>
				0 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung oder einer <br>
				berufsständischen Versorgungseinrichtung pflichtversichert oder bei Befreiung von der <br>
				Versicherungspflicht freiwillig versichert; es gilt die allgemeine Beitragsbemessungsgrenze<br>
				<br>
				1 = wenn nicht 0 */
	public void setKrv(int arg0);

	/** Kassenindividueller Zusatzbeitragssatz bei einem gesetzlich krankenversicherten Arbeitnehmer <br>
			 in Prozent (bspw. 2,50 für 2,50 %) mit 2 Dezimalstellen. <br>
			 Es ist der volle Zusatzbeitragssatz anzugeben. Die Aufteilung in Arbeitnehmer- und Arbeitgeber-<br>
			 anteil erfolgt im Programmablauf. */
	public void setKvz(BigDecimal arg0);

	/** Lohnzahlungszeitraum:<br>
	             1 = Jahr<br>
	             2 = Monat<br>
	             3 = Woche<br>
	             4 = Tag */
	public void setLzz(int arg0);

	/** Der als elektronisches Lohnsteuerabzugsmerkmal für den Arbeitgeber nach § 39e EStG festgestellte <br>
	             oder in der Bescheinigung für den Lohnsteuerabzug 2025 eingetragene Freibetrag für den <br>
	             Lohnzahlungszeitraum in Cent */
	public void setLzzfreib(BigDecimal arg0);

	/** Der als elektronisches Lohnsteuerabzugsmerkmal für den Arbeitgeber nach § 39e EStG festgestellte <br>
	             oder in der Bescheinigung für den Lohnsteuerabzug 2025 eingetragene Hinzurechnungsbetrag für den<br>
	             Lohnzahlungszeitraum in Cent */
	public void setLzzhinzu(BigDecimal arg0);

	/** Nicht zu besteuernde Vorteile bei Vermögensbeteiligungen <br>
	             (§ 19a Absatz 1 Satz 4 EStG) in Cent */
	public void setMbv(BigDecimal arg0);

	/** Dem Arbeitgeber mitgeteilte Zahlungen des Arbeitnehmers zur privaten<br>
	             Kranken- bzw. Pflegeversicherung im Sinne des §10 Abs. 1 Nr. 3 EStG 2010<br>
	             als Monatsbetrag in Cent (der Wert ist inabhängig vom Lohnzahlungszeitraum immer <br>
	             als Monatsbetrag anzugeben). */
	public void setPkpv(BigDecimal arg0);

	/** Krankenversicherung:<br>
	             0 = gesetzlich krankenversicherte Arbeitnehmer<br>
	             1 = ausschließlich privat krankenversicherte Arbeitnehmer OHNE Arbeitgeberzuschuss<br>
	             2 = ausschließlich privat krankenversicherte Arbeitnehmer MIT Arbeitgeberzuschuss */
	public void setPkv(int arg0);

	/** Zahl der beim Arbeitnehmer zu berücksichtigenden Beitragsabschläge in der sozialen Pflegeversicherung<br>
	             bei mehr als einem Kind<br>
	             0 = kein Abschlag<br>
				 1 = Beitragsabschlag für das 2. Kind<br>
				 2 = Beitragsabschläge für das 2. und 3. Kind<br>
				 3 = Beitragsabschläge für 2. bis 4. Kinder<br>
				 4 = Beitragsabschläge für 2. bis 5. oder mehr Kinder */
	public void setPva(BigDecimal arg0);

	/** 1, wenn bei der sozialen Pflegeversicherung die Besonderheiten in Sachsen zu berücksichtigen sind bzw. <br>
	        	 	zu berücksichtigen wären, sonst 0. */
	public void setPvs(int arg0);

	/** 1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung <br>
	        	 	zu zahlen hat, sonst 0. */
	public void setPvz(int arg0);

	/** Religionsgemeinschaft des Arbeitnehmers lt. elektronischer Lohnsteuerabzugsmerkmale oder der <br>
	             Bescheinigung für den Lohnsteuerabzug 2025 (bei keiner Religionszugehörigkeit = 0) */
	public void setR(int arg0);

	/** Steuerpflichtiger Arbeitslohn für den Lohnzahlungszeitraum vor Berücksichtigung des <br>
	             Versorgungsfreibetrags und des Zuschlags zum Versorgungsfreibetrag, des Altersentlastungsbetrags <br>
	             und des als elektronisches Lohnsteuerabzugsmerkmal festgestellten oder in der Bescheinigung für <br>
	             den Lohnsteuerabzug 2025 für den Lohnzahlungszeitraum eingetragenen Freibetrags bzw. <br>
	             Hinzurechnungsbetrags in Cent */
	public void setRe4(BigDecimal arg0);

	/** Sonstige Bezüge einschließlich zu besteuernde Vorteile bei Vermögensbeteiligungen und Sterbegeld bei Versorgungsbezügen sowie <br>
	             Kapitalauszahlungen/Abfindungen, in Cent (ggf. 0) */
	public void setSonstb(BigDecimal arg0);

	/** In SONSTB enthaltene Entschädigungen nach § 24 Nummer 1 EStG */
	public void setSonstent(BigDecimal arg0);

	/** Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,<br>
	              (in SONSTB enthalten) in Cent */
	public void setSterbe(BigDecimal arg0);

	/** Steuerklasse:<br>
	             1 = I<br>
	             2 = II<br>
	             3 = III<br>
	             4 = IV<br>
	             5 = V<br>
	             6 = VI */
	public void setStkl(int arg0);

	/** In RE4 enthaltene Versorgungsbezuege in Cents (ggf. 0) */
	public void setVbez(BigDecimal arg0);

	/** Vorsorgungsbezug im Januar 2005 bzw. fuer den ersten vollen Monat<br>
	             in Cents */
	public void setVbezm(BigDecimal arg0);

	/** Voraussichtliche Sonderzahlungen im Kalenderjahr des Versorgungsbeginns<br>
	             bei Versorgungsempfaengern ohne Sterbegeld, Kapitalauszahlungen/Abfindungen<br>
	             bei Versorgungsbezuegen in Cents */
	public void setVbezs(BigDecimal arg0);

	/** In SONSTB enthaltene Versorgungsbezuege einschliesslich Sterbegeld<br>
	            in Cents (ggf. 0) */
	public void setVbs(BigDecimal arg0);

	/** Jahr, in dem der Versorgungsbezug erstmalig gewaehrt wurde; werden<br>
	             mehrere Versorgungsbezuege gezahlt, so gilt der aelteste erstmalige Bezug */
	public void setVjahr(int arg0);

	/** Zahl der Freibetraege fuer Kinder (eine Dezimalstelle, nur bei Steuerklassen<br>
	             I, II, III und IV) */
	public void setZkf(BigDecimal arg0);

	/** Zahl der Monate, fuer die Versorgungsbezuege gezahlt werden (nur<br>
	             erforderlich bei Jahresberechnung (LZZ = 1) */
	public void setZmvb(int arg0);

	/** Bemessungsgrundlage fuer die Kirchenlohnsteuer in Cents */
	public BigDecimal getBk();

	/** Bemessungsgrundlage der sonstigen Bezüge  für die Kirchenlohnsteuer in Cent.<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei <br>
                 Vermögensbeteiligungen (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern BK <br>
                 (maximal bis 0). Der Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen <br>
                 im Rahmen der Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getBks();

	/** Fuer den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents */
	public BigDecimal getLstlzz();

	/** Fuer den Lohnzahlungszeitraum einzubehaltender Solidaritaetszuschlag<br>
	             in Cents */
	public BigDecimal getSolzlzz();

	/** Solidaritätszuschlag für sonstige Bezüge (ohne Vergütung für mehrjährige Tätigkeit in Cent.<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei Vermögensbeteiligungen <br>
                 (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern SOLZLZZ (maximal bis 0). Der <br>
                 Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen im Rahmen der <br>
                 Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getSolzs();

	/** Lohnsteuer für sonstige Bezüge in Cent<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei Vermögensbeteiligungen<br>
                 (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern LSTLZZ (maximal bis 0). Der <br>
                 Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen im Rahmen der <br>
                 Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getSts();

	/** Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers zur<br>
				 privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. auch<br>
				 die Mindestvorsorgepauschale) in Cent beim laufenden Arbeitslohn. Für Zwecke der Lohn-<br>
				 steuerbescheinigung sind die einzelnen Ausgabewerte außerhalb des eigentlichen Lohn-<br>
				 steuerbescheinigungsprogramms zu addieren; hinzuzurechnen sind auch die Ausgabewerte<br>
				 VKVSONST */
	public BigDecimal getVkvlzz();

	/** Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers <br>
				 zur privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. <br>
				 auch die Mindestvorsorgepauschale) in Cent bei sonstigen Bezügen. Der Ausgabewert kann<br>
				 auch negativ sein. */
	public BigDecimal getVkvsonst();

	/** Verbrauchter Freibetrag bei Berechnung des laufenden Arbeitslohns, in Cent */
	public BigDecimal getVfrb();

	/** Verbrauchter Freibetrag bei Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent */
	public BigDecimal getVfrbs1();

	/** Verbrauchter Freibetrag bei Berechnung der sonstigen Bezüge, in Cent */
	public BigDecimal getVfrbs2();

	/** Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE über <br>
				dem Grundfreibetrag bei der Berechnung des laufenden Arbeitslohns, in Cent */
	public BigDecimal getWvfrb();

	/** Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE über dem Grundfreibetrag <br>
				bei der Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent */
	public BigDecimal getWvfrbo();

	/** Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE <br>
				über dem Grundfreibetrag bei der Berechnung der sonstigen Bezüge, in Cent */
	public BigDecimal getWvfrbm();
}
