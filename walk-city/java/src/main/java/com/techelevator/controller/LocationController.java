package com.techelevator.controller;

import com.techelevator.dao.LocationDao;
import com.techelevator.model.Location;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class LocationController
{
    private LocationDao locationDao;

    public LocationController(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @GetMapping("")
    public List<Location> getLocations() {
        return locationDao.findAll();
    }

    @GetMapping("/{locationId}")
    public Location getLocationById(@PathVariable int locationId) {
        Location location = locationDao.getLocationById(locationId);
        return location;
    }

    @GetMapping("/category/{category}")
    public List<Location> getLocationByCategory(@PathVariable String category) {
        return locationDao.findByCategory(category);
    }

}
