import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class RegistrationServlet extends HttpServlet {

    private static Set<String> usernames = new HashSet<>();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        out.println("<html><body>");

        // Username uniqueness
        if (usernames.contains(username)) {
            out.println("<h3>Username already exists!</h3>");
            return;
        }

        // Email validation
        if (!email.contains("@") || !email.contains(".")) {
            out.println("<h3>Invalid Email Format!</h3>");
            return;
        }

        // Password strength
        if (password.length() < 6) {
            out.println("<h3>Password must contain minimum 6 characters!</h3>");
            return;
        }

        // Password match
        if (!password.equals(confirm)) {
            out.println("<h3>Password does not match!</h3>");
            return;
        }

        usernames.add(username);

        out.println("<h2>Registration Successful!</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("</body></html>");
    }
}