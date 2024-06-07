package com.example.golfscoremanagement.repository;

import com.example.golfscoremanagement.entity.*;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoundRepository implements IRoundRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Round> findMenu(int userId) {
        var sql = "SELECT " +
                "s.id" +
                ", c.name" +
                ", play_date" +
                ", h1.score+h2.score+h3.score+h4.score+h5.score+h6.score+h7.score+h8.score+h9.score+h10.score+h11.score+h12.score+h13.score+h14.score+h15.score+h16.score+h17.score+h18.score score" +
                ", h1.patts+h2.patts+h3.patts+h4.patts+h5.patts+h6.patts+h7.patts+h8.patts+h9.patts+h10.patts+h11.patts+h12.patts+h13.patts+h14.patts+h15.patts+h16.patts+h17.patts+h18.patts patts " +
                "FROM scores s " +
                "JOIN users u ON s.user_id = u.id " +
                "JOIN courses c ON s.course_id = c.id " +
                "JOIN hole1  h1 ON s.id = h1.id " +
                "JOIN hole2 h2 ON s.id = h2.id " +
                "JOIN hole3 h3 ON s.id = h3.id " +
                "JOIN hole4 h4 ON s.id = h4.id " +
                "JOIN hole5 h5 ON s.id = h5.id " +
                "JOIN hole6 h6 ON s.id = h6.id " +
                "JOIN hole7 h7 ON s.id = h7.id " +
                "JOIN hole8 h8 ON s.id = h8.id " +
                "JOIN hole9 h9 ON s.id = h9.id " +
                "JOIN hole10 h10 ON s.id = h10.id " +
                "JOIN hole11 h11 ON s.id = h11.id " +
                "JOIN hole12 h12 ON s.id = h12.id " +
                "JOIN hole13 h13 ON s.id = h13.id " +
                "JOIN hole14 h14 ON s.id = h14.id " +
                "JOIN hole15 h15 ON s.id = h15.id " +
                "JOIN hole16 h16 ON s.id = h16.id " +
                "JOIN hole17 h17 ON s.id = h17.id " +
                "JOIN hole18 h18 ON s.id = h18.id " +
                "WHERE s.user_id = " +
                userId +
                " ORDER BY play_date DESC " +
                "LIMIT 5;";
        return jdbcTemplate.query(sql, new DataClassRowMapper<>(Round.class));
    }

    @Override
    public MenuScore findMenuScore(int userId) {
        var param = new MapSqlParameterSource();
        param.addValue("id", userId);
        var sql = "SELECT ROUND(AVG(h1.score+h2.score+h3.score+h4.score+h5.score+h6.score+h7.score+h8.score+h9.score+h10.score+h11.score+h12.score+h13.score+h14.score+h15.score+h16.score+h17.score+h18.score),1) avgscore" +
                ", MIN(h1.score+h2.score+h3.score+h4.score+h5.score+h6.score+h7.score+h8.score+h9.score+h10.score+h11.score+h12.score+h13.score+h14.score+h15.score+h16.score+h17.score+h18.score) bestscore" +
                ", ROUND(AVG(h1.patts+h2.patts+h3.patts+h4.patts+h5.patts+h6.patts+h7.patts+h8.patts+h9.patts+h10.patts+h11.patts+h12.patts+h13.patts+h14.patts+h15.patts+h16.patts+h17.patts+h18.patts),1) avgpat " +
                "FROM scores s " +
                "JOIN users u ON s.user_id = u.id " +
                "JOIN courses c ON s.course_id = c.id " +
                "JOIN hole1  h1 ON s.id = h1.id " +
                "JOIN hole2 h2 ON s.id = h2.id " +
                "JOIN hole3 h3 ON s.id = h3.id " +
                "JOIN hole4 h4 ON s.id = h4.id " +
                "JOIN hole5 h5 ON s.id = h5.id " +
                "JOIN hole6 h6 ON s.id = h6.id " +
                "JOIN hole7 h7 ON s.id = h7.id " +
                "JOIN hole8 h8 ON s.id = h8.id " +
                "JOIN hole9 h9 ON s.id = h9.id " +
                "JOIN hole10 h10 ON s.id = h10.id " +
                "JOIN hole11 h11 ON s.id = h11.id " +
                "JOIN hole12 h12 ON s.id = h12.id " +
                "JOIN hole13 h13 ON s.id = h13.id " +
                "JOIN hole14 h14 ON s.id = h14.id " +
                "JOIN hole15 h15 ON s.id = h15.id " +
                "JOIN hole16 h16 ON s.id = h16.id " +
                "JOIN hole17 h17 ON s.id = h17.id " +
                "JOIN hole18 h18 ON s.id = h18.id " +
                "WHERE s.user_id = :id;";
        var list = jdbcTemplate.query(sql,param, new DataClassRowMapper<>(MenuScore.class));
        System.out.println("----------------");
        System.out.println(list);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Round> findAll(int userId) {
        var sql = "SELECT " +
                "s.id" +
                ", c.name" +
                ", play_date" +
                ", h1.score+h2.score+h3.score+h4.score+h5.score+h6.score+h7.score+h8.score+h9.score+h10.score+h11.score+h12.score+h13.score+h14.score+h15.score+h16.score+h17.score+h18.score score" +
                ", h1.patts+h2.patts+h3.patts+h4.patts+h5.patts+h6.patts+h7.patts+h8.patts+h9.patts+h10.patts+h11.patts+h12.patts+h13.patts+h14.patts+h15.patts+h16.patts+h17.patts+h18.patts patts " +
                "FROM scores s " +
                "JOIN users u ON s.user_id = u.id " +
                "JOIN courses c ON s.course_id = c.id " +
                "JOIN hole1  h1 ON s.id = h1.id " +
                "JOIN hole2 h2 ON s.id = h2.id " +
                "JOIN hole3 h3 ON s.id = h3.id " +
                "JOIN hole4 h4 ON s.id = h4.id " +
                "JOIN hole5 h5 ON s.id = h5.id " +
                "JOIN hole6 h6 ON s.id = h6.id " +
                "JOIN hole7 h7 ON s.id = h7.id " +
                "JOIN hole8 h8 ON s.id = h8.id " +
                "JOIN hole9 h9 ON s.id = h9.id " +
                "JOIN hole10 h10 ON s.id = h10.id " +
                "JOIN hole11 h11 ON s.id = h11.id " +
                "JOIN hole12 h12 ON s.id = h12.id " +
                "JOIN hole13 h13 ON s.id = h13.id " +
                "JOIN hole14 h14 ON s.id = h14.id " +
                "JOIN hole15 h15 ON s.id = h15.id " +
                "JOIN hole16 h16 ON s.id = h16.id " +
                "JOIN hole17 h17 ON s.id = h17.id " +
                "JOIN hole18 h18 ON s.id = h18.id " +
                "WHERE s.user_id = " +
                userId +
                " ORDER BY play_date DESC;";
        return jdbcTemplate.query(sql, new DataClassRowMapper<>(Round.class));
    }

    @Override
    public int insert(Score score, List<Hole> holes) throws NoSuchPostalCodeException {
        var param = new MapSqlParameterSource();
        param.addValue("user",score.userId());
        param.addValue("course", score.courseId());
        param.addValue("note", score.note());
        try {
            jdbcTemplate.update(
                    "INSERT INTO scores (user_id, play_date, course_id, note) VALUES (:user, '" + score.playDate() +"', :course, :note)"
                    , param);
        } catch (Exception e) {
            throw new NoSuchPostalCodeException(e);
        }

        for (var i=1; i<=18; i++) {
            param.addValue("score", holes.get(i-1).score());
            param.addValue("pat", holes.get(i-1).patts());
            try {
                jdbcTemplate.update(
                        "INSERT INTO hole" + i + " (score, patts, bunker, water, ob, pena) VALUES (:score, :pat, 0, 0, 0, 0)"
                        ,param);
            } catch (Exception e) {
                throw new NoSuchPostalCodeException(e);
            }
        }
        return 0;
    }

    @Override
    public int delete(int id) throws NoSuchPostalCodeException {
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        try {
            jdbcTemplate.update(
                    "DELETE FROM scores WHERE id = :id;"
                    , param);
        } catch (Exception e) {
            throw new NoSuchPostalCodeException(e);
        }

        for (var i=1; i<=18; i++) {
            try {
                jdbcTemplate.update(
                        "DELETE FROM hole" + i + " WHERE id = :id;"
                        ,param);
            } catch (Exception e) {
                throw new NoSuchPostalCodeException(e);
            }
        }
        return 0;
    }

    @Override
    public Score findScore(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM scores WHERE id = :id;", param, new DataClassRowMapper<>(Score.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Holes> findHole1_9(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        List<Holes> round = new ArrayList<>();
        for (var i=1; i<=9; i++) {
            var list = jdbcTemplate.query("SELECT * FROM hole" + i + " WHERE id = :id;", param, new DataClassRowMapper<>(Holes.class));
            if (!list.isEmpty()) {
                list.set(0,new Holes(list.get(0).id(),list.get(0).score(),list.get(0).patts(),i,0,0,0));
                round.add(list.get(0));
            }
        }
        return round;
    }

    @Override
    public List<Holes> findHole10_18(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        List<Holes> round = new ArrayList<>();
        for (var i=10; i<=18; i++) {
            var list = jdbcTemplate.query("SELECT * FROM hole" + i + " WHERE id = :id;", param, new DataClassRowMapper<>(Holes.class));
            if (!list.isEmpty()) {
                list.set(0,new Holes(list.get(0).id(),list.get(0).score(),list.get(0).patts(),i,0,0,0));
                round.add(list.get(0));
            }
        }
        return round;
    }
}
