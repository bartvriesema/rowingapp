package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.Person;
import org.vriesema.novi.rowingapp.repository.PersonRepository;
import org.vriesema.novi.rowingapp.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl (PersonRepository repository) {
        this.personRepository = repository;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
