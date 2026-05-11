import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckoutStep1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String postal = request.getParameter("postal");

        out.println("<html><body>");

        // Phone validation
        if (!phone.matches("[0-9]{10}")) {
            out.println("<h3>Invalid Phone Number!</h3>");
            return;
        }

        // Postal validation
        if (!postal.matches("[0-9]{6}")) {
            out.println("<h3>Invalid Postal Code!</h3>");
            return;
        }

        // Forward using hidden fields
        out.println("<h2>Checkout - Step 2</h2>");

        out.println("<form action='CheckoutStep2Servlet' method='post'>");

        out.println("<input type='hidden' name='name' value='" + name + "'>");
        out.println("<input type='hidden' name='phone' value='" + phone + "'>");
        out.println("<input type='hidden' name='postal' value='" + postal + "'>");

        out.println("Credit Card Number:");
        out.println("<input type='text' name='card' required><br><br>");

        out.println("Expiry Date (MM/YY):");
        out.println("<input type='text' name='expiry' required><br><br>");

        out.println("<input type='submit' value='Place Order'>");

        out.println("</form>");

        out.println("</body></html>");
    }
}