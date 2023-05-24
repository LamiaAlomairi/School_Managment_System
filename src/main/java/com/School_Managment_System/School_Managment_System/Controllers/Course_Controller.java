package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Services.Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class Course_Controller {
    @Autowired
    Course_Service course_service;
    @GetMapping(value = "getAll")
    public List<Course> getAllCourses() {

        return course_service.getAllCourses();
    }
    @GetMapping(value = "getById")
    public Course getCourseById(@RequestParam Long id) {

        return course_service.getCourseById(id);
    }

    @PostMapping(value = "add")
    public String addCourse(@RequestBody Course course){
        course_service.addCourse(course);
        return "Course added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        course_service.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}
