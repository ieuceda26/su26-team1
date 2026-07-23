# LocalGuide - Niche neighborhood tours by trusted locals
**Project Name**: LocalGuide \
**Version**: 1.0 \
**Date**: 2026-07-22 \ 
**Purpose**:Test plan for LocalGuide application

## Actors
- Provider P: Guide
- Customer C: Tourist
- Service S: Tours

## Use Cases

#### 1. Provider US-4 - Create a profile to attract users, US-5 - As a provider, I want to create tours so that user can see my offerings.

1. Provider P1 logs in and creates a profile with credentials.
2. P1 updates their profile to change name and keywords.
3. P1 creates a new service S1 with identifying attributes (tour name, price, location)
4. P1 logs out

#### 2. Customer: US-1 - Create a profile, 
1. Customer signs up if no account exist.
2. Customer puts personal information (full name, email, password)
3. Customer exits

#### 3. Customer: US-3 - book a tour, US-6 - write a comment, US-9 - book multiple tours.
1. C2 signs up for the first time and creates a profile.
2. Edits profile to preference.
3. Customer C2 books a tour from the tour page with provider P1.
4. Customer C2 completes a tour.
5. C2 writes a review and submits it.
6. The review is saved and is visible to the guide and the customer itself

#### 4. Customer: US-2 - Browse through locations.
1. Customer C1 logs in and goes to the location page. 
2. C1 views all the available locations.
3. If C1 is interested in a location they can click on the book button and it will redirect them to the tour page to book.

#### 5. Provider: US-8 - As a provider, I want to say what experience I offer to tourists.
1. Provider P1 logs in and goes to Edit Tour.
2. P1 alters service S1 with changes to the description.
3. Upon clicking to Update Tour, the updated information will be displayed.

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Locations page response time < 3 seconds**

- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "Locations" page load
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 3 seconds

**Scenario P2:** Guide profile update time < 2 seconds

- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for updating a guide's profile once the Update button is pressed
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 2 seconds

### Security & Privacy Requirements

**Scenario S1:** Customer and Provider cannot access each other's pages

- **Setup:** Customer tries to access guide-only data and vice versa
- **Steps:**
  1. Customer logs in.
  2. Attempts to navigate to "/guide/profile" and access guide-only data.
  3. Observe the response.
- **Expected Outcome:**
  - Access is denied.
  - Customer is redirected to login page.
  - No sensitive guide data is exposed to the customer.

**Scenario S2:** Guide cannot edit another guide's tour

- **Setup:**Guide is trying to edit an tour that is not theirs for malicious reasons.
- **Steps:**
  1. Guide logs in.
  2. Attempts to edit or delete another person's tour listing (via URL or API).
  3. Observe response.
- **Expected Outcome:**
  - Access is denied.
  - Trainer is redirected to an error page or their profile.
  - No sensitive data from the other guide is exposed to the attacking guide.

### Usability Requirements

**Scenario U1:** New customer completes registration and books a tour within 7 minutes

- **Setup:** New customer books a tour of their choice with a facilitator observing the process.
- **Steps:**
  1. New customer logs in for the first time.
  2. Customer moves to "Book a Tour".
  3. Customer browses available guides and books one.
  4. Customer marks the booked tour as Completed once returning to their dashboard.
  5. Customer clicks on Leave Review, and writes a quick review for their selected tour.
- **Expected Outcome:**
  - Time to complete registration and book a session is ≤ 7 minutes.
