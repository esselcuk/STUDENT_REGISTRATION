<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>

        <link rel="stylesheet" href="resources/css/login.css">
<title>Login the System</title>
<script>
function validateForm(){
	var x =document.myForm.un;
	var y =document.myForm.pass;
	if((x.value == null || x.value=="") || (y.value==null||y.value=="")){
		
		alert("User ID and Password must not be empty");
		return false;
	}
	
}

</script>
</head>
<body>

<div class="login-card">
    <h3 text-align="center">Log-in to ON-LINE</h3><br>
  <form action="LoginServlet" onsubmit="return validateForm();" name="myForm">
    <input type="text" name="un" placeholder="Username">
    <input type="password" name="pass" placeholder="Password">
    <input type="submit" name="OK" class="login login-submit" value="login">
    <input type="reset" value="Reset" id="login">
  </form>
    <span style="color:red;font-weight:bold"><%
    if (null!=request.getAttribute("errorMessage"))
    {
  		out.println(request.getAttribute("errorMessage"));
    } %>
    </span>
  <div class="login-help">
    
  </div>
</div>
</body>
</html>