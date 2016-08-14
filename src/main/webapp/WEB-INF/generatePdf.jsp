<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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

<%     
	out.clear();
    
    out = pageContext.pushBody();
    response.setContentType("application/pdf");
    
    
    /* String path = application.getRealPath(request.getRequestURI());
	path = path.substring(0, path.length() - 101); */
	//out.println(path);
	
    try{
    	
    	String filePath = "";
		Path objPath = new Path();
		String path = objPath.getPath();
		boolean pathFlag = objPath.getFlag();
		if (pathFlag == true){
			filePath = path + "FormFillPDF.pdf";
		}else{
			filePath = path + "FormFillPDF.pdf";
		}
    	String strpath = new String();
    	strpath = filePath;
    	File file1 = new File(strpath);
    	if (file1.exists()){
    		DataOutputStream temps = new DataOutputStream(response.getOutputStream());
    		DataInputStream in = new DataInputStream(new FileInputStream(strpath));
    		
    		byte[] b = new byte[2048];
    		while((in.read(b)) != -1){
    			temps.write(b);
    			temps.flush();
    			
    		}
    		
    		in.close();
    		temps.close();
    		
    	}else{
    		out.print("not exist");
    	}
    	
    }catch(Exception e){
    	out.print(e.getMessage());
    }   
%>

</body>
</html>