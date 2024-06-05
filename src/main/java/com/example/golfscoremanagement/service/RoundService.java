package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Round;
import com.example.golfscoremanagement.repository.IRoundRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoundService implements IRoundService {

    @Autowired
    private IRoundRepository menuRepository;

    @Override
    public List<Round> findMenu(int userId){
        return menuRepository.findMenu(userId);
    }
}
