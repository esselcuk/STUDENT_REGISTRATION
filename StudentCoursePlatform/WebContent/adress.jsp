<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="resources/css/updateinformation.css">
<title>Adress Information</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="adress">
SELECT * from t_adress where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<div class="form-style-2">
<div class="form-style-2-heading">Adress Information</div>
<form action="UpdateAdressServlet" method="post">
<c:forEach var="row" items="${adress.rows}">
<label for="field1"><span>Adress <span class="required">*</span></span><input type="text" class="input-field" name="adress" value="${row.adress}" /></label>
<label for="field1"><span>State <span class="required">*</span></span><input type="text" class="input-field" name="state" value="${row.state}" /></label>
<label for="field1"><span>City <span class="required">*</span></span><input type="text" class="input-field" name="city" value="${row.city}" /></label>
<label for="field1"><span>Postal Code <span class="required">*</span></span><input type="text" class="input-field" name="postalcode" value="${row.post_code}" /></label>
<label for="field1"><span>Phone <span class="required">*</span></span><input type="text" class="input-field" name="phone" value="${row.gsm_phone}" /></label>
<label for="field1"><span>Email <span class="required">*</span></span><input type="text" class="input-field" name="email" value="${row.email}" /></label>

<label><span>&nbsp;</span><input type="submit" value="Update" /></label>
</c:forEach>
</form>
</body>
</html>