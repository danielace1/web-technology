<%@ page import="java.sql.*" %>

<html>
<head>
<title>Student Result</title>

<style>

body{
    font-family:Arial;
    background:#f4f6f8;
}

.container{
    width:700px;
    margin:50px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
}

h2{
    text-align:center;
    color:#0d6efd;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

th,td{
    border:1px solid #ccc;
    padding:10px;
    text-align:center;
}

th{
    background:#0d6efd;
    color:white;
}

.total{
    margin-top:20px;
    font-size:20px;
    color:green;
    font-weight:bold;
}

</style>
</head>

<body>

<div class="container">

<%

String roll = request.getParameter("roll");
String pass = request.getParameter("pass");

int total = 0;

try{

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studentdb",
        "root",
        "D@niel1805"
    );

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM students WHERE roll_no=? AND password=?"
    );

    ps.setString(1, roll);
    ps.setString(2, pass);

    ResultSet rs = ps.executeQuery();

    if(rs.next()){

%>

<h2>Student Mark Details</h2>

<p><b>Name:</b> <%= rs.getString("name") %></p>
<p><b>Roll No:</b> <%= rs.getString("roll_no") %></p>

<table>

<tr>
<th>Subject</th>
<th>Marks</th>
</tr>

<%

PreparedStatement ps2 = con.prepareStatement(
"SELECT subject, marks FROM marks WHERE roll_no=?"
);

ps2.setString(1, roll);

ResultSet rs2 = ps2.executeQuery();

while(rs2.next()){

    int mark = rs2.getInt("marks");
    total += mark;

%>

<tr>
<td><%= rs2.getString("subject") %></td>
<td><%= mark %></td>
</tr>

<%
}
%>

</table>

<div class="total">
Total Marks: <%= total %>
</div>

<%

    } else {

        out.println("<h3 style='color:red;'>Invalid Login</h3>");
    }

}catch(Exception e){

    out.println(e);
}

%>

</div>

</body>
</html>