package com.example.demo.citizens.controller;

import com.example.demo.citizens.model.City;
import com.example.demo.citizens.model.CityR;
import com.example.demo.citizens.repository.CityRepository;
import com.example.demo.citizens.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PersonRepository personRepository;


    @GetMapping(path = "city/all")
    public Iterable<CityR> allCities() {
        List<CityR> list = new ArrayList<>();

        Iterable<City> all = cityRepository.findAll();
        for (City city: all) {
            CityR cityR = new CityR();
            cityR.setName(city.getName()); ;
            cityR.setAmountOfUsers(city.getPersonSet().size());
            list.add(cityR);
        }
        return list;
    }

    @GetMapping(path = "city/frontend/all")
    public ModelAndView cities() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cities");
        modelAndView.addObject("cities", cityRepository.findAll());
        return modelAndView;
    }

    @GetMapping(path = "city/frontend/add")
    public String get(Model model) {
        City city = new City();
        model.addAttribute("city", city);
        return "addcity";
    }

    @PostMapping(path = "city/frontend/add")
    public String addNewCity(Model model,  @ModelAttribute("city") City city) {
        cityRepository.save(city);
        return "addcity";
    }
}
