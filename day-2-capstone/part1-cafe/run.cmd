@echo off
REM Part 1 - coffee shop. Requires Java 25 (JDK).
cd /d "%~dp0"
javac cafe\*.java
if %errorlevel%==0 java cafe.RunTests
