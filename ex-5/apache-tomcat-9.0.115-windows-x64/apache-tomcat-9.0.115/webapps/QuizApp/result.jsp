<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #4e73df, #6f42c1);
            margin:0;
            padding:0;
        }

        .container{
            width:500px;
            margin:100px auto;
            background:white;
            padding:40px;
            border-radius:12px;
            text-align:center;
            box-shadow:0 10px 25px rgba(0,0,0,0.2);
        }

        h2{
            color:#4e73df;
            margin-bottom:20px;
        }

        .score-box{
            background:#f8f9fc;
            padding:25px;
            border-radius:10px;
            margin-top:20px;
            border-left:5px solid #4e73df;
        }

        .score{
            font-size:40px;
            color:#28a745;
            font-weight:bold;
            margin:15px 0;
        }

        .message{
            font-size:18px;
            color:#555;
        }

        .btn{
            display:inline-block;
            margin-top:25px;
            padding:12px 25px;
            background:#4e73df;
            color:white;
            text-decoration:none;
            border-radius:8px;
            font-size:16px;
        }

        .btn:hover{
            background:#2e59d9;
        }
    </style>
</head>

<body>

<%
if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
    return;
}

int score = 0;
int totalQuestions = 0;

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/quizdb","root","D@niel1805");

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("SELECT * FROM questions");

while(rs.next()){

    totalQuestions++;

    String correct = rs.getString("answer");

    String userAns = request.getParameter(
        "q"+rs.getInt("id"));

    if(userAns != null && correct.equals(userAns)){
        score++;
    }
}

rs.close();
st.close();
con.close();
%>

<div class="container">

    <h2>Quiz Result</h2>

    <div class="score-box">

        <p class="message">
            Student: <b><%= session.getAttribute("user") %></b>
        </p>

        <p class="message">Your Score</p>

        <div class="score">
            <%= score %> / <%= totalQuestions %>
        </div>

<%
if(score == totalQuestions){
%>

        <p class="message">
            Excellent Performance!
        </p>

<%
}else if(score >= totalQuestions/2){
%>

        <p class="message">
            Good Job!
        </p>

<%
}else{
%>

        <p class="message">
            Keep Practicing!
        </p>

<%
}
%>

    </div>

    <a href="login.jsp" class="btn">
        Logout
    </a>

</div>

<%
session.invalidate();
%>

</body>
</html>