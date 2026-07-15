package com.bridgelabz.mycontacts.validation;

import java.util.regex.Pattern;

public class UserValidator {

    // Name should start with capital and minimum 3 letters
    public static  boolean validateName(String  name){

        String regex = "^[A-Z][a-zA-Z]{2,}$";

        return Pattern.matches(regex , name);

    }

    public  static  boolean validateEmail(String email){

        String regex = "^[A-Za-z0-9+.-_]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        return  Pattern.matches(regex, email);

    }

    public  static  boolean validatePassword(String  password){

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$";

        return  Pattern.matches(regex , password);

    }


}
