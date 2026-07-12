@echo off
REM Run all three parts of the Day 2 capstone in order. Requires Java 25 (JDK).
REM Each part's run.cmd cd's into its own folder, so we call them by ABSOLUTE
REM path (%~dp0 = this script's folder) - otherwise part 2 would be looked up
REM relative to part 1's folder and "cannot find the path".
cd /d "%~dp0"

echo.
echo ======================================================================
echo   PART 1 - coffee shop (Factory, Decorator, Strategy, Observer)
echo ======================================================================
call "%~dp0part1-cafe\run.cmd"

echo.
echo ======================================================================
echo   PART 2 - home theater (Builder, Singleton, Adapter, Facade, Template Method)
echo ======================================================================
call "%~dp0part2-theater\run.cmd"

echo.
echo ======================================================================
echo   PART 3 - text editor (Command, Memento, State, Composite, Iterator, Visitor, Chain)
echo ======================================================================
call "%~dp0part3-editor\run.cmd"

echo.
echo Done. Fill in the TODOs until every part reports 0 failed.
