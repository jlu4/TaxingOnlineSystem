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

<h2>${refundorowe}</h2>

<form action="refundConfirm" method ="get">
	<b>[22] OverPaid:&nbsp&nbsp</b>    ${overpaid} 
	<br><br>
	<b>[23a]refund:&nbsp&nbsp</b> <input type="hidden" name = "overpaid" value= ${overpaid} >
	<b>[23a]refund:&nbsp&nbsp</b> <input type="text" name = "refund" value="10000">
	<br><br>
	<b>[23b]routing_num:&nbsp&nbsp</b> <input type="text" name = "routing_num" value="2345678">
	<br><br>
	
	<b>[23c] checking</b>&nbsp&nbsp&nbsp<input type="radio" name="checkingOrSaving" value="1" checked="checked">
	<b>&nbsp&nbsp&nbsp saving</b>&nbsp&nbsp<input type="radio" name="checkingOrSaving" value="2">
	<br><br>
	
	<b>[23d]account_num:&nbsp&nbsp</b> <input type="text" name = "account_num" value="123454338">
	<br><br>
	<b>[23e]mail_outUS_add:&nbsp&nbsp</b> <input type="text" name = "mail_outUS_add" value="please enter here">
	<br><br>
	<b>[24]tax_2015:&nbsp&nbsp</b> <input type="text" name = "tax_2015" value="2345">
	<br><br>
	<b>[25]Amount you owe:&nbsp&nbsp</b> ${owe}
	<br><br>	
	<input type="hidden" name = "owe" value= ${owe} >
	<input type="submit" class="btn btn-primary" value="Review Refund">
  
</form>
</div>
</body>
</html>