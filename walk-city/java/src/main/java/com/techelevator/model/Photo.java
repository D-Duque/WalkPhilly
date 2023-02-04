package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Photo {
    private int height;
    @JsonAlias("html_attributions")
    private String[] htmlAttributions;
    @JsonAlias("photo_reference")
    private String photoReference;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[] getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(String[] htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}


