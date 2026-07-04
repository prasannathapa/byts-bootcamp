#!/usr/bin/env bash
# Compile the capstone and run the tests. Requires a JDK 17 or newer.
cd "$(dirname "$0")"
javac bank/*.java && java bank.RunTests
