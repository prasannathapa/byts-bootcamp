#!/usr/bin/env bash
# Part 1 - coffee shop. Requires Java 25 (JDK).
cd "$(dirname "$0")"
javac cafe/*.java && java cafe.RunTests
