package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Course;
import com.example.golfscoremanagement.entity.Round;
import com.example.golfscoremanagement.entity.User;
import com.example.golfscoremanagement.repository.ICourseRepository;
import com.example.golfscoremanagement.repository.IRoundRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id){
        return courseRepository.findById(id);
    }
}
