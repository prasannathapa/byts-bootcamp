@echo off
REM Run all three parts of the Day 2 capstone in order. Requires Java 25 (JDK).
cd /d "%~dp0"

echo.
echo ======================================================================
echo   PART 1 - coffee shop (Factory, Decorator, Strategy, Observer)
echo ======================================================================
call part1-cafe\run.cmd

echo.
echo ======================================================================
echo   PART 2 - home theater (Builder, Singleton, Adapter, Facade, Template Method)
echo ======================================================================
call part2-theater\run.cmd

echo.
echo ======================================================================
echo   PART 3 - text editor (Command, Memento, State, Composite, Iterator, Visitor, Chain)
echo ======================================================================
call part3-editor\run.cmd

echo.
echo Done. Fill in the TODOs until every part reports 0 failed.
