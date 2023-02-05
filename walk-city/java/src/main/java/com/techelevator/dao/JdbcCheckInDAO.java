package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
<<<<<<< HEAD
class JdbcCheckInDao implements CheckInDao
{
    private JdbcTemplate jdbcTemplate;
=======
public class JdbcCheckInDao implements CheckInDao
{
        private JdbcTemplate jdbcTemplate;

        private List<CheckIn> checkIns = new ArrayList<>();
>>>>>>> da3d32fa9d372c7db07f3d7f08f991610a5cc848

    private List<CheckIn> checkIns = new ArrayList<>();

    public JdbcCheckInDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<CheckIn> findAll()
    {
        List<CheckIn> checkInList = new ArrayList<>();
        String sql = "SELECT * FROM checking";

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
        String sql = "SELECT * FROM checking WHERE checking_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, checkingID);

        if(results.next())
        {
            return mapRowToCheckIn(results);
        }
        else {
            throw new RuntimeException("CheckingId " + checkingID + " was not found");
        }

<<<<<<< HEAD
    }
=======
        @Override
        public List<CheckIn> findCheckInByUserAndLocation(int userId, int locationId){
            List<CheckIn> checkInList = new ArrayList<>();
>>>>>>> da3d32fa9d372c7db07f3d7f08f991610a5cc848

    @Override
    public List<CheckIn> findCheckInByUserAndLocation(int UserId, int LocationId){
        List<CheckIn> checkInList = new ArrayList<>();

<<<<<<< HEAD
        String sql = "SELECT * FROM locations WHERE user_id = ? AND location_id = ?";
=======
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, locationId);
>>>>>>> da3d32fa9d372c7db07f3d7f08f991610a5cc848

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, UserId,LocationId);

        while (results.next())
        {
            CheckIn checkIn = mapRowToCheckIn(results);
            checkInList.add(checkIn);
        }
        return checkInList;
    }

<<<<<<< HEAD
    @Override
    public CheckIn create(CheckIn checkIn) {
        checkIn.setCheckingId(getMaxIdPlusOne());
        checkIns.add(checkIn);
        return checkIn;
    }

    public CheckIn mapRowToCheckIn(SqlRowSet rs) {
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckingId(rs.getInt("checking_id"));
        checkIn.setUserId(rs.getInt("user_id"));
        checkIn.setLocationId(rs.getInt("location_id"));
        return checkIn;
    }
=======
        @Override
        public List<CheckIn> findAllCheckInsByUserId(int userID) {
            List<CheckIn> checkInList = new ArrayList<>();

            String sql = "SELECT * FROM checking WHERE user_id = ?";

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
            checkIn.setCheckingId(rs.getInt("checking_id"));
            checkIn.setUserId(rs.getInt("user_id"));
            checkIn.setLocationId(rs.getInt("location_id"));
            return checkIn;
        }
>>>>>>> da3d32fa9d372c7db07f3d7f08f991610a5cc848

    /**
     * finds the max id in the list of checkIns and returns it
     *
     * @return int the max id
     */
    private int getMaxId() {
        int maxId = 0;
        for (CheckIn checkIn : checkIns) {
            if (checkIn.getCheckingId() > maxId) {
                maxId = checkIn.getCheckingId();
            }
        }
        return maxId;
    }

<<<<<<< HEAD
    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxId() + 1;
    }
=======
        /**
         * Adds 1 to the max id and returns it
         *
         * @return
         */
        private int getMaxIdPlusOne() {
            return getMaxId() + 1;
        }
>>>>>>> da3d32fa9d372c7db07f3d7f08f991610a5cc848
}
