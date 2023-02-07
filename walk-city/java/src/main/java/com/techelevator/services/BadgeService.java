package com.techelevator.services;

import com.techelevator.controller.BadgesController;
import com.techelevator.controller.CheckInController;
import com.techelevator.dao.CheckInDao;
import com.techelevator.dao.UserBadgeDao;
import com.techelevator.dao.UserCheckInCategoryDao;
import com.techelevator.model.CheckIn;
import com.techelevator.model.User;
import com.techelevator.model.UserBadge;
import com.techelevator.model.UserCheckInCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BadgeService {

    private UserBadgeDao userBadgeDao;
    private CheckInDao checkInDao;
    private UserCheckInCategoryDao userCheckInCategoryDao;

    public BadgeService(UserBadgeDao userBadgeDao, CheckInDao checkInDao, UserCheckInCategoryDao userCheckInCategoryDao) {
        this.userBadgeDao = userBadgeDao;
        this.checkInDao = checkInDao;
        this.userCheckInCategoryDao = userCheckInCategoryDao;
    }

    public boolean checkForNewBadge(int userId){
        List<CheckIn> checkInList = checkInDao.findAllCheckInsByUserId(userId);
        List<UserCheckInCategory> userCheckInCategoryList = userCheckInCategoryDao.listAll(userId);
        //methods for checking each badge
        checkForParkBadge(userId, userCheckInCategoryList);
        checkForRestaurantBadge(userId, userCheckInCategoryList);
        checkForBarBadge(userId, userCheckInCategoryList);
        checkForMuseumBadge(userId, userCheckInCategoryList);
        checkForAllBadge(userId, checkInList);
        //if any return true, then return true
       return true;
    }

    private boolean checkForParkBadge(int userId, List<UserCheckInCategory> userCheckInCategoryList){
        var parkList = userCheckInCategoryList.stream()
                                .filter(checkIn -> checkIn.getCategory().equals("Park"))
                                .collect(Collectors.toList());
        if (parkList.size() == 5){
            UserBadge userBadge = new UserBadge();
            userBadge.setUserId(userId);
            userBadge.setBadgeId(4);
            userBadgeDao.create(userBadge);
            return true;
        }
        return false;
    }

    private boolean checkForRestaurantBadge(int userId, List<UserCheckInCategory> userCheckInCategoryList){
        var restaurantList = userCheckInCategoryList.stream()
                .filter(checkIn -> checkIn.getCategory().equals("Restaurant"))
                .collect(Collectors.toList());
        if (restaurantList.size() == 5){
            UserBadge userBadge = new UserBadge();
            userBadge.setUserId(userId);
            userBadge.setBadgeId(4);
            userBadgeDao.create(userBadge);
            return true;
        }
        return false;
    }

    private boolean checkForBarBadge(int userId, List<UserCheckInCategory> userCheckInCategoryList){
        var barList = userCheckInCategoryList.stream()
                .filter(checkIn -> checkIn.getCategory().equals("Bar"))
                .collect(Collectors.toList());
        if (barList.size() == 5){
            UserBadge userBadge = new UserBadge();
            userBadge.setUserId(userId);
            userBadge.setBadgeId(4);
            userBadgeDao.create(userBadge);
            return true;
        }
        return false;
    }

    private boolean checkForMuseumBadge(int userId, List<UserCheckInCategory> userCheckInCategoryList){
        var museumList = userCheckInCategoryList.stream()
                .filter(checkIn -> checkIn.getCategory().equals("Museum"))
                .collect(Collectors.toList());
        if (museumList.size() == 5){
            UserBadge userBadge = new UserBadge();
            userBadge.setUserId(userId);
            userBadge.setBadgeId(4);
            userBadgeDao.create(userBadge);
            return true;
        }
        return false;
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
