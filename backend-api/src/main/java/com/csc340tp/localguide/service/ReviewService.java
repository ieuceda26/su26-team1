package com.csc340tp.localguide.service;
import com.csc340tp.localguide.entity.Review;
import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.repository.ReviewRepository;
import com.csc340tp.localguide.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

private final ReviewRepository reviewRepository;
private final TouristRepository touristRepository;

public ReviewService(ReviewRepository reviewRepository, TouristRepository touristRepository) {
    this.reviewRepository = reviewRepository;
    this.touristRepository = touristRepository; 
}

    // writeRev()
    public Review writeReview(Long touristId, Long listingId, Integer rating, String text) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("Tourist not found: " + touristId));

        Review review = new Review(rating, text, tourist, null);
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
        return reviewRepository.findByGuideId(guideId);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
}

