package com.techelevator.model;

public class CheckIn
{
    private int checkInId;
    private int userId;
    private int locationId;

    public CheckIn(){
    }

    public CheckIn(int checkInId, int userId, int locationId)
    {
        this.checkInId = checkInId;
        this.userId = userId;
        this.locationId = locationId;
    }

    public int getCheckInId()
    {
        return checkInId;
    }

    public int getUserId()
    {
        return userId;
    }

    public int getLocationId()
    {
        return locationId;
    }

    public void setCheckInId(int checkInId)
    {
        this.checkInId = checkInId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public void setLocationId(int locationId)
    {
        this.locationId = locationId;
    }
}
