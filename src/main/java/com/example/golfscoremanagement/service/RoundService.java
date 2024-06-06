package com.example.golfscoremanagement.service;

import com.example.golfscoremanagement.entity.Hole;
import com.example.golfscoremanagement.entity.Round;
import com.example.golfscoremanagement.entity.Score;
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
    @Transactional
    public int insert(Score score, List<Hole> holes) throws NoSuchPostalCodeException {
        return roundRepository.insert(score, holes);
    }
}
