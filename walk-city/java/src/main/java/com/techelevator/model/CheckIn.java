package com.techelevator.model;

public class CheckIn
{
    private int checkingId;
    private int userId;
    private int locationId;

    public CheckIn(){
    }

    public CheckIn(int checkingId, int userId, int locationId)
    {
        this.checkingId = checkingId;
        this.userId = userId;
        this.locationId = locationId;
    }

    public int getCheckingId()
    {
        return checkingId;
    }

    public int getUserId()
    {
        return userId;
    }

    public int getLocationId()
    {
        return locationId;
    }

    public void setCheckingId(int checkingId)
    {
        this.checkingId = checkingId;
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
