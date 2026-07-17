package com.bridgelabz.mycontacts.search;

import com.bridgelabz.mycontacts.model.Contact;

public class EmailSearchCriteria implements SearchCriteria{

    private  String  searchEmail;

    public EmailSearchCriteria(String searchEmail){
        this.searchEmail=searchEmail;
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getEmailAddresses() == null){
            return  false;
        }

        for( String email : contact.getEmailAddresses()){

            if( email != null && email.toLowerCase().contains(searchEmail.toLowerCase())){
                return  true;
            }

        }

        return  false;
    }

}
