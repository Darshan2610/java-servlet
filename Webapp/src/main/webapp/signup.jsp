<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="" method="post">
		Name : <input type="text" name="name" id="name"> <br>
		<br> Email :<input type="text" name="email" id="email"> <br>
		<br> Phone Number : <input type="text" name="phone" id="phone">
		<br>
		<br> Password : <input type="password" name="pass" id="pass">
		<br>
		<br> <input type="submit" value="Register"> <br>
		

	</form>
	<br> <a href="login.jsp">Already Have account? Click Here</a>
	<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String pass = request.getParameter("pass");

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pes", "root", "");
		PreparedStatement ps = con.prepareStatement("insert into user(name,eid,phone,password) values(?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, phone);
		ps.setString(4, pass);

		int i = ps.executeUpdate();

		if (i > 0) {
			out.println("<script>alert('Inserted Success')</script>");
			
		}

	} catch (Exception ex) {
		ex.printStackTrace();
	}
	%>

</body>

</html>