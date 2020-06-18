<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
  <h1>Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
   <tr>
     <td>id</td>
     <td><input type="text" name="id" /></td>
    </tr>
    <tr>
     <td>name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>sername</td>
     <td><input type="text" name="sername" /></td>
    </tr>
    <tr>
     <td>email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>address</td>
     <td><input type="text" name="address" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>