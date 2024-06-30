package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {courseService.save(course);}

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable Long id) {return ResponseEntity.ok(courseService.findById(id));}

}
