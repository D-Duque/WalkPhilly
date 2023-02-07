package com.techelevator.controller;

import com.techelevator.dao.CheckInDao;
import com.techelevator.dao.UserCheckInCategoryDao;
import com.techelevator.model.CheckIn;
import com.techelevator.model.UserCheckInCategory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class CheckInController
{
    private CheckInDao checkInDao;
    private UserCheckInCategoryDao userCheckInCategoryDao;

    public CheckInController(CheckInDao checkInDao, UserCheckInCategoryDao userCheckInCategoryDao) {this.checkInDao = checkInDao;
    this.userCheckInCategoryDao = userCheckInCategoryDao;}

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

    @GetMapping("/checkins/category/user/{userId}")
    public List<UserCheckInCategory> getCategoryCheckInsByUserId(@PathVariable int userId){
        List<UserCheckInCategory> checkIns = userCheckInCategoryDao.listAll(userId);
        return checkIns;
    }
}
