package com.techelevator.controller;

import com.techelevator.dao.BadgeDao;
import com.techelevator.dao.UserBadgeDao;
import com.techelevator.model.Badge;
import com.techelevator.model.UserBadge;
import com.techelevator.model.UserCheckInCategory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping

public class BadgesController {

    private UserBadgeDao userBadgeDao;
    private BadgeDao badgeDao;

    public BadgesController(UserBadgeDao userBadgeDao, BadgeDao badgeDao) {
        this.userBadgeDao = userBadgeDao;
        this.badgeDao = badgeDao;
    }

    @GetMapping("/badges/user/{userId}")
    public List<UserBadge> getBadgesByUser(@PathVariable int userId){
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

    @GetMapping("/badges/all")
    public List<Badge> listAllBadges(){
        return badgeDao.listAll();
    }
}
