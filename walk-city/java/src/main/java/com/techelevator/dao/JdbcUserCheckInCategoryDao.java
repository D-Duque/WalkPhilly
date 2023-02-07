package com.techelevator.dao;

import com.techelevator.model.UserCheckInCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserCheckInCategoryDao implements UserCheckInCategoryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserCheckInCategoryDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserCheckInCategory> listAll(int userId){
        List<UserCheckInCategory> userCheckInCategoryList = new ArrayList<>();
        String sql = "SELECT check_in_id, check_in.location_id, locations.category FROM check_in " +
                "JOIN locations ON locations.location_id = check_in.location_id " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            UserCheckInCategory userCheckInCategory = mapRowToUserCheckInCategory(results);
            userCheckInCategoryList.add(userCheckInCategory);
        }
                return userCheckInCategoryList;
    }

    public UserCheckInCategory mapRowToUserCheckInCategory (SqlRowSet rs){
        UserCheckInCategory userCheckInCategory = new UserCheckInCategory();
        userCheckInCategory.setCheckInId(rs.getInt("check_in_id"));
        userCheckInCategory.setLocationId(rs.getInt("location_id"));
        userCheckInCategory.setCategory(rs.getString("category"));
        return userCheckInCategory;
    }


}
