package com.example.demo.citizens.controller;

import com.example.demo.citizens.model.Person;
import com.example.demo.citizens.repository.CityRepository;
import com.example.demo.citizens.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CityRepository cityRepository;

    @GetMapping(path = "persons/frontend/all")
    public ModelAndView persons() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("persons");
        modelAndView.addObject("persons", personRepository.findAll());
        return modelAndView;
    }

    @GetMapping(path = "persons/frontend/add")
    public String get(Model model) {
        Person person = new Person();
        model.addAttribute("person", new PersonToAdd());
        return "addperson";
    }

    static class PersonToAdd {
        String name;

        Integer cityId;

        public PersonToAdd() {
        }

        public PersonToAdd(String name, Integer cityId) {
            this.name = name;
            this.cityId = cityId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }
    }

    @PostMapping(path = "persons/frontend/add")
    public String addNewPerson(Model model, @ModelAttribute("person") PersonToAdd person) {
        personRepository.save(new Person(null, person.name, cityRepository.findById(person.cityId).get()));
        return "addperson";
    }

}