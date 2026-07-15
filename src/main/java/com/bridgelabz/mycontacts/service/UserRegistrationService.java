package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.validation.UserValidator;

import java.util.Scanner;

public class UserRegistrationService {

    public User registerUser(){

        Scanner scanner = new Scanner(System.in);

        String  name ;
        String email;
        String password;


        // Name Validation
        while (true){

            System.out.println("Enter Name :");
            name = scanner.nextLine();

            if(UserValidator.validateName(name)){
                break;
            }

            System.out.println("Invalid Name !");

        }

        //Email Validation

        while (true){

            System.out.println("Enter Email : ");
            email = scanner.nextLine();

            if(UserValidator.validateEmail(email)){
                break;

            }

            System.out.println("Invalid Email!");

        }

        //Password Validation

        while (true){

            System.out.println("Enter password");
            password = scanner.nextLine();

            if(UserValidator.validatePassword(password)){
                break;

            }

            System.out.println("Invalid Password");
            System.out.println("Password must contain:");
            System.out.println("• One Uppercase Letter");
            System.out.println("• One Number");
            System.out.println("• One Special Character");
            System.out.println("• Minimum 8 Characters");

        }



        User user = new User(name , email , password);

        return user;
    }


}
