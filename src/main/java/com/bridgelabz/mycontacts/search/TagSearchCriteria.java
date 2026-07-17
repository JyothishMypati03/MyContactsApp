package com.bridgelabz.mycontacts.search;

import com.bridgelabz.mycontacts.model.Contact;

public class TagSearchCriteria implements SearchCriteria{

    private  String  searchTag;

    public  TagSearchCriteria(String searchTag){
        this.searchTag=searchTag;
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getTags() == null ){
            return  false;
        }

        for(String  tag : contact.getTags()){

            if( tag != null && tag.toLowerCase().contains(searchTag.toLowerCase())){
                return  true;
            }

        }

        return  false;
    }

}
