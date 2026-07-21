<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>LocalGuide - My Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="custom.css">
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container">
      <a class="navbar-brand logo" href="../index.html">
        <svg class="logo-house" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="black"
          stroke-width="1.5">
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
          <li class="nav-item"><a class="nav-link" href="/customer/logout">Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>


  <div class="container mt-4 align-items-center text-center">
    <h1>Welcome, ${tourist.name}!</h1> <!-- Displays the tourists name -->
    <p class="lead">Ready for your next adventure?</p>
  </div>

  <!-- Profile card - data from Tourist entity -->
  <div class="container mt-4">
    <div class="row justify-content-center">
      <div class="col-md-4">
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title">My Profile</h5>
            <ul class="list-group list-group-flush">
              <li class="list-group-item"><strong>Name:</strong> ${tourist.name}</li>
              <li class="list-group-item"><strong>Email:</strong> ${tourist.email}</li> 
              <li class="list-group-item"><strong>Tourist ID:</strong> ${tourist.touristId}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="container mt-4">
    <div class="row g-4">
      <!-- Upcoming Bookings -->
      <div class="col-md-6">
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title">Upcoming Bookings</h5>
            <ul class="list-group list-group-flush">
              <#if upcomingTours?has_content> <!-- Check if there are any upcoming tours or not. Goes to else if no data -->
                <#list upcomingTours as tour>
                  <li class="list-group-item">
                    <strong>${tour.name}</strong><br>
                    ${tour.location}
                    <#if tour.text?has_content>
                      &mdash; ${tour.text}
                    </#if>
                    <div class="d-flex gap-2 mt-2">
                      <form method="post" action="/customer/complete/${tour.tourId}">
                        <button type="submit" class="btn btn-sm btn-success">Mark as Completed</button>
                      </form>
                      <form method="post" action="/customer/cancel/${tour.tourId}">
                        <button type="submit" class="btn btn-sm btn-danger">Cancel Booking</button>
                      </form>
                    </div>
                  </li>
                </#list>
                <#else>
                  <li class="list-group-item text-muted">No upcoming bookings. <a href="/customer/book">Book a tour!</a>
                  </li>
              </#if>
            </ul>
          </div>
        </div>
      </div>

      <!-- Past Tours -->
      <div class="col-md-6">
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title">Past Tours</h5>
            <ul class="list-group list-group-flush">
              <#if pastTours?has_content>
                <#list pastTours as tour>
                  <li class="list-group-item">
                    <strong>${tour.name}</strong><br>
                    ${tour.location}<br>
                    <a href="/customer/book" class="btn btn-sm btn-primary mt-2">Leave a Review</a>
                  </li>
                </#list>
                <#else>
                  <li class="list-group-item text-muted">No past tours yet.</li>
              </#if>
            </ul>
          </div>
        </div>
      </div>

    </div>
  </div>


        </div>
    </div>
  </div>

  <footer class="bg-light text-center text-lg-start mt-5">
    <div class="container p-4">
      <p>&copy; 2026 LocalGuide. This is an educational project.</p>
    </div>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>