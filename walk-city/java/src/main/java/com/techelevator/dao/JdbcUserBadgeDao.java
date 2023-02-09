package com.techelevator.dao;

import com.techelevator.model.UserBadge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcUserBadgeDao implements UserBadgeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserBadgeDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<UserBadge> listAll(){
        List<UserBadge> userBadgeList = new ArrayList<>();
        String sql = "SELECT * from user_badge";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            UserBadge userBadge = mapRowToUserBadge(results);
            userBadgeList.add(userBadge);
        }
        return userBadgeList;
    }

    @Override
    public List<UserBadge> getUserBadgesByUser(int userId){
        List<UserBadge> userBadgeList = new ArrayList<>();
        String sql = "SELECT * FROM user_badge WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()){
            UserBadge userBadge = mapRowToUserBadge(results);
            userBadgeList.add(userBadge);
        }

        return userBadgeList;

    }

    @Override
    public List<UserBadge> getUserBadgesByBadge(int badgeId){
        List<UserBadge> userBadgeList = new ArrayList<>();
        String sql = "SELECT * FROM user_badge WHERE badge_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, badgeId);

        while(results.next()){
            UserBadge userBadge = mapRowToUserBadge(results);
            userBadgeList.add(userBadge);
        }

        return userBadgeList;
    }

    @Override
    public void create(UserBadge userBadge){
        int userId = userBadge.getUserId();
        int badgeId = userBadge.getBadgeId();
        LocalDateTime earnedTime = userBadge.getEarnedTime();

        String sql = "INSERT into user_badge (user_id, badge_id, earned_time) "
                + "VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, userId, badgeId, earnedTime);
    }

    public UserBadge mapRowToUserBadge(SqlRowSet rs){
        UserBadge userBadge =  new UserBadge();
        userBadge.setUserId(rs.getInt("user_id"));
        userBadge.setBadgeId(rs.getInt("badge_id"));
        userBadge.setEarnedTime(Objects.requireNonNull(rs.getTimestamp("earned_time")).toLocalDateTime());
        return userBadge;
    }



}
