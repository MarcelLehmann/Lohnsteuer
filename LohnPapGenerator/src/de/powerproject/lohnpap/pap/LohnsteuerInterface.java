package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) 
 * @date Tue Dec 14 20:16:22 CET 2021
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

	/** in VKAPA und VMT enthaltene Entschädigungen nach §24 Nummer 1 EStG <br>
	             sowie tarifermäßigt zu besteuernde Vorteile bei Vermögensbeteiligungen <br>
	             (§ 19a Absatz 4 EStG) in Cent */
	public void setEntsch(BigDecimal arg0);

	/** eingetragener Faktor mit drei Nachkommastellen */
	public void setF(double arg0);

	/** Jahresfreibetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge <br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung <br>
	             auf der Bescheinigung für den Lohnsteuerabzug 2022 in Cent (ggf. 0) */
	public void setJfreib(BigDecimal arg0);

	/** Jahreshinzurechnungsbetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge<br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung auf der <br>
	             Bescheinigung für den Lohnsteuerabzug 2022 in Cent (ggf. 0) */
	public void setJhinzu(BigDecimal arg0);

	/** Voraussichtlicher Jahresarbeitslohn ohne sonstige Bezüge (d.h. auch ohne Vergütung <br>
	             für mehrjährige Tätigkeit und ohne die zu besteuernden Vorteile bei Vermögensbeteiligungen,<br>
	             § 19a Absatz 4 EStG) in Cent. <br>
	             Anmerkung: Die Eingabe dieses Feldes (ggf. 0) ist erforderlich bei Eingaben zu sonstigen <br>
	             Bezügen (Felder SONSTB, VMT oder VKAPA). <br>
	             Sind in einem vorangegangenen Abrechnungszeitraum bereits sonstige Bezüge gezahlt worden,<br>
	             so sind sie dem voraussichtlichen Jahresarbeitslohn hinzuzurechnen. Gleiches gilt für zu <br>
	             besteuernde Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 EStG). Vergütungen für <br>
	             mehrjährige Tätigkeit aus einem vorangegangenen Abrechnungszeitraum werden in voller <br>
	             Höhe hinzugerechnet. */
	public void setJre4(BigDecimal arg0);

	/** In JRE4 enthaltene Versorgungsbezuege in Cents (ggf. 0) */
	public void setJvbez(BigDecimal arg0);

	/** Merker für die Vorsorgepauschale<br>
				2 = der Arbeitnehmer ist NICHT in der gesetzlichen Rentenversicherung versichert.<br>
				<br>
				1 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die <br>
					Beitragsbemessungsgrenze OST.<br>
					<br>
				0 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die <br>
					Beitragsbemessungsgrenze WEST. */
	public void setKrv(int arg0);

	/** Einkommensbezogener Zusatzbeitragssatz eines gesetzlich krankenversicherten Arbeitnehmers, <br>
			 auf dessen Basis der an die Krankenkasse zu zahlende Zusatzbeitrag berechnet wird,<br>
			 in Prozent (bspw. 0,90 für 0,90 %) mit 2 Dezimalstellen. <br>
			 Der von der Kranken-kasse festgesetzte Zusatzbeitragssatz ist bei Abweichungen unmaßgeblich. */
	public void setKvz(BigDecimal arg0);

	/** Lohnzahlungszeitraum:<br>
	             1 = Jahr<br>
	             2 = Monat<br>
	             3 = Woche<br>
	             4 = Tag */
	public void setLzz(int arg0);

	/** Der als elektronisches Lohnsteuerabzugsmerkmal für den Arbeitgeber nach § 39e EStG festgestellte <br>
	             oder in der Bescheinigung für den Lohnsteuerabzug 2022 eingetragene Freibetrag für den <br>
	             Lohnzahlungszeitraum in Cent */
	public void setLzzfreib(BigDecimal arg0);

	/** Der als elektronisches Lohnsteuerabzugsmerkmal für den Arbeitgeber nach § 39e EStG festgestellte <br>
	             oder in der Bescheinigung für den Lohnsteuerabzug 2022 eingetragene Hinzurechnungsbetrag für den<br>
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

	/** 1, wenn bei der sozialen Pflegeversicherung die Besonderheiten in Sachsen zu berücksichtigen sind bzw. <br>
	        	 	zu berücksichtigen wären, sonst 0. */
	public void setPvs(int arg0);

	/** 1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung <br>
	        	 	zu zahlen hat, sonst 0. */
	public void setPvz(int arg0);

	/** Religionsgemeinschaft des Arbeitnehmers lt. elektronischer Lohnsteuerabzugsmerkmale oder der <br>
	             Bescheinigung für den Lohnsteuerabzug 2022 (bei keiner Religionszugehörigkeit = 0) */
	public void setR(int arg0);

	/** Steuerpflichtiger Arbeitslohn für den Lohnzahlungszeitraum vor Berücksichtigung des <br>
	             Versorgungsfreibetrags und des Zuschlags zum Versorgungsfreibetrag, des Altersentlastungsbetrags <br>
	             und des als elektronisches Lohnsteuerabzugsmerkmal festgestellten oder in der Bescheinigung für <br>
	             den Lohnsteuerabzug 2022 für den Lohnzahlungszeitraum eingetragenen Freibetrags bzw. <br>
	             Hinzurechnungsbetrags in Cent */
	public void setRe4(BigDecimal arg0);

	/** Sonstige Bezüge (ohne Vergütung aus mehrjähriger Tätigkeit) einschließlich nicht tarifermäßigt <br>
	             zu besteuernde Vorteile bei Vermögensbeteiligungen und Sterbegeld bei Versorgungsbezügen sowie <br>
	             Kapitalauszahlungen/Abfindungen, soweit es sich nicht um Bezüge für mehrere Jahre handelt, <br>
	             in Cent (ggf. 0) */
	public void setSonstb(BigDecimal arg0);

	/** Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,<br>
	             soweit es sich nicht um Bezuege fuer mehrere Jahre handelt<br>
	             (in SONSTB enthalten) in Cents */
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

	/** Kapitalauszahlungen / Abfindungen / Nachzahlungen bei Versorgungsbezügen <br>
	             für mehrere Jahre in Cent (ggf. 0) */
	public void setVkapa(BigDecimal arg0);

	/** Entschädigungen und Vergütung für mehrjährige Tätigkeit sowie tarifermäßigt <br>
			     zu besteuernde Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 Satz 2 EStG) <br>
			     ohne Kapitalauszahlungen und ohne Abfindungen bei Versorgungsbezügen <br>
			     in Cent (ggf. 0) */
	public void setVmt(BigDecimal arg0);

	/** Zahl der Freibetraege fuer Kinder (eine Dezimalstelle, nur bei Steuerklassen<br>
	             I, II, III und IV) */
	public void setZkf(BigDecimal arg0);

	/** Zahl der Monate, fuer die Versorgungsbezuege gezahlt werden (nur<br>
	             erforderlich bei Jahresberechnung (LZZ = 1) */
	public void setZmvb(int arg0);

	/** In JRE4 enthaltene Entschädigungen nach § 24 Nummer 1 EStG und zu besteuernde <br>
	             Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 EStG in Cent */
	public void setJre4ent(BigDecimal arg0);

	/** In SONSTB enthaltene Entschädigungen nach § 24 Nummer 1 EStG sowie nicht <br>
	    	     tarifermäßigt zu besteuernde Vorteile bei Vermögensbeteiligungen in Cent */
	public void setSonstent(BigDecimal arg0);

	/** Bemessungsgrundlage fuer die Kirchenlohnsteuer in Cents */
	public BigDecimal getBk();

	/** Bemessungsgrundlage der sonstigen Bezüge (ohne Vergütung für mehrjährige Tätigkeit)<br>
	             für die Kirchenlohnsteuer in Cent.<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei <br>
                 Vermögensbeteiligungen (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern BK <br>
                 (maximal bis 0). Der Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen <br>
                 im Rahmen der Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getBks();

	/** Bemessungsgrundlage der Vergütung für mehrjährige Tätigkeit und der tarifermäßigt <br>
	             zu besteuernden Vorteile bei Vermögensbeteiligungen für die Kirchenlohnsteuer in Cent */
	public BigDecimal getBkv();

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

	/** Solidaritätszuschlag für die Vergütung für mehrjährige Tätigkeit und der tarifermäßigt <br>
	             zu besteuernden Vorteile bei Vermögensbeteiligungen in Cent */
	public BigDecimal getSolzv();

	/** Lohnsteuer für sonstige Bezüge (ohne Vergütung für mehrjährige Tätigkeit und ohne <br>
	             tarifermäßigt zu besteuernde Vorteile bei Vermögensbeteiligungen) in Cent<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei Vermögensbeteiligungen<br>
                 (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern LSTLZZ (maximal bis 0). Der <br>
                 Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen im Rahmen der <br>
                 Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getSts();

	/** Lohnsteuer für die Vergütung für mehrjährige Tätigkeit und der tarifermäßigt zu besteuernden<br>
	             Vorteile bei Vermögensbeteiligungen in Cent */
	public BigDecimal getStv();

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
				 auch negativ sein. Für tarifermäßigt zu besteuernde Vergütungen für mehrjährige <br>
				 Tätigkeiten enthält der PAP keinen entsprechenden Ausgabewert. */
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
