package com.csc340tp.localguide.service;

import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    // register()
    public Tourist register(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    // login() - find by email and password
    public Optional<Tourist> login(String email, String password) {
        return touristRepository.findAll().stream()
                .filter(t -> t.getEmail().equals(email) && t.getPassword().equals(password))
                .findFirst();
    }

    // updateProfile()
    public Tourist updateProfile(Long id, Tourist updated) {
        Tourist existing = touristRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tourist not found: " + id));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPassword(updated.getPassword());
        return touristRepository.save(existing);
    }

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public Optional<Tourist> getTouristById(Long id) {
        return touristRepository.findById(id);
    }
}

