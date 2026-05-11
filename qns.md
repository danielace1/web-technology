# lab qns

# 1

Exercise 1

1. Geographic Information System: Create an HTML page with an image
   map of a country with clickable regions that display demographic and
   economic data.
2. Interactive World Map: Create an HTML page with an image map of the
   world, with clickable continents that display population statistics and major
   cities.
3. Interactive Solar System Map: Create an HTML page with an image map
   of the solar system. Make each planet a clickable hotspot that displays
   information about the planet's properties, missions, and discoveries when
   clicked.
4. Responsive Image Map Application: Create a webpage with an image map
   of a computer system (motherboard, CPU, RAM, etc.) with clickable regions
   that display component information in a modal window. Implement
   responsive design so it works on both desktop and mobile.
5. Create an image map for a College campus layout, with clickable areas
   leading to information about different departments.

# 2

## Exercise 2: Creating Web Page with All Types of Cascading Style Sheets

1: Create a responsive e-commerce product page featuring a navigation bar and product
gallery. Implement a sticky header using external CSS, design product cards with hover effects
using internal CSS, and style individual featured product highlights with inline CSS. Build a
responsive grid system that adapts from three columns on desktop to one column on mobile,
and implement a tabbed interface for product information including description, specifications,
and reviews.

2: Design a news portal homepage with different CSS implementation methods. Use external
CSS for the overall layout and grid system, internal CSS for styling featured article sections, and
inline CSS for highlighting breaking news items. Implement a responsive sidebar that converts
to top navigation on mobile screens, create custom pagination controls, and design card-based
article previews with hover effects revealing article excerpts.

3: Build a restaurant website utilizing various CSS techniques. Create a full-screen hero section
with parallax scrolling effect, implement a food menu using CSS Grid with images that enlarge
on hover, and design a reservation form with custom form controls. Use transition effects for
navigation links, develop a responsive image gallery for food items that adapts to different
screen sizes, and implement CSS animations for page loading elements.

4: Develop a travel blog featuring different CSS implementation methods. Create an image
slider using CSS animations, implement a masonry layout for blog posts with varying heights,
and design a floating social sharing sidebar. Add a sticky table of contents for longer articles,
style blockquotes with custom borders and typography, and build a responsive footer with a
newsletter signup that validates input using CSS pseudo-classes.

5: Construct a portfolio for a creative professional using various CSS approaches. Design a
split-screen layout for the hero section, implement smooth scrolling between sections, and
create interactive project cards that flip to reveal project details. Style a skills section using
custom progress bars, build a testimonial carousel using CSS transitions, and implement a
contact section with form validation feedback using only CSS. Ensure consistent typography
and color themes using CSS variables throughout the site.

# 3

## Exercise 3: Client Side Scripts for Validating Web Form Controls using DHTML

1: Registration Form Validation Create a user registration form with fields for username,
email, password, and password confirmation. Implement real-time validation using DHTML that
checks username availability as the user types, validates email format using regular
expressions, ensures password strength (minimum 8 characters, at least one uppercase letter,
one number, and one special character), and confirms passwords match. Display appropriate
error messages beside each field when validation fails, and change the input border color to
indicate validity status. Disable the submit button until all fields pass validation, then enable it
with a highlight effect.

2: E-commerce Checkout Form Design a multi-step checkout form with shipping information,
billing details, and payment method sections. Implement DHTML validation for postal codes
based on country selection, validate phone numbers with appropriate country formats, ensure
credit card numbers pass Luhn algorithm validation, and check expiration dates against the
current date. Create progress indicators that update as the user completes each section, and
implement a summary panel that dynamically updates with validated information. Allow users to
navigate between steps only when the current step is validated.

3: Job Application Form Build a job application form with personal details, education history,
work experience, and file upload fields. Use DHTML to validate that required fields are
completed, ensure date fields follow proper chronological order (start date before end date),
validate file types and sizes for uploaded resumes, and dynamically add/remove education and
work experience sections as needed. Implement character counters for text areas with
maximum limits, and provide validation feedback through tooltips that appear when inputs
receive focus.

4: Event Registration Form Create an event registration form with attendee information,
session selection, and special requirements fields. Implement DHTML to validate email formats,
prevent scheduling conflicts when selecting multiple sessions, ensure age requirements are met
for specific events, and dynamically calculate and display registration costs based on selections.
Allow users to add multiple attendees with validation for each, prevent duplicate registrations
with the same email, and implement a confirmation dialog that summarizes all validated
information before final submission.

5: Survey Form Develop a dynamic survey form with various question types (multiple choice,
rating scales, open-ended responses). Use DHTML to validate that required questions are
answered, ensure numerical responses fall within specified ranges, validate that the correct
number of options are selected for questions with minimum/maximum selection requirements,
and implement conditional questions that appear based on previous answers. Create a progress
bar that updates as the user completes valid responses, and implement a timing function that
saves responses automatically at regular intervals, with validation occurring before each save.

# 5

## Lab Questions – Without Session Management

1. User Registration Form
   Design and implement a RegistrationServlet that processes form data without using session tracking. Perform server-side validation for username uniqueness, email format, password strength, and password confirmation. Display validation feedback to the user upon submission.

2. Multi-Step E-commerce Checkout
   Create a set of servlets (CheckoutStep1Servlet, CheckoutStep2Servlet, etc.) to handle a multi-step checkout process without session usage. Pass user data between steps using hidden fields or request forwarding. Validate postal code, phone number format, credit card (Luhn algorithm), and expiration date at each step.

3. Job Application Form
   Implement a JobApplicationServlet that handles complex form data including personal details, education history, work experience, and resume upload. Perform server-side validation for required fields, chronological dates, and file upload constraints, all without using session tracking.

4. Event Registration Form
   Develop an EventRegistrationServlet that validates attendee data, prevents duplicate email entries, checks age restrictions, and calculates total registration cost. Do this without using sessions, handling all user data directly in request processing.

5. Dynamic Survey Form
   Build a SurveyServlet that handles submission of dynamic survey responses, ensuring all required answers are validated server-side. Use AJAX calls for autosave functionality without session tracking and validate each input during periodic saves.

## Lab Questions – With Session Management

1. User Registration Form with Session
   Create a SessionRegistrationServlet that stores user input in the session during form filling. Allow users to resume a partially filled registration form and ensure session-based data validation before final submission.

2. Session-Based Multi-Step Checkout Form
   Implement a SessionCheckoutServlet that maintains user input across all checkout steps (shipping, billing, payment) using session attributes. Validate each section and display a summary before final submission.

3. Session-Managed Job Application Form
   Develop a SessionJobApplicationServlet that uses session objects to store form entries like education and work experience dynamically. Enable users to add/remove form sections and validate file uploads, preserving state through the session.

4. Event Registration Form with Multiple Attendees
   Build a SessionEventRegistrationServlet that uses session attributes to manage multiple attendees and session selections. Validate input data, avoid duplicate entries, calculate registration cost dynamically, and summarize all data before confirmation.

5. Survey Form with Session Persistence
   Design a SessionSurveyServlet that tracks user survey progress using the session. Enable auto-save functionality that periodically saves answers to the session, validate responses on each save, and allow users to resume the survey at a later time.

# 6

6 A)  
Design and develop a web-based application using to conduct an . The application should include a login page, a question display page (with multiple-choice options retrieved from a database), and a result page showing the student's score. All database operations such as user authentication, question retrieval, answer submission, and score calculation must be handled directly within JSP pages using embedded JDBC code. Ensure basic validation and session management where required.

6 B)
Create a simple three-tier web application using to display the . Student information and marks should be stored in a relational database. Upon login, the JSP should retrieve and display the student’s name, roll number, subject-wise marks, and total score. All logic for connecting to the database and fetching data must be written directly in JSP pages using JDBC. Use SQL joins for efficient data retrieval and display the result in a tabular format.

# 7

Create an XML-based application to manage and display student data using , , and . First, define an XML file (students.xml) that stores student details such as student ID, name, department, semester, and a list of subjects with marks. Then, create an file to validate the structure and data types of the XML document. Finally, develop an stylesheet to transform the XML into a readable HTML format that displays each student’s information and their marks in tabular form.
