import java.util.Scanner;

public class ATM {
    private static int customerId = 1234;
    private static int customerPin = 4321;
    private static double balance = 1000;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // authenticate the customer before allowing access to the ATM authenticateCustomer();

        // display the main menu
        int choice = 0;
        while (choice != 6) {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    changePin();
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    private static void authenticateCustomer() {
        System.out.println("Welcome to the ATM.");
        System.out.print("Please enter your customer ID: ");
        int id = scanner.nextInt();
        System.out.print("Please enter your PIN: ");
        int pin = scanner.nextInt();
        if (id == customerId && pin == customerPin) {
            System.out.println("Authentication successful. Welcome, customer.");
        } else {
            System.out.println("Authentication failed. Please try again.");
            authenticateCustomer();
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. transfer");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");
        System.out.print("Please enter your choice: ");
    }

    private static void checkBalance() {
        System.out.println("\nYour current balance is $" + balance);
    }

    private static void withdraw() {
        System.out.print("\nPlease enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is $" + balance);
        } else {
            System.out.println("Invalid amount. Please try again.");
            withdraw();
        }
    }

    private static void deposit() {
        System.out.print("\nPlease enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance is $" + balance);
        } else {
            System.out.println("Invalid amount. Please try again.");
            deposit();
        }
    }

    private static void transfer() {
        System.out.println("Please enter the amount to transfer:");
        int amount = scanner.nextInt();

        if (amount <= balance) {
            System.out.println("Please enter the recipient's account number:");
            int accountNumber = scanner.nextInt();
            System.out.println("Transfer successful.");
            System.out.println("Your new balance is " + balance);
        } else {
            System.out.println("Insufficient balance.");	
		transfer();
        }
    }

    private static void changePin() {
        System.out.println("Please enter your current PIN:");
        int currentPIN = scanner.nextInt();
        System.out.println("Please enter your new PIN:");
        int newPIN = scanner.nextInt();
        System.out.println("PIN changed successfully.");
	  changePin();
    }

    private static void exit() {
        System.out.println("Thank you for using the ATM!");
        System.exit(0);

    }
}
