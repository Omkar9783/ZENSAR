@echo off
REM Navigate to the directory where this file is located
cd /d "%~dp0"

REM Run ATM Application
echo Compiling ATM...
javac -cp ".;lib/mysql-connector-j-9.1.0.jar" ATM.java

echo Starting ATM Application...
java -cp ".;lib/mysql-connector-j-9.1.0.jar" ATM

pause
