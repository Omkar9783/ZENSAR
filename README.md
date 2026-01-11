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
- **Databases:** `ZENSAR_JAVA`, `ATM_DB`

## 📁 Project Files

### Database Programs

#### `DatabaseNavigator.java`

Database navigation GUI with First, Next, Previous, and Last buttons to browse student records.

- **Features:** Navigate through student database records
- **Database:** ZENSAR_JAVA
- **Table:** stds_nkocet
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" DatabaseNavigator`

#### `StudentDatabaseOperations.java`

Creates and populates the student database with sample data.

- **Purpose:** Database initialization script
- **Creates:** ZENSAR_JAVA database with stds_nkocet table
- **Inserts:** 10 student records (Roll No 401-410)
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" StudentDatabaseOperations`

#### `DBViewer.java`

GUI application to view and browse MySQL database tables.

- **Features:** Select and view any table from ZENSAR_JAVA database
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" DBViewer`
- **Launcher:** Double-click `LaunchDBViewer.command` (macOS)

#### `CreateDatabase.java`

Simple database creation utility.

- **Purpose:** Creates NKOCET_TE database
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" CreateDatabase`

### ATM System

#### `ATM.java`

Complete ATM banking system with database backend.

- **Features:**
  - Login authentication
  - Checking and Saving accounts
  - Withdraw, Deposit, Balance inquiry
  - Real-time database updates
- **Database:** ATM_DB
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" ATM`

#### `SetupATMDB.java`

ATM database initialization script.

- **Purpose:** Creates ATM_DB database and accounts table
- **Sample Accounts:**
  - Customer: 12345, PIN: 1234
  - Customer: 67890, PIN: 5678
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" SetupATMDB`

### GUI Examples

#### `CardLayoutExample.java`

Demonstrates CardLayout manager with switchable panels.

- **Features:** Toggle between Numbers and Alphabets panels
- **Concept:** CardLayout, ActionListener
- **Run:** `java CardLayoutExample`

#### `FlowLayoutExample.java`

Form layout example using FlowLayout.

- **Components:** Labels, TextFields, Buttons
- **Layout:** FlowLayout
- **Run:** `java FlowLayoutExample`

#### `ButtonExample.java`

Basic AWT button demonstration.

- **Purpose:** Simple button creation and positioning
- **Run:** `java ButtonExample`

#### `WindowClosingExample.java`

Demonstrates window event handling.

- **Concept:** WindowAdapter, WindowEvent
- **Run:** `java WindowClosingExample`

#### `Calculator.java`

GUI calculator with basic arithmetic operations.

- **Features:** Addition, Subtraction, Multiplication, Division
- **Layout:** GridLayout (4x4)
- **Run:** `java Calculator`

### Multithreading Programs

#### `BusReservationSystem.java`

Thread-safe bus seat booking system.

- **Concept:** Synchronized methods, Thread safety
- **Features:** Prevents double booking using synchronization
- **Run:** `java BusReservationSystem`

#### `BusPrintingSystem.java`

Demonstrates thread execution and synchronization.

- **Concept:** Thread lifecycle, synchronized blocks
- **Run:** `java BusPrintingSystem`

### Utility Files

#### `TestDB.java`

Database connection test utility.

- **Purpose:** Verify MySQL connection and display version
- **Run:** `java -cp ".:lib/mysql-connector-j-9.1.0.jar" TestDB`

#### `LaunchDBViewer.command`

macOS launcher script for DBViewer.

- **Usage:** Double-click to compile and run DBViewer

## 🚀 How to Run

### Compile Java Files

```bash
javac *.java
```

### Run Programs Without Database

```bash
java ClassName
```

### Run Programs With Database

```bash
java -cp ".:lib/mysql-connector-j-9.1.0.jar" ClassName
```

### Windows Users

On Windows, use semicolon (`;`) instead of colon (`:`) in classpath:

```bash
java -cp ".;lib/mysql-connector-j-9.1.0.jar" ClassName
```

## 📝 Notes

- All database programs use MySQL Connector/J 9.1.0
- Default database credentials are hardcoded (change in production)
- Programs with GUI will open windows - ensure display is available
- Hinglish comments are included for better understanding

## 🎓 Learning Outcomes

This repository demonstrates:

- ✅ JDBC database connectivity
- ✅ Swing/AWT GUI development
- ✅ Event handling (ActionListener, WindowListener)
- ✅ Layout managers (FlowLayout, GridLayout, CardLayout, null layout)
- ✅ Multithreading and synchronization
- ✅ PreparedStatement for SQL injection prevention
- ✅ ResultSet navigation (scrollable)

## 📧 Contact

For questions or issues, please open an issue in this repository.

---

**Repository:** [ZENSAR](https://github.com/Omkar9783/ZENSAR)
