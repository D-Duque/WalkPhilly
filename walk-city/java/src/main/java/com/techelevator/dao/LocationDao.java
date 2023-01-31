package com.techelevator.dao;

import com.techelevator.model.Location;

import java.util.List;

public interface LocationDao
{
    List<Location> findAll();

    Location getLocationById(Long locationID);

    Location findByName(String locationName);


}
