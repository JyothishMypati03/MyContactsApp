package com.bridgelabz.mycontacts.filter;

import com.bridgelabz.mycontacts.model.Contact;

public class FrequentlyContactedFilterCriteria implements FilterCriteria{

    private final int minCount;

    public FrequentlyContactedFilterCriteria(int minCount) {
        this.minCount = minCount;
    }

    @Override
    public boolean matches(Contact contact) {

        return contact.getContactCount() >= minCount;
    }
}
