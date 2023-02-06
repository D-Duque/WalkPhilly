package com.techelevator.controller;

import com.techelevator.dao.CheckInDao;
import com.techelevator.model.CheckIn;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping

public class CheckInController
{
    private CheckInDao checkInDao;

    public CheckInController(CheckInDao checkInDao) {this.checkInDao = checkInDao;}

    @GetMapping("/checkins")
    public List<CheckIn> getCheckIns() {return checkInDao.findAll(); }

    @GetMapping("/checkins/{checkInId}")
    public CheckIn getCheckInById(@PathVariable int checkInId) {
        CheckIn checkIn = checkInDao.getCheckInById(checkInId);
        return checkIn;
    }

    @GetMapping("/checkins/{userId}/{locationId}")
    public List<CheckIn> getCheckInByUserIdAndLocationId(@PathVariable int userId, int locationId) {
        List<CheckIn> checkIns = checkInDao.findCheckInByUserAndLocation(userId, locationId);
        return checkIns;
    }

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public CheckIn add(@Valid @RequestBody CheckIn checkIn) {
        return checkInDao.create(checkIn);
    }

    @GetMapping("/checkins/{userId}")
    public List<CheckIn> getCheckInsByUserId(@PathVariable int userId) {
        List<CheckIn> checkIns = checkInDao.findAllCheckInsByUserId(userId);
        return checkIns;
    }
}
