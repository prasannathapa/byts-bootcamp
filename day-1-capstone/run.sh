#!/usr/bin/env bash
# Run all three parts of the Day 1 capstone in order. Requires Java 25 (JDK).
cd "$(dirname "$0")"

run_part () {
  echo ""
  echo "======================================================================"
  echo "  $1"
  echo "======================================================================"
  ( cd "$2" && bash run.sh )
}

run_part "PART 1 - a tiny bank (the four pillars)"        part1-bank
run_part "PART 2 - a report exporter (the five principles)" part2-report
run_part "FINALE - export a bank statement (pillars + SOLID)" part3-finale

echo ""
echo "Done. Fill in the TODOs until every part reports 0 failed."
