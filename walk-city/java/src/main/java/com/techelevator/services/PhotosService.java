package com.techelevator.services;

import com.techelevator.model.PlacesSearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class PhotosService {
    private static final String API_URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference={photoReference}&key={apiKey}";
    private RestTemplate restTemplate = new RestTemplate();

    public String getImageURL(String photoReference, String apiKey) {
        String imageURL = restTemplate.getForObject(API_URL, String.class, photoReference, apiKey);
        return imageURL;


    }
}
