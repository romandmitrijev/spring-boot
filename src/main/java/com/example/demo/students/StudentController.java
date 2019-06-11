package com.example.demo.students;

import com.example.demo.students.model.Departments;
import com.example.demo.students.model.Students;
import com.example.demo.students.repository.DepartmentRepository;
import com.example.demo.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

//    @GetMapping(path = "/all")
//    public Iterable<Students> findAll(){
//        studentRepository.findAll();
//    }

    @RequestMapping(method = RequestMethod.POST, path = "/students/new")
    public void newStudent(@RequestBody Students student){
        studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/name")
    public Iterable<Students> findStudentByName (@RequestParam("name") String name){
        return studentRepository.findAllByFirstName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/speciality")
    public Iterable<Students> studentsBySpeciality (@RequestParam("spec") String speciality){
        Departments department = departmentRepository.findDepartmentBySpeciality(speciality);
        Long departmentId = department.getId();
        return studentRepository.findByDepartmentId(Math.toIntExact(departmentId));

    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/department")
    public Iterable<Students> studentsByDepartment (@RequestParam("dep") String department){
        Iterable<Departments> departmentsIterable = departmentRepository.findDepartmentsByDepartment(department);

        List<Integer> departmentIdList = new ArrayList<>();
        for (Departments departmentToSee:departmentsIterable){
            departmentIdList.add(Math.toIntExact(departmentToSee.getId()));
        }

        List<Students> studentsByDepartment = new ArrayList<>();
        for (Integer departmentId : departmentIdList){
            studentsByDepartment.addAll(studentRepository.findByDepartmentId(departmentId)) ;
        }
        return studentsByDepartment;
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/students/names")
//    public Iterable<Departments> sameStudentsNameInADepartment (@RequestParam("name") String name){
//        Iterable<Students> studentsWithSameName = studentRepository.findAllByFirstName(name);
//        List<Integer> departmentsIds = new ArrayList<>();
//        for (Students student:studentsWithSameName) {
//            departmentsIds.add(student.getDepartmentId());
//        }
//        List<Departments> departmentsList = new ArrayList<>();
//        for (Integer departmentId:departmentsIds) {
//            Optional<Departments> byId = departmentRepository.findById(Integer.toUnsignedLong(departmentId));
//            departmentsList.addAll(byId);
//        }
//        return departmentsList;
//    }
}
