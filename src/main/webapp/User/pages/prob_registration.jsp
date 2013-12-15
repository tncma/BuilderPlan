<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROBLEM REGISTRATION</title>
</head>
<body>
<s:form action="registerProblem" method="post">
 
	<s:textfield key="name" />
	<s:textfield key="doorno" />
	<s:textfield key="street" />
	<s:textfield key="village" />
	<s:textfield key="district" />
	<s:textfield key="pincode" />
	<s:textfield key="operation" />
	<s:textfield key="gender" />
	<s:textfield key="telephone" />
		<s:textfield key="mobileno" />
	<s:textfield key="emailid" />
	<s:select label="Departments" 
		headerKey="-1" headerValue="Select The Department"
		list="department" 
		name="dept" 
		value="Education" />
	<%-- <s:textfield key="complaint_type" />
	<s:textfield key="priority" />
	<s:textfield key="subtypes" />
	<s:textfield key="complanit_text" />
	<s:textfield key="dept" /> --%>
	    <s:submit key="submit" name="submit" />
 
</s:form>
</body>
</html>