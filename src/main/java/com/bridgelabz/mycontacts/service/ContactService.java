package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.Contact;
import com.bridgelabz.mycontacts.model.User;
import com.bridgelabz.mycontacts.validation.ContactValidator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {

     List<Contact> contacts =  new ArrayList<>();

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

    // Displays the details of a contact by name.
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

    // Edits the details of an existing contact.
    public  void editContact(Scanner scanner){
        System.out.println("\n========== EDIT CONTACT ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.print("Enter Contact Name to Edit: ");
        String name = scanner.nextLine();

        Contact contact = findContactByName(name);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Leave field empty to keep old value.");

        System.out.print("Enter New Contact Name: ");
        String newName = scanner.nextLine();
        if(!newName.isBlank()){
            if(ContactValidator.validateName(newName)){
                contact.setName(newName);
            }else {
                System.out.println("Invalid name. Old name kept.");
            }
        }

        System.out.print("How many new phone numbers do you want to set? ");
        String phoneInput = scanner.nextLine();

        if(!phoneInput.isBlank()){
            try{
                int phoneCount = Integer.parseInt(phoneInput);
                if(phoneCount > 0 ){
                    List<String> newPhones = new ArrayList<>();
                    for(int i=1 ; i<=phoneCount; i++){

                        while (true){
                            System.out.println("Enter Phone Number " + i + ": ");
                            String phone = scanner.nextLine();

                            if(ContactValidator.validatePhoneNumber(phone)){
                                newPhones.add(phone);
                                break;
                            }

                            System.out.println("Invalid phone number.");
                        }
                    }
                    contact.setPhoneNumbers(newPhones);

                }

            }catch (NumberFormatException e){

                System.out.println("Invalid number. Phone numbers not changed.");

            }


        }

        System.out.print("How many new email addresses do you want to set? ");
        String emailInput = scanner.nextLine();
        if (!emailInput.isBlank()) {
            try {
                int emailCount = Integer.parseInt(emailInput);
                if (emailCount > 0) {
                    List<String> newEmails = new ArrayList<>();
                    for (int i = 1; i <= emailCount; i++) {
                        while (true) {
                            System.out.print("Enter Email Address " + i + ": ");
                            String email = scanner.nextLine();

                            if (ContactValidator.validateEmail(email)) {
                                newEmails.add(email);
                                break;
                            }

                            System.out.println("Invalid email format.");
                        }
                    }
                    contact.setEmailAddresses(newEmails);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Email addresses not changed.");
            }
        }

        System.out.print("Enter New Address: ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isBlank()) {
            contact.setAddress(newAddress);
        }

        System.out.print("Enter New Notes: ");
        String newNotes = scanner.nextLine();
        if (!newNotes.isBlank()) {
            contact.setNotes(newNotes);
        }

        System.out.println("Contact updated successfully.");

    }

    //Delete Contact
    public  void deleteContact(Scanner scanner){

        System.out.println("\n========== DELETE CONTACT ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.print("Enter Contact Name to Delete: ");
        String name = scanner.nextLine();

        Contact contactToDelete = null;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactToDelete = contact;
                break;
            }
        }

        if (contactToDelete == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("\nContact Found:");
        System.out.println(contactToDelete);

        System.out.print("\nAre you sure you want to delete this contact? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            contacts.remove(contactToDelete);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }


    }

    // BulkOperations
    public void  bulkoperation(Scanner scanner){

        while (true){

            System.out.println("\n========== BULK OPERATIONS ==========");
            System.out.println("1. Bulk Delete Contacts");
            System.out.println("2. Bulk Add Tag");
            System.out.println("3. Export Contacts");
            System.out.print("Enter Your Choice: ");

            int choice;
            try {

                choice = scanner.nextInt();

            }catch (Exception e){

                System.out.println("Invalid choice.");
                continue;

            }

            switch (choice){

                case 1 : bulkDeleteContacts(scanner); break;
                case 2 : bulkAddTag(scanner); break;
                case 3 : exportContacts(scanner); break;
                default:  System.out.println("Invalid choice.");
            }
        }
    }

    //bulkDeleteCotacts
    public  void bulkDeleteContacts(Scanner scanner){

        if(contacts.isEmpty()){

            System.out.println("No contacts Avalilabe ");
            return;
        }

        System.out.println("Enter contact name to delete (comma separated) :");
        String contactsString = scanner.nextLine();

        String[] contactsNames = contactsString.split(",");

        List<Contact> toRemove = new ArrayList<>();

        for( String contactName : contactsNames){

            Contact contactByName = findContactByName(contactName);
            if(contactByName != null){
                toRemove.add(contactByName);
            }

        }

        if (toRemove.isEmpty()) {
            System.out.println("No matching contacts found.");
            return;
        }

        contacts.removeAll(toRemove);
        System.out.println("Selected contacts deleted successfully.");

    }

    //bulkAddTag
    public void bulkAddTag(Scanner scanner){

        if(contacts.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Enter contact names to tag (comma separated): ");
        String contactsString = scanner.nextLine();

        System.out.println("Enter tag Name : ");
        String tag = scanner.nextLine().trim();

        String[] contactsNames = contactsString.split(",");
        int updatedCount = 0;

        for(String contactsName : contactsNames){

            Contact contactByName = findContactByName(contactsName);
            if(contactByName != null ){

                contactByName.addTag(tag);
                updatedCount++;

            }

        }

        if(updatedCount == 0){
            System.out.println("No matching contacts found.");

        }else {
            System.out.println("Tag added to " + updatedCount + " contact(s).");
        }

    }

    //ExportsContacts
    public void exportContacts(Scanner scanner){

        if(contacts.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Enter export file name (default: contacts-export.txt): ");
        String  fileName = scanner.nextLine().trim();

        if(fileName.isBlank()){
            fileName ="contacts-export.txt";

        }

        Path path = Paths.get(fileName);

        try(BufferedWriter bufferedWriter =Files.newBufferedWriter(path)){

                for(Contact contact  : contacts){

                    bufferedWriter.write(contacts.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();

                }

            System.out.println("Contacts exported successfully.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Finds a contact by name.
    private Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
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
