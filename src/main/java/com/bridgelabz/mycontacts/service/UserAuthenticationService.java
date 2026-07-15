package com.bridgelabz.mycontacts.service;

import com.bridgelabz.mycontacts.auth.Authentication;
import com.bridgelabz.mycontacts.auth.SessionManager;
import com.bridgelabz.mycontacts.model.User;

public class UserAuthenticationService {

        private final Authentication authentication;

        public  UserAuthenticationService(Authentication authentication){

            this.authentication = authentication;

        }

        public  boolean authenticate(User user , String email , String  password){

            boolean isLoggedIn = authentication.login(user , email , password);


            if(isLoggedIn){

                SessionManager.getInstance().setLoggedIdUserEmail(user.getEmail());

            }

            return isLoggedIn;

        }


}
