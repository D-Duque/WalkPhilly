package com.techelevator.dao;

import com.techelevator.model.Badge;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBadgeDao implements BadgeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBadgeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Badge> listAll(){
        List<Badge> badgeList = new ArrayList<>();
        String sql = "SELECT * from badges";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Badge badge = mapRowToBadge(results);
            badgeList.add(badge);
        }
        return badgeList;
    }

    public Badge mapRowToBadge(SqlRowSet rs){
        Badge badge = new Badge();
        badge.setBadgeId(rs.getInt("badge_id"));
        badge.setBadgeName(rs.getString("badge_name"));
        badge.setDescription(rs.getString("description"));
        badge.setBadgeImage(rs.getString("badge_image"));
        return badge;
    }
}
