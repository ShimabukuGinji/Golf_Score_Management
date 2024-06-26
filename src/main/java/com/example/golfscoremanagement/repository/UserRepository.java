package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRepository implements IUserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY id",
            new DataClassRowMapper<>(User.class));
    }

    @Override
    public User findLogin(String loginId, String loginPass) {
        var param = new MapSqlParameterSource();
        param.addValue("ID", loginId);
        param.addValue("pass", loginPass);
        var list = jdbcTemplate.query("SELECT * FROM users WHERE login_id = :ID AND password = :pass ORDER BY id;",
                param,
                new DataClassRowMapper<>(User.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(String name, String displayId, String loginId, String password) {
        var param = new MapSqlParameterSource();
        param.addValue("name", name);
        param.addValue("displayId", displayId);
        param.addValue("loginId", loginId);
        param.addValue("password", password);
        return jdbcTemplate.update(
                "insert into users(name, display_name, login_id, password, role) values(:name, :displayId, :loginId, :password, 2);"
                ,param);
    }
}

