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

    @ManyToOne
    @JoinColumn(name="tour_listing_id", nullable = false)
    private TourListings listing;

    // Foreign key: tourist who wrote the review
    @ManyToOne
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne
    @JoinColumn(name = "guide_id", nullable = true)
    private Guide guide;

    private String replyText;

    public Review() {}

    public Review(Integer rating, String text, Tourist tourist, Guide guide, String replyText, TourListings listing) {
        this.rating = rating;
        this.text = text;
        this.tourist = tourist;
        this.guide = guide;
        this.replyText = replyText;
        this.listing = listing;
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

    public TourListings getListing(){ return listing;}
    public void setListing (TourListings listing) {this.listing = listing;}

    public String getReplyText() {return replyText;}
    public void setReplyText(String replyText) {this.replyText = replyText;}
}