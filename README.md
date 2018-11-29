Lohnsteuer
==========

Java Rechner für Lohnsteuer + Generator aus Programmablaufplan (PAP) vom Bundesministerium für Finanzen (BMF)
(Stand 2019, Eclipse Projekt)

Code wird automatisch aus dem Programmablaufplan vom BMF erzeugt.<br>
Quelle: <a target="_blank" href="https://www.bmf-steuerrechner.de/interface/programmablauf.xhtml">https:/&#47;www.bmf-steuerrechner.de/interface/</a>

Benutzung als Netto-Lohnrechner: 

  - <a href="https://github.com/MarcelLehmann/Lohnsteuer/raw/master/LohnPapGenerator/lohnsteuer.jar">lohnsteuer.jar</a> in das eigene Projekt einbinden.
  - Aktuelle Instanz mittels Lohnsteuer.getInstance() holen.
  - Eingabevariablen mittels Setter-Methoden belegen. Z.B. über setJre4(...) den voraussichtlichen Jahresarbeitslohn übergeben. Die Methoden sind mit einem Kommentar versehen, der die jeweilige Bedeutung erläutert. Weitere Informationen sind unter <a target="_blank"  href="https://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2018-11-12-PAP-2019-anlage-1.pdf?__blob=publicationFile&v=1">Programmablaufplan 2019 PDF (BMF)</a> zu finden.
  - Methode main() aufrufen.
  - Ergebnis über die Getter-Methoden entsprechend auslesen. Z.B. liefert getLstlzz() die für den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents. Die Methoden sind ebenfalls mit einem Kommentar versehen, der die jeweilige Bedeutung erläutert. Weitere Informationen sind unter <a target="_blank"  href="https://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2018-11-12-PAP-2019-anlage-1.pdf?__blob=publicationFile&v=1">Programmablaufplan 2019 PDF (BMF)</a> zu finden.
  - Die Lohnsteuerberechnung für ein bestimmtes Datum erfolgt über Lohnsteuer.getInstance(Date date) oder direkt über die entsprechenden Klassen Lohnsteuer&lt;Jahr&gt;. Das Interface für die Getter und Setter-Methoden wird immer für den aktuellsten Rechner erstellt. Sollen Eingabe-/Ausgabewerte für ältere Rechner gelesen bzw. geschrieben werden, muss zuvor auf das entsprechende Jahr gecastet werden oder direkt der jeweilige Rechner als Instanz geladen werden. 
  - Der aktuellste Rechner ist für das Jahr 2019 und der älteste für 2006. (Stand 29.11.2018)

Verfügbare Rechner

 - <a target="_blank" href="https://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2018-11-12-PAP-2019-anlage-1.pdf?__blob=publicationFile&v=1">Programmablaufplan 2019 (PDF 525 KB)</a> 
 - <a target="_blank" href="https://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2017-11-23-PAP-2018-anlage-1-geaendert.pdf?__blob=publicationFile&v=1">Programmablaufplan 2018 (PDF 521 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2016-11-11-PAP-2017.pdf?__blob=publicationFile&v=3">Programmablaufplan 2017 (PDF 971 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2015-11-16-PAP-2016-anlage-1.pdf?__blob=publicationFile&v=3">Programmablaufplan 2016 (PDF 518 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2015-09-08-PAP-dezember-2015-anlage-1.pdf?__blob=publicationFile&v=3">Programmablaufplan 2015 Dezember (PDF 618 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2014-11-26-PAP-2015-anlage-1.pdf?__blob=publicationFile&v=3">Programmablaufplan 2015 bis November (PDF 591 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2013-12-03-entwuerfe-PAP-2014-anlage-1.pdf?__blob=publicationFile&v=3">Programmablaufplan 2014 (PDF 632 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/2013-02-20-PAP-2013_geaendert.pdf?__blob=publicationFile&v=5">Programmablaufplan 2013 (PDF 616 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/004_b_PAP_2012.pdf?__blob=publicationFile&v=3">Programmablaufplan 2012 (PDF 171 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/003_b_PAP_Dez_2011.pdf?__blob=publicationFile&v=3">Programmablaufplan Dezember 2011 (PDF 157 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/002_a_PAP_2011_maschinell.pdf?__blob=publicationFile&v=3">Programmablaufplan bis November 2011 (PDF 211 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/005_c_PAP_2010_Austausch.pdf?__blob=publicationFile&v=3">Programmablaufplan 2010 (PDF 202 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/012_PAP_2009_a.pdf?__blob=publicationFile&v=3">Programmablaufplan 2009 (PDF 144 KB)</a> 
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/011_PAP_2008_a.pdf?__blob=publicationFile&v=3">Programmablaufplan 2008 (PDF 143 KB)</a>
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/010_PAP_2007_a.pdf?__blob=publicationFile&v=3">Programmablaufplan 2007 (PDF 151 KB)</a>
 - <a target="_blank" href="http://www.bundesfinanzministerium.de/Content/DE/Downloads/Steuern/Steuerarten/Lohnsteuer/Programmablaufplan/006_PAP_2006_a.pdf?__blob=publicationFile&v=3">Programmablaufplan 2006 (PDF 195 KB)</a>

<h3>Lizenzinformation</h3>

    Copyright 2015-2016 Marcel Lehmann
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
