package com.csc340tp.localguide.uicontrollers;

import com.csc340tp.localguide.entity.Tourist;
import com.csc340tp.localguide.service.ReviewService;
import com.csc340tp.localguide.service.TouristService;
import com.csc340tp.localguide.service.TourListingService;
import com.csc340tp.localguide.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerUiController {

    private final TouristService touristService; 
    private final TourService tourService; 
    private final TourListingService tourListingService;
    private final ReviewService reviewService;

    public CustomerUiController(TouristService touristService, TourService tourService, TourListingService tourListingService, ReviewService reviewService) {  
        this.touristService = touristService;  
        this.tourService = tourService;
        this.tourListingService = tourListingService;
        this.reviewService = reviewService;
    }

    // US-1: Show login/register page

    @GetMapping("/login")
    public String login() {
        return "login"; //shows login page
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String password, 
            HttpSession session, Model model) {
        Tourist saved = touristService.register(new Tourist(name, email, password)); // Save the new tourist to the database
        session.setAttribute("touristId", saved.getTouristId()); // Store the touristId in the session for future requests
        return "redirect:/customer/dashboard"; 
    }

    @PostMapping("/login")
    public String loginCustomer(HttpSession session, @RequestParam String email, @RequestParam String password,
            Model model) {
        Tourist tourist = touristService.login(email, password).orElse(null); // Attempt to log in the tourist using the provided email and password
        if (tourist != null && password.equals(tourist.getPassword())) { // if tourists exists, store the touristId in the session and redirect to dashboard
            session.setAttribute("touristId", tourist.getTouristId()); 
            return "redirect:/customer/dashboard";
        }
        return "redirect:/customer/login"; 
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/customer/login";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/locations")
    public String locations(Model model) {
        model.addAttribute("tourListings", tourListingService.getAllListings());
        return "locations";
    }

    // Dashboard showing bookings 

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        Long touristId = (Long) session.getAttribute("touristId"); // retrieves id from logged in tourist

        if (touristId == null) {
            return "redirect:/customer/login"; 
        }

        Tourist tourist = touristService.getTouristById(touristId).orElse(null); 
        model.addAttribute("tourist", tourist); //
        model.addAttribute("upcomingTours", tourService.getUpcomingTours(touristId)); 
        model.addAttribute("pastTours", tourService.getPastTours(touristId)); 
        model.addAttribute("reviews", reviewService.getReviewsByTourist(touristId));
        return "dashboard-customer"; 
    }

    // ── US-3: Book a tour ───────────────────────────────────────────

    @GetMapping("/book")
    public String bookPage(HttpSession session, Model model) { 
        Long touristId = (Long) session.getAttribute("touristId");
        if (touristId == null) {
            return "redirect:/customer/login";
        }
        model.addAttribute("tourListings", tourListingService.getAllListings());
        return "tour";
    }

    @PostMapping("/book")
    public String bookTour(@RequestParam Long serviceId,HttpSession session) {
        Long touristId = (Long) session.getAttribute("touristId");
        if (touristId == null) {
            return "redirect:/customer/login";
        }
        tourService.book(touristId, serviceId); 
        return "redirect:/customer/dashboard";
    }

    // ── US-3: Cancel a booking ───────────────────────────────────────

    @PostMapping("/cancel/{tourId}")
    public String cancelTour(@PathVariable Long tourId, HttpSession session) {
        Long touristId = (Long) session.getAttribute("touristId"); 
        if (touristId == null) {
            return "redirect:/customer/login";
        }
        tourService.cancel(tourId); 
        return "redirect:/customer/dashboard";
    }

    @PostMapping("/complete/{tourId}")
    public String completeTour(@PathVariable Long tourId, HttpSession session) {
        Long touristId = (Long) session.getAttribute("touristId");
        if (touristId == null) {
            return "redirect:/customer/login";
        }
        tourService.complete(tourId);
        return "redirect:/customer/dashboard";
    }

    @PostMapping({"/review"})
    public String submitReview(@RequestParam Integer rating,
                               @RequestParam String text,
                               @RequestParam(required = false) Long listingId,
                               HttpSession session) {
        Long touristId = (Long) session.getAttribute("touristId");
        if (touristId == null) {
            return "redirect:/customer/login";
        }

        if (listingId == null) {
            listingId = 1L;
        }

        reviewService.writeReview(touristId, listingId, rating, text);

        return "redirect:/customer/dashboard";
    }
}
