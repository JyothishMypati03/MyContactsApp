package com.bridgelabz.mycontacts.model;

public class User {

    //Private Fields
    private  String name ;
    private  String email;
    private  String  password;


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

    // Display user details
    @Override
    public String toString() {
        return "User Details\n" +
                "Name     : " + name + "\n" +
                "Email    : " + email;
    }




}
