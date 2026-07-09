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

    @ManyToOne
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @JoinColumn(name = "tour_listing_id")
    private Long serviceId;

    public Tour() {}

    public Tour(String name, String text, String location, Tourist tourist, Long serviceId) {
        this.name = name;
        this.text = text;
        this.location = location;
        this.tourist = tourist;
        this.serviceId = serviceId;
    }

    public Long getTourId() { return tourId; }
    public void setTourId(Long tourId) { this.tourId = tourId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Tourist getTourist() { return tourist; }
    public void setTourist(Tourist tourist) { this.tourist = tourist; }

    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
}
