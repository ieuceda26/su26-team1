package com.csc340tp.localguide.service;

import com.csc340tp.localguide.entity.Tour;
import com.csc340tp.localguide.entity.TourListings;
import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.repository.TourRepository;
import com.csc340tp.localguide.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private TourListingService tourListingService;

    // book()
    public Tour book(Long touristId, Long serviceId) {
        Tourist tourist = touristRepository.findById(touristId) 
                .orElseThrow(() -> new RuntimeException("Tourist not found: " + touristId)); 

        TourListings listings = tourListingService.getListingbyId(serviceId); // Retrieve the tour listing by its ID

        Tour tour = new Tour(listings.getName(), listings.getDescription(), listings.getLocation(), tourist, listings); // Create a new Tour object with the provided details
        return tourRepository.save(tour);
    }

    // reschedule()
    public Tour reschedule(Long tourId, Tour updated) {
        Tour existing = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found: " + tourId));
        existing.setName(updated.getName());
        existing.setText(updated.getText());
        existing.setLocation(updated.getLocation());
        return tourRepository.save(existing);
    }

    // cancel()
    public void cancel(Long tourId) {
        tourRepository.deleteById(tourId);
    }

    public Tour complete(Long tourId) {
        Tour existing = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found: " + tourId));
        existing.setStatus("Completed");
        return tourRepository.save(existing);
    }

    public List<Tour> getToursByTourist(Long touristId) {
        return tourRepository.findByTouristTouristId(touristId);
    }

    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public List<Tour> getUpcomingTours(Long touristId) {
        return tourRepository.findByTouristTouristIdAndStatus(touristId, "Upcoming");

    }

    public List<Tour> getPastTours(Long touristId) {
        return tourRepository.findByTouristTouristIdAndStatus(touristId, "Completed");
    }
}
