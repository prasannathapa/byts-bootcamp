@echo off
REM Part 2 - home theater. Requires Java 25 (JDK).
cd /d "%~dp0"
javac theater\*.java
if %errorlevel%==0 java theater.RunTests
