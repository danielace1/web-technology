# Title

Design and development of a responsive Travel Blog using Bootstrap framework

## Objective

To design and develop a responsive travel blog webpage using the Bootstrap framework. The webpage includes an image slider using Bootstrap Carousel, a masonry-style blog layout, a floating social media sharing sidebar, a sticky table of contents, styled blockquotes, and a responsive footer with newsletter signup form validated using CSS pseudo-classes.

## Tools Required

- HTML5
- CSS3
- Bootstrap 5
- Text Editor
- Web Browser

## Procedure

- Create an HTML file and include Bootstrap CSS and JS using CDN links.
- Design a header section using Bootstrap utility classes.
- Implement an image slider using Bootstrap Carousel component.
- Create a responsive page layout using Bootstrap Grid system.
- Add a sticky table of contents using Bootstrap positioning utilities.
- Design blog posts using Bootstrap Cards in a masonry-style layout.
- Style blockquotes using custom CSS along with Bootstrap typography.
- Create a floating social media sidebar using fixed positioning.
- Design a responsive footer using Bootstrap grid.
- Implement newsletter signup form with CSS pseudo-class validation.
- Add responsive behavior using Bootstrap breakpoints.
- Save the file and test it in a web browser.

## Code

### index.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>WanderBlog</title>

    <!-- Bootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />

    <link rel="stylesheet" href="./assets/css/style.css" />

    <!-- Font Awesome -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <!-- Header -->
    <header class="bg-primary text-white text-center py-4">
      <h1 class="fw-bold">WanderBlog</h1>
      <p>Explore the world beautifully</p>
    </header>

    <!-- Carousel -->
    <div
      id="travelCarousel"
      class="carousel slide carousel-fade"
      data-bs-ride="carousel"
    >
      <!-- Indicators -->
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#travelCarousel"
          data-bs-slide-to="0"
          class="active"
        ></button>
        <button
          type="button"
          data-bs-target="#travelCarousel"
          data-bs-slide-to="1"
        ></button>
        <button
          type="button"
          data-bs-target="#travelCarousel"
          data-bs-slide-to="2"
        ></button>
      </div>

      <!-- Slides -->
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
            class="d-block w-100"
            height="500"
          />
          <div class="carousel-caption">
            <h3>Beach Escapes</h3>
            <p>Feel the ocean breeze</p>
          </div>
        </div>

        <div class="carousel-item">
          <img
            src="https://images.unsplash.com/photo-1501785888041-af3ef285b470"
            class="d-block w-100"
            height="500"
          />
          <div class="carousel-caption">
            <h3>Mountain Adventures</h3>
            <p>Chase the clouds</p>
          </div>
        </div>

        <div class="carousel-item">
          <img
            src="https://images.unsplash.com/photo-1491553895911-0055eca6402d"
            class="d-block w-100"
            height="500"
          />
          <div class="carousel-caption">
            <h3>City Stories</h3>
            <p>Discover urban magic</p>
          </div>
        </div>
      </div>

      <!-- Controls -->
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#travelCarousel"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon"></span>
      </button>

      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#travelCarousel"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon"></span>
      </button>
    </div>

    <!-- Content -->
    <div class="container my-5">
      <div class="row">
        <!-- TOC -->
        <aside class="col-md-3 position-sticky top-0">
          <div class="list-group shadow-sm">
            <h5 class="p-3 mb-0 bg-light">Destinations</h5>
            <a class="list-group-item" href="beach.html">Beach Trip</a>
            <a class="list-group-item" href="mountain.html">Mountain Trek</a>
            <a class="list-group-item" href="city.html">City Tour</a>
          </div>
        </aside>

        <!-- Blog -->
        <section class="col-md-9 masonry">
          <div class="card">
            <img
              src="https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
              class="card-img-top"
            />
            <div class="card-body">
              <h5>Beach Trip</h5>
              <p>Golden sands, blue waters, and peaceful vibes.</p>
              <blockquote>Let the waves wash your worries away.</blockquote>
              <a href="beach.html" class="btn btn-primary btn-sm">Read More</a>
            </div>
          </div>

          <div class="card">
            <img
              src="https://images.unsplash.com/photo-1501785888041-af3ef285b470"
              class="card-img-top"
            />
            <div class="card-body">
              <h5>Mountain Trek</h5>
              <p>Nature, silence, and breathtaking heights.</p>
              <a href="mountain.html" class="btn btn-success btn-sm"
                >Read More</a
              >
            </div>
          </div>

          <div class="card">
            <img
              src="https://images.unsplash.com/photo-1491553895911-0055eca6402d"
              class="card-img-top"
            />
            <div class="card-body">
              <h5>City Tour</h5>
              <p>Lights, culture, and endless stories.</p>
              <a href="city.html" class="btn btn-warning btn-sm">Read More</a>
            </div>
          </div>
        </section>
      </div>
    </div>

    <!-- Social -->
    <div class="social">
      <a class="fb" href="#"><i class="fab fa-facebook-f"></i></a>
      <a class="tw" href="#"><i class="fab fa-twitter"></i></a>
      <a class="ig" href="#"><i class="fab fa-instagram"></i></a>
    </div>

    <!-- Footer -->
    <footer class="text-white pt-5 pb-3">
      <div class="container">
        <div class="row text-center text-md-start">
          <!-- Brand -->
          <div class="col-md-4 mb-4">
            <h4 class="fw-bold">WanderBlog</h4>
            <p>
              Discover beautiful destinations, travel stories, and unforgettable
              experiences around the world.
            </p>
          </div>

          <!-- Links -->
          <div class="col-md-4 mb-4">
            <h5>Quick Links</h5>
            <ul class="list-unstyled">
              <li>
                <a href="beach.html" class="text-white text-decoration-none"
                  >Beach Trip</a
                >
              </li>
              <li>
                <a href="mountain.html" class="text-white text-decoration-none"
                  >Mountain Trek</a
                >
              </li>
              <li>
                <a href="city.html" class="text-white text-decoration-none"
                  >City Tour</a
                >
              </li>
            </ul>
          </div>

          <!-- Newsletter -->
          <div class="col-md-4">
            <h5>Newsletter</h5>
            <p>Get travel tips and destination ideas.</p>
            <form>
              <div class="input-group">
                <input
                  type="email"
                  class="form-control"
                  placeholder="Your email"
                  required
                />
                <button class="btn btn-success">Subscribe</button>
              </div>
            </form>
          </div>
        </div>

        <hr class="border-light mt-4" />

        <p class="text-center mb-0">
          © 2026 WanderBlog • Designed with ❤️ using Bootstrap
        </p>
      </div>
    </footer>

    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
      integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
      integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
```

### beach.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Beach Trip</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <nav class="navbar navbar-dark bg-primary">
      <div class="container">
        <a class="navbar-brand" href="index.html">← Back to Home</a>
      </div>
    </nav>

    <header class="text-center my-4">
      <h1>Beach Trip</h1>
      <p>Sun • Sand • Serenity</p>
    </header>

    <div class="container">
      <img
        src="https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
        class="img-fluid rounded mb-4"
      />

      <p>
        Beach trips offer relaxation, scenic beauty, and refreshing experiences.
        The sound of waves and the warmth of the sun create perfect holiday
        moments.
      </p>
    </div>

    <footer class="bg-dark text-white text-center p-3 mt-4">
      © 2026 WanderBlog
    </footer>
  </body>
</html>
```

### city.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>City Tour</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <nav class="navbar navbar-dark bg-warning">
      <div class="container">
        <a class="navbar-brand text-dark" href="index.html">← Back to Home</a>
      </div>
    </nav>

    <header class="text-center my-4">
      <h1>City Tour</h1>
      <p>Culture • History • Nightlife</p>
    </header>

    <div class="container">
      <img
        src="https://images.unsplash.com/photo-1491553895911-0055eca6402d"
        class="img-fluid rounded mb-4"
      />

      <p>
        City tours introduce travelers to diverse cultures, iconic landmarks,
        and vibrant lifestyles.
      </p>
    </div>

    <footer class="bg-dark text-white text-center p-3 mt-4">
      © 2026 WanderBlog
    </footer>
  </body>
</html>
```

### mountain.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Mountain Trek</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <nav class="navbar navbar-dark bg-success">
      <div class="container">
        <a class="navbar-brand" href="index.html">← Back to Home</a>
      </div>
    </nav>

    <header class="text-center my-4">
      <h1>Mountain Trek</h1>
      <p>Adventure • Nature • Peace</p>
    </header>

    <div class="container">
      <img
        src="https://images.unsplash.com/photo-1501785888041-af3ef285b470"
        class="img-fluid rounded mb-4"
      />

      <p>
        Mountain trekking builds endurance, connects you with nature, and offers
        stunning panoramic views.
      </p>
    </div>

    <footer class="bg-dark text-white text-center p-3 mt-4">
      © 2026 WanderBlog
    </footer>
  </body>
</html>
```

### style.css

```css
body {
  font-family: "Segoe UI", sans-serif;
  background: #f8f9fa;
}

/* Hero Text */
.carousel-caption {
  background: rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  padding: 20px;
}

/* Floating Social */
.social {
  position: fixed;
  top: 40%;
  right: 15px;
  z-index: 1000;
}

.social a {
  display: block;
  margin-bottom: 10px;
  padding: 12px;
  border-radius: 50%;
  color: #fff;
  text-align: center;
}

.fb {
  background: #1877f2;
}
.tw {
  background: #1da1f2;
}
.ig {
  background: #e1306c;
}

/* Masonry */
.masonry {
  column-count: 2;
  column-gap: 1rem;
}

.masonry .card {
  break-inside: avoid;
  margin-bottom: 1rem;
  transition:
    transform 0.3s,
    box-shadow 0.3s;
}

.masonry .card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

/* Blockquote */
blockquote {
  border-left: 5px solid #0d6efd;
  padding-left: 15px;
  background: #eef3ff;
  font-style: italic;
}

footer {
  background: linear-gradient(135deg, #0d6efd, #0a58ca);
}

@media (max-width: 768px) {
  .masonry {
    column-count: 1;
  }
  .social {
    display: none;
  }
}
```

## Learning Outcome

- Understand Bootstrap grid and layout system
- Implement image sliders using Bootstrap Carousel
- Create responsive layouts without heavy custom CSS
- Use Bootstrap utility classes for positioning and stylings
- Design modern UI components using Bootstrap cards
- Apply CSS pseudo-classes for form validation
- Develop responsive, mobile-friendly webpages
