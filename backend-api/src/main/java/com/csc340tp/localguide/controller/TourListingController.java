package com.csc340tp.localguide.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340tp.localguide.entity.TourListings;
import com.csc340tp.localguide.service.TourListingService;

@RestController
@RequestMapping("/api/tour-listings")
public class TourListingController {
    private final TourListingService tourListingService;

    public TourListingController(TourListingService tourListingService) {
        this.tourListingService = tourListingService;
    }

    @GetMapping
    public ResponseEntity<List<TourListings>> getAllListings() {
        List<TourListings> listings = tourListingService.getAllListings();
        if (listings.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourListings> getListingById(@PathVariable long id) {
        TourListings listing = tourListingService.getListingbyId(id);
        if (listing != null) {
            return ResponseEntity.ok(listing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TourListings> createListing(@RequestBody TourListings listing) {
        TourListings createdListing = tourListingService.createListing(listing);
        return ResponseEntity.ok(createdListing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourListings> updateListing(@PathVariable long id, @RequestBody TourListings updatedListing) {
        TourListings listing = tourListingService.updateListings(id, updatedListing);
        if (listing != null) {
            return ResponseEntity.ok(listing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable long id) {
        boolean deleted = tourListingService.deleteListing(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
