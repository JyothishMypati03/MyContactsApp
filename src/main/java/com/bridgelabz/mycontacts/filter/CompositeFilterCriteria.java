package com.bridgelabz.mycontacts.filter;

import com.bridgelabz.mycontacts.model.Contact;

import java.util.List;

public class CompositeFilterCriteria implements  FilterCriteria{

    private  final List<FilterCriteria> criteriaList;


    public CompositeFilterCriteria(List<FilterCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public boolean matches(Contact contact) {

        for(FilterCriteria criteria  : criteriaList){

            if(!criteria.matches(contact)){
                return  false;
            }
        }

        return true;
    }
}
