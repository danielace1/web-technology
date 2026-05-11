<%@ page language="java" %>

<html>
  <head>
    <title>Student Login</title>

    <style>
      body {
        font-family: Arial;
        background: #f4f6f8;
      }

      .box {
        width: 350px;
        margin: 100px auto;
        background: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px gray;
      }

      h2 {
        text-align: center;
        color: #0d6efd;
      }

      input {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
      }

      button {
        width: 100%;
        padding: 10px;
        margin-top: 15px;
        background: #0d6efd;
        color: white;
        border: none;
      }
    </style>
  </head>

  <body>
    <div class="box">
      <h2>Student Login</h2>

      <form action="result.jsp" method="post">
        Roll No:
        <input type="text" name="roll" required />

        Password:
        <input type="password" name="pass" required />

        <button type="submit">Login</button>
      </form>
    </div>
  </body>
</html>
