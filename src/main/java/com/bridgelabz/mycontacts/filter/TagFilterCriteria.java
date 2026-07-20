package com.bridgelabz.mycontacts.filter;

import com.bridgelabz.mycontacts.model.Contact;

public class TagFilterCriteria implements FilterCriteria{

    private final String tag;

    public TagFilterCriteria(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getTags() == null){

            return false;

        }

        for( String cotactTag  : contact.getTags()){

            if(cotactTag != null &&  cotactTag.equalsIgnoreCase(tag) ){

                return  true;

            }

        }

        return false;
    }
}
