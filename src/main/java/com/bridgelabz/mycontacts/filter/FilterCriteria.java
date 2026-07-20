package com.bridgelabz.mycontacts.filter;

import com.bridgelabz.mycontacts.model.Contact;

public interface FilterCriteria {

    boolean matches(Contact contact);

}
