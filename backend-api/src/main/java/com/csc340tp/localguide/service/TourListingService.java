package com.csc340tp.localguide.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.csc340tp.localguide.repository.TourListingRepository;
import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.entity.TourListings;

@Service
public class TourListingService {
    private final TourListingRepository tListingRepository;
    private final GuideService guideService;

    public TourListingService(TourListingRepository tListingRepository, GuideService guideService){
        this.tListingRepository = tListingRepository;
        this.guideService = guideService;
    }

    public List<TourListings> getAllListings(){
        return tListingRepository.findAll();
    }

    public TourListings getListingbyId(long id){
        return tListingRepository.findById(id).orElse(null);
    }

    public TourListings createListing(TourListings list, long guideId){
        Guide guide = guideService.getGuideById(guideId);
        list.setGuide(guide);
        return tListingRepository.save(list);
    }

    public TourListings updateListings(long id, TourListings list){
        TourListings existingListing = tListingRepository.findById(id).orElse(null);
        if (existingListing != null){
            existingListing.setName(list.getName());
            existingListing.setLocation(list.getLocation());
            existingListing.setDescription(list.getDescription());
            existingListing.setPrice(list.getPrice());
            existingListing.setMaxparticipants(list.getMaxparticipants());
            existingListing.setImageUrl(list.getImageUrl());
            return tListingRepository.save(existingListing);
        }
        return null;
    }

    public boolean deleteListing(long id){
        if (tListingRepository.existsById(id)){
            tListingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TourListings> getListingsByGuideId(Long guideId) {
        return tListingRepository.findByGuideId(guideId);
    }
}
