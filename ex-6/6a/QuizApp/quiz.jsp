<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #4e73df, #6f42c1);
            margin:0;
            padding:0;
        }

        .container{
            width:800px;
            margin:40px auto;
            background:white;
            padding:30px;
            border-radius:12px;
            box-shadow:0 10px 25px rgba(0,0,0,0.2);
        }

        h2{
            text-align:center;
            color:#4e73df;
            margin-bottom:30px;
        }

        .question-box{
            background:#f8f9fc;
            padding:20px;
            margin-bottom:20px;
            border-radius:10px;
            border-left:5px solid #4e73df;
        }

        .question{
            font-size:18px;
            font-weight:bold;
            margin-bottom:15px;
            color:#333;
        }

        .option{
            margin:10px 0;
            font-size:16px;
        }

        input[type=radio]{
            margin-right:10px;
        }

        .btn{
            width:100%;
            padding:14px;
            background:#4e73df;
            color:white;
            border:none;
            border-radius:8px;
            font-size:18px;
            cursor:pointer;
            margin-top:20px;
        }

        .btn:hover{
            background:#2e59d9;
        }

        .top-bar{
            display:flex;
            justify-content:space-between;
            margin-bottom:20px;
            color:#555;
            font-weight:bold;
        }
    </style>
</head>

<body>

<%
if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<div class="container">

    <div class="top-bar">
        <span>Welcome, <%= session.getAttribute("user") %></span>
        <span>Online Quiz Examination</span>
    </div>

    <h2>Online Quiz</h2>

    <form action="result.jsp" method="post">

<%
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/quizdb","root","D@niel1805");

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("SELECT * FROM questions");

while(rs.next()){
%>

        <div class="question-box">

            <div class="question">
                Q<%= rs.getInt("id") %>.
                <%= rs.getString("question") %>
            </div>

            <div class="option">
                <input type="radio"
                       name="q<%=rs.getInt("id")%>"
                       value="<%=rs.getString("option1")%>">

                <%=rs.getString("option1")%>
            </div>

            <div class="option">
                <input type="radio"
                       name="q<%=rs.getInt("id")%>"
                       value="<%=rs.getString("option2")%>">

                <%=rs.getString("option2")%>
            </div>

            <div class="option">
                <input type="radio"
                       name="q<%=rs.getInt("id")%>"
                       value="<%=rs.getString("option3")%>">

                <%=rs.getString("option3")%>
            </div>

            <div class="option">
                <input type="radio"
                       name="q<%=rs.getInt("id")%>"
                       value="<%=rs.getString("option4")%>">

                <%=rs.getString("option4")%>
            </div>

        </div>

<%
}

rs.close();
st.close();
con.close();
%>

        <input type="submit" value="Submit Quiz" class="btn">

    </form>

</div>

</body>
</html>