package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    User findLogin(String loginId, String loginPass);

    int insert(String name, String displayId, String loginId, String password);
}