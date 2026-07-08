#!/usr/bin/env bash
# Compile the EXPERT capstone and run its tests. Requires a JDK 17 or newer.
cd "$(dirname "$0")"
javac editor/*.java && java editor.RunTests
