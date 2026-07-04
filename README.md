# Design + HLD Bootcamp

Slides and hands-on capstones for a four-day bootcamp on object-oriented design,
design patterns, and high-level system design.

**Get everything:** clone or download this repo. The slides are self-contained HTML,
so open any `presentation.html` directly, or open `index.html` as a launcher.

```
git clone https://github.com/prasannathapa/byts-bootcamp
```

**View the slides online without cloning** (rendered via githack):
<https://raw.githack.com/prasannathapa/byts-bootcamp/main/index.html>

## Days

| Day | Topic | Slides | Capstone |
| --- | --- | --- | --- |
| 1 (am) | Object-Oriented Programming | `oop/` | `oop-capstone/` (a tiny bank) |
| 1 (pm) | SOLID principles | `solid/` | `solid-capstone/` (a report exporter) |
| 2 | Design patterns | `patterns/` | `patterns-capstone/` (a coffee shop) |
| 3 | High-level design | `hld/` | `hld-capstone/` (a design exercise) |
| 4 | Mini Instagram | `instagram/` | [github.com/prasannathapa/mini-insta](https://github.com/prasannathapa/mini-insta) |

## Capstones

Each `*-capstone/` folder is a small Java exercise. Read `RunTests.java` (the
spec), fill in the TODOs, and run until every test is green:

```
cd oop-capstone       # or solid-capstone, patterns-capstone
./run.sh              # Windows: run.cmd
```

Requires a JDK 17 or newer. No build tools to install.
