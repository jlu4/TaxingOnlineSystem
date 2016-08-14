<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		#wrapper {
		    width: 50%;
		    margin: 0 auto;
		}
	</style>
<title>Enter Your Person Info</title>
</head>
<body>
<div id="wrapper" >
	<div style="text-align:center;">
	<h2> ${step1} </h2>
	---<b>Step1</b>---Step2---Step3---
	
	<br><br>
	
	<form action="confirm_person_info.html" method = "post">
	
	---------->&nbsp<b>First Name:&nbsp&nbsp</b> <input type="text" name = "firstname" value="Kobe">
	<br><br>
	---------->&nbsp<b>Last Name:&nbsp&nbsp</b> <input type="text" name = "lastname" value="Bryant">
	<br><br>
	------->&nbsp<b>Identifying &#8470:&nbsp&nbsp</b> <input type="text" name = "id_num" value="SSN or ITIN">
	<br><br>
	----->&nbsp<b>Home Address:&nbsp&nbsp</b> <input type="text" name = "home_addr" value="123 Broad Way, Apt 456">
	<br><br>
	<b>City/State PostCode:&nbsp&nbsp</b> <input type="text" name = "city_state_zip" value="Jersey City,NJ 07307">
	<br><br>
	-----><b>Foreign Country:&nbsp&nbsp</b> <input type="text" name = "country" value="China">
	<br><br>
	----><b>Foreign Province:&nbsp&nbsp</b> <input type="text" name = "province" value="Hubei">
	<br><br>
	----><b>Foreign ZipCode:&nbsp&nbsp</b> <input type="text" name = "zipcode" value="430074">
	<br><br>
	<b>&nbsp [1]Single Non Resident Alien</b>&nbsp&nbsp&nbsp<input type="radio" name="isSingle" value="1" checked="checked"><br>
	<b>&nbsp [2]Married Non-resident Alien</b>&nbsp&nbsp<input type="radio" name="isSingle" value="2">
	<br><br>
	
	<input type="submit" class="btn btn-primary" value="Review Person Info">
	<hr>${path}</hr>
	<br>
	<br>	
	</form>
	</div>
</div>
</body>
</html>