package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.*;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoundRepository {
    List<Round> findMenu(int userId);

    MenuScore findMenuScore(int userId);

    List<Round> findAll(int userId);

    int insert(Score score, List<Hole> holes) throws NoSuchPostalCodeException;

    int delete(int id) throws NoSuchPostalCodeException;

    Score findScore(int id);

    List<Holes> findHole1_9(int id);

    List<Holes> findHole10_18(int id);
}
