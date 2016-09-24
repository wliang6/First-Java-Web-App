<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <!-- redirecting the LoginServlet to the JSP file (this file) -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Website from JSP</title>
</head>

<%-- <!--  below are scriplets in Java. NOT RECOMMENDED to have scriplets in JSP files as it is for user view purpose -->
<%
System.out.println(request.getParameter("name"));
Date date = new Date();
%>

<div>Current date is <%=date %></div> --%>
<body>
<h1>My First JSP </h1>
<%-- My name is: ${name} <!--  this expression language accesses the attribute -->
<br>
My password is: ${password} --%>
<p><font color="red">${errorMessage}</font></p>
<form action="/login.do" method="post">
	Enter your name. <input type="text" name="name"/>
	<br>
	Enter your password. <input type="text" name="password"/> <input type="submit" value="Submit"/>
</form>
</body>
</html>

<!--  Valid user -> we will send him to welcome.jsp -->
<!--  Invalid user -> we will send him back to login.jsp -->