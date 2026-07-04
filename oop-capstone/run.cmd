@echo off
REM Compile the capstone and run the tests. Requires a JDK 17 or newer.
cd /d "%~dp0"
javac bank\Account.java bank\Transaction.java bank\Ledger.java bank\RunTests.java
if %errorlevel%==0 java bank.RunTests
