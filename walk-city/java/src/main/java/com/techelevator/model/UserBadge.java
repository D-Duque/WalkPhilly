package com.techelevator.model;

import java.time.LocalDateTime;

public class UserBadge {
    private int userId;
    private int badgeId;
    private LocalDateTime earnedTime;

    public UserBadge() {this.earnedTime = LocalDateTime.now();}


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public LocalDateTime getEarnedTime() {
        return earnedTime;
    }

    public void setEarnedTime(LocalDateTime earnedTime) {
        this.earnedTime = earnedTime;
    }
}
