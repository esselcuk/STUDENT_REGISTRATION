<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="resources/css/updateinformation.css">

<title>Education Information</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="education">
SELECT * from t_education  where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>
<div class="form-style-2">
<div class="form-style-2-heading">Education Information</div>
<form action="UpdateEducationServlet" method="post">
<c:forEach var="row" items="${education.rows}">
<label for="field1"><span>High School Name <span class="required">*</span></span><input type="text" class="input-field" name="schoolname" value="${row.h_sch_name}" /></label>
<label><span>High School Type<span class="required">*</span></span> <select name="schooltype" class="select-field">
<option value="1" ${row.h_sch_type=='1' ? 'selected' : '' } >Fen Lisesi</option>
<option value="2" ${row.h_sch_type=='2' ? 'selected' : '' }  >Anadolu Lisesi</option>
<option value="3" ${row.h_sch_type=='3' ? 'selected' : '' }  >Meslek Lisesi</option>
<option value="4" ${row.h_sch_type=='4' ? 'selected' : '' } >Others</option>

</select></label>
<label for="field1"><span>High School City <span class="required">*</span></span><input type="text" class="input-field" name="schoolcity" value="${row.h_sch_city}" /></label>
<label for="field1"><span>Graduation Year <span class="required">*</span></span><input type="text" class="input-field" name="graduationyear" value="${row.grad_year}" /></label>
<label><span>Foreign Language<span class="required">*</span></span> <select name="language" class="select-field">
<option value="Turkish" ${row.f_lang=='Turkish' ? 'selected' : '' } >Turkish</option>
<option value="German" ${row.f_lang=='German' ? 'selected' : '' }  >German</option>
<option value="English" ${row.f_lang=='English' ? 'selected' : '' }  >English</option>
<option value="Others" ${row.f_lang=='Others' ? 'selected' : '' } >Others</option>

</select></label>

<label><span>&nbsp;</span><input type="submit" value="Update" /></label>
</c:forEach>
</form></div>
</body>
</html>