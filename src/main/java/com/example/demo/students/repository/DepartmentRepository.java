package com.example.demo.students.repository;

import com.example.demo.students.model.Departments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DepartmentRepository extends CrudRepository<Departments, Long> {

    Departments findDepartmentBySpeciality (String speciality);

    List<Departments> findDepartmentsByDepartment(String department);

}
