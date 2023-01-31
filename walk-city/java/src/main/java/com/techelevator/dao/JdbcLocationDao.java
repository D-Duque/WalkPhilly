package com.techelevator.dao;

import com.techelevator.model.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
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
        String sql = "SELECT * FROM locations";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Location location = mapRowToLocation(results);
            locationList.add(location);
        }

        return locationList;
    }

    @Override
    public Location getLocationById(Long locationID)
    {
        String sql = "SELECT * FROM locations" +
                     "WHERE location_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationID);

        if(results.next())
        {
            return mapRowToLocation(results);
        }
        else {
            throw new RuntimeException("locationId " + locationID + " was not found");
        }

    }

    @Override
    public Location findByName(String locationName)
    {
        String sql = "SELECT * FROM locations WHERE location_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationName);

        if (results.next())
        {
            return mapRowToLocation(results);
        }
       else {
            throw new RuntimeException("locationName " + locationName + " was not found");
        }
    }

    public Location mapRowToLocation(SqlRowSet rs) {
        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
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
