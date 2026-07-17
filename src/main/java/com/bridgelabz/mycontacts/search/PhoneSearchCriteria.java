package com.bridgelabz.mycontacts.search;

import com.bridgelabz.mycontacts.model.Contact;

public class PhoneSearchCriteria implements  SearchCriteria{

    private  String  searchPhone;

    public  PhoneSearchCriteria(String  searchPhone){
        this.searchPhone=searchPhone;
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getPhoneNumbers() == null ){
            return  false;
        }

        for( String phone  :contact.getPhoneNumbers()){

            if(phone != null && phone.contains(searchPhone)){
                return true;
            }

        }

        return  false;
    }
}
