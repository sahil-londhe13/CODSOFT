import java.util.Scanner;

public class FxConverter {

    private static void showMenu() {
        System.out.println("\n===== Currency Converter Menu =====");
        System.out.println("1. India (INR)");
        System.out.println("2. America (USD)");
        System.out.println("3. Europe (EUR)");
        System.out.println("4. Exit");
        System.out.println("===================================");
    }

    private static double getRate(int from, int to) {

        // India -> America / Europe
        if (from == 1 && to == 2) return 0.012;
        if (from == 1 && to == 3) return 0.011;

        // America -> India / Europe
        if (from == 2 && to == 1) return 83.0;
        if (from == 2 && to == 3) return 0.92;

        // Europe -> India / America
        if (from == 3 && to == 1) return 90.0;
        if (from == 3 && to == 2) return 1.08;

        return -1;
    }

    private static String getCurrencyName(int option) {
        if (option == 1) return "INR";
        if (option == 2) return "USD";
        if (option == 3) return "EUR";
        return "";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Welcome to Currency Converter System ===");

        while (running) {

            showMenu();

            System.out.print("Select base country (1-4): ");
            int baseChoice = scanner.nextInt();

            if (baseChoice == 4) {
                System.out.println("Thank you for using the Currency Converter.");
                break;
            }

            System.out.print("Select target country (1-3): ");
            int targetChoice = scanner.nextInt();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            double rate = getRate(baseChoice, targetChoice);

            if (rate == -1) {
                System.out.println("Conversion not available for selected countries.");
            } else {
                double result = amount * rate;
                System.out.printf(
                    "Converted Amount: %.2f %s%n",
                    result,
                    getCurrencyName(targetChoice)
                );
            }
        }

        scanner.close();
    }
}
