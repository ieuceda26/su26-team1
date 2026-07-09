package com.csc340tp.localguide.service;

import com.csc340tp.localguide.entity.Tour;
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

    // book()
    public Tour book(Long touristId, Tourlisting tourlisting, String name, String text, String location) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("Tourist not found: " + touristId));
        Tourlisting listing = tourlistingRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Tour listing not found: " + serviceId));
        Tour tour = new Tour(name, text, location, tourist, listing);
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

    public List<Tour> getToursByTourist(Long touristId) {
        return tourRepository.findByTouristTouristId(touristId);
    }

    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }
}


