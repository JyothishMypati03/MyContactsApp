package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.Contact;
import com.bridgelabz.mycontacts.search.*;

import java.util.List;
import java.util.Scanner;

public class SearchService {

    private List<Contact> contacts;

    public SearchService(List<Contact> contacts){
        this.contacts=contacts;
    }

    public  void searchContacts(Scanner scanner){

        System.out.println("\n========== SEARCH CONTACTS ==========");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Phone");
        System.out.println("3. Search by Email");
        System.out.println("4. Search by Tag");
        System.out.print("Enter Your Choice: ");

        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter Search Value: ");
        String searchValue = scanner.nextLine();

        SearchCriteria criteria = null;

        switch (choice) {
            case 1:
                criteria = new NameSearchCriteria(searchValue);
                break;
            case 2:
                criteria = new PhoneSearchCriteria(searchValue);
                break;
            case 3:
                criteria = new EmailSearchCriteria(searchValue);
                break;
            case 4:
                criteria = new TagSearchCriteria(searchValue);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        boolean found = false;

        System.out.println("\n========== SEARCH RESULTS ==========");

        for(  Contact contact :contacts){

            if(criteria.matches(contact)){

                System.out.println(contact);
                System.out.println("----------------------------------");
                found = true;

            }

        }

        if (!found) {
            System.out.println("No matching contacts found.");
        }

    }


}
