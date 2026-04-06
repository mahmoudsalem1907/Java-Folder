public class BankAccount {

    private double balance;


    public void print() {
        System.out.println("Balance: " + balance);
    }
    //ايداع
    public synchronized void deposit(double amount) {
        balance = balance + amount;
//        return balance;
        notify();

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //سحب
    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            try {
                System.out.println(Thread.currentThread().getName() +
                        " Waiting... Balance is low: " + balance);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        balance -= amount;
    }



}
