package com.techelevator.controller;

import com.techelevator.dao.UserBadgeDao;
import com.techelevator.model.UserBadge;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping

public class BadgesController {

    private UserBadgeDao userBadgeDao;

    public BadgesController(UserBadgeDao userBadgeDao) {this.userBadgeDao = userBadgeDao;}

    @GetMapping("/badges/user/{userId}")
    public List<UserBadge> getBadgesById(@PathVariable int userId){
        List<UserBadge> userBadges = userBadgeDao.getUserBadgesByUser(userId);
        return userBadges;
    }

    @GetMapping("/badges/badge/{badgeId}")
    public List<UserBadge> getBadgesByBadge(@PathVariable int badgeId){
        List<UserBadge> userBadges = userBadgeDao.getUserBadgesByBadge(badgeId);
        return userBadges;
    }

    @PostMapping("/badges/add")
    public void addBadge(@Valid @RequestBody UserBadge userBadge){
        userBadgeDao.create(userBadge);
    }
}
