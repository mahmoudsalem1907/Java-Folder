package models;

public class Account {
    private String username;
    private String password;
    private String email;
    private double balance;
    private int age;
    private String Phone;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account() {

    }

    public Account(String username, String password, int age, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.Phone = phone;
    }

    @Override
    public String toString() {
        return "Account Details {\n" +
                "\tusername: " + username + "\n" +
                "\tpassword: *************\n" +
                "\temail: " + email + "\n" +
                "\tPhone: " + Phone + "\n" +
                "\tbalance: " + balance + "\n" +
                "\tage: " + age + "\n" +
                "}";
    }
}
