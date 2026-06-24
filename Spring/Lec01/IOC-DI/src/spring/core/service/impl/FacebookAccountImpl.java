package spring.core.service.impl;

import sping.core.service.AccountService;

public class FacebookAccountImpl implements AccountService {



    @Override
    public void createAccount(String unsername , String password){
        System.out.println("Now You create Account in facebook by username : "+unsername +"and password : "+password);
    }
    @Override
    public void createPost(Long userId,String text){
        System.out.println("Now You create Post in facebook by username : "+userId +"and Text : "+text);

    }
}
