package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public interface CheckInDao
{

    List<CheckIn> findAll();

    CheckIn getCheckInById(int checkingId);

    List<CheckIn> findCheckInByUserAndLocation(int userId, int locationId);

    CheckIn create(CheckIn checkIn);

    List<CheckIn> findAllCheckInsByUserId (int userID);

}
