<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LocalGuide - Create New Tour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="custom.css">
  </head>
  <body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="container">
            <a class="navbar-brand logo" href="../index.html">
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
                <li class="nav-item"><a class="nav-link" href="../about.html">About</a></li>
                <li class="nav-item"><a class="nav-link" href="../customer-prototype/tour.html">Book a Tour</a></li>
                <li class="nav-item"><a class="nav-link" href="../login.html">Login / Sign Up</a></li>
                <li class="nav-item"><a class="nav-link" href="../customer-prototype/locations.html">Locations</a></li>
            </ul>
            </div>
        </div>
    </nav>

    <!-- Starting Message -->
    <div class="container mt-4 align-items-center text-center">
      <h1>Update Tour</h1>
      <p>Need a change to your tour? Update it here!</p>
    </div>

    <!-- Form for creating a new tour -->
    <div class="container mt-4">
        <form action="/guide/update-tour/${tourListing.id}" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Tour Name</label>
                <input type="text" name="name" class="form-control" id="name" value="${tourListing.name}" placeholder="Enter tour name">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Tour Description</label>
                <textarea class="form-control" name="description" id="description" rows="3" placeholder="Enter tour description">${tourListing.description}</textarea>
            </div>
            <div class="mb-3">
                <label for="location" class="form-label">Tour Location</label>
                <input type="text" class="form-control" name="location" id="location" value="${tourListing.location}" placeholder="Enter tour location">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Tour Price ($)</label>
                <input type="number" class="form-control" name="price" id="price" value="${tourListing.price}" placeholder="Enter tour price">
            </div>
            <div class="mb-3">
                <label for="maxparticipants" class="form-label">Maximum Participants</label>
                <input type="number" class="form-control" name="maxparticipants" id="maxparticipants" value="${tourListing.maxparticipants}" placeholder="Enter maximum number of participants">
            </div>
            <div class="mb-3">
                <label for="imageUrl" class="form-label">Maximum Participants</label>
                <input type="text" class="form-control" name="imageUrl" id="imageUrl" value="${tourListing.imageUrl}" placeholder="Enter Image URL">
            </div>
            <button type="submit" class="btn btn-primary">Update Tour</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>