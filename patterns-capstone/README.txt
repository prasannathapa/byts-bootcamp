DESIGN PATTERNS CAPSTONE - a tiny coffee shop
=============================================

One small program that needs four patterns at once: Factory, Decorator, Strategy,
and Observer. Implement the classes in the cafe/ package until every test passes.

Requires a JDK 17 or newer. Check:  java -version

WHAT TO DO
----------
1. Read cafe/RunTests.java first. It is the specification - do not edit it.
   The tests are grouped into four checkpoints; make each green before the next:

     CP1  Factory & base drinks
     CP2  Decorator
     CP3  Strategy
     CP4  Observer

2. Fill in the TODOs in the cafe/ package:

     cafe/Beverage.java        the shared interface (given)
     cafe/Espresso.java, Tea.java   base drinks (given, as examples)
     cafe/BeverageFactory.java a FACTORY: build a base drink from its name
     cafe/Milk.java            a DECORATOR: wrap a Beverage, add +50 and ", milk"
     cafe/Syrup.java           a DECORATOR: wrap a Beverage, add +75 and ", syrup"
     cafe/Discount.java        the strategy interface (given)
     cafe/NoDiscount.java      a STRATEGY: price unchanged
     cafe/PercentOff.java      a STRATEGY: take a percentage off
     cafe/OrderObserver.java   the observer interface (given)
     cafe/Counter.java         the SUBJECT: price an order, notify every subscriber
     cafe/SalesTotal.java      an OBSERVER: keep a running total
     cafe/ReceiptPrinter.java  an OBSERVER: remember the last receipt line

3. Run the tests until all seventeen are green:

     Windows:        run.cmd
     macOS / Linux:  ./run.sh

   Or by hand, from this folder:   javac cafe/*.java  &&  java cafe.RunTests

IN INTELLIJ
-----------
Open this patterns-capstone folder. The exercise lives in the `cafe` package and
the reference lives in a separate `solution` package, so the two never clash.
Run the class cafe.RunTests (right-click it, Run). Make every test green.

WHICH PATTERN EACH TEST PROVES
------------------------------
  - Building a drink from the string "espresso": FACTORY. The caller asks by
    name; it never writes `new Espresso()` itself.
  - Stacking milk and syrup on an espresso, and the cost adding up: DECORATOR.
    Each add-on wraps a Beverage and delegates, then adds its own bit.
  - Swapping no-discount for 20-percent-off without touching anything else:
    STRATEGY - the discount is an interchangeable algorithm behind one interface.
  - Placing an order and having a running total and a receipt update on their own:
    OBSERVER - the Counter tells every subscriber; it never knows who is listening.

Notice Counter.placeOrder uses three patterns in one line: it prices the drink
(DECORATOR), applies the discount (STRATEGY), and notifies subscribers (OBSERVER).

The full reference solution is in the solution/ package. Try it yourself first.


BONUS CAPSTONE (for fast finishers) - a smart home theater
==========================================================

Done early? A second, self-contained capstone in the theater/ package covers the
FIVE patterns the coffee shop did not: Builder, Singleton, Adapter, Facade, and
Template Method. Same rules - read theater/RunTests.java first, then fill the TODOs
until all fourteen tests pass.

  CP1  Builder          theater/Scene.java        build a room scene fluently, with defaults
  CP2  Singleton        theater/Hub.java          one shared control hub, reached via Hub.get()
  CP3  Adapter          theater/AmpAdapter.java    make a 0..11 VintageAmp speak the 0..100 SoundSystem
  CP4  Facade           theater/Theater.java       one watch(scene) call drives lights + sound + screen + hub
  CP5  Template Method  theater/Projector.java, theater/SoundBar.java
                                                   fill the warm-up hook in a locked startUp() skeleton

Run it:
  Windows:        run-theater.cmd
  macOS / Linux:  ./run-theater.sh
  By hand:        javac theater/*.java  &&  java theater.RunTests

Notice CP4's watch() ties three patterns together in one call: it applies the
Builder's Scene, drives the Adapter'd sound, and records on the Singleton Hub -
all hidden behind the Facade.
