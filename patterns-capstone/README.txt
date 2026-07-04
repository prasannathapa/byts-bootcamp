DESIGN PATTERNS CAPSTONE - a tiny coffee shop
=============================================

One small program that needs three patterns at once: Decorator, Factory, and
Strategy. Implement the classes in the cafe/ package until every test passes.

Requires a JDK 17 or newer. Check:  java -version

WHAT TO DO
----------
1. Read cafe/RunTests.java first. It is the specification - do not edit it.
2. Fill in the TODOs in the cafe/ package (Espresso and Tea are given as
   worked examples, so two tests pass before you start):

     cafe/Milk.java            a DECORATOR: wrap a Beverage, add +50 and ", milk"
     cafe/Syrup.java           a DECORATOR: wrap a Beverage, add +75 and ", syrup"
     cafe/BeverageFactory.java a FACTORY: build a base drink from its name
     cafe/NoDiscount.java      a STRATEGY: price unchanged
     cafe/PercentOff.java      a STRATEGY: take a percentage off

3. Run the tests until all eight are green:

     Windows:        run.cmd
     macOS / Linux:  ./run.sh

   Or by hand, from this folder:   javac cafe/*.java  &&  java cafe.RunTests

IN INTELLIJ
-----------
Open this patterns-capstone folder and run the class cafe.RunTests (right-click
it, Run). Make every test green.

WHICH PATTERN EACH TEST PROVES
------------------------------
  - Stacking milk and syrup on an espresso, and the cost adding up: DECORATOR.
  - Building a drink from the string "espresso": FACTORY.
  - Swapping no-discount for 20-percent-off without touching anything else:
    STRATEGY - an interchangeable algorithm behind one interface.
