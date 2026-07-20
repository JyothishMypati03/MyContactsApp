package com.bridgelabz.mycontacts.validation;

public class TagValidator {

    public static boolean validateTagName(String tagName) {
        return tagName != null && tagName.trim().matches("^[A-Za-z]{2,20}$");
    }

}
