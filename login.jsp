<%@page import="java.awt.Window"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 					styling starts here                   -->

<style type="text/css">.container{


.frm input{
margin-left:10px;
margin-top: 30%;
}
.frm {
margin-left: 25px;}


</style>
</head>





<body>
<div class="container">
	<div class="frm">
		<form class="loginn" action="" method="post">
            <label>Email :</label>  <input type="email" name="email" id="email">
            <br><br>
            <label>Password :</label><input type="password" name="pass" id="pass">
            <br><br>
            <input type="submit" value="Login">
            
		</form>
	</div>
</div>

<%
String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pes","root","");
                PreparedStatement ps = con.prepareStatement("select * from user where eid=? and password=?");
                ps.setString(1, email);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    out.println("Logged in success");
                    response.sendRedirect("index.jsp");
                }
                else{
                    out.println("Username or Password Incorrect");
                }
                
                
                
                
                
                
                
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }%>
        
       
</body>
</html>