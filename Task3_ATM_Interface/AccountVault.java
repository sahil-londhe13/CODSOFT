public class AccountVault {

    private double currentBalance;

    public AccountVault(double openingAmount) {
        currentBalance = openingAmount;
    }

    public double viewBalance() {
        return currentBalance;
    }

    public boolean addFunds(double amount) {
        if (amount <= 0) {
            return false;
        }
        currentBalance += amount;
        return true;
    }

    public boolean removeFunds(double amount) {
        if (amount <= 0 || amount > currentBalance) {
            return false;
        }
        currentBalance -= amount;
        return true;
    }
}
