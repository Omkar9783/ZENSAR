# ZENSAR Java Projects

This repository contains various Java programs developed during coursework, covering GUI applications, database operations, and multithreading concepts.

## 📋 Table of Contents

- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Project Files](#project-files)
- [How to Run](#how-to-run)

## 🔧 Prerequisites

- **Java Development Kit (JDK)** - Version 8 or higher
- **MySQL Server** - For database-related programs
- **MySQL Connector/J** - Located in `lib/mysql-connector-j-9.1.0.jar`

## 🗄️ Database Setup

Some programs require MySQL database. Default credentials:

- **Host:** localhost:3306
- **Username:** root
- **Password:** omkar@123
- **Databases:** `ZENSAR_JAVA`

## 📁 Project Files

### Database Programs

| File Name                        | Description                        | Database    | Key Features                                              |
| -------------------------------- | ---------------------------------- | ----------- | --------------------------------------------------------- |
| `DatabaseNavigator.java`         | GUI for navigating student records | ZENSAR_JAVA | First, Next, Previous, Last buttons to browse records     |
| `StudentDatabaseOperations.java` | Database initialization script     | ZENSAR_JAVA | Creates database and inserts 10 student records (401-410) |
| `DBViewer.java`                  | Universal database table viewer    | ZENSAR_JAVA | View any table with dropdown selection                    |
| `CreateDatabase.java`            | Simple database creator            | ZENSAR_JAVA | Creates new database                                      |
| `TestDB.java`                    | Connection test utility            | -           | Verifies MySQL connection and displays version            |

### ATM Banking System

| File Name         | Description              | Purpose                                                                             |
| ----------------- | ------------------------ | ----------------------------------------------------------------------------------- |
| `ATM.java`        | Complete ATM application | Login, withdraw, deposit, balance inquiry with real-time DB updates                 |
| `SetupATMDB.java` | ATM database setup       | Creates accounts table in ZENSAR_JAVA with sample accounts (12345/1234, 67890/5678) |

### GUI Examples

| File Name                   | Layout Manager   | Description                           | Key Concepts                          |
| --------------------------- | ---------------- | ------------------------------------- | ------------------------------------- |
| `CardLayoutExample.java`    | CardLayout       | Switchable panels (Numbers/Alphabets) | Panel switching, ActionListener       |
| `FlowLayoutExample.java`    | FlowLayout       | Form with labels and text fields      | Basic form layout                     |
| `ButtonExample.java`        | null (absolute)  | Simple button demonstration           | AWT basics, setBounds                 |
| `WindowClosingExample.java` | BorderLayout     | Window event handling                 | WindowAdapter, WindowEvent            |
| `Calculator.java`           | GridLayout (4x4) | Basic calculator                      | Arithmetic operations, event handling |

### Multithreading Programs

| File Name                   | Concept              | Description                                               |
| --------------------------- | -------------------- | --------------------------------------------------------- |
| `BusReservationSystem.java` | Synchronized methods | Thread-safe seat booking system preventing double booking |
| `BusPrintingSystem.java`    | Synchronized blocks  | Thread lifecycle and synchronization demonstration        |

### Utility Files

| File Name                         | Type                 | Purpose                         |
| --------------------------------- | -------------------- | ------------------------------- |
| `LaunchDBViewer.command`          | Shell script (macOS) | One-click launcher for DBViewer |
| `lib/mysql-connector-j-9.1.0.jar` | Library              | MySQL JDBC driver               |

## 🚀 How to Run

### Compile Java Files

```bash
javac *.java
```

### Run Programs Without Database

```bash
java ClassName
```

**Examples:**

```bash
java Calculator
java CardLayoutExample
java BusReservationSystem
```

### Run Programs With Database

```bash
# macOS/Linux
java -cp ".:lib/mysql-connector-j-9.1.0.jar" ClassName

# Windows
java -cp ".;lib/mysql-connector-j-9.1.0.jar" ClassName
```

**Examples:**

```bash
# Setup databases first
java -cp ".:lib/mysql-connector-j-9.1.0.jar" SetupATMDB
java -cp ".:lib/mysql-connector-j-9.1.0.jar" StudentDatabaseOperations

# Run applications
java -cp ".:lib/mysql-connector-j-9.1.0.jar" ATM
java -cp ".:lib/mysql-connector-j-9.1.0.jar" DatabaseNavigator
java -cp ".:lib/mysql-connector-j-9.1.0.jar" DBViewer
```

### Quick Start Guide

| Step | Command                                                                        | Description                           |
| ---- | ------------------------------------------------------------------------------ | ------------------------------------- |
| 1    | `javac -cp ".:lib/mysql-connector-j-9.1.0.jar" SetupATMDB.java`                | Compile ATM setup                     |
| 2    | `java -cp ".:lib/mysql-connector-j-9.1.0.jar" SetupATMDB`                      | Setup ATM tables in ZENSAR_JAVA       |
| 3    | `javac -cp ".:lib/mysql-connector-j-9.1.0.jar" StudentDatabaseOperations.java` | Compile student DB setup              |
| 4    | `java -cp ".:lib/mysql-connector-j-9.1.0.jar" StudentDatabaseOperations`       | Setup student tables in ZENSAR_JAVA   |
| 5    | `javac -cp ".:lib/mysql-connector-j-9.1.0.jar" *.java`                         | Compile all programs                  |
| 6    | Ready to run!                                                                  | Use commands above to run any program |

## 📊 Database Schema

### ZENSAR_JAVA Database

**Table: stds_nkocet**
| Column | Type | Description |
|--------|------|-------------|
| stds_no | INT (PK) | Student roll number |
| stds_name | VARCHAR(100) | Student name |
| stds_stipend | DOUBLE | Stipend amount |

**Table: accounts**
| Column | Type | Description |
|--------|------|-------------|
| customer_number | INT (PK) | Customer ID |
| pin_number | INT | PIN for authentication |
| checking_balance | DOUBLE | Checking account balance |
| saving_balance | DOUBLE | Saving account balance |

## 📝 Notes

- All database programs use MySQL Connector/J 9.1.0
- Default database credentials are hardcoded (change in production)
- Programs with GUI will open windows - ensure display is available
- Hinglish comments are included for better understanding
- On Windows, use semicolon (`;`) instead of colon (`:`) in classpath

## 🎓 Learning Outcomes

| Category        | Skills Demonstrated                                                     |
| --------------- | ----------------------------------------------------------------------- |
| **Database**    | JDBC connectivity, PreparedStatement, ResultSet navigation (scrollable) |
| **GUI**         | Swing/AWT components, Event handling (ActionListener, WindowListener)   |
| **Layouts**     | FlowLayout, GridLayout, CardLayout, Absolute positioning                |
| **Concurrency** | Multithreading, Synchronization, Thread safety                          |
| **Security**    | SQL injection prevention using PreparedStatement                        |
| **Design**      | MVC pattern, Separation of concerns                                     |

## 📧 Contact

For questions or issues, please open an issue in this repository.

---

**Repository:** [ZENSAR](https://github.com/Omkar9783/ZENSAR)  
**Last Updated:** January 2026
