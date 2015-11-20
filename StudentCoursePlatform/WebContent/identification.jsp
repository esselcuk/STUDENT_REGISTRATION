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
 
<sql:query dataSource="${snapshot}" var="identify">
SELECT * from t_identification_card where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<sql:query dataSource="${snapshot}" var="place">
SELECT * from t_place where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<sql:query dataSource="${snapshot}" var="family">
SELECT * from t_family where user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>
 <span id="message" style="color:red;font-weight:bold"><%
    if (null!=request.getAttribute("updateMessage"))
    {
  		out.println(request.getAttribute("updateMessage"));
    } %>
    </span>
 <div class="form-style-2">
<div class="form-style-2-heading">Identification Information</div>
<form action="UpdateIdentificationServlet" method="post">
<c:forEach var="row" items="${identify.rows}">

<label for="field1"><span>ID <span class="required">*</span></span><input type="text" class="input-field" name="id" value="${row.user_id}" /></label>
<label for="field2"><span>Gender <span class="required">*</span></span><select name="gender" class="select-field">
<option value="Male" ${row.gender=='Male' ? 'selected' : '' } >Male</option>
<option value="Female" ${row.gender=='Female' ? 'selected' : '' } >Female</option>
</select></label>
<label><span>Nationality<span class="required">*</span></span> <select name="nationality" class="select-field">
<option value="Turkish" ${row.nationality=='Turkish' ? 'selected' : '' } >Turkish</option>
<option value="German" ${row.nationality=='German' ? 'selected' : '' }  >German</option>
<option value="English" ${row.nationality=='English' ? 'selected' : '' }  >English</option>
<option value="Others" ${row.nationality=='Others' ? 'selected' : '' } >Others</option>

</select></label>
<label for="field1"><span>Birth Date<span class="required">*</span></span><input type="text" class="select-field" name="birthdate" value="${row.birthdate}" /></label>
<label for="field2"><span>Religion <span class="required">*</span></span><select name="religion" class="select-field">
<option value="Muslim" ${row.religion=='Muslim' ? 'selected' : '' }>Muslim</option>
<option value="Others" ${row.religion=='Others' ? 'selected' : '' }>Others</option>
</select></label>
<label for="field2"><span>Blood Type <span class="required">*</span></span><select name="bloodtype" class="select-field">
<option value="General Question">A Rh(-)</option>
<option value="A Rh(+)" ${row.blood_type=='A Rh(+)' ? 'selected' : ''}>A Rh(+)</option>
<option value="B Rh(-)" ${row.blood_type=='B Rh(-)' ? 'selected' : ''}>B Rh(-)</option>
<option value="B Rh(+)" ${row.blood_type=='B Rh(-)' ? 'selected' : ''}>B Rh(+)</option>
<option value="AB Rh(+)" ${row.blood_type=='AB Rh(+)' ? 'selected' : ''} >AB Rh(+)</option>
<option value="AB Rh(-)" ${row.blood_type=='AB Rh(-)' ? 'selected' : ''}>AB Rh(-)</option>
<option value="0 Rh(+)" ${row.blood_type=='0 Rh(+)' ? 'selected' : ''}>0 Rh(+)</option>
<option value="0 Rh(-)" ${row.blood_type=='0 Rh(-)' ? 'selected' : ''}>0 Rh(-)</option>
</select></label>
<br><br><br><br>
</c:forEach>

<div class="form-style-2-heading">Place Information</div>

<c:forEach var="row2" items="${place.rows}">
<label for="field1"><span>Province <span class="required">*</span></span><input type="text" class="input-field" name="province" value="${row2.province}" /></label>
<label for="field1"><span>Sub Province <span class="required">*</span></span><input type="text" class="input-field" name="subprovince" value="${row2.subprovince}" /></label>

<label for="field1"><span>Village <span class="required">*</span></span><input type="text" class="input-field" name="village" value="${row2.village}" /></label>

<label for="field1"><span>Registration No <span class="required">*</span></span><input type="text" class="input-field" name="registration_no" value="${row2.registration_no}" /></label>
<label for="field1"><span>Family No <span class="required">*</span></span><input type="text" class="input-field" name="family_no" value="${row2.family_no}" /></label>

<label for="field1"><span>Order No <span class="required">*</span></span><input type="text" class="input-field" name="order_no" value="${row2.order_no}" /></label>

<br><br><br><br>

</c:forEach>
<div class="form-style-2-heading">Family Information</div>
<c:forEach var="row3" items="${family.rows}">
<label for="field1"><span>Mothers Name <span class="required">*</span></span><input type="text" class="input-field" name="mother_name" value="${row3.mother_name}" /></label>
<label for="field1"><span>Fathers Name <span class="required">*</span></span><input type="text" class="input-field" name="father_name" value="${row3.father_name}" /></label>
<label for="field1"><span>Mothers Job <span class="required">*</span></span><input type="text" class="input-field" name="mother_job" value="${row3.mother_job}" /></label>

<label for="field1"><span>Fathers Job <span class="required">*</span></span><input type="text" class="input-field" name="father_job" value="${row3.father_job}" /></label>

<label><span>&nbsp;</span><input type="submit" value="Update" /></label>
</c:forEach>
</form>

</div>
</body>
</html>