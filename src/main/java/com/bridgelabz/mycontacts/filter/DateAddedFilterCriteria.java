package com.bridgelabz.mycontacts.filter;

import com.bridgelabz.mycontacts.model.Contact;

import java.time.LocalDate;

public class DateAddedFilterCriteria implements FilterCriteria{

    private  final LocalDate fromDate;

    public DateAddedFilterCriteria(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getCreatedAt() == null){
            return  false;
        }

        return !contact.getCreatedAt().toLocalDate().isBefore(fromDate);
    }
}
