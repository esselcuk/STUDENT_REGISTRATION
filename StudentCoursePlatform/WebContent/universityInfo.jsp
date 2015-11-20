<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="resources/css/updateinformation.css">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="university">
SELECT * from t_university   where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>
<div class="form-style-2">
<div class="form-style-2-heading">Education Information</div>
<form action="UpdateUniversityInfoServlet" method="post">
<c:forEach var="row" items="${university.rows}">
<label><span>Institute Faculty<span class="required">*</span></span> <select name="faculty" class="select-field">
<option value="1" ${row.faculty=='1' ? 'selected' : '' } >Faculty of Engineering</option>
<option value="2" ${row.faculty=='2' ? 'selected' : '' }  >Faculty of X</option>
<option value="3" ${row.faculty=='3' ? 'selected' : '' }  >Faculty of Y</option>
<option value="4" ${row.faculty=='4' ? 'selected' : '' } >Others</option>

</select></label>
<label><span>Department<span class="required">*</span></span> <select name="department" class="select-field">
<option value="1" ${row.department =='1' ? 'selected' : '' } >Computer Engineering</option>
<option value="2" ${row.department =='2' ? 'selected' : '' }  >Electricity Engineering</option>
<option value="3" ${row.department =='3' ? 'selected' : '' }  >Pyshic Engineering</option>
<option value="4" ${row.department =='4' ? 'selected' : '' } >Others</option>

</select></label>
<label for="field1"><span>Entry Year <span class="required">*</span></span><input type="text" class="input-field" name="entryyear" value="${row.entry_year}" /></label>
<label for="field1"><span>Exit Year <span class="required">*</span></span><input type="text" class="input-field" name="exityear" value="${row.exit_year}" /></label>

<label><span>&nbsp;</span><input type="submit" value="Update" /></label>
</c:forEach>
</form></div>
</body>
</html>