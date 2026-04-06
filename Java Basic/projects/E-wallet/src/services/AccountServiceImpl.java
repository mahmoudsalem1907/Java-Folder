package services;

import models.Account;
import models.EWallet;

import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    EWallet eWallet = new EWallet();

    @Override
    public Account getAccountExistByUserNameAndPassword(Account account){

        Optional<Account> accountOptional = eWallet
                .getAccounts()
                .stream()
                .filter(a -> a.getUsername().equals(account.getUsername()) && a.getPassword().equals(account.getPassword()) )
                .findAny();
        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        return  null;
    }


    @Override
    public boolean createAccount(Account account) {

        Optional<Account> accountStream = eWallet.getAccounts()
                .stream()
                .filter(acc -> Objects.equals(acc.getUsername(), account.getUsername())
                        || Objects.equals(acc.getPhone(), account.getPhone()))
                .findAny();

        if(accountStream.isPresent()){
            return false;
        }
        eWallet.getAccounts().add(account);
        return true;
    }

}
