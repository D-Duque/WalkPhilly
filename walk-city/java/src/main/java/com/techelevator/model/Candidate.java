package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Candidate {
    @JsonAlias("place_id")
    private String placeId;
    private Photo[] photos;

    public String getplaceId() {
        return placeId;
    }
    public Photo[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = photos;
    }
    public void setPlaceId(String placeId) {this.placeId  = placeId;}
}
