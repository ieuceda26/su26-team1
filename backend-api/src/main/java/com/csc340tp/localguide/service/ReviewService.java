package com.csc340tp.localguide.service;

import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.entity.Review;
import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.repository.GuideRepository;
import com.csc340tp.localguide.repository.ReviewRepository;
import com.csc340tp.localguide.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private GuideRepository guideRepository;

    // writeRev()
    public Review writeReview(Long touristId, Long guideId, Integer rating, String text) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("Tourist not found: " + touristId));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide not found: " + guideId));
        Review review = new Review(rating, text, tourist, guide);
        return reviewRepository.save(review);
    }

    // editRev()
    public Review editReview(Long reviewId, Integer rating, String text) {
        Review existing = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found: " + reviewId));
        existing.setRating(rating);
        existing.setText(text);
        return reviewRepository.save(existing);
    }

    // delRev()
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public List<Review> getReviewsByTourist(Long touristId) {
        return reviewRepository.findByTouristTouristId(touristId);
    }

    public List<Review> getReviewsByGuide(Long guideId) {
        return reviewRepository.findByGuideGuideId(guideId);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
}

