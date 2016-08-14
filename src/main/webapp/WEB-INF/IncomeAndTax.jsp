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
		    width: 50%;
		    margin: 0 auto;
		}
	</style>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper" >


<!--  <h1> ${msg} </h1>-->
<h3>Enter your income, we calculate tax for you </h3>


<form action="calculateTax" method ="get">
<b>[3]wage:&nbsp&nbsp</b> <input type="text" name = "wage" value="50000">
	<br><br>
<b>[4]taxable_refunds:&nbsp&nbsp</b> <input type="text" name = "taxable_refunds" value="15000">
	<br><br>
<b>[5]scholarship :&nbsp&nbsp</b> <input type="text" name = "scholarship" value="20000">
	<br><br>
	
<b>[6]treaty:&nbsp&nbsp</b> <input type="text" name = "treaty" value="5000">
	<br><br>
<b>treaty_type:&nbsp&nbsp</b> <input type="text" name = "treaty_type" value="C">
	<br><br>
<b>[11]itemized_deduction:&nbsp&nbsp</b> <input type="text" name = "itemized_deduction" value="4000">
	<br><br>
	
<b>[13]exemption:&nbsp&nbsp</b> <input type="text" name = "exemption" value="3950">
	<br><br>
	
<b>[18a]federal_withheld_W2:&nbsp&nbsp</b> <input type="text" name = "federal_withheld_W2" value="13000">
	<br><br>
<b>[18b]federal_withheld_1042S:&nbsp&nbsp</b> <input type="text" name = "federal_withheld_1042S" value="12000">
	<br><br>
<b>[19]return_of_2013:&nbsp&nbsp</b> <input type="text" name = "return_of_2013" value="2000">
	<br><br>
<b>[20]credit_1040C:&nbsp&nbsp</b> <input type="text" name = "credit_1040C" value="50">
	<br><br>
<input type="submit" class="btn btn-primary" value="Calculate">
  
</form>
</div>
</body>
</html>