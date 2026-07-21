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
            <a class="navbar-brand logo" href="index.html">
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
                <li class="nav-item"><a class="nav-link" href="/customer/logout">Logout</a></li>
            </ul>
            </div>
        </div>
    </nav>

     <div class="row justify-content-center g-4">

            <!-- Login Form -->
            <div class="col-md-5">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">Login</h1>
                        <form method="post" action="/customer/login">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Login as Customer</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Sign Up Form -->
            <div class="col-md-5">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">Sign Up</h1>
                        <form method="post" action="/customer/register">
                            <div class="mb-3">
                                <label for="name" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name">
                            </div>
                            <div class="mb-3">
                                <label for="reg-email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="reg-email" name="email" placeholder="Enter your email">
                            </div>
                            <div class="mb-3">
                                <label for="reg-password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="reg-password" name="password" placeholder="Enter your password">
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Create Account</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvw"></script>
</body>
</html>
