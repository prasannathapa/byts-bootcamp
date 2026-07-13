#!/usr/bin/env bash
# Compile the systems capstone and run the tests. Requires a JDK 17 or newer.
cd "$(dirname "$0")"
javac systems/*.java && java systems.RunTests
