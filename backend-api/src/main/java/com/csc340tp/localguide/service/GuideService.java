package com.csc340tp.localguide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.repository.GuideRepository;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public Guide getGuideById(long id) {
        return guideRepository.findById(id).orElse(null);
    }

    public Guide createGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public Guide updateGuide(long id, Guide guide) {
        Guide existingGuide = guideRepository.findById(id).orElse(null);
        if (existingGuide != null) {
            existingGuide.setName(guide.getName());
            existingGuide.setEmail(guide.getEmail());
            existingGuide.setPassword(guide.getPassword());
            existingGuide.setKeyword(guide.getKeyword());
            return guideRepository.save(existingGuide);
        }
        return null;
    }

    public boolean deleteGuide(long id) {
        if (guideRepository.existsById(id)) {
            guideRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Login function to be implemented when we actually get to the login part of the project


    public List<Guide> searchGuides(String keyword) {
        return guideRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Guide> searchGuidesByKeyword(String keyword) {
        return guideRepository.findByKeywordContainingIgnoreCase(keyword);
    }

    public Guide findByEmail(String email) {
        return guideRepository.findByEmail(email);
    }
}
