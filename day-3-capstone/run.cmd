@echo off
REM Compile the systems capstone and run the tests. Requires a JDK 17 or newer.
cd /d "%~dp0"
javac systems\*.java && java systems.RunTests
