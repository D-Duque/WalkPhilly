package com.techelevator.services;

import com.techelevator.model.PlacesSearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@Component
public class PhotosService {
    private static final String API_URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference={photoReference}&key={apiKey}";
    private RestTemplate restTemplate = new RestTemplate();

    public byte[] getImage(String photoReference, String apiKey) {
        byte[] image = restTemplate.getForObject(API_URL, byte[].class, photoReference, apiKey);
        return image;
    }
}
