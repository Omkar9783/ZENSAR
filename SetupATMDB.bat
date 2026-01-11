@echo off
REM Navigate to the directory where this file is located
cd /d "%~dp0"

REM Setup ATM Database
echo Setting up ATM Database...
javac -cp ".;lib/mysql-connector-j-9.1.0.jar" SetupATMDB.java
java -cp ".;lib/mysql-connector-j-9.1.0.jar" SetupATMDB

pause
