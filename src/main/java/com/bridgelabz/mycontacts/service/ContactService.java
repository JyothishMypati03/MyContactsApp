package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.Contact;
import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.validation.ContactValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {

    private final List<Contact> contacts =  new ArrayList<>();

    // Creates a new contact for the logged-in user.
    public  void createContact(User loggedInUser , Scanner scanner){

        System.out.println("\n========== CREATE CONTACT ==========");

        String name;
        while (true) {
            System.out.print("Enter Contact Name: ");
            name = scanner.nextLine();

            if (ContactValidator.validateName(name)) {
                break;
            }

            System.out.println("Invalid name. First letter should be capital and minimum 3 letters.");
        }

        int phoneCount = readPositiveCount(scanner, "How many phone numbers do you want to add? ");
        List<String> phoneNumbers = new ArrayList<>();

        for (int i = 1; i <= phoneCount; i++) {
            while (true) {
                System.out.print("Enter Phone Number " + i + ": ");
                String phone = scanner.nextLine();

                if (ContactValidator.validatePhoneNumber(phone)) {
                    phoneNumbers.add(phone);
                    break;
                }

                System.out.println("Invalid phone number. It should start with 6, 7, 8, or 9 and contain 10 digits.");
            }
        }

        int emailCount = readPositiveCount(scanner, "How many email addresses do you want to add? ");
        List<String> emailAddresses = new ArrayList<>();

        for (int i = 1; i <= emailCount; i++) {
            while (true) {
                System.out.print("Enter Email Address " + i + ": ");
                String email = scanner.nextLine();

                if (ContactValidator.validateEmail(email)) {
                    emailAddresses.add(email);
                    break;
                }

                System.out.println("Invalid email format.");
            }
        }

        System.out.print("Enter Address (optional): ");
        String address = scanner.nextLine();

        System.out.print("Enter Notes (optional): ");
        String notes = scanner.nextLine();

        Contact contact = new Contact(
                loggedInUser.getEmail(),
                name,
                phoneNumbers,
                emailAddresses,
                address,
                notes
        );

        contacts.add(contact);

        System.out.println("Contact created successfully.");

    }

    // Displays all saved contacts.
    public void viewContacts() {
        System.out.println("\n========== CONTACT LIST ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------------------");
        }
    }

    public void viewContactDetails(Scanner scanner){

        System.out.println("\n========== VIEW CONTACT DETAILS ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.print("Enter Contact Name: ");
        String name = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("\n" + contact);
                return;
            }
        }

        System.out.println("Contact not found.");

    }

    // Reads and returns a valid positive number from the user.
    private int readPositiveCount(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                int count = Integer.parseInt(scanner.nextLine());
                if (count > 0) {
                    return count;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Enter a valid positive number.");
        }
    }


}
