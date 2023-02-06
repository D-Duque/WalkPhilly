package com.techelevator.controller;

import com.techelevator.dao.CheckInDao;
import com.techelevator.model.CheckIn;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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
    public void add(@Valid @RequestBody CheckIn checkIn) {
        checkInDao.create(checkIn);
    }

    @GetMapping("/checkins/user/{userId}")
    public List<CheckIn> getCheckInsByUserId(@PathVariable int userId) {
        List<CheckIn> checkIns = checkInDao.findAllCheckInsByUserId(userId);
        return checkIns;
    }
}
