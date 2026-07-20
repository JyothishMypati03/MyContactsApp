package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.filter.*;
import com.bridgelabz.mycontacts.model.Contact;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactFilterService {

    private final List<Contact> contacts;

    public ContactFilterService(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void filterContacts(Scanner scanner){

        if(contacts.isEmpty()){
            System.out.println("No Contacts Available");
            return;
        }

        System.out.println("\n========== ADVANCED FILTERS ==========");
        System.out.println("1. Filter by Tag");
        System.out.println("2. Filter by Date Added");
        System.out.println("3. Filter by Frequently Contacted");
        System.out.println("4. Combine Filters");
        System.out.println("5. Sort by Name");
        System.out.println("6. Sort by Frequently Contacted");
        System.out.print("Enter Your Choice: ");

        int choice;
        try {
            choice=Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Invalid choice");
            return;
        }

        List<Contact> result = new ArrayList<>(contacts);

        switch (choice){
            case 1 : {
                System.out.println("Enter your Tag");
                String  tag = scanner.nextLine();

                FilterCriteria criteria= new TagFilterCriteria(tag);
                 result = result.stream().filter(criteria::matches).collect(Collectors.toList());
                 break;
            }

            case 2 : {

                System.out.println("Enter From Date (YYYY-MM-DD) : ");
                String  dateText = scanner.nextLine();

                try {
                    LocalDate fromDate = LocalDate.parse(dateText);
                    FilterCriteria criteria = new DateAddedFilterCriteria(fromDate);
                    result = result.stream().filter(criteria::matches).collect(Collectors.toList());
                }catch (Exception e){
                    System.out.println("Invalid date format.");
                    return;
                }
                break;

            }

            case 3 : {
                System.out.println("Enter Minimum Contact Count :");
                int minCount =  Integer.parseInt(scanner.nextLine());

                FilterCriteria criteria = new FrequentlyContactedFilterCriteria(minCount);
                result = result.stream().filter(criteria::matches).collect(Collectors.toList());
                break;
            }

            case  4 : {
                List<FilterCriteria> criteriaList = new ArrayList<>();
                System.out.println("ADD TAG Filter (yes/No)");
                String  addTag =  scanner.nextLine();
                if(addTag.equalsIgnoreCase("yes")){
                    System.out.println("Enter Tag : ");
                    String tag = scanner.nextLine();
                    criteriaList.add(new TagFilterCriteria(tag));
                }

                System.out.println("Add Date Filter (Yes/No) : ");
                String  addDate = scanner.nextLine();
                if(addDate.equalsIgnoreCase("yes")){
                    System.out.print("Enter From Date (yyyy-mm-dd): ");
                    String dateText = scanner.nextLine();
                    try {
                        LocalDate fromDate = LocalDate.parse(dateText);
                        criteriaList.add(new DateAddedFilterCriteria(fromDate));
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                        return;
                    }

                }

                System.out.print("Add Frequently Contacted Filter? (yes/no): ");
                String addFreq = scanner.nextLine();
                if (addFreq.equalsIgnoreCase("yes")) {
                    System.out.print("Enter Minimum Contact Count: ");
                    int minCount = Integer.parseInt(scanner.nextLine());
                    criteriaList.add(new FrequentlyContactedFilterCriteria(minCount));
                }

                FilterCriteria composite = new CompositeFilterCriteria(criteriaList);
                result = result.stream().filter(composite::matches).collect(Collectors.toList());
                break;


            }

            case 5 : {
                result.sort(Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
                break;
            }

            case 6 :  result.sort(Comparator.comparingInt(Contact::getContactCount).reversed());break;

            default:
                System.out.println("Invalid choice.");
                return;


        }
        System.out.println("\n========== FILTER RESULTS ==========");
        if (result.isEmpty()) {
            System.out.println("No matching contacts found.");
            return;
        }

        for (Contact contact : result) {
            System.out.println(contact);
            System.out.println("----------------------------------");
        }

    }
}
