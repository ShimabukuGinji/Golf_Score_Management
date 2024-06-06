package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Hole;
import com.example.golfscoremanagement.entity.Round;
import com.example.golfscoremanagement.entity.Score;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoundService {
    List<Round> findMenu(int userId);

    int insert(Score score, List<Hole> holes) throws NoSuchPostalCodeException;
}
