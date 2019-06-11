package com.example.demo.citizens.service;

import com.example.demo.citizens.model.Person;
import com.example.demo.citizens.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> findAllPersons(){
        return personRepository.findAll();
    }

}
