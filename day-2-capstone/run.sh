#!/usr/bin/env bash
# Run all three parts of the Day 2 capstone in order. Requires Java 25 (JDK).
cd "$(dirname "$0")"

run_part () {
  echo ""
  echo "======================================================================"
  echo "  $1"
  echo "======================================================================"
  ( cd "$2" && bash run.sh )
}

run_part "PART 1 - coffee shop (Factory, Decorator, Strategy, Observer)"                 part1-cafe
run_part "PART 2 - home theater (Builder, Singleton, Adapter, Facade, Template Method)"  part2-theater
run_part "PART 3 - text editor (Command, Memento, State, Composite, Iterator, Visitor, Chain)" part3-editor

echo ""
echo "Done. Fill in the TODOs until every part reports 0 failed."
