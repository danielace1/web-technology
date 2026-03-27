import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String products[] = request.getParameterValues("product");

        if (products != null) {

            for (String item : products) {

                Cookie c = new Cookie("cart", item);
                c.setMaxAge(60 * 60 * 24);
                response.addCookie(c);

            }

        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Shopping Cart</title>");
        out.println("<style>");
        out.println("body{font-family:Arial;background:#f4f4f4;text-align:center;}");
        out.println("table{margin:auto;border-collapse:collapse;width:50%;background:white;}");
        out.println("th,td{border:1px solid gray;padding:10px;}");
        out.println("th{background:#333;color:white;}");
        out.println("button{padding:10px 15px;background:#28a745;color:white;border:none;}");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h2>Your Shopping Cart</h2>");

        out.println("<table>");
        out.println("<tr><th>Product</th><th>Price</th></tr>");

        int total = 0;

        Cookie cookies[] = request.getCookies();

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("cart")) {

                    String item = c.getValue();
                    int price = 0;

                    if (item.equals("Laptop"))
                        price = 55000;
                    if (item.equals("Mobile"))
                        price = 25000;
                    if (item.equals("Headphones"))
                        price = 3000;
                    if (item.equals("Keyboard"))
                        price = 1500;

                    total += price;

                    out.println("<tr>");
                    out.println("<td>" + item + "</td>");
                    out.println("<td>₹" + price + "</td>");
                    out.println("</tr>");

                }

            }

        }

        out.println("<tr>");
        out.println("<th>Total</th>");
        out.println("<th>₹" + total + "</th>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<br><button>Checkout</button>");
        out.println("<br><br><a href='index.html'>Continue Shopping</a>");

        out.println("</body>");
        out.println("</html>");

    }

}