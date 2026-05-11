<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
<head>
<title>Student Details</title>

<style>
body {
  font-family: Arial;
  background: #f4f6f8;
}

h2 {
  text-align: center;
  color: #0d6efd;
}

table {
  border-collapse: collapse;
  width: 80%;
  margin: auto;
  background: white;
}

th, td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}

th {
  background: #0d6efd;
  color: white;
}

.student-box {
  margin-bottom: 30px;
}
</style>

</head>

<body>

<h2>Student Information</h2>

<xsl:for-each select="students/student">

<div class="student-box">

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Department</th>
<th>Semester</th>
</tr>

<tr>
<td><xsl:value-of select="id"/></td>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="department"/></td>
<td><xsl:value-of select="semester"/></td>
</tr>
</table>

<br/>

<table>
<tr>
<th>Subject</th>
<th>Marks</th>
</tr>

<xsl:for-each select="subjects/subject">
<tr>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="marks"/></td>
</tr>
</xsl:for-each>

</table>

</div>

</xsl:for-each>

</body>
</html>

</xsl:template>
</xsl:stylesheet>