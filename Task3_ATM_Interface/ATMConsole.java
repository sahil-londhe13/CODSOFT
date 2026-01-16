import java.util.Scanner;

public class ATMConsole {

    private static void displayMenu() {
        System.out.println("\n====== ATM MENU ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
        System.out.println("======================");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        AccountVault userAccount = new AccountVault(5000.00); // initial balance

        boolean sessionActive = true;

        System.out.println("Welcome to Secure ATM System");

        while (sessionActive) {

            displayMenu();
            int userChoice = reader.nextInt();

            switch (userChoice) {

                case 1:
                    System.out.printf("Current Balance: %.2f%n",
                            userAccount.viewBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositValue = reader.nextDouble();

                    if (userAccount.addFunds(depositValue)) {
                        System.out.println("Amount deposited successfully.");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawValue = reader.nextDouble();

                    if (userAccount.removeFunds(withdrawValue)) {
                        System.out.println("Please collect your cash.");
                    } else {
                        System.out.println("Transaction failed. Check balance or amount.");
                    }
                    break;

                case 4:
                    sessionActive = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        reader.close();
    }
}
