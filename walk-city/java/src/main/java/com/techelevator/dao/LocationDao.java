package com.techelevator.dao;

import com.techelevator.model.Location;

import java.util.List;

public interface LocationDao
{
    List<Location> findAll();

    Location getLocationById(int locationID);

    Location findByName(String locationName);

    List<Location> findByCategory(String category);
}
