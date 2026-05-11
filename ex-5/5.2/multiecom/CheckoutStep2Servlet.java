import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckoutStep2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String postal = request.getParameter("postal");

        String card = request.getParameter("card");
        String expiry = request.getParameter("expiry");

        out.println("<html><body>");

        // Card validation
        if (!card.matches("[0-9]{16}")) {
            out.println("<h3>Invalid Credit Card Number!</h3>");
            return;
        }

        // Expiry validation
        if (!expiry.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
            out.println("<h3>Invalid Expiry Date!</h3>");
            return;
        }

        out.println("<h2>Order Placed Successfully!</h2>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("<p>Postal Code: " + postal + "</p>");

        out.println("<h3>Payment Successful</h3>");

        out.println("</body></html>");
    }
}