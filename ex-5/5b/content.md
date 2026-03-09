📝 Title

Event Registration Form with Multiple Attendees Using Java Servlet and Session Management

🎯 Objective

To develop a SessionEventRegistrationServlet that uses HTTP session attributes to store and manage multiple attendee registrations, validate input data, prevent duplicate entries, calculate registration costs dynamically, and display a final summary before confirmation.

🛠 Tools Required

Java Development Kit
Apache Tomcat Server
Web Browser

🔄 Procedure

Installed JDK and Apache Tomcat.

Created a new web application folder inside the webapps directory.

Designed an HTML form to collect attendee information and session selections.

Created SessionEventRegistrationServlet.java.

Implemented HttpSession to store attendee data.

Used ArrayList to manage multiple attendees within the session.

Added validation for:

Required fields

Duplicate email entries

Age restrictions

Calculated total registration cost dynamically.

Configured servlet mapping in web.xml.

Compiled servlet and deployed it inside WEB-INF/classes.

Started the Tomcat server.

Accessed the application via browser.
