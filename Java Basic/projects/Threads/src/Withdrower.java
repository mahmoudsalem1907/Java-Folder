public class Withdrower implements Runnable {
    @Override
    public void run() {
        bankAccount.withdraw(500);
        System.out.println("w | Balance: " + bankAccount.getBalance());
    }

    private BankAccount bankAccount;
    public Withdrower(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
