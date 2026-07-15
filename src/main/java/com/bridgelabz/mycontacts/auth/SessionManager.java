package com.bridgelabz.mycontacts.auth;

public class SessionManager {

    private  static SessionManager instance;
    private String  loggedIdUserEmail;

    private  SessionManager(){}

    public  static  SessionManager getInstance(){

        if(instance == null){

            instance = new SessionManager();

        }

        return  instance;

    }


    public  void setLoggedIdUserEmail(String email){

        this.loggedIdUserEmail=email;

    }

    public  String  getLoggedIdUserEmail(){

        return  loggedIdUserEmail;

    }

    public void logout (){

        loggedIdUserEmail = null ;

    }

}
