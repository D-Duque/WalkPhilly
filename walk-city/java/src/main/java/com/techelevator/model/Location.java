package com.techelevator.model;

public class Location
{
    private Long locationId;
    private String locationName;
    private String category;
    private double latitude;
    private double longitude;
    private String address;
    private String description;
    private String availability;
    private String image;
    private String socialMedia;

    public Location()
    {
    }

    public Location(Long locationId, String locationName, String category, double latitude, double longitude, String address, String description, String availability, String image, String socialMedia)
    {
        this.locationId = locationId;
        this.locationName = locationName;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.description = description;
        this.availability = availability;
        this.image = image;
        this.socialMedia = socialMedia;
    }

    public Long getLocationId()
    {
        return locationId;
    }

    public void setLocationId(Long locationId)
    {
        this.locationId = locationId;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAvailability()
    {
        return availability;
    }

    public void setAvailability(String availability)
    {
        this.availability = availability;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getSocialMedia()
    {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia)
    {
        this.socialMedia = socialMedia;
    }
}


