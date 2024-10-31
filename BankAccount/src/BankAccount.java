public class BankAccount {
    private String ownerName;
    private String accountNumber;
    private double balance;
    private static final double MIN_BALANCE = 50000.0;
    private static final double WITHDRAWAL_FEE = 5000.0;

    public BankAccount(String ownerName, String accountNumber, double initialBalance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
    }

    public void deposit(double amount) {
        if (isValidAmount(amount)) {
            balance += amount;
            displayTransaction("Deposited", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (isValidWithdrawal(amount)) {
            balance -= (amount + WITHDRAWAL_FEE);
            displayTransaction("Withdrew", amount, WITHDRAWAL_FEE);
        } else {
            System.out.println("Withdrawal denied. Insufficient balance or minimum balance requirement not met.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Owner: " + ownerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance + " VND");
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private boolean isValidWithdrawal(double amount) {
        return amount > 0 && (balance - amount - WITHDRAWAL_FEE) >= MIN_BALANCE;
    }

    private void displayTransaction(String action, double amount) {
        System.out.println(action + ": " + amount + " VND. New balance: " + balance + " VND.");
    }

    private void displayTransaction(String action, double amount, double fee) {
        System.out.println(action + ": " + amount + " VND with fee of " + fee + " VND. New balance: " + balance + " VND.");
    }
}