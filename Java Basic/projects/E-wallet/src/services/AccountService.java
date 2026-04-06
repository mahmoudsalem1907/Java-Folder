package services;

import models.Account;

public interface AccountService {
    boolean createAccount(Account account) ;

//    Account login(String username,String password);

    Account getAccountExistByUserNameAndPassword(Account account) ;


}
