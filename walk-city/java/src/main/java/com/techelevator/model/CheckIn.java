package com.techelevator.model;

import java.time.LocalDateTime;


public class CheckIn
{
    private int checkInId;
    private int userId;
    private int locationId;
    private LocalDateTime checkInTime;
    private boolean isCheckedIn;



    public CheckIn(){
        this.checkInTime = LocalDateTime.now();
    }

    public CheckIn(int checkInId, int userId, int locationId, LocalDateTime checkInTime, boolean isCheckedIn)
    {
        this.checkInId = checkInId;
        this.userId = userId;
        this.locationId = locationId;
        this.checkInTime = checkInTime;
        this.isCheckedIn = isCheckedIn;
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

    public LocalDateTime getCheckInTime()
    {
        return checkInTime;
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

    public void setCheckInTime(LocalDateTime checkInTime)
    {
        this.checkInTime = checkInTime;
        ;
    }
    public boolean isCheckedIn()
    {
        return isCheckedIn;
    }

    public void setIsCheckedIn(boolean isCheckedIn)
    {
        this.isCheckedIn = isCheckedIn;
    }
}
