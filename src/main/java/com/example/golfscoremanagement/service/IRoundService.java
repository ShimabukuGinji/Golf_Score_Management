package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Round;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoundService {
    List<Round> findMenu(int userId);
}
