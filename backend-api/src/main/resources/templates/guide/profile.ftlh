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

     <!-- Profile card - data from Tourist entity -->
    <div class="container mt-4">
      <div class="row justify-content-center">
        <div class="col-md-4">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">My Profile</h5>
              <ul class="list-group list-group-flush">
                <li class="list-group-item"><strong>Name:</strong> ${guide.name}</li>
                <li class="list-group-item"><strong>Email:</strong> ${guide.email}</li> 
                <li class="list-group-item"><strong>Tourist ID:</strong> ${guide.id}</li>
                <li class="list-group-item"><strong>Keywords:</strong> ${guide.keyword}</li>
              </ul>
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
          <div class="list-group-item">
            <img src="${tourListing.imageUrl}">
            <p>${tourListing.name}</p>
            <p>${tourListing.description}</p>
            <small>Location: ${tourListing.location}</small><br>
            <small>Price: ${tourListing.price}</small><br>
            <small>Max Participants: ${tourListing.maxparticipants}</small><br>
            <#if tourListing.guide.id == guide.id>
              <a href="/guide/update-tour/${tourListing.id}" class="btn btn-primary mt-2">Edit Tour</a>
              <form action="/guide/delete-tour/${tourListing.id}" method="post">
                <button type="submit" class="btn btn-danger">Delete Tour</button>
              </form>
            </#if>
          </div>
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

    <!--Delete Account section-->
    <div class="bg-warning container mt-4"><h3>Delete Account</h3>
      <p>Keep in mind that if you delete your account, your tours and reviews will be lost.</p>
      <form action="/guide/delete/${guide.id}" method="post">
        <button type="submit" class="btn btn-danger">Delete Tour</button>
      </form>
  </div>

    <!-- Reviews Section -->
    <div class="container mt-4">
      <h2>Reviews</h2>
      <div class="card">
        <#list reviews as review>
        <div class="card-body">
          <h3 class="card-text">Rating: ${review.rating}</h3>
          <h4 class="card-text">Tour: ${review.listing.name}</h4>
          <h5 class="card-text">${review.text}</h5>
          <#if review.replyText?? || review.replyText?has_content>
          <p>Current Reply:<br>${review.replyText}</p>
            <form action="/guide/reviews/${review.reviewId}/reply" method="post">
              <div class="mb-3">
                <label for="replyText" class="form-label">Edit Reply</label>
                <input type="text" class="form-control" id="replyText" name="replyText" placeholder="Write your reply here...">
              </div>
              <button type="submit" class="btn btn-primary">Submit New Reply</button>
              </form>
          </#if>
          <#if !review.replyText?? || !review.replyText?has_content>
            <form action="/guide/reviews/${review.reviewId}/reply" method="post">
              <div class="mb-3">
                <label for="replyText" class="form-label">Reply</label>
                <input type="text" class="form-control" id="replyText" name="replyText" placeholder="Write your reply here...">
              </div>
              <button type="submit" class="btn btn-primary">Submit Reply</button>
              </form>
          </#if>
        </div>
        </#list>
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