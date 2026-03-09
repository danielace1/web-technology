import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SessionEventRegistrationServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        // Get attendee list from session
        ArrayList<String> attendees = (ArrayList<String>) session.getAttribute("attendees");

        if (attendees == null) {
            attendees = new ArrayList<>();
        }

        out.println("<html><body>");

        // Validate session selection
        if (sessions == null) {
            out.println("<h3>Please select at least one session.</h3>");
            return;
        }

        // Duplicate Email Check inside session list
        for (String a : attendees) {
            if (a.contains(email)) {
                out.println("<h3>Email already registered in this session.</h3>");
                return;
            }
        }

        // Age restriction + cost calculation
        for (String s : sessions) {

            if (s.equals("Technical Workshop")) {
                if (age < 18) {
                    out.println("<h3>Technical Workshop requires age 18+</h3>");
                    return;
                }
                totalCost += 500;
            }

            if (s.equals("Design Seminar")) {
                totalCost += 400;
            }

            if (s.equals("Marketing Talk")) {
                totalCost += 300;
            }
        }

        // Store attendee info
        String attendeeInfo = "Name: " + name + " | Email: " + email + " | Cost: ₹" + totalCost;

        attendees.add(attendeeInfo);

        session.setAttribute("attendees", attendees);

        // Output
        out.println("<h2>Attendee Added Successfully</h2>");

        out.println("<h3>Current Attendees in Session:</h3>");
        out.println("<ul>");

        for (String a : attendees) {
            out.println("<li>" + a + "</li>");
        }

        out.println("</ul>");

        out.println("<a href='index.html'>Add Another Attendee</a>");

        out.println("</body></html>");
    }
}