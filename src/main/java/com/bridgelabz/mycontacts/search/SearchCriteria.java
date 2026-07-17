package com.bridgelabz.mycontacts.search;

import com.bridgelabz.mycontacts.model.Contact;

public interface SearchCriteria {

    boolean matches(Contact contact);

}
