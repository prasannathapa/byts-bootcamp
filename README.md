# Design + HLD Bootcamp

Slides and hands-on capstones for a four-day bootcamp on object-oriented design,
design patterns, and high-level system design.

**Get everything:** clone or download this repo. The slides are self-contained HTML,
so open any `presentation.html` directly, or open `index.html` as a launcher.

```
git clone --recurse-submodules https://github.com/prasannathapa/byts-bootcamp
```

(Day 4's capstone is a git submodule. If you already cloned without `--recurse-submodules`,
run `git submodule update --init` to fetch it.)

**View the slides online without cloning** (rendered via githack):
<https://raw.githack.com/prasannathapa/byts-bootcamp/main/index.html>

## Days

| Day | Topic | Slides | Capstone |
| --- | --- | --- | --- |
| 1 | Object design: pillars + SOLID | `day-1/` | `day-1-capstone/` (bank + report + finale) |
| 2 | Design patterns | `day-2/` | `day-2-capstone/` (cafe + theater + editor) |
| 3 | High-level design | `day-3/` | `day-3-capstone/` (build the HLD blocks) |
| 4 | Mini Instagram | `day-4/` | `day-4-capstone/` — [mini-insta](https://github.com/prasannathapa/mini-insta) submodule |

## Capstones

Each `*-capstone/` folder is a small Java exercise. Read `RunTests.java` (the
spec), fill in the TODOs, and run until every test is green:

```
cd day-1-capstone     # or day-2-capstone, day-3-capstone
./run.sh              # Windows: run.cmd
```

Requires a JDK 17 or newer. No build tools to install.
