package com.bridgelabz.mycontacts;
import com.bridgelabz.mycontacts.auth.AuthenticationConfig;
import com.bridgelabz.mycontacts.auth.SessionManager;
import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.service.ContactService;
import com.bridgelabz.mycontacts.service.UserAuthenticationService;
import com.bridgelabz.mycontacts.service.UserProfileService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Creates a sample registered user.
        User registeredUser = new User("Jyothish", "Jyothish@gmail.com", "JAVA@!123");
        registeredUser.setPhoneNumber("9876543210");
        registeredUser.setAddress("Hyderabad");

        // Creates the authentication service.
        UserAuthenticationService authService =
                new UserAuthenticationService(new AuthenticationConfig());

        // Reads login credentials from the user.
        System.out.println("=== User Authentication ===");
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Authenticates the user.
        boolean loggedIn = authService.authenticate(registeredUser, email, password);

        // Exits if authentication fails.
        if (!loggedIn) {
            System.out.println("Invalid Email or Password!");
            scanner.close();
            return;
        }

        // Displays successful login message.
        System.out.println("Login Successful!");
        System.out.println("Logged In User: " +
                SessionManager.getInstance().getLoggedIdUserEmail());

        // Creates service objects.
        UserProfileService profileService = new UserProfileService();
        ContactService contactService = new ContactService();

        // Displays the main menu repeatedly.
        while (true){

            System.out.println("\n==========  MY CONTACTS APP  ==========");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Create Contact");
            System.out.println("5. View Contact Details");
            System.out.println("6. Edit Contact");
            System.out.println("7. View Contacts");
            System.out.print("Enter Your Choice: ");

            // Reads the user's menu choice.
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Executes the selected operation.
            switch (choice){

                case  1 : profileService.viewProfile(registeredUser); break;
                case  2 : profileService.updateProfile(registeredUser , scanner); break;
                case  3 : profileService.changePassword(registeredUser , scanner); break;
                case  4 : contactService.createContact(registeredUser ,scanner); break;
                case  5 : contactService.viewContactDetails(scanner);break;
                case  6 : contactService.editContact(scanner);
                case  7 : contactService.viewContacts(); break;
                default :  System.out.println("Invalid choice.");
            }

        }


    }

}
