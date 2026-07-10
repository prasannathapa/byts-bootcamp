DAY 1 CAPSTONE - object design, end to end
===========================================

One capstone in three parts. Part 1 exercises the four pillars of OOP; part 2
exercises the five SOLID principles; the finale ties them together. Read the
RunTests.java in each part first - the tests are the specification.

Requires Java 25 (JDK) - the same version used all week. Check:  java -version


SETUP - brand new? follow this exactly (Windows / macOS / Linux)
---------------------------------------------------------------
You need two tools: Git (downloads the code) and a Java 25 JDK (compiles and
runs it). Do these five steps in order.

  1) INSTALL GIT
       Windows         winget install Git.Git
       macOS           brew install git
       Linux           sudo apt install git
       no package mgr  download from  https://git-scm.com/downloads
     check it:         git --version          (should print a version)

  2) INSTALL JAVA 25 (JDK) - free, from Adoptium Temurin
       Windows         winget install EclipseAdoptium.Temurin.25.JDK
       macOS           brew install --cask temurin@25
       Linux / any OS  download from  https://adoptium.net
     check it:         java -version          (must say 25 - not 8 or 17)

  3) CLONE THE CODE  (same command on every OS)
       git clone https://github.com/prasannathapa/byts-bootcamp.git
       cd byts-bootcamp

  4) OPEN IT IN AN IDE
       IntelliJ IDEA (preferred): File > Open > pick the byts-bootcamp folder > Trust
       VS Code:                   run  code .   then install "Extension Pack for Java"

  5) GO TO TODAY'S FOLDER AND RUN THE TESTS
       cd day-1-capstone
       macOS / Linux:            ./run.sh
       Windows (PowerShell):     .\run.cmd
     The ./ and .\ are part of the command - keep them, they mean "run it here".

You will see FAILING tests. That is expected - the failures are your to-do list.
Fill in the TODOs until every part reports 0 failed. Each part also has its own
run.cmd / run.sh if you want to run one at a time.


PART 1 - a tiny bank            (folder: part1-bank/, package: bank)
--------------------------------------------------------------------
A small program that needs all four pillars at once. Fill in the TODOs:

    bank/Account.java      a balance that can never go negative     (encapsulation)
    bank/Transaction.java  a sealed family (interface given)         (abstraction)
                           Deposit / Withdraw / Transfer apply()      (polymorphism)
    bank/Ledger.java       holds accounts, runs transactions         (composition)

Why each pillar:
  - The overdraw test passes only if Account guards its private balance.
  - runAll takes a mixed list and calls one method; each Transaction knows how to
    apply itself - that is polymorphism.
  - You can add Transfer without touching the loop: open for extension.
  - The Ledger HOLDS a map instead of extending one: composition, not inheritance.


PART 2 - a report exporter      (folder: part2-report/, package: report)
------------------------------------------------------------------------
A rigid exporter that would know every format itself, behind one growing switch.
Reshape it so the tests pass, by leaning on an interface instead of a switch:

    report/Report.java        the data (given - a record)
    report/ReportFormat.java  the seam: one small interface (given)          (ISP)
    report/CsvFormat.java     format a report as CSV                         (OCP, LSP)
    report/JsonFormat.java    format a report as JSON                        (OCP, LSP)
    report/ReportService.java validate, then use the INJECTED format         (SRP, DIP)

Which principle each test proves:
  - A brand new format that just works: dependency inversion + open-closed.
  - Every format honouring the same one-method contract: ISP + Liskov.
  - The service rejecting a blank title while the formatter only formats: SRP.


FINALE - export a bank statement   (folder: part3-finale/, package: finale)
---------------------------------------------------------------------------
The two halves, joined. Export a list of accounts through a pluggable format -
the pillars produce the data, SOLID decides how it leaves the building:

    finale/Account.java           a guarded balance (given)          (encapsulation)
    finale/StatementFormat.java   the seam: one interface (given)     (ISP, OCP, DIP)
    finale/PlainFormat.java       one "id: balance" line per account  (OCP, LSP)
    finale/CsvFormat.java         a CSV statement                     (OCP, LSP)
    finale/StatementExporter.java hold the INJECTED format; delegate   (DIP, composition)

When your own new format works through the exporter with no change to it, you have
every idea from Day 1 in one small file.


THE REFERENCE SOLUTION
----------------------
Each part has a `solution/` package with a full reference. Try it yourself first.
