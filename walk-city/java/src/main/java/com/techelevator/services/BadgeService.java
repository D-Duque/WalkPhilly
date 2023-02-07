package com.techelevator.services;

import com.techelevator.controller.BadgesController;
import com.techelevator.controller.CheckInController;
import com.techelevator.dao.CheckInDao;
import com.techelevator.dao.UserBadgeDao;
import com.techelevator.model.CheckIn;
import com.techelevator.model.User;
import com.techelevator.model.UserBadge;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BadgeService {

    private UserBadgeDao userBadgeDao;
    private CheckInDao checkInDao;

    public BadgeService(UserBadgeDao userBadgeDao, CheckInDao checkInDao) {
        this.userBadgeDao = userBadgeDao;
        this.checkInDao = checkInDao;
    }

    public boolean checkForNewBadge(int userId){
        List<CheckIn> checkInList = checkInDao.findAllCheckInsByUserId(userId);
        //methods for checking each badge
        checkForParkBadge(userId, checkInList);
        checkForRestaurantBadge(userId, checkInList);
        checkForBarBadge(userId, checkInList);
        checkForMuseumBadge(userId, checkInList);
        checkForAllBadge(userId, checkInList);
        //if any return true, then return true
       return true;
    }

    private boolean checkForParkBadge(int userId, List<CheckIn> checkInList){
        
        return true;
    }

    private boolean checkForRestaurantBadge(int userId, List<CheckIn> checkInList){
        return true;
    }

    private boolean checkForBarBadge(int userId, List<CheckIn> checkInList){
        return true;
    }

    private boolean checkForMuseumBadge(int userId, List<CheckIn> checkInList){
        return true;
    }

    private boolean checkForAllBadge(int userId, List<CheckIn> checkInList){

        if (checkInList.size() == 40){
            UserBadge userBadge = new UserBadge();
            userBadge.setUserId(userId);
            userBadge.setBadgeId(1);
            userBadgeDao.create(userBadge);
            return true;
        }
        return false;
    }
}
