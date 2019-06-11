package com.example.demo.citizens.repository;

import com.example.demo.citizens.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
