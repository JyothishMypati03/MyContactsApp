package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.model.Contact;
import com.bridgelabz.mycontacts.model.Tag;
import com.bridgelabz.mycontacts.validation.TagValidator;

import java.util.*;

public class TagService {

     private  final Set<Tag> tags  = new LinkedHashSet<>();
     private  final List<Contact> contacts ;

    public TagService(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void createTag(Scanner scanner){
        System.out.println("\n========== CREATE TAG ==========");

        System.out.print("Enter Tag Name: ");
        String tagName = scanner.nextLine().trim();

        if (!TagValidator.validateTagName(tagName)) {
            System.out.println("Invalid tag name. Use only letters, 2 to 20 characters.");
            return;
        }

        Tag newTag = new Tag(tagName);

        if (tags.contains(newTag)) {
            System.out.println("Tag already exists.");
            return;
        }

        tags.add(newTag);
        System.out.println("Tag created successfully.");

    }

    public  void viewTags(){

        System.out.println("\n========== TAG LIST ==========");

        if(tags.isEmpty()){

            System.out.println("No tags available.");
            return;

        }

        for (Tag tag : tags) {
            System.out.println(tag);
        }

    }

    public  void addTagToContact(Scanner scanner){

        System.out.println("\n========== APPLY TAG TO CONTACT ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.print("Enter Contact Name: ");
        String contactName = scanner.nextLine().trim();

        Contact contact = findContactByName(contactName);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter Tag Name: ");
        String tagName = scanner.nextLine().trim();

        if (!TagValidator.validateTagName(tagName)) {
            System.out.println("Invalid tag name.");
            return;
        }

        Tag tag = new Tag(tagName);

        if (!tags.contains(tag)) {
            tags.add(tag);
            System.out.println("New tag created and added.");
        }

        contact.addTag(String.valueOf(tag));
        System.out.println("Tag applied successfully.");

    }
    public void removeTagFromContact(Scanner scanner) {
        System.out.println("\n========== REMOVE TAG FROM CONTACT ==========");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.print("Enter Contact Name: ");
        String contactName = scanner.nextLine().trim();

        Contact contact = findContactByName(contactName);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter Tag Name to Remove: ");
        String tagName = scanner.nextLine().trim();

        Tag tag = new Tag(tagName);

        if (contact.getTags().contains(tag)) {
            contact.removeTag(tag);
            System.out.println("Tag removed successfully.");
        } else {
            System.out.println("Tag not found for this contact.");
        }
    }

    public void viewContactsByTag(Scanner scanner) {
        System.out.println("\n========== SEARCH CONTACTS BY TAG ==========");

        System.out.print("Enter Tag Name: ");
        String tagName = scanner.nextLine().trim();

        Tag searchTag = new Tag(tagName);
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getTags().contains(searchTag)) {
                System.out.println(contact);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found with this tag.");
        }
    }

    private Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }


}
