package com.bridgelabz.mycontacts.search;

import com.bridgelabz.mycontacts.model.Contact;


public class NameSearchCriteria implements SearchCriteria{

    private String searchName;

    public NameSearchCriteria(String  searchName){
        this.searchName=searchName;
    }

    @Override
    public boolean matches(Contact contact) {

        return  contact.getName() != null && contact.getName().toLowerCase().contains(searchName.toLowerCase());

    }
}
