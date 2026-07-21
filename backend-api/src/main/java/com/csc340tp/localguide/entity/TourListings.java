package com.csc340tp.localguide.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "guide_id", nullable = false)
    private Guide guide;

    public TourListings(String name, String location, String description, double price, String maxparticipants) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.price = price;
        this.maxparticipants = maxparticipants;
    }

}