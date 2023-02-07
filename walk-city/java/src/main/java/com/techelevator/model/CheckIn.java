package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckIn
{
    private int checkInId;
    private int userId;
    private int locationId;
    private LocalDateTime checkInTime;

    public CheckIn(){
        this.checkInTime = LocalDateTime.now();
    }

    public CheckIn(int checkInId, int userId, int locationId, LocalDateTime checkInTime)
    {
        this.checkInId = checkInId;
        this.userId = userId;
        this.locationId = locationId;
        this.checkInTime = checkInTime;
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
}
