package com.bridgelabz.mycontacts.auth;

import com.bridgelabz.mycontacts.model.User;

public class AuthenticationConfig implements  Authentication{

    @Override
    public boolean login(User user, String email, String password) {

        return user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password);

    }
}
