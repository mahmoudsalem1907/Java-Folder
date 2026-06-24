package spring.core.service.impl;

import sping.core.service.AccountService;

public class InstagramAccountImpl implements AccountService {


    @Override
    public void createAccount(String unsername , String password){
        System.out.println("Now You create Account in Insta by username : "+unsername +" and password : "+password);
    }
    @Override
    public void createPost(Long userId,String text){
        System.out.println("Now You create Post in Insta by username : "+userId +" and Text : "+text);

    }
}
