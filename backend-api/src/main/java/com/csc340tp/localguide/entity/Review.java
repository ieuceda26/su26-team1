package com.csc340tp.localguide.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Integer rating;
    private String text;

    // Foreign key: tourist who wrote the review
    @ManyToOne
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    // Foreign key: guide being reviewed (by guide_id)
    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guideId;

    public Review() {}

    public Review(Integer rating, String text, Tourist tourist, Guide guideId) {
        this.rating = rating;
        this.text = text;
        this.tourist = tourist;
        this.guideId = guideId;
    }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Tourist getTourist() { return tourist; }
    public void setTourist(Tourist tourist) { this.tourist = tourist; }

    public Guide getGuideId() { return guideId; }
    public void setGuideId(Guide guideId) { this.guideId = guideId; }
}
