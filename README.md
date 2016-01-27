Lohnsteuer
==========

Java Rechner für Lohnsteuer + Generator aus Programmablaufplan (PAP) vom Bundesministerium für Finanzen (BMF)
(Stand 2016, Eclipse Projekt)

Code wird automatisch aus dem Programmablaufplan vom BMF erzeugt.<br>
Quelle: <a target="_blank" href="https://www.bmf-steuerrechner.de/interface/">https:/&#47;www.bmf-steuerrechner.de/interface/</a>

Benutzung als Netto-Lohnrechner: 

  - <a href="https://github.com/MarcelLehmann/Lohnsteuer/raw/master/LohnPapGenerator/lohnsteuer.jar">lohnsteuer.jar</a> in das eigene Projekt einbinden.
  - Aktuelle Instanz mittels Lohnsteuer.getInstance() holen.
  - Eingabevariablen mittels Setter-Methoden belegen. Z.B. über setJre4(...) den voraussichtlichen Jahresarbeitslohn übergeben. Die Methoden sind mit einem Kommentar versehen, der die jeweilige Bedeutung erläutert. Weitere Informationen sind unter <a target="_blank"  href="https://www.bmf-steuerrechner.de/pruefdaten/pap2016.pdf">Programmablaufplan 2016 PDF (BMF)</a> zu finden.
  - Methode main() aufrufen.
  - Ergebnis über die Getter-Methoden entsprechend auslesen. Z.B. liefert getLstlzz() die für den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents. Die Methoden sind ebenfalls mit einem Kommentar versehen, der die jeweilige Bedeutung erläutert. Weitere Informationen sind unter <a target="_blank"  href="https://www.bmf-steuerrechner.de/pruefdaten/pap2016.pdf">Programmablaufplan 2016 PDF (BMF)</a> zu finden.
  - Die Lohnsteuerberechnung für ein bestimmtes Datum erfolgt über Lohnsteuer.getInstance(Date date) oder direkt über die entsprechenden Klassen Lohnsteuer&lt;Jahr&gt;. Das Interface für die Getter und Setter-Methoden wird immer für den aktuellsten Rechner erstellt. Sollen Eingabe-/Ausgabewerte für ältere Rechner gelesen bzw. geschrieben werden, muss zuvor auf das entsprechende Jahr gecastet werden oder direkt der jeweilige Rechner als Instanz geladen werden. 
  - Der aktuellste Rechner ist für das Jahr 2016 und der älteste für 2006. (Stand 27.01.2016)

Verfügbare Rechner

 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2016.pdf"> 
Programmablaufplan 2016 (PDF 518 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2015Dezember.pdf"> 
Programmablaufplan 2015 Dezember (PDF 618 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2015bisNovember.pdf"> 
Programmablaufplan 2015 bis November (PDF 591 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2014.pdf"> 
Programmablaufplan 2014 (PDF 632 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2013_2.pdf"> 
Programmablaufplan 2013 (PDF 616 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2012.pdf"> 
Programmablaufplan 2012 (PDF 171 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2011Dezember.pdf">
Programmablaufplan Dezember 2011 (PDF 157 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2011bisNovember.pdf">
Programmablaufplan bis November 2011 (PDF 211 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2010.pdf">
Programmablaufplan 2010 (PDF 202 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2009.pdf">
Programmablaufplan 2009 (PDF 144 KB)
</a> 
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2008.pdf">
Programmablaufplan 2008 (PDF 143 KB)
</a>
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2007.pdf">
Programmablaufplan 2007 (PDF 151 KB)
</a>
 - <a target="_blank" href="https://www.bmf-steuerrechner.de/pruefdaten/pap2006.pdf">
Programmablaufplan 2006 (PDF 195 KB)
</a>

