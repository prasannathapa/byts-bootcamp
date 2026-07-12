#!/usr/bin/env bash
# Part 2 - home theater. Requires Java 25 (JDK).
cd "$(dirname "$0")"
javac theater/*.java && java theater.RunTests
