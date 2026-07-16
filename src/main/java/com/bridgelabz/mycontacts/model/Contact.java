package com.bridgelabz.mycontacts.model;

import java.time.LocalDateTime;
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
