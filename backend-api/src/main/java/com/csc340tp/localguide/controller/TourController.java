package com.csc340tp.localguide.controller;

import com.csc340tp.localguide.entity.Tour;
import com.csc340tp.localguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    // POST a new booking
    @PostMapping
    public ResponseEntity<Tour> book(@RequestBody Map<String, Object> body) {
        Long touristId = Long.valueOf(body.get("touristId").toString());
        Long serviceId = Long.valueOf(body.get("serviceId").toString());
        String name = body.get("name").toString();
        String text = body.get("text").toString();
        String location = body.get("location").toString();
        return ResponseEntity.ok(tourService.book(touristId, serviceId, name, text, location));
    }

    // GET all bookings for a tourist
    @GetMapping("/tourist/{touristId}")
    public List<Tour> getToursByTourist(@PathVariable Long touristId) {
        return tourService.getToursByTourist(touristId);
    }

    // GET single tour
    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        return tourService.getTourById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // reschedule() - PUT to update a booking
    @PutMapping("/{id}")
    public ResponseEntity<Tour> reschedule(@PathVariable Long id, @RequestBody Tour updated) {
        return ResponseEntity.ok(tourService.reschedule(id, updated));
    }

    // cancel() - DELETE a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        tourService.cancel(id);
        return ResponseEntity.noContent().build();
    }
}

