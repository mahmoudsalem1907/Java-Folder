package services;

import models.Account;
import models.ValidationResponseEnum;

import java.util.Scanner;

/**
 * ApplicationServiceImpl
 *
 * This class is responsible for:
 * - Starting the application
 * - Showing the main menu
 * - Handling user input (Login / Register / Exit)
 *
 * It acts as a Console Controller layer between
 * the user and AccountService.
 */
public class ApplicationServiceImpl implements ApplicationService {

    // Service responsible for business logic related to Account
    static AccountService accountService = new AccountServiceImpl();
    static ValidationService validationService = new ValidationServiceImpl();
    EWalletService eWalletService = new EWalletServiceImpl();
    Account account;

    /**
     * Entry point of the application.
     * Displays menu and keeps running until:
     * - User logs in successfully
     * - User registers successfully
     * - User chooses Exit
     * - User enters wrong choice 4 times
     */
    public void startApplication() {

        // Print welcome banner
        welcomeMessage("to كاشاتى");

        boolean isExit = false;
        Scanner sc = new Scanner(System.in);

        int count = 0; // counts wrong attempts

        // Main application loop
        while (true) {

            System.out.println("1.Login \n2.Register \n3.Exit");
            System.out.println("----------------------------------------");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();

            switch (choice) {

                // LOGIN OPTION
                case 1:
                    boolean resultOfLogin = login();

                    // If login successful → exit application
                    if (resultOfLogin) {
                        eWalletService.homeOption(account,sc);
                    }
                    break;

                // REGISTER OPTION
                case 2:
                    boolean resultOfRegister = register();

                    // If registration successful → exit application
                    if (resultOfRegister) {
                        eWalletService.homeOption(account,sc);
                    }
                    break;

                // EXIT OPTION
                case 3:
                    isExit = true;
                    System.out.println("Good Bye!");
                    return;

                // INVALID INPUT
                default:
                    System.out.println("Wrong choice \nEnter Valid choice....");
                    System.out.println("----------------------------------------");
                    count++; // increase wrong attempts counter
            }

            // Optional safety exit (not actually needed because of return)
            if (isExit) break;

            // If user enters wrong choice 4 times → stop program
            if (count == 4) {
                System.out.println("You Entered Wrong Choice Many Times :) ...");
                break;
            }
        }
    }

    /**
     * Prints the welcome message banner.
     */
    private static void welcomeMessage(String message) {
        System.out.println("------------Welcome "+message+"-----------");
        System.out.println("----------------------------------------");
    }

    /**
     * Handles Login operation.
     *
     * Steps:
     * 1. Take username & password from user
     * 2. Create Account object
     * 3. Call AccountService to validate credentials
     *
     * @return true  → if login successful
     *         false → if credentials are invalid
     */
    private boolean login() {
        System.out.println("------------ Welcome You Can Register Here :) -----------");
        System.out.println("Enter your username:");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        System.out.println("Enter your password:");
        String password = sc.next();

        // Create temporary account object for validation
        account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        // Check if account exists in system
        Account isAccountExist =
                accountService.getAccountExistByUserNameAndPassword(account);


        if (isAccountExist != null) {
            this.account = isAccountExist;
            System.out.println("Welcome " + username + " in your Account :)");

            return true;
        } else {
            System.out.println("Account not exist");
            return false;
        }
    }

    /**
     * Handles Register operation.
     *
     * Steps:
     * 1. Collect user data
     * 2. Create Account object
     * 3. Call AccountService to create new account
     *
     * @return true  → if account created successfully
     *         false → if account already exists
     */
    private boolean register() {

        Scanner sc = new Scanner(System.in);
        System.out.println("------------ Welcome You Can Register Here :) -----------");
        System.out.println("Enter your username:");
        String name = sc.next();
        if (userNameValidation(name)) return false;

        System.out.println("Enter your password:");
        String pass = sc.next();
        if (passwordValidation(pass)) return false;

        System.out.println("Enter your age");
        int age = sc.nextInt();
        if (ageValidation(age)) return false;

        System.out.println("Enter your Phone");
        String phone = sc.next();
        if (phoneValidation(phone)) return false;

        System.out.println("Enter your mail");
        String mail = sc.next();


        // Create account object with provided data
        account = new Account(name, pass, age, mail , phone);

        // Try to create account using service layer
        boolean flagAccountCreated = accountService.createAccount(account);

        if (flagAccountCreated) {
            System.out.println("Account Created Successfully.....");
            System.out.println("Welcome " + name + " in new Account :)");
            return true;
        } else {
            System.out.println("Account Creation Failed.....");
            System.out.println("Change Your Phone Number Or Your UserName");
            System.out.println("Account Already Exists");
            return false;
        }
    }

    private static boolean userNameValidation(String name) {
        ValidationResponseEnum validateS = validationService.usernameAndPasswordValidate(name);

        switch (validateS) {
            case LENGTH_LESS_THAN_3 :
                System.out.println("Invalid username length");
                return true;

            case USERNAME_FIRST_CHAR_NOT_UPPERCASE:
                System.out.println("Username Not Have First Char Uppercase");
                return true;
        }
        return false;
    }

    private static boolean passwordValidation(String pass) {
        ValidationResponseEnum validateS = validationService.usernameAndPasswordValidate(pass);

        switch (validateS) {
            case LENGTH_LESS_THAN_3 :
                System.out.println("Invalid Password length");
                return true;

        }
        return false;
    }

    private static boolean ageValidation(int age) {
        ValidationResponseEnum validateS = validationService.ageValidate(age);

        switch (validateS) {
            case AGE_LESS_THAN_18 :
                System.out.println("Age is less than 18");
                return true;

        }
        return false;
    }

    private static boolean phoneValidation(String phoneNumber) {
        ValidationResponseEnum validateS = validationService.phoneValidate(phoneNumber);

        switch (validateS) {
            case LENGTH_LESS_THAN_11:
                System.out.println("length is less than 11");
                return true;

            case NON_NUMERIC:
                System.out.println("Invalid Phone Number");
                return true;

            case INVALID_EGYPT_PHONE:
                System.out.println("Invalid Phone Number In EGY");
                return true;

            case FAILED:
                System.out.println("Invalid Phone Number");
                return true;
        }
        return false;
    }





}
