import java.io.*;
import java.time.LocalDate;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import java.util.*;

@MultipartConfig(maxFileSize = 2 * 1024 * 1024) // 2MB limit
public class SoftwareDeveloperServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gradYearStr = request.getParameter("gradYear");
        String[] skills = request.getParameterValues("skills");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        Part resumePart = request.getPart("resume");
        String fileName = resumePart.getSubmittedFileName();

        boolean error = false;

        out.println("<html><body>");

        // 1️⃣ Required validation
        if (name == null || name.isEmpty() ||
                email == null || email.isEmpty()) {

            out.println("<h3 style='color:red'>Name and Email are required!</h3>");
            error = true;
        }

        // 2️⃣ Graduation year validation
        if (gradYearStr != null && !gradYearStr.isEmpty()) {
            int gradYear = Integer.parseInt(gradYearStr);
            int currentYear = LocalDate.now().getYear();

            if (gradYear > currentYear) {
                out.println("<h3 style='color:red'>Invalid Graduation Year!</h3>");
                error = true;
            }
        }

        // 3️⃣ Date validation
        if (startDateStr != null && endDateStr != null &&
                !startDateStr.isEmpty() && !endDateStr.isEmpty()) {

            LocalDate start = LocalDate.parse(startDateStr);
            LocalDate end = LocalDate.parse(endDateStr);

            if (end.isBefore(start)) {
                out.println("<h3 style='color:red'>End Date must be after Start Date!</h3>");
                error = true;
            }
        }

        // 4️⃣ File validation
        if (fileName == null || !fileName.endsWith(".pdf")) {
            out.println("<h3 style='color:red'>Only PDF resume allowed!</h3>");
            error = true;
        }

        // 5️⃣ If no error → Save file
        if (!error) {

            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + "resumes";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();

            resumePart.write(uploadPath + File.separator + fileName);

            out.println("<h2 style='color:green'>Application Submitted Successfully!</h2>");
            out.println("<p><b>Position:</b> Software Developer – Full Stack</p>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Email:</b> " + email + "</p>");

            out.println("<p><b>Skills:</b> ");
            if (skills != null) {
                for (String s : skills) {
                    out.println(s + " ");
                }
            }
            out.println("</p>");
        }

        out.println("</body></html>");
    }
}