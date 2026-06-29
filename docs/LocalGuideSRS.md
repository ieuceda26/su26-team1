
# Requirements – LocalGuide

**Project Name:** LocalGuide \
**Team:** Pedro Magalhaes - Provider, Isaac Euceda - Customer \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-06-29

---

## 1. Overview
**Vision.** LocalGuide is a service used to find some not so wellknown places that have the potential to be great tourist destinations. Native guides will be able to use the platform to host tours and show the beauty of the location. The user can book tours, time and day they want to visit and leave thoughtful reviews. 

**Glossary** Terms used in the project
- **Local Guide:** The native guide that will host the tours and be tasked with highlighting hidden spots in the city. 
- **Customer:** A person interested in touring the location.
- **Profile:** A collection of information about a user, including personal details, fitness goals, and preferences.
- **Location:** Refers to the actual city/cities being toured.
- **Tour:** Is a journey through a city, town or building. 

**Primary Users / Roles.**
- **Customer** - Find native guides that are hosting tours at the location they want to visit. 
- **Local Guide** — Host tours and gain traction.

**Scope (this semester).**
- User profiles (customers & provider)
- Broswe through different locations and their galleries
- Booking tours
- Reviews and comments

**Out of scope (deferred).**
- Keyword system
- Virtual tour

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑1 - Register & manage profile**

  _Story:_ As a customer, I want to create a profile so that I can book tours and browse locations.

  _Acceptance:_
  
  Scenario: Register with valid credentials
    Given I am not registered
    When I provide valid registration details
    Then I should be successfully registered and logged in


- **US‑2 - Browse locations**

  _Story:_ As a customer, I want to broswe through different locations so that I can have a variety of choices and pick the one that interests me the most. 

  _Acceptance:_
  
  Scenario: Browse locations
    Given I am logged in as a customer
    When I click on locations
    Then I should see a list of locations and have the ability to broswe through each one


- **US-3 - Book a Tour**

  _Story:_ As a customer, I want to book a tour so that I can explore the place and create memories.

  _Acceptance:_
  
  Scenario: Book a tour
    Given I am logged in as a customer
    When I select a location and choose a local guide
    Then I should receive a confirmation of the booked session


- **US-4 - Write a review after a tour**

    _Story:_ 

    _Acceptance:_
  
    Scenario: 

- **US-4 **

### 2.2 Provider (Trainer) Stories

- **US-5 - Create and update profile**
  _Story:_ 

  _Acceptance:_
  
  Scenario: 
- **US-6 - **

  _Story:_ 

  _Acceptance:_
  
  Scenario: 

- **US-7 - **

  _Story:_
  _Acceptance:_
  
  Scenario:
    

- **US-8 - **

  _Story:_ 

  _Acceptance:_
  
  Scenario: 
---

## 3. Non‑Functional Requirements
- **Performance:** 
- **Availability/Reliability:** 
- **Security/Privacy:** 
- **Usability:** 

---

## 4. Assumptions, Constraints, and Policies
- 
- 

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues.
- **M2 High‑fidelity prototype** — core customer/provider UI flows fully interactive.
- **M3 Design** — architecture, schema, API outline.
- **M4 Backend API** — key endpoints + tests.
- **M5 Increment** — ≥2 use cases end‑to‑end.
- **M6 Final** — complete system & documentation.

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.
- Major changes should update this SRS.
