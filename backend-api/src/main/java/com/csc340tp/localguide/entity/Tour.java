package com.csc340tp.localguide.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;

    private String name;
    private String text;
    private String location;
    private String status;

    @ManyToOne
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private TourListings tourListings;

    public Tour() {
    }

    public Tour(String name, String text, String location, Tourist tourist, TourListings tourListings) {
        this.name = name;
        this.text = text;
        this.location = location;
        this.tourist = tourist;
        this.tourListings = tourListings;
        this.status = "Upcoming"; // when tour is booked, status is set to "Upcoming"
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public TourListings getTourListings() {
        return tourListings;
    }

    public void setTourListings(TourListings tourListings) {
        this.tourListings = tourListings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}