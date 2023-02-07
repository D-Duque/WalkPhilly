package com.techelevator.dao;

import com.techelevator.model.UserCheckInCategory;

import java.util.List;

public interface UserCheckInCategoryDao {
    List<UserCheckInCategory> listAll(int userId);
}
