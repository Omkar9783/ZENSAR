import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;

public class ATM {
    public static void main(String[] args) {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}

class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() {
        int x = 1;
        do {
            try {
                // Initialize DB connection first to validate login
                // For simplicity in this structure, we'll ask for inputs and then validate against DB in Account class
                
                System.out.println("Welcome to the ATM Project!");
                System.out.print("Enter your customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());

                if (validateLogin(getCustomerNumber(), getPinNumber())) {
                    getAccountType();
                } else {
                    System.out.println("\nWrong Customer Number or PIN Number.\n");
                }
            } catch (InputMismatchException | SQLException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.\n");
                x = 2;
                menuInput.nextLine(); // Clear buffer
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\nInvalid Choice.\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\nInvalid Choice.\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\nInvalid Choice.\n");
                getSaving();
        }
    }
}

class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // DB config
    private static final String URL = "jdbc:mysql://localhost:3306/ATM_DB";
    private static final String USER = "root";
    private static final String PASS = "omkar@123";

    private Connection getConnection() throws SQLException {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
             e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Validate login and load balances
    public boolean validateLogin(int customerNum, int pinNum) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE customer_number = ? AND pin_number = ?")) {
            
            stmt.setInt(1, customerNum);
            stmt.setInt(2, pinNum);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.customerNumber = rs.getInt("customer_number");
                this.pinNumber = rs.getInt("pin_number");
                this.checkingBalance = rs.getDouble("checking_balance");
                this.savingBalance = rs.getDouble("saving_balance");
                return true;
            }
        }
        return false;
    }

    // Update DB
    private void updateBalanceInDB() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET checking_balance = ?, saving_balance = ? WHERE customer_number = ?")) {
            
            stmt.setDouble(1, checkingBalance);
            stmt.setDouble(2, savingBalance);
            stmt.setInt(3, customerNumber);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error updating database: " + e.getMessage());
        }
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        updateBalanceInDB();
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        updateBalanceInDB();
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        updateBalanceInDB();
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        updateBalanceInDB();
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
}