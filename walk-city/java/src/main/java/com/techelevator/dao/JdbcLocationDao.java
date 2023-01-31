package com.techelevator.dao;

import com.techelevator.model.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcLocationDao implements LocationDao
{
    private JdbcTemplate jdbcTemplate;

    public JdbcLocationDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Location> findAll()
    {
        List<Location> locationList = new ArrayList<>();
        String sql = "select * from locations";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Location location = mapRowToLocation(results);
        }


        return locationList;
    }

    @Override
    public Location getLocationById(Long locationID)
    {
        return null;
    }

    @Override
    public Location findByName(String locationName)
    {
        return null;
    }

    public Location mapRowToLocation(SqlRowSet rs) {
        Location location = new Location();
        location.setLocationId(rs.getLong("location_id"));
        location.setLocationName(rs.getString("location_name"));
        location.setCategory(rs.getString("category"));
        location.setLatitude(rs.getDouble("latitude"));
        location.setLongitude(rs.getDouble("longitude"));
        location.setAddress(rs.getString("address"));
        location.setDescription(rs.getString("description"));
        location.setAvailability(rs.getString("availability"));
        location.setImage(rs.getString("image"));
        location.setSocialMedia(rs.getString("social_media"));
        return location;
    }
}
