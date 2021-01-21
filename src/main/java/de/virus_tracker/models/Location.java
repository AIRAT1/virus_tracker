package de.virus_tracker.models;

import lombok.Data;

@Data
public class Location {
    private String state;
    private String country;
    private int latestTotalCases;
    private int delta;
}
