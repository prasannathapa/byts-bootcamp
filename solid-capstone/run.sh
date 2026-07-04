#!/usr/bin/env bash
# Compile the capstone and run the tests. Requires a JDK 17 or newer (records).
cd "$(dirname "$0")"
javac report/*.java && java report.RunTests
