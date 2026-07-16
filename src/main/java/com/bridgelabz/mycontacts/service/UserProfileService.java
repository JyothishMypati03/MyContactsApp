package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.validation.UserValidator;

import java.util.Scanner;

/**
 * Service class responsible for managing user profile operations.
 * This includes creating, retrieving, updating, and deleting
 * user profile information.
 */

public class UserProfileService {


   // Displays the user's profile details.
    public  void viewProfile(User user){

        System.out.println("\n========== PROFILE DETAILS ==========");
        System.out.println(user);

    }

    // Updates the user's profile details.
    public  void updateProfile(User user , Scanner scanner){

        System.out.println("\n========== UPDATE PROFILE ==========");

        String  name;
        String  email;
        String  phoneNumber;
        String  address;

        //Name
        while (true){

            System.out.println("Enter New Name : ");
            name = scanner.nextLine();

            if(UserValidator.validateName(name)){

                break;
            }

            System.out.println("Invalid name. First letter should be capital and minimum 3 letters.");

        }

        //Email
        while (true){

            System.out.println("Enter New Email : ");
            email = scanner.nextLine();

            if(UserValidator.validateEmail(email)){

                break;

            }

            System.out.println("Invalid email format.");

        }


        // PhoneNumber
        while (true){

            System.out.println("Enter new PhoneNumber : ");
            phoneNumber= scanner.nextLine();

            if(UserValidator.validatePhoneNumber(phoneNumber)){
                break;
            }

            System.out.println("Invalid phone number. It should start with 6, 7, 8, or 9 and contain 10 digits.");

        }

        //Address
        System.out.println("Enter New Address: ");
        address = scanner.nextLine();

        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);

        System.out.println("Profile updated successfully.");


    }

    // Changes the user's password after validating the current password.
    public  void changePassword(User user , Scanner scanner){

        System.out.println("\n========== CHANGE PASSWORD ==========");

        System.out.print("Enter Current Password: ");
        String currentPassword = scanner.nextLine();

        if (!user.getPassword().equals(currentPassword)) {
            System.out.println("Current password is incorrect.");
            return;
        }

        String newPassword;

        while (true){

            System.out.println("Enter New Password : ");
            newPassword =  scanner.nextLine();

            if(UserValidator.validatePassword(newPassword)){
                break;
            }

            System.out.println("Invalid password.");
            System.out.println("Password must contain:");
            System.out.println("- at least 8 characters");
            System.out.println("- one uppercase letter");
            System.out.println("- one number");
            System.out.println("- one special character");

        }

        user.setPassword(newPassword);
        System.out.println("Password changed successfully.");

    }



}
