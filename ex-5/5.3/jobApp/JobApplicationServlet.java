import java.io.*;
import java.time.LocalDate;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/JobApplicationServlet")

@MultipartConfig(maxFileSize = 2 * 1024 * 1024)

public class JobApplicationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String gradyear = request.getParameter("gradyear");

        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");

        Part resume = request.getPart("resume");

        String filename = resume.getSubmittedFileName();

        out.println("<html><body>");

        // Required validation

        if (name.isEmpty() || email.isEmpty()) {
            out.println("<h3>Name and Email Required!</h3>");
            return;
        }

        // Phone validation

        if (!phone.matches("[0-9]{10}")) {
            out.println("<h3>Invalid Phone Number!</h3>");
            return;
        }

        // Graduation year validation

        int currentYear = LocalDate.now().getYear();

        if (Integer.parseInt(gradyear) > currentYear) {
            out.println("<h3>Invalid Graduation Year!</h3>");
            return;
        }

        // Date validation

        if (!startdate.isEmpty() && !enddate.isEmpty()) {

            LocalDate start = LocalDate.parse(startdate);
            LocalDate end = LocalDate.parse(enddate);

            if (end.isBefore(start)) {
                out.println("<h3>End Date must be after Start Date!</h3>");
                return;
            }
        }

        // Resume validation

        if (!filename.endsWith(".pdf")) {
            out.println("<h3>Only PDF files allowed!</h3>");
            return;
        }

        out.println("<h2>Application Submitted Successfully!</h2>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("<p>Resume Uploaded: " + filename + "</p>");

        out.println("</body></html>");
    }
}