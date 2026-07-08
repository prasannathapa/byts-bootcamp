#!/usr/bin/env bash
# Compile the bonus (theater) capstone and run its tests. Requires a JDK 17 or newer.
cd "$(dirname "$0")"
javac theater/*.java && java theater.RunTests
