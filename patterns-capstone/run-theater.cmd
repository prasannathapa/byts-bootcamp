@echo off
REM Compile the bonus (theater) capstone and run its tests. Requires a JDK 17 or newer.
cd /d "%~dp0"
javac theater\SoundSystem.java theater\VintageAmp.java theater\AmpAdapter.java theater\Lights.java theater\Screen.java theater\Scene.java theater\Hub.java theater\Appliance.java theater\Projector.java theater\SoundBar.java theater\Theater.java theater\RunTests.java
if %errorlevel%==0 java theater.RunTests
