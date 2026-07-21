<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LocalGuide - Login</title>
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
                <li class="nav-item"><a class="nav-link" href="/about">About</a></li>
                <li class="nav-item"><a class="nav-link" href="/tourist/tours">Book a Tour</a></li>
                <li class="nav-item"><a class="nav-link" href="/users/login">Login / Sign Up</a></li>
                <li class="nav-item"><a class="nav-link" href="/tourist/locations">Locations</a></li>
            </ul>
            </div>
        </div>
    </nav>

    <!-- Login Form -->
    <div class="container mt-4">
        <h1 class="text-center">Login</h1>
        <form form action="/guide/login" method="post" class="mt-4">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="Enter your email">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
            </div>
            <button type="submit" class="btn btn-secondary w-100 mt-2">Login as Tour Guide</button>
        </form>
        <p class="text-center mt-3">Don't have an account? <a href="/guide/register">Sign up here!</a></p>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>