# HLD design exercise - Mini Instagram

Day 3 has no code. It has a design. Produce the high-level design for Mini
Instagram on paper (or a whiteboard), using the building blocks from the session.

## How to run it

1. Read `BRIEF.md`. It has the requirements and the five decisions to make.
2. In pairs, sketch your design. Boxes, arrows, and a one-line reason for each
   choice. There is no single right answer, only trade-offs you can defend.
3. Then clone the code you build on Day 4 and run its tests. Its `docs/` folder
   (`ARCHITECTURE.html` and `HLD.html`) is one worked reference design to compare
   against - after you have your own sketch.

   ```
   git clone https://github.com/prasannathapa/mini-insta
   cd mini-insta
   ./mvnw test          # on Windows: mvnw.cmd test
   ```

Every box you draw is a package in that repo; every arrow is a port.
