package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> findAll();

    User findLogin(String loginId, String loginPass);

    int insert(String name, String displayId, String loginId, String password);
}
