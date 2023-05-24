package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Services.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class Student_Controller {
    @Autowired
    Student_Service student_service;
    @GetMapping(value = "getAll")
    public List<Student> getAllStudents() {

        return student_service.getAllStudents();
    }
    @GetMapping(value = "getById")
    public Student getStudentById(@RequestParam Long id) {

        return student_service.getStudentById(id);
    }

    @PostMapping(value = "add")
    public String addStudent(@RequestBody Student student){
        student_service.addStudent(student);
        return "Student added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        student_service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
