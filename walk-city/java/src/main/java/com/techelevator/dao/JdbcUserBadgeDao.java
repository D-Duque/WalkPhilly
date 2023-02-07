package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import com.techelevator.model.User;
import com.techelevator.model.UserBadge;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserBadgeDao implements UserBadgeDao{
    private JdbcTemplate jdbcTemplate;

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
    public List<UserBadge> getUserBadgeByBadge(int badgeId){
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

        String sql = "INSERT into user_badge (user_id, badge_id) "
                + "VALUES (?, ?) ";

        jdbcTemplate.update(sql);
    }

    public UserBadge mapRowToUserBadge(SqlRowSet rs){
        UserBadge userBadge =  new UserBadge();
        userBadge.setUserId(rs.getInt("user_id"));
        userBadge.setBadgeId(rs.getInt("badge_id"));
        return userBadge;
    }



}
