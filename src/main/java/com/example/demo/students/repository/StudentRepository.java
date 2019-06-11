package com.example.demo.students.repository;

import com.example.demo.students.model.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Students, Long> {

    List<Students> findAllByFirstName(String name);

    List<Students> findByDepartmentId(Integer id);


}
