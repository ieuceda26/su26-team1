package com.csc340tp.localguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340tp.localguide.entity.TourListings;

public interface TourListingRepository extends JpaRepository<TourListings, Long> {
    List<TourListings> findByGuideId(long guideId);
    
}
