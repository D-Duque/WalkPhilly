package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public CheckIn create(CheckIn checkIn) {
        checkIn.setCheckInId(getMaxIdPlusOne());
        checkIns.add(checkIn);
        return checkIn;
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
        return checkIn;
    }


    /**
     * finds the max id in the list of checkIns and returns it
     *
     * @return int the max id
     */
    private int getMaxId() {
        int maxId = 0;
        for (CheckIn checkIn : checkIns) {
            if (checkIn.getCheckInId() > maxId) {
                maxId = checkIn.getCheckInId();
            }
        }
        return maxId;
    }


    /**
     * Adds 1 to the max id and returns it
     *
     * @return int maxId + 1
     */
    private int getMaxIdPlusOne() {
        return getMaxId() + 1;
    }

}
