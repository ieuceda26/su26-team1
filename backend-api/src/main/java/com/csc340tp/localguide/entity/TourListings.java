package com.csc340tp.localguide.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tour_listing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourListings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private String maxparticipants;
    
    @Column(length = 1000)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "guide_id", nullable = false)
    private Guide guide;

    //to delete related reviews and tours
    @OneToMany(mappedBy = "listing", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "tourListings", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Tour> tours;

    public TourListings(String name, String location, String description, double price, String maxparticipants, String imageUrl) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.price = price;
        this.maxparticipants = maxparticipants;
        this.imageUrl = imageUrl;
    }

}