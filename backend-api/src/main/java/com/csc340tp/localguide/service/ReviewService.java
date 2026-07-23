package com.csc340tp.localguide.service;
import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.entity.Review;
import com.csc340tp.localguide.entity.TourListings;
import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.repository.ReviewRepository;
import com.csc340tp.localguide.repository.TourListingRepository;
import com.csc340tp.localguide.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

private final ReviewRepository reviewRepository;
private final TouristRepository touristRepository;
private final TourListingRepository tListingRepository;

public ReviewService(ReviewRepository reviewRepository, TouristRepository touristRepository, TourListingRepository tListingRepository) {
    this.reviewRepository = reviewRepository;
    this.touristRepository = touristRepository; 
    this.tListingRepository= tListingRepository;
}

    // writeRev()
    public Review writeReview(Long touristId, Long listingId, Integer rating, String text) {
        Tourist tourist = touristRepository.findById(touristId)
         .orElseThrow(() -> new RuntimeException("Listing not found: " + listingId));
        TourListings listing = tListingRepository.findById(listingId)
            .orElseThrow(() -> new RuntimeException("Listing not found: " + listingId));
        Guide guide = listing.getGuide();
        Review review = new Review(rating, text, tourist, guide, null, listing);
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

    //Pedro - for the reply text to work
    public Review updateReview(Long reviewId, Review review) {
    Review existingReview = reviewRepository.findById(reviewId).orElse(null);
    if (existingReview != null) {

        if (review.getRating() != null) {
            existingReview.setRating(review.getRating());
        }

        if (review.getText() != null) {
            existingReview.setText(review.getText());
        }

        if (review.getReplyText() != null) {
            existingReview.setReplyText(review.getReplyText());
        }

        return reviewRepository.save(existingReview);
    }
    return null;
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

    public void deleteReviewsByListingId(Long listingId) {
        reviewRepository.deleteByListing_Id(listingId);
    }

}

