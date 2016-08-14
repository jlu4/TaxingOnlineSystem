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
		th {
		    text-align: mid;
		}
		#wrapper {
		    width: 40%;
		    margin: 0 auto;
		}
	</style>
<title>Confirm your personal information</title>
</head>
<body>
<div id="wrapper" >
<div style="text-align:left;">
<h3>Confirm your personal Info</h3>
First Name: ${firstname} 
<br><br>
Last Name: ${lastname}
<br><br>
Identifying &#8470: ${id_num}
<br><br>
Home Address: ${home_addr}
<br><br>
City/State PostCode: ${city_state_zip}
<br><br>
Foreign Country: ${country}
<br><br>
Foreign Province: ${province}
<br><br>
Foreign ZipCode: ${zipcode}
<br><br>
Status: ${isSingle}
<br><br>




<form action="IncomeAndTax" method = "post">

<input type="submit" class="btn btn-primary" value="Confirm">

</form>

<br>or<br><br>

<form action="person_info.html" method = "get">

<input type="submit" class="btn btn-primary" value="Modify">

</form>
</div>
</div>
</body>
</html>