@echo off
REM Navigate to the directory where this file is located
cd /d "%~dp0"

REM Run DatabaseNavigator Application
echo Compiling DatabaseNavigator...
javac -cp ".;lib/mysql-connector-j-9.1.0.jar" DatabaseNavigator.java

echo Starting DatabaseNavigator...
java -cp ".;lib/mysql-connector-j-9.1.0.jar" DatabaseNavigator

pause
