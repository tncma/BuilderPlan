<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PART 2</title>
</head>
<body>
       <s:form action="registerComplaint" method="post">
         <s:select label="SUB-Departments" 
		headerKey="-1" headerValue="Select The SUB-Department"
		list="sub_department" 
		name="sub_dept" 
		value="XXX" />
		
		<s:textarea label="complaint" name="comp_text" cols="40" rows="10"/>
		
		<%--   <s:select label="Priority" 
		headerKey="-1" headerValue="Select The Proirity"
		list="Priority" 
		name="pri_value" 
		value="1" /> --%>
		
		
		 <s:submit key="submit" name="submit" />
		 </s:form>
</body>
</html>