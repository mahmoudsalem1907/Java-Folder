package models;

import java.util.ArrayList;
import java.util.List;

public class EWallet {

    private final String username = "كاشاتى";

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getUsername() {
        return username;
    }
}
