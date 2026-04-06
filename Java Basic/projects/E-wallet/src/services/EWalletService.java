package services;

import models.Account;
import models.DepositResponseEnum;

import java.util.Scanner;

public interface EWalletService {
    void homeOption(Account account, Scanner sc);
    DepositResponseEnum deposit(Account account, double amount);
    boolean withdraw(Account account,double amount);
    boolean transfer(Account account,String to, double amount);

}
