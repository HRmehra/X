<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%

try {
Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>database da data</strong></font></h2>
<table >
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>name</b></td>
<td><b>sername</b></td>
<td><b>email</b></td>
<td><b>address</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
statement=connection.createStatement();
String sql ="SELECT * FROM person";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887"> 

<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("sername") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("address") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>