<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
    <h2>Simple Calculator</h2>

    <form action="<%= request.getContextPath() %>/calculate" method="post">
      Number 1: <input type="text" name="num1" required /><br /><br />
      Number 2: <input type="text" name="num2" required /><br /><br />

      <select name="operation">
        <option value="add">Add</option>
        <option value="sub">Subtract</option>
        <option value="mul">Multiply</option>
        <option value="div">Divide</option>
      </select>

      <br /><br />
      <input type="submit" value="Calculate" />
    </form>

    <h3>
      Result: <%= request.getAttribute("result") != null ?
      request.getAttribute("result") : "" %>
    </h3>
  </body>
</html>
