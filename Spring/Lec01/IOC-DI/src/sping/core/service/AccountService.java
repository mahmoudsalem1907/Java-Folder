package sping.core.service;

public interface AccountService {
    void createAccount(String username,String password);
    void createPost(Long userId,String text);
}
