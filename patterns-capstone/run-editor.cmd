@echo off
REM Compile the EXPERT capstone and run its tests. Requires a JDK 17 or newer.
cd /d "%~dp0"
javac editor\Command.java editor\Editor.java editor\Mode.java editor\Node.java editor\NodeVisitor.java editor\TextFilter.java editor\RunTests.java
if %errorlevel%==0 java editor.RunTests
