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

    @Override
    public User findLogin(String loginId, String loginPass){
        return userRepository.findLogin(loginId, loginPass);
    }

    @Override
    public int insert(String name, String displayId, String loginId, String password){
        return userRepository.insert(name, displayId, loginId, password);
    }
}
