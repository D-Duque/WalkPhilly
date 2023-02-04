package com.techelevator.model;

public class PlacesSearchResponse {
    private Candidate[] candidates;
    private String status;


    public Candidate[] getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidate[] candidates) {
        this.candidates = candidates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
