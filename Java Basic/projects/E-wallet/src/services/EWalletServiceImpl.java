package services;

import models.Account;
import models.DepositResponseEnum;

import java.util.Scanner;

public class EWalletServiceImpl implements EWalletService {

    @Override
    public boolean transfer(Account account, String to, double amount) {

        Account account1 = new Account();
        account1 =
        if (genralValidationWithdrowandTransfer(account, amount)) return false;
        account.setBalance(account.getBalance() - amount);
        return true;
    }


    @Override
    public DepositResponseEnum deposit(Account account, double amount) {


        //check Account is EXist
        //may create ACCount from main and send
        //MUST amount > 100
        if (account.getUsername().isEmpty() || account.getPassword().isEmpty()) {
            return DepositResponseEnum.EMPTY_CREDENTIALS;
        }
        if (amount <100){
            return DepositResponseEnum.INVALID_AMOUNT;
        }
        account.setBalance(account.getBalance() + amount);
        return DepositResponseEnum.SUCCESS;
    }


    @Override
    public boolean withdraw(Account account,double amount) {
        synchronized (account) {
            if (genralValidationWithdrowandTransfer(account, amount)) return false;
            account.setBalance(account.getBalance() - amount);
            return true;
        }

    }

    private static boolean genralValidationWithdrowandTransfer(Account account, double amount) {
        if(account == null){
            System.out.println("Invalid Account");
            return true;
        }
        if(amount < 0){
            System.out.println("Invalid Amount");
            System.out.println("Enter Vaild Amount");
            return true;
        }
        if (account.getBalance() < amount) {
            System.out.println("Insufficient Balance");
            return true;
        }
        return false;
    }


    @Override
    public void homeOption(Account account, Scanner sc){
        while(true){
            //        welcomeMessage("Home Menu");
            System.out.println("1.Withdrow \n2.Deposit\n3.Transfer Money\n4.Show Account Details\n5.Change Password\n6.Exit");
            int choice = sc.nextInt();

            double Amount = 0;
            switch (choice) {

                case 1:
                    withdrawService(account, sc);
                    break;
                case 2:
                    depositService(account, sc, Amount);
                    break;
                case 3:
                    System.out.println("Welcome in Transfer Money");
                    System.out.println("Enter Destination Username");
                    String destinationUserName = sc.next();
                    System.out.println("Enter Amount to Transfer");
                    int transferAmount = sc.nextInt();
                    transfer(account,destinationUserName,transferAmount);
                    break;
                case 4:
                    accountDetailsService(account);
                    break;
                case 5:
                    createNewPasswordService(account, sc);
                    break;
                case 6:
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Wrong choice \nEnter Valid choice....");
            }
        }



    }

    private static void accountDetailsService(Account account) {
        String accountDetails= account.toString();
        System.out.println(accountDetails);
    }

    private static void createNewPasswordService(Account account, Scanner sc) {
        System.out.println("Enter your password");
        String password = sc.next();
        if(password.equals(account.getPassword())){
            System.out.println("Enter New password");
            String newPassword = sc.next();
            if(!newPassword.equals(password)){
                account.setPassword(newPassword);
                System.out.println("New Password Done Successfully");
            }else{
                System.out.println("password same the old password");
            }

        }else {
            System.out.println("Wrong Password");
        }
    }

    private void depositService(Account account, Scanner sc, double Amount) {
        System.out.println("Enter your amount to deposit\n   -Must Positive Number\n   -Only Numbers\n   -Not Vaild Characters\n   -Not Null");
        try {
            Amount = sc.nextDouble();
        }catch (Exception e){
            System.out.println("Enter Valid Amount");
        }
        DepositResponseEnum depositResult = deposit(account, Amount);
        switch (depositResult) {

            case SUCCESS:
                System.out.println("Deposited Successfully");
                break;

            case EMPTY_CREDENTIALS:
                System.out.println("Username or Password is Invalid");
                break;

            case INVALID_AMOUNT:
                System.out.println("Amount must be >= 100");
                break;
        }
    }

    private void withdrawService(Account account, Scanner sc) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {

            System.out.println("""
                Enter your amount to Withdrow
                - Must Positive Number
                - Only Numbers
                - Not Vaild Characters
                - Not Null
                """);

            if (sc.hasNextDouble()) {

                double amount = sc.nextDouble();

                boolean success = withdraw(account, amount);

                if (success) {
                    System.out.println("Withdraw Done Successfully");
                    System.out.println("Your Balance is " + account.getBalance());
                    break;
                } else {
                    System.out.println("Withdraw failed.");
                    break;
                }

            } else {
                System.out.println("Invalid number format.");
                sc.next();
                attempts++;
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Too many failed attempts.");
        }

        return;
    }

}
