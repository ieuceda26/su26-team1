package com.csc340tp.localguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340tp.localguide.entity.TourListings;

public interface TourListingRepository extends JpaRepository<TourListings, Long> {
    // No custom queries here yet!
    
}
