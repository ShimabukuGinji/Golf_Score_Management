package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.Round;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoundRepository {
    List<Round> findMenu(int userId);
}
