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