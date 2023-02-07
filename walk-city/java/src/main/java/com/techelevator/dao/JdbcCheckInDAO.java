package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcCheckInDao implements CheckInDao
{
    private JdbcTemplate jdbcTemplate;

    private List<CheckIn> checkIns = new ArrayList<>();

    public JdbcCheckInDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<CheckIn> findAll()
    {
        List<CheckIn> checkInList = new ArrayList<>();
        String sql = "SELECT * FROM check_in";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            CheckIn checkIn = mapRowToCheckIn(results);
            checkInList.add(checkIn);
        }

        return checkInList;
    }

    @Override
    public CheckIn getCheckInById(int checkingID)
    {
        String sql = "SELECT * FROM check_in WHERE check_in_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, checkingID);

        if(results.next())
        {
            return mapRowToCheckIn(results);
        }
        else {
            throw new RuntimeException("CheckInId " + checkingID + " was not found");
        }


    }

    @Override
    public List<CheckIn> findCheckInByUserAndLocation(int UserId, int LocationId){
        List<CheckIn> checkInList = new ArrayList<>();

        String sql = "SELECT * FROM check_in WHERE user_id = ? AND location_id = ?";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, UserId,LocationId);

        while (results.next())
        {
            CheckIn checkIn = mapRowToCheckIn(results);
            checkInList.add(checkIn);
        }
        return checkInList;
    }

    @Override
    public Integer create(CheckIn checkIn) {

        int userId = checkIn.getUserId();
        int locationId = checkIn.getLocationId();
        LocalDateTime checkInTime = checkIn.getCheckInTime();

        String sql = "INSERT into check_in (user_id, location_id, check_in_time)"
                        + " VALUES (?, ?, ?)"
                        + " RETURNING check_in_id";

        Integer checkInId = jdbcTemplate.queryForObject(sql, Integer.class, userId, locationId, checkInTime);
        if (checkInId != null) {
            return checkInId;
        }
        return null;
    }

    @Override
    public List<CheckIn> findAllCheckInsByUserId(int userID) {
        List<CheckIn> checkInList = new ArrayList<>();

        String sql = "SELECT * FROM check_in WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);

        while (results.next())
        {
            CheckIn checkIn = mapRowToCheckIn(results);
            checkInList.add(checkIn);
        }
        return checkInList;
    }

    public CheckIn mapRowToCheckIn(SqlRowSet rs) {
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInId(rs.getInt("check_in_id"));
        checkIn.setUserId(rs.getInt("user_id"));
        checkIn.setLocationId(rs.getInt("location_id"));
        checkIn.setCheckInTime(Objects.requireNonNull(rs.getTimestamp("check_in_time")).toLocalDateTime());
        return checkIn;
    }

}
