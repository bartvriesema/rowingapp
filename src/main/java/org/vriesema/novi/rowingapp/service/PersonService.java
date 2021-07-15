package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
}
