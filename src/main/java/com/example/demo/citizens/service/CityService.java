package com.example.demo.citizens.service;

import com.example.demo.citizens.model.City;
import com.example.demo.citizens.repository.CityRepository;
import com.example.demo.citizens.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PersonRepository personRepository;

    public Iterable<City> getAllCities (){
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Integer id){
        if (!cityRepository.existsById(id)){
            System.out.println("City with id" + id + "not found");
        }
        return cityRepository.findById(id);
    }

}
