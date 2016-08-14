<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.PrintStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="com.inno.tax.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to Taxing For You</title>
	<style type="text/css">
		body {
			background-image: url('http://crunchify.com/bg.png');
		}
		table, th, td {
		    border: 1px solid black;
		    border-collapse: collapse;
		}
		th {
		    text-align: mid;
		}
		#wrapper {
		    width: 50%;
		    margin: 0 auto;
		}
	</style>
</head>
<body>
<div id="wrapper" >
	<div style="text-align:center;">
		<h1 style="color:rgb(55,123,181)">Taxing 4 You</h1>
		<h2> Please read this page before start</h2><br>
		This Web App is designed for Chinese Student only who needs to fill the 1040 NR-EZ form to get tax refund!<br>
		<br>
		<br>
		<h3>Pre-requests:(please check if you have the forms below)</h3><br>
		<table style="width:50%" align="center">
		  <tr>
		    <td><strong>Forms</strong></td>
		    <td><strong>Status</strong></td> 
		  </tr>
		  <tr>
		    <td>W-2 Form</td>
		    <td>Required</td> 
		  </tr>
		  <tr>
		    <td>1042-S Form</td>
		    <td>Not Necessary</td>
		  </tr>
		  <tr>
		    <td>1099-G Form</td>
		    <td>Not Necessary</td> 
		  </tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<form action="person_info.html" method ="get">
		<input type="submit" class="btn btn-primary" value="Click here to Start"> 
		</form> 
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		----------------All rights reserved by Fantastic 4 &copy Oct 20 2015----------------<br>
	</div>
	<% 
/* 	String strPathFile = application.getRealPath(request.getRequestURI());
	out.println("文件的绝对路径:" + strPathFile+ "<br/>"); */
	String a=request.getRequestURI(); 
	String b= application.getRealPath(request.getRequestURI()); 
	String c= application.getRealPath("/"); 
	out.println("文件的绝对路径:" + a+ "<br/>");
	out.println("文件的绝对路径:" + b+ "<br/>");
	out.println("文件的绝对路径:" + c+ "<br/>");
	out.println(System.getProperty("user.dir"));
try{
    	
	Path objPath = new Path();
	String path = objPath.getHerokuPath();
	out.println("文件的绝对路径:" + path+ "<br/>");
}catch(Exception e){
	out.print(e.getMessage());
}   
	%>
</div>
</body>
</html>


