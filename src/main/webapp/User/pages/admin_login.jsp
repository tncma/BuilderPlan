<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<s:form action="loginCheck" method="post">
 
	<s:textfield key="name" />
	<s:textfield key="password" />
	   <s:submit key="submit" name="submit" />
 
</s:form>
</body>
</html>