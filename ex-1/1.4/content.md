# Title

Webpage with an Image Map of Computer System Components

## Objective

To design a web page using HTML that displays a single image of a computer system and uses image mapping to create clickable regions for different components such as CPU, Motherboard, RAM, and Hard Disk, where each region navigates to a separate HTML page containing detailed information about that component.

## Tools Required

- HTML5
- Web Browser
- Text Editor
- Image computer system components

## Procedure

- Open a text editor and create a new HTML file named index.html.
- Write the basic HTML structure using <html>, <head>, and <body> tags.
- Add a heading to describe the webpage.
- Insert a single image of a computer system using the <img> tag.
- Use the usemap attribute to link the image with an image map.
- Define an image map using the <map> tag.
- Create multiple clickable regions using <area> tags for CPU, RAM, Motherboard, and Hard Disk.
- Assign appropriate coords values to each <area> tag based on component positions.
- Link each clickable area to its respective HTML page using the href attribute.
- Create separate HTML files (cpu.html, ram.html, motherboard.html, hdd.html) and add relevant component information.
- Save all files in the same project folder.  
  Open index.html in a web browser and verify navigation by clicking each component area.

## Code:

### index.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Computer System Image Map</title>
  </head>

  <body>
    <h2 align="center">Computer System Components</h2>

    <center>
      <img
        src="./assets/img/computer.jpg"
        usemap="#systemmap"
        width="1870"
        height="980"
        alt="Computer System Components"
      />
    </center>

    <map name="systemmap">
      <area
        shape="rect"
        coords="130,492,404,863"
        href="hdd.html"
        alt="Hard Disk"
      />

      <area
        shape="rect"
        coords="400,520,750,880"
        href="motherboard.html"
        alt="Motherboard"
      />

      <area shape="rect" coords="800,520,1150,880" href="cpu.html" alt="CPU" />

      <area shape="rect" coords="1549,504,1744,878" href="ram.html" alt="RAM" />
    </map>
  </body>
</html>
```

### cpu.html

```html
<!doctype html>
<html>
  <head>
    <title>CPU</title>
  </head>
  <body>
    <h2>CPU (Central Processing Unit)</h2>
    <p>
      The CPU is the brain of the computer. It performs arithmetic and logical
      operations and controls all system activities.
    </p>

    <a href="index.html">Back to Main Page</a>
  </body>
</html>
```

### ram.html

```html
<!doctype html>
<html>
  <head>
    <title>RAM</title>
  </head>
  <body>
    <h2>RAM (Random Access Memory)</h2>
    <p>
      RAM stores temporary data and instructions that are currently being used
      by the computer.
    </p>

    <a href="index.html">Back to Main Page</a>
  </body>
</html>
```

### motherboard.html

```html
<!doctype html>
<html>
  <head>
    <title>Motherboard</title>
  </head>
  <body>
    <h2>Motherboard</h2>
    <p>
      The motherboard is the main circuit board that connects all hardware
      components of the computer.
    </p>

    <a href="index.html">Back to Main Page</a>
  </body>
</html>
```

### hdd.html

```html
<!doctype html>
<html>
  <head>
    <title>Hard Disk</title>
  </head>
  <body>
    <h2>Hard Disk</h2>
    <p>
      The hard disk stores the operating system, software, and user data
      permanently.
    </p>

    <a href="index.html">Back to Main Page</a>
  </body>
</html>
```

## Learning Outcome

- Understand the concept of image mapping in HTML
- Learn to create clickable regions using <map> and <area> tags
- Gain knowledge of linking multiple HTML pages
- Improve skills in webpage navigation design
- Develop interactive web pages using basic HTML
