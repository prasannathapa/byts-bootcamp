@echo off
REM Run all three parts of the Day 1 capstone in order. Requires Java 25 (JDK).
cd /d "%~dp0"

echo.
echo ======================================================================
echo   PART 1 - a tiny bank (the four pillars)
echo ======================================================================
call "%~dp0part1-bank\run.cmd"

echo.
echo ======================================================================
echo   PART 2 - a report exporter (the five principles)
echo ======================================================================
call "%~dp0part2-report\run.cmd"

echo.
echo ======================================================================
echo   FINALE - export a bank statement (pillars + SOLID)
echo ======================================================================
call "%~dp0part3-finale\run.cmd"

echo.
echo Done. Fill in the TODOs until every part reports 0 failed.
