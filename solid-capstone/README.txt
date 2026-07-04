SOLID CAPSTONE - a report exporter
===================================

You are handed a report exporter that breaks almost every SOLID principle: it
would know every format itself, behind one growing switch. Reshape it so the
tests pass, by leaning on an interface instead of a switch.

Requires a JDK 17 or newer (records). Check:  java -version

WHAT TO DO
----------
1. Read report/RunTests.java first. It is the specification - do not edit it.
2. Fill in the TODOs in the report/ package:

     report/Report.java        the data (given - a record)
     report/ReportFormat.java  the seam: one small interface (given)          (ISP)
     report/CsvFormat.java     format a report as CSV                         (OCP, LSP)
     report/JsonFormat.java    format a report as JSON                        (OCP, LSP)
     report/ReportService.java validate, then use the INJECTED format         (SRP, DIP)

3. Run the tests until all eight are green:

     Windows:        run.cmd
     macOS / Linux:  ./run.sh

   Or by hand, from this folder:   javac report/*.java  &&  java report.RunTests

IN INTELLIJ
-----------
Open this solid-capstone folder and run the class report.RunTests (right-click
it, Run). Make every test green.

WHICH PRINCIPLE EACH TEST PROVES
--------------------------------
  - Handing the service a brand new format that just works: dependency inversion
    and open-closed. The service never changes; you extend by adding a class.
  - Every format honouring the same one-method contract: interface segregation
    and Liskov substitution - any format is usable through the interface.
  - The service rejecting a blank title while the formatter only formats: single
    responsibility. Validation is the service's job, not the formatter's.
