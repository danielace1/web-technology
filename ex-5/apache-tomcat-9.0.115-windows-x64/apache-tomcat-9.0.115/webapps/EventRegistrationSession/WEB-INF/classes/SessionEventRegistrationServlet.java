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

        int age = 0;
        int totalCost = 0;

        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {
            age = 0;
        }

        HttpSession session = request.getSession();
        ArrayList<String> attendees = (ArrayList<String>) session.getAttribute("attendees");

        if (attendees == null) {
            attendees = new ArrayList<>();
        }

        // ===== HTML START =====
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Registration Result</title>");

        // ===== CSS =====
        out.println("<style>");
        out.println("body { font-family: Arial; background: linear-gradient(to right, #667eea, #764ba2); margin:0; }");

        out.println(
                ".container { max-width: 700px; margin: 50px auto; background: #fff; padding: 30px; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2);}");

        out.println("h2 { text-align:center; color: #28a745; margin-bottom: 20px; }");

        out.println(
                ".error { color: #e63946; background:#ffe5e5; padding:12px; border-radius:8px; text-align:center; margin-bottom:15px;}");

        out.println(".info { color:#333; margin-bottom:10px; }");

        out.println("ul { list-style:none; padding:0; }");

        out.println("li { background:#f1f5ff; margin:10px 0; padding:12px; border-radius:10px; }");

        out.println(
                ".btn { display:inline-block; padding:12px 18px; margin-top:20px; background:#667eea; color:white; text-decoration:none; border-radius:8px; font-weight:bold; transition:0.3s;}");

        out.println(".btn:hover { background:#5a67d8; }");

        out.println(".center { text-align:center; }");

        out.println("</style>");

        out.println("</head><body>");
        out.println("<div class='container'>");

        // ===== VALIDATION =====

        if (sessions == null || sessions.length == 0) {
            out.println("<div class='error'>⚠ Please select at least one session.</div>");
            out.println("<div class='center'><a class='btn' href='index.html'>Go Back</a></div>");
            out.println("</div></body></html>");
            return;
        }

        if (name == null || email == null || name.trim().isEmpty() || email.trim().isEmpty()) {
            out.println("<div class='error'>⚠ Name and Email are required.</div>");
            out.println("<div class='center'><a class='btn' href='index.html'>Go Back</a></div>");
            out.println("</div></body></html>");
            return;
        }

        // ===== DUPLICATE CHECK =====
        for (String a : attendees) {
            if (a.contains(email)) {
                out.println("<div class='error'>⚠ Email already registered.</div>");
                out.println("<div class='center'><a class='btn' href='index.html'>Go Back</a></div>");
                out.println("</div></body></html>");
                return;
            }
        }

        // ===== COST CALCULATION =====
        for (String s : sessions) {

            if (s.equals("Technical Workshop")) {
                if (age < 18) {
                    out.println("<div class='error'>⚠ Technical Workshop requires age 18+</div>");
                    out.println("<div class='center'><a class='btn' href='index.html'>Go Back</a></div>");
                    out.println("</div></body></html>");
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

        // ===== STORE DATA =====
        String attendeeInfo = "👤 " + name + " | 📧 " + email + " | 💰 ₹" + totalCost;
        attendees.add(attendeeInfo);
        session.setAttribute("attendees", attendees);

        // ===== SUCCESS OUTPUT =====
        out.println("<h2>✅ Registration Successful</h2>");

        out.println("<p class='info'><strong>Name:</strong> " + name + "</p>");
        out.println("<p class='info'><strong>Email:</strong> " + email + "</p>");
        out.println("<p class='info'><strong>Total Cost:</strong> ₹" + totalCost + "</p>");

        out.println("<h3>📋 Attendees List</h3>");
        out.println("<ul>");

        for (String a : attendees) {
            out.println("<li>" + a + "</li>");
        }

        out.println("</ul>");

        out.println("<div class='center'>");
        out.println("<a class='btn' href='index.html'>➕ Add Another</a>");
        out.println("</div>");

        out.println("</div></body></html>");
    }
}