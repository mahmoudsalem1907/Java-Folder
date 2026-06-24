package spring.core.service.Impl;

import spring.core.service.AccountService;
import spring.core.service.UserService;


public class AccountServiceImpl implements AccountService {
    UserService userService;

    public AccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavePerson(String name) {
        userService.save(name);
    }

}
