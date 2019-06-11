package com.example.demo.fruits.repositories;

import com.example.demo.fruits.model.Fruits;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FruitsRepository extends CrudRepository<Fruits, Long> {

    List<Fruits> findAllByName(String name);

    List<Fruits> findAllByIdGreaterThan(Integer id);
}
