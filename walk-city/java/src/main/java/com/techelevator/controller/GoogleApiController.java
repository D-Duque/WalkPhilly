package com.techelevator.controller;

import com.techelevator.model.PlacesSearchResponse;
import com.techelevator.services.PhotosService;
import com.techelevator.services.PlacesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/photos")
@CrossOrigin
public class GoogleApiController {
    private PhotosService photosService;
    private PlacesService placesService;

    private static final String API_KEY = "AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c";

    public GoogleApiController() {
        this.photosService = new PhotosService();
        this.placesService =  new PlacesService();
    }

    @RequestMapping(value="/{address}", method = RequestMethod.GET)
    public String getImage (@PathVariable String address){
        String photoReference = placesService.getPhotoReference(address, API_KEY);
        String imageURL = photosService.getImageURL(photoReference, API_KEY);
        System.out.println(imageURL);
        return imageURL;
    }
}
