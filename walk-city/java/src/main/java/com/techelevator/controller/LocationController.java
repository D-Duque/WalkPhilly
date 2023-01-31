package com.techelevator.controller;

import com.techelevator.dao.LocationDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LocationController
{
    private LocationDao locationDao;
}
