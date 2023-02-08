package com.techelevator.model;

public class Badge {
    private int badgeId;
    private String badgeName;
    private String description;
    private String badgeImage;

    public Badge(int badgeId, String badgeName, String description, String badgeImage){
        this.badgeId = badgeId;
        this.badgeName = badgeName;
        this.description = description;
        this.badgeImage = badgeImage;
    }

    public Badge() {

    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBadgeImage() {
        return badgeImage;
    }

    public void setBadgeImage(String badgeImage) {
        this.badgeImage = badgeImage;
    }
}
