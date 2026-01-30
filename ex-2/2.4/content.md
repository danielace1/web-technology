# Title

Design and development of a responsive Travel Blog using advanced CSS techniques

## Objective

To design and develop a responsive travel blog webpage using HTML and CSS that demonstrates different CSS implementation techniques such as CSS animations, masonry layout, sticky navigation, floating social media sidebar, styled blockquotes, responsive design, and form validation using CSS pseudo-classes, along with navigation to separate pages for individual blog posts.

## Tools Required

- HTML5
- CSS3
- Text Editor
- Web Browser (Chrome / Firefox / Edge)

## Procedure

- Open a text editor and create an index.html file for the travel blog homepage.
- Add the basic HTML structure and include an external CSS file using the <link> tag.
- Create a header section displaying the blog title and tagline.
- Implement an image slider using CSS animations to showcase travel images.  
  Design the main layout using CSS Flexbox for content alignment.
- Create a sticky table of contents section with links to separate destination pages.
- Implement a masonry layout for blog cards using CSS column properties.
- Design individual blog cards with hover effects and “Read More” links.Create separate HTML pages (beach.html, mountain.html, city.html) for each travel destination.
- Style blockquotes with custom borders and background colors.
- Add a floating social media sharing sidebar using fixed positioning.
- Design a responsive footer with a newsletter subscription form. Apply CSS pseudo-classes (:valid and :invalid) to validate email input fields.
- Use media queries to ensure responsiveness for mobile screens.
- Save all files and test the webpage in a browser.

## Code:

### index.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Travel Blog</title>

    <link rel="stylesheet" href="./assets/style.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
    />
  </head>

  <body>
    <header class="header">
      <h1>Travel Blog</h1>
      <p>Explore • Experience • Enjoy</p>
    </header>

    <!-- Slider -->
    <div class="slider">
      <div class="slides">
        <img
          src="https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
        />
        <img
          src="https://images.unsplash.com/photo-1501785888041-af3ef285b470"
        />
        <img
          src="https://images.unsplash.com/photo-1491553895911-0055eca6402d"
        />
      </div>
    </div>

    <div class="container">
      <!-- TOC -->
      <div class="toc">
        <h3>Destinations</h3>
        <a href="beach.html">🏖 Beach Trip</a>
        <a href="mountain.html">⛰ Mountain Trek</a>
        <a href="city.html">🏙 City Tour</a>
      </div>

      <!-- Blog Cards -->
      <div class="blog">
        <div class="post">
          <h3>Beach Trip</h3>
          <p>Sunny beaches and calming waves.</p>
          <a class="readmore" href="beach.html">Read more →</a>
        </div>

        <div class="post">
          <h3>Mountain Trek</h3>
          <p>Breathtaking views and adventure.</p>
          <a class="readmore" href="mountain.html">Read more →</a>
        </div>

        <div class="post">
          <h3>City Tour</h3>
          <p>Cultural exploration and city life.</p>
          <a class="readmore" href="city.html">Read more →</a>
        </div>
      </div>
    </div>

    <!-- Social -->
    <div class="social">
      <a class="fb" href="#"><i class="fab fa-facebook-f"></i></a>
      <a class="tw" href="#"><i class="fab fa-twitter"></i></a>
      <a class="ig" href="#"><i class="fab fa-instagram"></i></a>
    </div>

    <footer>
      <h3>Subscribe to our Newsletter</h3>
      <form>
        <input type="email" placeholder="Enter your email" required />
        <button>Subscribe</button>
      </form>
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
    <title>Mountain Trek</title>
    <link rel="stylesheet" href="./assets/style.css" />
  </head>

  <body>
    <header class="header">
      <h1>Mountain Trek</h1>
    </header>

    <div class="page">
      <p>
        Mountain trekking builds endurance and offers stunning scenic views. It
        is perfect for adventure lovers.
      </p>

      <blockquote>“The best view comes after the hardest climb.”</blockquote>

      <a class="back" href="index.html">← Back to Home</a>
    </div>
  </body>
</html>
```

### beach.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Beach Trip</title>
    <link rel="stylesheet" href="./assets/style.css" />
  </head>

  <body>
    <header class="header">
      <h1>Beach Trip</h1>
    </header>

    <div class="page">
      <p>
        Beach trips offer relaxation, fresh air, and peaceful surroundings.
        Watching waves and sunsets helps reduce stress.
      </p>

      <blockquote>
        “To sit in silence at the shore is to understand the power of nature.”
      </blockquote>

      <a class="back" href="index.html">← Back to Home</a>
    </div>
  </body>
</html>
```

### city.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>City Tour</title>
    <link rel="stylesheet" href="./assets/style.css" />
  </head>

  <body>
    <header class="header">
      <h1>City Tour</h1>
    </header>

    <div class="page">
      <p>
        City tours help explore culture, architecture, and lifestyle. Museums
        and streets tell stories of history.
      </p>

      <blockquote>
        “A city is more than buildings; it’s a living story.”
      </blockquote>

      <a class="back" href="index.html">← Back to Home</a>
    </div>
  </body>
</html>
```

### style.css

```css
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, sans-serif;
  background: #f8fafc;
  color: #1f2937;
}

/* Header */
.header {
  background: #0f766e;
  color: white;
  padding: 15px;
  text-align: center;
}

/* Slider */
.slider {
  height: 400px;
  overflow: hidden;
}

.slides {
  display: flex;
  width: 300%;
  animation: slide 15s infinite;
}

.slides img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

@keyframes slide {
  0% {
    margin-left: 0;
  }
  33% {
    margin-left: -100%;
  }
  66% {
    margin-left: -200%;
  }
}

/* Layout */
.container {
  display: flex;
  margin: 20px;
}

.toc {
  width: 20%;
  background: #fef3c7;
  padding: 15px;
  position: sticky;
  top: 20px;
}

.toc a {
  display: block;
  margin-bottom: 10px;
  text-decoration: none;
  color: #0f766e;
}

.blog {
  width: 60%;
  column-count: 2;
  column-gap: 15px;
}

.post {
  background: white;
  padding: 20px;
  margin-bottom: 15px;
  border-radius: 10px;
  break-inside: avoid;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.post h3 {
  color: #fb7185;
}

.readmore {
  color: #0f766e;
  text-decoration: none;
  font-weight: bold;
}

/* Pages */
.page {
  padding: 30px;
}

blockquote {
  border-left: 5px solid #fb7185;
  padding-left: 15px;
  background: #fff7ed;
  font-style: italic;
}

.back {
  display: inline-block;
  margin-top: 20px;
  color: #0f766e;
  text-decoration: none;
}

/* Social */
.social {
  position: fixed;
  right: 10px;
  top: 40%;
}

.social a {
  display: block;
  padding: 12px;
  color: white;
  border-radius: 50%;
  margin-bottom: 5px;
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

/* Footer */
/* ---------- Footer ---------- */
footer {
  background: #0f766e;
  color: white;
  padding: 30px 20px;
  text-align: center;
}

footer h3 {
  margin-bottom: 15px;
  font-weight: normal;
}

/* Footer Form */
footer form {
  max-width: 420px;
  margin: 0 auto;
  display: flex;
  gap: 10px;
}

/* Email Input */
footer input[type="email"] {
  flex: 1;
  padding: 12px 15px;
  border-radius: 30px;
  border: 2px solid transparent;
  outline: none;
  font-size: 15px;
}

/* Button */
footer button {
  padding: 12px 25px;
  border-radius: 30px;
  border: none;
  background: #fb7185;
  color: white;
  font-size: 15px;
  cursor: pointer;
  transition:
    background 0.3s ease,
    transform 0.2s ease;
}

/* Hover Effect */
footer button:hover {
  background: #f43f5e;
  transform: scale(1.05);
}

/* Validation using CSS only */
footer input:valid {
  border-color: #22c55e;
}

footer input:invalid {
  border-color: #f87171;
}

/* Responsive Footer Form */
@media (max-width: 500px) {
  footer form {
    flex-direction: column;
  }

  footer button {
    width: 100%;
  }
}

/* Responsive */
@media (max-width: 768px) {
  .container {
    flex-direction: column;
  }
  .toc,
  .blog {
    width: 100%;
  }
  .blog {
    column-count: 1;
  }
  .social {
    display: none;
  }
}
```

## Learning Outcome

- Understand external CSS implementation for layout and design
- Learn to create CSS-based image sliders using animations
- Implement masonry layouts using CSS columns
- Design sticky navigation and floating sidebars
- Create responsive web layouts using media queries
- Apply CSS pseudo-classes for form validation
- Develop multi-page websites with internal navigation
- Enhance UI design using modern color patterns and hover effects
