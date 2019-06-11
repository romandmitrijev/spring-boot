package com.example.demo.fruits;

import com.example.demo.fruits.model.Fruits;
import com.example.demo.fruits.repositories.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitsController {

    @Autowired
    FruitsRepository fruitsRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/fruits/all")
    public Iterable<Fruits> getAll() {
        return fruitsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fruits/name")
    public Iterable<Fruits> get(@RequestParam("name") String name) {
        return fruitsRepository.findAllByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/admin/fruits/new")
    public void newFruit(@RequestBody Fruits fruit) {
            fruitsRepository.save(fruit);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/fruits/delete")
    public void deleteFruit (@RequestBody Fruits fruit){
        fruitsRepository.delete(fruit);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/fruits/delete/id")
    public void deleteFruitById (@RequestParam("id") Long id) {
        fruitsRepository.deleteById(id);
    }
}
