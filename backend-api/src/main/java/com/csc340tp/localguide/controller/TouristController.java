package com.csc340tp.localguide.controller;

import com.csc340tp.localguide.service.TouristService;
import com.csc340tp.localguide.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tourists")
public class TouristController {

    @Autowired
    private TouristService touristService;

    // POST a new Tourist
    @PostMapping
    public ResponseEntity<Tourist> register(@RequestBody Tourist tourist) {
        return ResponseEntity.ok(touristService.register(tourist));
    }

    // POST with email + password
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        return touristService.login(credentials.get("email"), credentials.get("password"))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body("Invalid email or password"));
    }

    // GET all tourists
    @GetMapping
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }

    // GET tourist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable Long id) {
        return touristService.getTouristById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // updateProfile() - PUT an existing Tourist
    @PutMapping("/{id}")
    public ResponseEntity<Tourist> updateProfile(@PathVariable Long id, @RequestBody Tourist updated) {
        return ResponseEntity.ok(touristService.updateProfile(id, updated));
    }
}

