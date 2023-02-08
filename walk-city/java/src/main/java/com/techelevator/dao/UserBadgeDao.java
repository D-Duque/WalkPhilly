package com.techelevator.dao;

import com.techelevator.model.CheckIn;
import com.techelevator.model.User;
import com.techelevator.model.UserBadge;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserBadgeDao {

    List<UserBadge> listAll();

    List<UserBadge> getUserBadgesByUser(int userId);

    List<UserBadge> getUserBadgesByBadge(int badgeId);

    void create(UserBadge userBadge);


}
