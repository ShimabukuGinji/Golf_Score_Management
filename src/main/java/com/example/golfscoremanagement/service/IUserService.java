package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> findAll();
}