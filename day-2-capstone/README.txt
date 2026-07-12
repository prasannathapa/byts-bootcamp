DAY 2 CAPSTONE - design patterns, three shops
==============================================

One capstone in three parts, graded by difficulty. Part 1 (everyone) is a coffee
shop; part 2 (most of you) a home theater; part 3 (a stretch) a text editor.
Across the three you build SIXTEEN of the classic Gang-of-Four patterns. Read the
RunTests.java in each part first - the tests are the specification.

Requires Java 25 (JDK) - installed on Day 1. Check:  java -version


SETUP - you already cloned this and installed Java on Day 1
-----------------------------------------------------------
Just pull today's folder and run. From inside your byts-bootcamp clone:

  1) GET TODAY'S CODE
       git pull
     If git complains about local changes from yesterday:
       git reset --hard origin/main      (discards your local edits)
       git pull

  2) GO TO TODAY'S FOLDER AND RUN THE TESTS
       cd day-2-capstone
       macOS / Linux:            ./run.sh
       Windows (PowerShell):     .\run.cmd
     The ./ and .\ are part of the command - keep them.

Failing tests are expected - they are your to-do list.


PART 1 - coffee shop        (folder: part1-cafe/, package: cafe)   EVERYONE
---------------------------------------------------------------------------
Four patterns, four checkpoints, 17 tests. Fill in the TODOs in cafe/:

    CP1  Factory     BeverageFactory.java   build a base drink from its name
    CP2  Decorator   Milk.java, Syrup.java  wrap a Beverage, add cost + label
    CP3  Strategy    NoDiscount, PercentOff a swappable discount behind one interface
    CP4  Observer    Counter.java           price an order, notify every subscriber

Counter.placeOrder uses three patterns in one line: it prices the drink (Decorator),
applies the discount (Strategy), and notifies subscribers (Observer).


PART 2 - home theater       (folder: part2-theater/, package: theater)   MOST OF YOU
------------------------------------------------------------------------------------
Five more patterns, 14 tests. Fill in the TODOs in theater/:

    CP1  Builder          Scene.java       build a room scene fluently, with defaults
    CP2  Singleton        Hub.java         one shared control hub, reached via Hub.get()
    CP3  Adapter          AmpAdapter.java  make a 0..11 VintageAmp speak the 0..100 SoundSystem
    CP4  Facade           Theater.java     one watch(scene) drives lights + sound + screen + hub
    CP5  Template Method  Projector.java, SoundBar.java   fill the warm-up hook in a locked startUp()

watch() ties three together in one call: the Builder's Scene, the Adapter'd sound,
and the Singleton Hub - all hidden behind the Facade.


PART 3 - text editor        (folder: part3-editor/, package: editor)   STRETCH
------------------------------------------------------------------------------
Seven harder patterns, 19 tests. The tough module - one checkpoint at a time, and
don't let Visitor (CP6) stall you. Fill in the TODOs in editor/:

    CP1  Command                 Command.java     InsertText + run/undo/redo (real undo AND redo)
    CP2  Memento                 Editor.java      snapshot() / restore() the whole buffer
    CP3  State                   Mode.java        INSERT vs READONLY decide what a keystroke does
    CP4  Composite               Node.java        a document tree: Paragraph (leaf) + Section (holds Nodes)
    CP5  Iterator                Node.java        walk every Paragraph, depth-first, in order
    CP6  Visitor                 NodeVisitor.java a WordCountVisitor over the tree (double dispatch)
    CP7  Chain of Responsibility TextFilter.java  a trim -> collapse-spaces -> censor pipeline


RUNNING
-------
Run everything from this folder:   ./run.sh    (Windows: .\run.cmd)
Or one part at a time, e.g.:        cd part1-cafe  &&  ./run.sh

THE REFERENCE SOLUTION
----------------------
Each part has a reference package (solution / theatersolution / editorsolution).
Try it yourself first.
