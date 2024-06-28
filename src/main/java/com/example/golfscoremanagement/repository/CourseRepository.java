package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseRepository implements ICourseRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query("SELECT * FROM courses ORDER BY id",
                new DataClassRowMapper<>(Course.class));
    }

    @Override
    public Course findById(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM courses WHERE id = :id ORDER BY id",
                param, new DataClassRowMapper<>(Course.class));
        return list.isEmpty() ? null : list.get(0);
    }
}