package com.bridgelabz.mycontacts.model;

public class User {

    //Private Fields
    private  String name ;
    private  String email;
    private  String  password;
    private String  phoneNumber ;
    private String address;


    public  User(String  name , String  email , String password){

        this.name=name;
        this.email=email;
        this.password=password;

    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // Display user details
    @Override
    public String toString() {
        return "User Details\n" +
                "Name        : " + name + "\n" +
                "Email       : " + email + "\n" +
                "Phone       : " + phoneNumber + "\n" +
                "Address     : " + address ;

    }




}
