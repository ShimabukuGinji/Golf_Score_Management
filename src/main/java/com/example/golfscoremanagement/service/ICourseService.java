package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {
    List<Course> findAll();

    Course findById(int id);
}
