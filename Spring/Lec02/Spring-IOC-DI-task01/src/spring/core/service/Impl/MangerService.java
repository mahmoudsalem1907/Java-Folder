package spring.core.service.Impl;

import spring.core.service.UserService;

public class MangerService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("Name of Manager: " + name+ " is saved!");
    }

    @Override
    public void update(String name) {
        System.out.println("Name of Manager: " + name+ " is updated!");
    }
}