package com.bridgelabz.mycontacts;

import com.bridgelabz.mycontacts.auth.AuthenticationConfig;
import com.bridgelabz.mycontacts.auth.SessionManager;
import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.service.UserAuthenticationService;
import com.bridgelabz.mycontacts.service.UserProfileService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        UserProfileService profileService = new UserProfileService();


        User registeredUser = new User("Jyothish", "Jyothish@gmail.com", "JAVA@!123");
        registeredUser.setPhoneNumber("9876543210");
        registeredUser.setAddress("Hyderabad");

        while (true){

            System.out.println("\n========== USER PROFILE MANAGEMENT ==========");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.print("Enter Your Choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case  1 : profileService.viewProfile(registeredUser); break;
                case  2 : profileService.updateProfile(registeredUser , scanner); break;
                case  3 : profileService.changePassword(registeredUser , scanner); break;
                default:  System.out.println("Invalid choice.");
            }



        }


    }

}
