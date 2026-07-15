package com.bridgelabz.mycontacts;

import com.bridgelabz.mycontacts.auth.AuthenticationConfig;
import com.bridgelabz.mycontacts.auth.SessionManager;
import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.service.UserAuthenticationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        User registeredUser = new User("Jyothish", "Jyothish@gmail.com", "JAVA@!123");

        UserAuthenticationService userAuthenticationService = new UserAuthenticationService(new AuthenticationConfig());

        System.out.println("=== User Authentication ===");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean loggedIn = userAuthenticationService.authenticate(registeredUser, email, password);

        if (loggedIn) {
            System.out.println("Login Successful!");
            System.out.println("Logged In User: " +
                    SessionManager.getInstance().getLoggedIdUserEmail());
        } else {
            System.out.println("Invalid Email or Password!");
        }


    }

}
