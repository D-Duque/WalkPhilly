package com.techelevator.services;

import com.techelevator.model.Candidate;
import com.techelevator.model.Photo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.PlacesSearchResponse;


@Component
public class PlacesService {

    private static final String API_URL = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?inputtype=textquery&fields=photo&input={address}&key={apiKey}";
    private RestTemplate restTemplate = new RestTemplate();

    public String getPhotoReference(String address, String apiKey) {
        PlacesSearchResponse searchResponse = restTemplate.getForObject(API_URL,PlacesSearchResponse.class, address, apiKey);
//        System.out.println(searchResponse);
        Candidate[] candidates = searchResponse.getCandidates();
        int candidatesLength = candidates.length;
        Candidate candidate = candidates[0];
        Photo photo = candidate.getPhotos()[0];
        return photo.getPhotoReference();
    }
}
