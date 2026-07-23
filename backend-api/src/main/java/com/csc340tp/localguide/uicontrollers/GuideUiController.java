package com.csc340tp.localguide.uicontrollers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.entity.Review;
import com.csc340tp.localguide.entity.TourListings;
import com.csc340tp.localguide.service.GuideService;
import com.csc340tp.localguide.service.ReviewService;
import com.csc340tp.localguide.service.TourListingService;
import com.csc340tp.localguide.service.TouristService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/guide")
public class GuideUiController {
    private final GuideService guideService;
    private final TouristService touristService;
    private final TourListingService tourListingService;
    private final ReviewService reviewService;

    public GuideUiController(GuideService guideService, TouristService touristService, 
    TourListingService tourListingService, ReviewService reviewService) {
        this.guideService = guideService;
        this.touristService = touristService;
        this.tourListingService = tourListingService;
        this.reviewService = reviewService;
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("guide", new Guide());
        return "guide/register";
    }

    @PostMapping("/register")
    public String registerGuide(Guide guide) {
        guideService.createGuide(guide);
        return "redirect:/guide/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "guide/login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, String email, String password) {
        Guide guide = guideService.findByEmail(email);
        if (guide != null && password.equals(guide.getPassword())) {
            session.setAttribute("guideId", guide.getId());
            return "redirect:/guide/profile";
        }
        return "redirect:/guide/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/guide/login";
    }

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        Long guideId = (Long) session.getAttribute("guideId");
        if (guideId == null) {
            return "redirect:/guide/login";
        }

        Guide guide = guideService.getGuideById(guideId);
        List<TourListings> tourListings = tourListingService.getListingsByGuideId(guideId);
        List<Review> reviews = reviewService.getReviewsByGuide(guideId);
        model.addAttribute("guide", guide);
        model.addAttribute("tourListings", tourListings);
        model.addAttribute("reviews", reviews);
        return "guide/profile";
    }

    @PostMapping("/update-profile/{id}")
    public String updateProfile(HttpSession session, @PathVariable("id") long guideId, Guide updatedGuide) {
        Long sessionGuideId = (Long) session.getAttribute("guideId");
        if (sessionGuideId == null || sessionGuideId != guideId) {
            return "redirect:/guide/login";
        }

        guideService.updateGuide(guideId, updatedGuide);
        return "redirect:/guide/profile";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(HttpSession session, @PathVariable("id") long guideId) {
        Long sessionGuideId = (Long) session.getAttribute("guideId");
        if (sessionGuideId == null || sessionGuideId != guideId) {
            return "redirect:/guide/login";
        }

        guideService.deleteGuide(guideId);
        session.invalidate();
        return "redirect:/guide/login";
    }

    //Create, update, delete tour listings

    @GetMapping("/new-tour")
    public String showNewTourPage(Model model) {
        model.addAttribute("tourListing", new TourListings());
        return "guide/new-tour";
    }

    @PostMapping("/new-tour")
    public String createTour(HttpSession session, TourListings tourListing) {
        Long guideId = (Long) session.getAttribute("guideId");
        if (guideId == null) {
            return "redirect:/guide/login";
        }

        tourListingService.createListing(tourListing, guideId);
        return "redirect:/guide/profile";
    }

    @GetMapping("/update-tour/{id}")
    public String showEditTourPage(HttpSession session, @PathVariable("id") long tourId, Model model) {
        Long guideId = (Long) session.getAttribute("guideId");
        if (guideId == null) {
            return "redirect:/guide/login";
        }

        TourListings tourListing = tourListingService.getListingbyId(tourId);
        if (tourListing == null || !tourListing.getGuide().getId().equals(guideId)) {
            return "redirect:/guide/profile";
        }

        model.addAttribute("tourListing", tourListing);
        return "/guide/update-tour";
    }


    @PostMapping("/update-tour/{id}")
    public String updateTour(HttpSession session, @PathVariable("id") long tourId, TourListings updatedTour) {
        Long guideId = (Long) session.getAttribute("guideId");
        if (guideId == null) {
            return "redirect:/guide/login";
        }

        TourListings existingTour = tourListingService.getListingbyId(tourId);
        if (existingTour != null && existingTour.getGuide().getId().equals(guideId)) {
            tourListingService.updateListings(tourId, updatedTour);
        }
        return "redirect:/guide/profile";
    }

    @PostMapping("/delete-tour/{id}")
    public String deleteTour(HttpSession session, @PathVariable("id") long tourId) {
        Long guideId = (Long) session.getAttribute("guideId");
        if (guideId == null) {
            return "redirect:/guide/login";
        }

        TourListings existingTour = tourListingService.getListingbyId(tourId);
        if (existingTour != null && existingTour.getGuide().getId().equals(guideId)) {
            tourListingService.deleteListing(tourId);
        }
        return "redirect:/guide/profile";
    }

    //Reply to reviews
    @PostMapping("/reviews/{reviewId}/reply")
    public String replyToReview(@PathVariable Long reviewId, @RequestParam(name = "replyText", required = false) String replyText, HttpSession session) {
    Long guideId = (Long) session.getAttribute("guideId");
    if (guideId == null) {
      return "redirect:/guide/login";
    }

    Review review = reviewService.getReviewById(reviewId).orElse(null);
    if (review == null || review.getGuide() == null || !guideId.equals(review.getGuide().getId())) {
      return "redirect:/guide/profile";
    }

    Review update = new Review();
    update.setReplyText(replyText != null ? replyText.trim() : null);
    reviewService.updateReview(reviewId, update);
    return "redirect:/guide/profile";
  }

}
