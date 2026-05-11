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

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Registration Result</title>");

        out.println("<style>");
        out.println(
                "body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg,#4facfe,#00f2fe); margin:0; padding:20px; }");
        out.println(
                ".card { max-width:500px; margin:auto; background:white; padding:30px; border-radius:15px; box-shadow:0 20px 40px rgba(0,0,0,0.2); }");
        out.println("h2 { text-align:center; color:#28a745; }");
        out.println(".error { color:#dc3545; text-align:center; font-weight:bold; }");
        out.println("p { font-size:15px; color:#333; margin:8px 0; }");
        out.println("ul { padding-left:20px; }");
        out.println("li { margin-bottom:5px; }");
        out.println(".total { font-size:18px; font-weight:bold; color:#0d6efd; margin-top:15px; }");
        out.println(
                ".btn { display:block; text-align:center; margin-top:20px; padding:12px; background:#0d6efd; color:white; text-decoration:none; border-radius:8px; }");
        out.println(".btn:hover { background:#0b5ed7; }");
        out.println("</style>");

        out.println("</head><body>");
        out.println("<div class='card'>");

        // 1️⃣ Validate empty sessions
        if (sessions == null) {
            out.println("<p class='error'>⚠ Please select at least one session.</p>");
            out.println("<a href='index.html' class='btn'>Go Back</a>");
            out.println("</div></body></html>");
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

        out.println("<h2>🎉 Registration Successful</h2>");

        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");

        out.println("<p><strong>Selected Sessions:</strong></p>");
        out.println("<ul>");
        for (String session : sessions) {
            out.println("<li>" + session + "</li>");
        }
        out.println("</ul>");

        out.println("<p class='total'>Total Cost: ₹" + totalCost + "</p>");

        out.println("<a href='index.html' class='btn'>Register Another</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}