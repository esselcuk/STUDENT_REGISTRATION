<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Information Info</title>
 <link rel="stylesheet" href="resources/css/updateinformation.css">
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="company">
SELECT * from t_job where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<div class="form-style-2">
<div class="form-style-2-heading">Job Information</div>
<form action="UpdateJobInfoServlet" method="post">
<c:forEach var="row" items="${company.rows}">
<label for="field1"><span>Company Name <span class="required">*</span></span><input type="text" class="input-field" name="companyname" value="${row.company_name}" /></label>
<label for="field1"><span>Position <span class="required">*</span></span><input type="text" class="input-field" name="position" value="${row.position}" /></label>
<label for="field1"><span>Adress <span class="required">*</span></span><input type="text" class="input-field" name="adress" value="${row.adress}" /></label>
<label for="field1"><span>Phone <span class="required">*</span></span><input type="text" class="input-field" name="phone" value="${row.phone}" /></label>

<label><span>&nbsp;</span><input type="submit" value="Update" /></label>
</c:forEach>
</form>
</body>
</html>