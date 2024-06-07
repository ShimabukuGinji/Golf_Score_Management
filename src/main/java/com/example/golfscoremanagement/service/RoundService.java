package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.*;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import com.example.golfscoremanagement.repository.IRoundRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoundService implements IRoundService {

    @Autowired
    private IRoundRepository roundRepository;
    @Override
    public List<Round> findMenu(int userId){
        return roundRepository.findMenu(userId);
    }

    @Override
    public MenuScore findMenuScore(int userId){
        return roundRepository.findMenuScore(userId);
    }
    @Override
    public List<Round> findAll(int userId){
        return roundRepository.findAll(userId);
    }
    @Override
    @Transactional
    public int insert(Score score, List<Hole> holes) throws NoSuchPostalCodeException {
        return roundRepository.insert(score, holes);
    }
    @Override
    @Transactional
    public int delete(int id) throws NoSuchPostalCodeException {
        return roundRepository.delete(id);
    }
    @Override
    public Score findScore(int id) {
        return roundRepository.findScore(id);
    }
    @Override
    public List<Holes> findHole1_9(int id) {
        return roundRepository.findHole1_9(id);
    }
    @Override
    public List<Holes> findHole10_18(int id) {
        return roundRepository.findHole10_18(id);
    }
}
