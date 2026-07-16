package com.bridgelabz.mycontacts.validation;

import java.util.regex.Pattern;

public class ContactValidator {

    private static  final String  NAME_REGEX  = "^[A-Z][a-zA-Z]{2,}$";
    private static  final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static  final String PHONE_REGEX = "^[6-9][0-9]{9}$";

    public  static  boolean validateName(String name){

        return Pattern.matches(NAME_REGEX , name);

    }

    public  static  boolean validateEmail(String email){

        return  Pattern.matches(EMAIL_REGEX , email);
    }

    public  static  boolean validatePhoneNumber(String  phoneNumber){

        return  Pattern.matches(PHONE_REGEX , phoneNumber);
    }

}
