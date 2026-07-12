@echo off
REM Part 3 - text editor (stretch). Requires Java 25 (JDK).
cd /d "%~dp0"
javac editor\*.java
if %errorlevel%==0 java editor.RunTests
