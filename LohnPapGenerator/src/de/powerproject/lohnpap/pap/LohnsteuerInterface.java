package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) 
 * @date Sun Nov 30 15:13:33 CET 2025
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

	/** Merker für die Vorsorgepauschale<br>
				 0 = der Arbeitnehmer ist in der Arbeitslosenversicherung pflichtversichert; es gilt die allgemeine Beitragsbemessungsgrenze<br>
				 1 = wenn nicht 0 */
	public void setAlv(int arg0);

	/** eingetragener Faktor mit drei Nachkommastellen */
	public void setF(double arg0);

	/** Jahresfreibetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge <br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung <br>
	             auf der Bescheinigung für den Lohnsteuerabzug 2026 in Cent (ggf. 0) */
	public void setJfreib(BigDecimal arg0);

	/** Jahreshinzurechnungsbetrag für die Ermittlung der Lohnsteuer für die sonstigen Bezüge<br>
	             sowie für Vermögensbeteiligungen nach § 19a Absatz 1 und 4 EStG nach Maßgabe der <br>
	             elektronischen Lohnsteuerabzugsmerkmale nach § 39e EStG oder der Eintragung auf der <br>
	             Bescheinigung für den Lohnsteuerabzug 2026 in Cent (ggf. 0) */
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

	/** In JRE4 enthaltene Entschädigungen nach § 24 Nummer 1 EStG und zu besteuernde<br>
	             Vorteile bei Vermögensbeteiligungen (§ 19a Absatz 4 EStG) in Cent */
	public void setJre4ent(BigDecimal arg0);

	/** In JRE4 enthaltene Versorgungsbezüge in Cent (ggf. 0) */
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
	             oder in der Bescheinigung für den Lohnsteuerabzug 2026 eingetragene Freibetrag für den <br>
	             Lohnzahlungszeitraum in Cent */
	public void setLzzfreib(BigDecimal arg0);

	/** Der als elektronisches Lohnsteuerabzugsmerkmal für den Arbeitgeber nach § 39e EStG festgestellte <br>
	             oder in der Bescheinigung für den Lohnsteuerabzug 2026 eingetragene Hinzurechnungsbetrag für den<br>
	             Lohnzahlungszeitraum in Cent */
	public void setLzzhinzu(BigDecimal arg0);

	/** Nicht zu besteuernde Vorteile bei Vermögensbeteiligungen <br>
	             (§ 19a Absatz 1 Satz 4 EStG) in Cent */
	public void setMbv(BigDecimal arg0);

	/** Dem Arbeitgeber mitgeteilte Beiträge des Arbeitnehmers für eine private<br>
	             Basiskranken- bzw. Pflege-Pflichtversicherung im Sinne des <br>
	             § 10 Absatz 1 Nummer 3 EStG in Cent; der Wert ist unabhängig vom Lohnzahlungszeitraum <br>
	             immer als Monatsbetrag anzugeben */
	public void setPkpv(BigDecimal arg0);

	/** Arbeitgeberzuschuss für eine private Basiskranken- bzw. Pflege-Pflichtversicherung im <br>
	             Sinne des § 10 Absatz 1 Nummer 3 EStG in Cent; der Wert ist unabhängig vom <br>
	             Lohnzahlungszeitraum immer als Monatsbetrag anzugeben */
	public void setPkpvagz(BigDecimal arg0);

	/** Krankenversicherung:<br>
	             0 = gesetzlich krankenversicherte Arbeitnehmer<br>
	             1 = ausschließlich privat krankenversicherte Arbeitnehmer */
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
	        	 	zu berücksichtigen wären */
	public void setPvs(int arg0);

	/** 1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung <br>
	        	 	zu zahlen hat */
	public void setPvz(int arg0);

	/** Religionsgemeinschaft des Arbeitnehmers lt. elektronischer Lohnsteuerabzugsmerkmale oder der <br>
	             Bescheinigung für den Lohnsteuerabzug 2026 (bei keiner Religionszugehörigkeit = 0) */
	public void setR(int arg0);

	/** Steuerpflichtiger Arbeitslohn für den Lohnzahlungszeitraum vor Berücksichtigung des <br>
	             Versorgungsfreibetrags und des Zuschlags zum Versorgungsfreibetrag, des Altersentlastungsbetrags <br>
	             und des als elektronisches Lohnsteuerabzugsmerkmal festgestellten oder in der Bescheinigung für <br>
	             den Lohnsteuerabzug 2026 für den Lohnzahlungszeitraum eingetragenen Freibetrags bzw. <br>
	             Hinzurechnungsbetrags in Cent */
	public void setRe4(BigDecimal arg0);

	/** Sonstige Bezüge einschließlich zu besteuernde Vorteile bei Vermögensbeteiligungen und Sterbegeld bei Versorgungsbezügen sowie <br>
	             Kapitalauszahlungen/Abfindungen, in Cent (ggf. 0) */
	public void setSonstb(BigDecimal arg0);

	/** In SONSTB enthaltene Entschädigungen nach § 24 Nummer 1 EStG sowie zu besteuernde Vorteile bei Vermögensbeteiligungen (§ 19a<br>
			     Absatz 4 EStG), in Cent */
	public void setSonstent(BigDecimal arg0);

	/** Sterbegeld bei Versorgungsbezügen sowie Kapitalauszahlungen/Abfindungen<br>
	              (in SONSTB enthalten), in Cent */
	public void setSterbe(BigDecimal arg0);

	/** Steuerklasse:<br>
	             1 = I<br>
	             2 = II<br>
	             3 = III<br>
	             4 = IV<br>
	             5 = V<br>
	             6 = VI */
	public void setStkl(int arg0);

	/** In RE4 enthaltene Versorgungsbezüge in Cent (ggf. 0) ggf. unter Berücksichtigung <br>
	             einer geänderten Bemessungsgrundlage nach  § 19 Absatz 2 Satz 10 und 11 EStG */
	public void setVbez(BigDecimal arg0);

	/** Versorgungsbezug im Januar 2005 bzw. für den ersten vollen Monat, wenn der <br>
	             Versorgungsbezug erstmalig nach Januar 2005 gewährt  wurde, in Cent */
	public void setVbezm(BigDecimal arg0);

	/** Voraussichtliche Sonderzahlungen von Versorgungsbezügen im<br>
				 Kalenderjahr des Versorgungsbeginns bei Versorgungsempfängern<br>
				 ohne Sterbegeld, Kapitalauszahlungen/Abfindungen in Cent */
	public void setVbezs(BigDecimal arg0);

	/** In SONSTB enthaltene Versorgungsbezüge einschließlich Sterbegeld in Cent (ggf. 0) */
	public void setVbs(BigDecimal arg0);

	/** Jahr, in dem der Versorgungsbezug erstmalig gewährt wurde;<br>
				 werden mehrere Versorgungsbezüge gezahlt, wird aus<br>
				 Vereinfachungsgründen für die Berechnung das Jahr des ältesten<br>
				 erstmaligen Bezugs herangezogen; auf die Möglichkeit der<br>
				 getrennten Abrechnung verschiedenartiger Bezüge (§ 39e Absatz 5a<br>
				 EStG) wird im Übrigen verwiesen */
	public void setVjahr(int arg0);

	/** Zahl der Freibeträge für Kinder (eine Dezimalstelle, nur bei Steuerklassen<br>
	             I, II, III und IV) */
	public void setZkf(BigDecimal arg0);

	/** Zahl der Monate, für die Versorgungsbezüge gezahlt werden [nur<br>
	             erforderlich bei Jahresberechnung (LZZ = 1)] */
	public void setZmvb(int arg0);

	/** Bemessungsgrundlage für die Kirchenlohnsteuer in Cent */
	public BigDecimal getBk();

	/** Bemessungsgrundlage der sonstigen Bezüge  für die Kirchenlohnsteuer in Cent.<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei <br>
                 Vermögensbeteiligungen (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern BK <br>
                 (maximal bis 0). Der Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen <br>
                 im Rahmen der Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getBks();

	/** Für den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cent */
	public BigDecimal getLstlzz();

	/** Für den Lohnzahlungszeitraum einzubehaltender Solidaritätszuschlag<br>
	             in Cent */
	public BigDecimal getSolzlzz();

	/** Solidaritätszuschlag für sonstige Bezüge in Cent.<br>
				 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei<br>
				 Vermögensbeteiligungen (§ 19a Absatz 1 Satz 4 EStG) resultieren,<br>
				 mindern SOLZLZZ (maximal bis 0). Der Sonderausgabenabzug für<br>
				 tatsächlich erbrachte Vorsorgeaufwendungen im Rahmen der<br>
				 Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getSolzs();

	/** Lohnsteuer für sonstige Bezüge in Cent<br>
                 Hinweis: Negativbeträge, die aus nicht zu besteuernden Vorteilen bei Vermögensbeteiligungen<br>
                 (§ 19a Absatz 1 Satz 4 EStG) resultieren, mindern LSTLZZ (maximal bis 0). Der <br>
                 Sonderausgabenabzug für tatsächlich erbrachte Vorsorgeaufwendungen im Rahmen der <br>
                 Veranlagung zur Einkommensteuer bleibt unberührt. */
	public BigDecimal getSts();

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
