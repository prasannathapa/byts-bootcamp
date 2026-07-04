@echo off
REM Compile the capstone and run the tests. Requires a JDK 17 or newer.
cd /d "%~dp0"
javac cafe\Beverage.java cafe\Espresso.java cafe\Tea.java cafe\Milk.java cafe\Syrup.java cafe\BeverageFactory.java cafe\Discount.java cafe\NoDiscount.java cafe\PercentOff.java cafe\RunTests.java
if %errorlevel%==0 java cafe.RunTests
