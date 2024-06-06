package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.entity.Course;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import com.example.golfscoremanagement.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ICourseService courseService;

    private record CourseInfo(Course course){};

    @GetMapping("course-per")
    public ResponseEntity<Course> course(@RequestParam(name = "courseId")int courseId){
        var course = courseService.findById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}