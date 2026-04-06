public class Depositor implements Runnable{
    @Override
    public void run() {
        bankAccount.deposit(150);
        System.out.println("d | Balance: " + bankAccount.getBalance());
    }

    private BankAccount bankAccount;
    public Depositor(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
