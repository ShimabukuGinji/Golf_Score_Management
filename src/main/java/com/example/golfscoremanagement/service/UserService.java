package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.User;
import com.example.golfscoremanagement.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
