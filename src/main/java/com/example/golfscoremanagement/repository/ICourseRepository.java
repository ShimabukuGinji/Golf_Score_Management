package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.Course;

import java.util.List;

public interface ICourseRepository {
    List<Course> findAll();
}
