package spring.core.service.Impl;

import spring.core.service.UserService;

public class PersonService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("Name of Person: " + name+ " is saved!");
    }

    @Override
    public void update(String name) {
        System.out.println("Name of Person: " + name+ " is updated!");
    }

    public void init(){
        System.out.println("Start Function...");
    }

    public void destroy(){
        System.out.println("End Function...");
    }
}
