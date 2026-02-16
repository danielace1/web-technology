# Title

Event Registration Form Using Servlet (Without Session Management)

## Objective

To develop a Java Servlet-based Event Registration system that validates attendee details, prevents duplicate email registration, checks age restrictions for specific sessions, and calculates total registration cost without using HttpSession. All user data is handled directly through request processing.

## Tools Required

- Java Development Kit
- Apache Tomcat Server
- IDE (e.g., Eclipse, IntelliJ IDEA, VS Code)
- Web Browser

## Procedure

- Installed JDK and Apache Tomcat server.
- Created a project folder inside the Tomcat webapps directory.
- Designed an HTML form (index.html) to collect attendee details and session selection.
- Created a servlet class EventRegistrationServlet.java.
- Implemented the following validations inside doPost():
- Checked for empty fields.
- Prevented duplicate email registration.
- Verified age restriction for specific sessions.
- Calculated total registration cost dynamically.
- Configured servlet mapping in web.xml.
- Compiled the servlet using servlet-api.jar.
- Started Apache Tomcat server.
- Accessed the application via:

## Code

### index.html

```html
<!-- PATH: -->
<!-- ex-4\apache-tomcat-9.0.115-windows-x64\apache-tomcat-9.0.115\webapps\EventRegistration\index.html -->

<!doctype html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Event Registration</title>
  </head>

  <body>
    <h2>Event Registration Form</h2>

    <form action="EventRegistrationServlet" method="post">
      Name: <input type="text" name="name" required /><br /><br />

      Email: <input type="email" name="email" required /><br /><br />

      Age: <input type="number" name="age" required /><br /><br />

      <h3>Select Sessions:</h3>

      <input type="checkbox" name="session" value="Technical Workshop" />
      Technical Workshop (₹500, 18+)<br />

      <input type="checkbox" name="session" value="Design Seminar" />
      Design Seminar (₹400)<br />

      <input type="checkbox" name="session" value="Marketing Talk" />
      Marketing Talk (₹300)<br /><br />

      <input type="submit" value="Register" />
    </form>
  </body>
</html>
```

### EventRegistrationServlet.java

```java
// PATH: ex-4\apache-tomcat-9.0.115-windows-x64\apache-tomcat-9.0.115\webapps\EventRegistration\WEB-INF\classes\EventRegistrationServlet.java

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class EventRegistrationServlet extends HttpServlet {

    // Used to prevent duplicate emails (No session used)
    private static Set<String> registeredEmails = new HashSet<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String[] sessions = request.getParameterValues("session");

        int age = Integer.parseInt(ageStr);
        int totalCost = 0;

        out.println("<html><body>");

        // 1️⃣ Validate empty sessions
        if (sessions == null) {
            out.println("<h3>Please select at least one session.</h3>");
            return;
        }

        // 2️⃣ Duplicate Email Check
        if (registeredEmails.contains(email)) {
            out.println("<h3>Duplicate Email! Registration not allowed.</h3>");
            return;
        }

        // 3️⃣ Age Restriction + Cost Calculation
        for (String session : sessions) {

            if (session.equals("Technical Workshop")) {
                if (age < 18) {
                    out.println("<h3>Age restriction failed for Technical Workshop (18+ required).</h3>");
                    return;
                }
                totalCost += 500;
            }

            if (session.equals("Design Seminar")) {
                totalCost += 400;
            }

            if (session.equals("Marketing Talk")) {
                totalCost += 300;
            }
        }

        // Add email to prevent duplicate
        registeredEmails.add(email);

        // 4️⃣ Display Output
        out.println("<h2>Registration Successful</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Age: " + age + "</p>");

        out.println("<p>Selected Sessions:</p><ul>");
        for (String session : sessions) {
            out.println("<li>" + session + "</li>");
        }
        out.println("</ul>");

        out.println("<h3>Total Cost: ₹" + totalCost + "</h3>");

        out.println("</body></html>");
    }
}
```

## Learning Outcome - Understood Servlet lifecycle and request handling. -

Implemented backend validation without using sessions. - Learned how to deploy
and run Servlet using Apache Tomcat. - Gained knowledge about dynamic HTML
response generation. - Practiced handling multiple form values using
getParameterValues().

```

```
