<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LocalGuide - Locations</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="custom.css">
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="container">
            <a class="navbar-brand logo" href="/customer/index">
            <svg class="logo-house" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="black" stroke-width="1.5">
                <path d="M3 11.5L12 4l9 7.5" />
                <path d="M5 10v9h14v-9" />
            </svg>
            <span class="logo-text">LocalGuide</span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navMenu">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="/customer/about">About</a></li>
                <li class="nav-item"><a class="nav-link" href="/customer/book">Book a Tour</a></li>
                <li class="nav-item"><a class="nav-link" href="/customer/login">Login / Sign Up</a></li>
                <li class="nav-item"><a class="nav-link" href="/customer/locations">Locations</a></li>
            </ul>
            </div>
        </div>
    </nav>

<div class="container mt-4 align-items-center text-center">
  <h1>Locations</h1>
  <p class="lead">Browse niche, off-the-beaten-path destinations hosted by local guides</p>
</div>

<div class="container mt-4">
  <#if tourListings?has_content>
    <div class="row row-cols-1 row-cols-md-3 g-4">
      <#list tourListings as listing>
        <div class="col">
          <div class="card h-100 location-card">
            <#if listing.imageUrl?has_content>
              <img src="${listing.imageUrl}" class="card-img-top location-image" alt="${listing.name}">
              <#else>
                <img src="https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=900&q=80" class="card-img-top location-image" alt="${listing.name}">
            </#if>
            <div class="card-body text-center">
              <h5 class="card-title">${listing.name}</h5>
              <p class="card-text">${listing.description}</p>
              <a href="/customer/book" class="btn btn-primary">Book Now</a>
            </div>
          </div>
        </div>
      </#list>
    </div>
    <#else>
      <div class="alert alert-info text-center">No tours are available right now.</div>
  </#if>
</div>

<footer class="bg-light text-center text-lg-start mt-5">
  <div class="container p-4">
    <p>&copy; 2026 LocalGuide. This is an educational project.</p>
  </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>