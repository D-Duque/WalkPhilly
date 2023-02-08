package com.techelevator.dao;

import com.techelevator.model.CheckIn;

import java.util.List;

public interface CheckInDao
{

    List<CheckIn> findAll();

    CheckIn getCheckInById(int checkingId);

    List<CheckIn> findCheckInByUserAndLocation(int userId, int locationId);

    Integer create(CheckIn checkIn);

    List<CheckIn> findAllCheckInsByUserId (int userID);


}
