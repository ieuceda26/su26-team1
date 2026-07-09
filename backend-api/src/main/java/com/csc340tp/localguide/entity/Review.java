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

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    public Review() {}

    public Review(Integer rating, String text, Tourist tourist, Guide guide) {
        this.rating = rating;
        this.text = text;
        this.tourist = tourist;
        this.guide = guide;
    }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Tourist getTourist() { return tourist; }
    public void setTourist(Tourist tourist) { this.tourist = tourist; }

    public Guide getGuide() { return guide; }
    public void setGuide(Guide guide) { this.guide = guide; }
}