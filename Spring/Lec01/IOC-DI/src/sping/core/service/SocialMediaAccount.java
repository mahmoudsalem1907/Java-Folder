package sping.core.service;

public class SocialMediaAccount {


    private AccountService accountService;

    public SocialMediaAccount(AccountService accountService){
        this.accountService = accountService;
    }
    public void createAccount(String username,String password)
    {

        accountService.createAccount(username,password);

    }


    public void createPost(Long userId,String text)
    {
        accountService.createPost(userId,text);
    }
}
