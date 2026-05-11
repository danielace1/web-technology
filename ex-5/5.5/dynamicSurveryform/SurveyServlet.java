import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SurveyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String autosave = request.getParameter("autosave");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");
        String rating = request.getParameter("rating");

        // AJAX Autosave

        if ("true".equals(autosave)) {

            out.println("<span style='color:green;'>Autosaved...</span>");

            return;
        }

        out.println("<html><body>");

        // Validation

        if (name == null || name.isEmpty()) {
            out.println("<h3>Name Required!</h3>");
            return;
        }

        if (email == null || !email.contains("@")) {
            out.println("<h3>Invalid Email!</h3>");
            return;
        }

        if (feedback == null || feedback.isEmpty()) {
            out.println("<h3>Feedback Required!</h3>");
            return;
        }

        if (rating == null) {
            out.println("<h3>Please select rating!</h3>");
            return;
        }

        out.println("<h2>Survey Submitted Successfully!</h2>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Feedback: " + feedback + "</p>");
        out.println("<p>Rating: " + rating + "</p>");

        out.println("</body></html>");
    }
}