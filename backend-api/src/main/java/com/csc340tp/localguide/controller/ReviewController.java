package com.csc340tp.localguide.controller;
import com.csc340tp.localguide.entity.Review;
import com.csc340tp.localguide.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // POST a new Review for a subscribed service
    @PostMapping
    public ResponseEntity<Review> writeReview(@RequestBody Map<String, Object> body) {
        Long touristId = Long.valueOf(body.get("touristId").toString());
        Long guideId = Long.valueOf(body.get("guideId").toString());
        Integer rating = Integer.valueOf(body.get("rating").toString());
        String text = body.get("text").toString();
        return ResponseEntity.ok(reviewService.writeReview(touristId, guideId, rating, text));
    }

    // GET reviews by tourist
    @GetMapping("/tourist/{touristId}")
    public List<Review> getReviewsByTourist(@PathVariable Long touristId) {
        return reviewService.getReviewsByTourist(touristId);
    }

    // GET reviews by guide
    @GetMapping("/guide/{guideId}")
    public List<Review> getReviewsByGuide(@PathVariable Long guideId) {
        return reviewService.getReviewsByGuide(guideId);
    }

    // GET single review
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT an existing Review
    @PutMapping("/{id}")
    public ResponseEntity<Review> editReview(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        Integer rating = Integer.valueOf(body.get("rating").toString());
        String text = body.get("text").toString();
        return ResponseEntity.ok(reviewService.editReview(id, rating, text));
    }

    // DELETE a Review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
