public class Main {
    public static void main(String[] args) {
        BankAccount testAcc = createBankAccount("Nguyen Hoang Long", "20235524", 10000000);
        displayInitialBalance(testAcc);

        performTransactions(testAcc);
        displayFinalBalance(testAcc);

        testAcc.displayAccountInfo();
    }

    private static BankAccount createBankAccount(String ownerName, String accountNumber, double initialBalance) {
        return new BankAccount(ownerName, accountNumber, initialBalance);
    }

    private static void displayInitialBalance(BankAccount account) {
        System.out.println("Initial balance: " + account.getBalance() + " VND");
    }

    private static void performTransactions(BankAccount account) {
        account.deposit(20000000);
        account.withdraw(3000000);
        account.withdraw(2000000);
    }

    private static void displayFinalBalance(BankAccount account) {
        System.out.println("Final balance: " + account.getBalance() + " VND");
    }
}