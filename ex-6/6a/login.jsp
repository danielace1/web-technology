<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Online Quiz Login</title>

    <style>
      body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #4e73df, #6f42c1);
        margin: 0;
        padding: 0;
      }

      .container {
        width: 400px;
        margin: 80px auto;
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
      }

      h2 {
        text-align: center;
        color: #4e73df;
        margin-bottom: 25px;
      }

      label {
        font-weight: bold;
        display: block;
        margin-top: 15px;
      }

      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 12px;
        margin-top: 6px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
        box-sizing: border-box;
      }

      input[type="text"]:focus,
      input[type="password"]:focus {
        border-color: #4e73df;
        outline: none;
      }

      .btn {
        width: 100%;
        padding: 12px;
        background: #4e73df;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 20px;
      }

      .btn:hover {
        background: #2e59d9;
      }

      .error {
        color: red;
        text-align: center;
        margin-top: 15px;
        font-weight: bold;
      }

      .footer {
        text-align: center;
        margin-top: 15px;
        color: #666;
        font-size: 14px;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <h2>Online Quiz Login</h2>

      <form method="post">
        <label>Username</label>
        <input type="text" name="uname" required />

        <label>Password</label>
        <input type="password" name="pass" required />

        <input type="submit" value="Login" class="btn" />
      </form>

      <% if(request.getMethod().equals("POST")){String u = request.getParameter("uname");
    String p = request.getParameter("pass");

    try{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/quizdb", "root",
        "D@niel1805");

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM users WHERE username=? AND password=?");

        ps.setString(1, u);
        ps.setString(2, p);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
          session.setAttribute("user", u); response.sendRedirect("quiz.jsp");
        }
        else {%> <p class="error">Invalid Username or Password</p> <%}
        rs.close();
        ps.close();
        con.close();

    } catch(Exception e) {
          %>
          <p class="error">Database Connection Error</p>
          <%
        }
      }
      %>

      <div class="footer">Web Technology Lab - Online Quiz System</div>
    </div>
  </body>
</html>
