<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LocalGuide - Tour Guide</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="custom.css">
  </head>
  <body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="container">
            <a class="navbar-brand logo" href="/index">
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
                <li class="nav-item"><a class="nav-link" href="/guide/logout">Logout</a></li>
            </ul>
            </div>
        </div>
    </nav>

    <!-- Welcome Message -->
    <div class="container mt-4 align-items-center text-center">
      <h1>Welcome, ${guide.name}!</h1>
      <p>Ready to guide some folks through the city?</p>
    </div>

    <!-- Dashboard -->
    <div class="container mt-4">
      <h2>Dashboard</h2>
      <p>Here's an overview of your tours and activities.</p>
      <div class="row">
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Total Tours</h5>
              <p class="card-text">3</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Upcoming Tours</h5>
              <p class="card-text">2</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Reviews</h5>
              <p class="card-text">5</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Tour List / Add new tour -->
    <div class="container mt-4">
      <h2>Your Tours</h2>
      <a href="/guide/new-tour" class="btn btn-primary m-3">&plus; New Tour</a>
      <div class="list-group">
        <#list tourListings as tourListing>
          <p class="list-group-item">${tourListing.name}<br>
            ${tourListing.description}<br>
            <small>Location: ${tourListing.location}</small><br>
            <small>Price: ${tourListing.price}</small><br>
            <small>Max Participants: ${tourListing.maxparticipants}</small><br>
            <#if tourListing.guide.id == guide.id>
              <a href="/guide/update-tour/${tourListing.id}" class="btn btn-primary mt-2">Edit Tour</a>
              <a href="/guide/delete-tour/${tourListing.id}" class="btn btn-danger mt-2">Delete Tour</a>
            </#if>
          </p>
        </#list>
      </div>
    </div>

    <!-- Form to edit profile data -->
    <div class="container mt-4">
      <h2>Edit Profile</h2>
      <form action="/guide/update-profile/${guide.id}" method="post">
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input type="text" class="form-control" id="name" name="name" value="${guide.name}">
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input type="email" class="form-control" id="email" name="email" value="${guide.email}">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password" value="${guide.password}">
        </div>
        <div class="mb-3">
          <label for="keyword" class="form-label">Keyword</label>
          <input type="text" class="form-control" id="keyword" name="keyword" value="${guide.keyword}">
        </div>
        <button type="submit" class="btn btn-primary">Update Profile</button>
      </form>
    </div>

    <div class="container mt-4 alert alert-danger">
      <h2>Delete Account</h2>
      <a href="/guide/delete/${guide.id}" class="btn btn-danger">Delete</a>
    </div>

    <!-- Reviews Section -->
    <div class="container mt-4">
      <h2>Reviews</h2>
      <div class="card">
        <div class="card-body">
          <p>&starf;&starf;&starf;&starf;&starf;</p>
          <h5 class="card-title">Great Tour!</h5>
          <p class="card-text">Went in for the spelunking, stayed for the history lesson. Highly recommend his tours!</p>
          <button class="btn btn-primary">Reply</button>
          <hr>
          <p>&starf;&starf;&starf;&starf;&star;</p>
          <h5 class="card-title">Informative and Fun</h5>
          <p class="card-text">The street art scavenger hunt was loads of fun and I learned a lot. Thanks, Jackson!</p>
          <button class="btn btn-primary">Reply</button>
          <hr>
          <p>&starf;&starf;&starf;&starf;&star;</p>
          <h5 class="card-title">Tour went...swimmingly</h5>
          <p class="card-text"> I gotta say, that tide pool tour was great! Loved getting a soak in, and I appreciate Jackson giving us snacks!</p>
          <button class="btn btn-primary">Reply</button>
          <hr>
          <p>&starf;&starf;&starf;&star;&star;</p>
          <h5 class="card-title">Overall Pleasant</h5>
          <p class="card-text">Had a generally decent time on the tours, I just thought Jackson talked too fast at points LOL</p>
          <button class="btn btn-primary">Reply</button>
          <hr>
          <p>&starf;&starf;&starf;&starf;&star;</p>
          <h5 class="card-title">Cool dude doing cool tours</h5>
          <p class="card-text">Probably one of the better tours guides I had met so far. He knows his stuff!</p>
          <button class="btn btn-primary">Reply</button>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="bg-light text-center text-lg-start mt-5">
      <div class="container p-4">
        <p>&copy; 2026 LocalGuide. This is an educational project.</p>
      </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>