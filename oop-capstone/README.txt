OOP CAPSTONE - a tiny bank
==========================

One small program that needs all four pillars of OOP at once. Implement the
classes in the bank/ package until every test in bank/RunTests.java passes.

Requires a JDK 17 or newer (records + sealed types). Check:  java -version

WHAT TO DO
----------
1. Read bank/RunTests.java first. It is the specification - do not edit it.
2. Fill in the TODOs in the bank/ package:

     bank/Account.java      a balance that can never go negative     (encapsulation)
     bank/Transaction.java  a sealed family (interface given)         (abstraction)
                            Deposit / Withdraw / Transfer apply()      (polymorphism)
     bank/Ledger.java       holds accounts, runs transactions         (composition)

3. Run the tests until they are all green:

     Windows:        run.cmd
     macOS / Linux:  ./run.sh

   Or by hand, from this folder:   javac bank/*.java  &&  java bank.RunTests

IN INTELLIJ
-----------
Open this oop-capstone folder and run the class bank.RunTests (right-click it,
Run). Make every test green.

WHY EACH PILLAR
---------------
  - The overdraw test passes only if your Account guards its private balance.
  - runAll takes a mixed list and calls one method; the right behaviour happens
    because each Transaction knows how to apply itself. That is polymorphism.
  - You can add Transfer without touching the loop: open for extension.
  - The Ledger HOLDS a map instead of extending one: composition, not inheritance.
