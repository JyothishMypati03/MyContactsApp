package com.bridgelabz.mycontacts.auth;

import com.bridgelabz.mycontacts.model.User;

public interface Authentication {

    boolean login (User user  , String email , String password);

}
