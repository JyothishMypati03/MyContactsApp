package com.bridgelabz.mycontacts.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Stores contact details
public class Contact {

    private UUID id ;
    private String ownerEmail;
    private String name;
    private List<String> phoneNumbers;
    private List<String> emailAddresses;
    private String address;
    private String notes;
    private LocalDateTime createdAt;

    public Contact(String ownerEmail ,
                   String name,
                   List<String> phoneNumbers,
                   List<String> emailAddresses,
                   String address,
                   String notes){

        this.id = UUID.randomUUID();
        this.ownerEmail = ownerEmail;
        this.name=name;
        this.phoneNumbers=phoneNumbers;
        this.emailAddresses=emailAddresses;
        this.address=address;
        this.notes=notes;
        this.createdAt=LocalDateTime.now();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = new ArrayList<>(emailAddresses);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public String getAddress() {
        return address;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emailAddresses=" + emailAddresses +
                ", address='" + address + '\'' +
                ", notes='" + notes + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
