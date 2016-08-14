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
<h2>Please confirm your income</h2>

<form action="refund" method ="get">
	<b>[3]wage:&nbsp&nbsp</b> ${wage}
	<br>
	<b>[4]taxable_refunds:&nbsp&nbsp</b> ${taxable_refunds}
	<br>
	<b>[5]scholarship :&nbsp&nbsp</b> ${scholarship}
	<br>
	
	<b>[6]treaty:&nbsp&nbsp</b> ${treaty}
	<br>
	<b>treaty_type:&nbsp&nbsp</b> ${treaty_type}
	<br>
	<b>[7]Add lines 3, 4, and 5:&nbsp&nbsp</b> ${num7}
	<br>
	<b>[8]Scholarship and fellowship grants excluded:&nbsp&nbsp</b> ${num8}
	<br>
	<b>[9]Student loan interest deduction:&nbsp&nbsp</b> ${num9}
	<br>
	<b>[10]adjusted gross income:&nbsp&nbsp</b> ${num10}
	<br>
	<b>[11]itemized_deduction:&nbsp&nbsp</b> ${itemized_deduction}
	<br>
	<b>[12]Subtract line 11 from line 10:&nbsp&nbsp</b> ${num12}
	<br>
	<b>[13]exemption:&nbsp&nbsp</b> ${exemption}
	<br>
	<b>[14]Taxable income.:&nbsp&nbsp</b> ${num14}
	<br><br>
	<b>[15]tax:&nbsp&nbsp</b> ${tax}
	<br><br>
	<b>[17]total tax:&nbsp&nbsp</b> ${num17}
	<br>
	<b>[18a]federal_withheld_W2:&nbsp&nbsp</b> ${federal_withheld_W2}
	<br>
	<b>[18b]federal_withheld_1042S:&nbsp&nbsp</b> ${federal_withheld_1042S}
	<br>
	<b>[19]2014 estimated tax payments and amount applied from 2013 return:&nbsp&nbsp</b> ${return_of_2013}
	<br>
	<b>[20]Credit for amount paid with Form 1040-C:&nbsp&nbsp</b> ${credit_1040C}
	<br>
	<b>[21]totalPayments:&nbsp&nbsp</b> ${totalPayments}
	<br><br>
<input type="submit" class="btn btn-primary" value="Confirm!">
  
</form>


</div>
</body>
</html>