<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
  <link rel="stylesheet" href="resources/css/csr.css">
<title>CCR Information</title>

</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="semesters">
select " " as semester_name,"1" as semester_id from dual
union
select "All Semester" as semester_name,"2" as semester_id from dual
union
select t2.semester_name, t2.semester_id from t_dic_semester t2, t_student_courses t1
where t1.course_semester = t2.semester_id and t1.user_id = ? order by semester_id asc;
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<sql:query dataSource="${snapshot}" var="count">
select * from t_student_courses;
</sql:query>


<form action="ListCoursesServlet" name="myform">
<div id ="div1" >
	<label for="sel1">Select a semester to list </label> 
	<select id="sel1" class="form-control" name="options">
	<c:forEach var="semesters" items="${semesters.rows}">
	<option value="${semesters.semester_id}">${semesters.semester_name}</option>
	</c:forEach></select></div>

<div id="div2"><br> <input id="button2" type="submit" value="List Courses"/>
</div>
</form>
<c:forEach items="${courses}" var="course">

<div id="div3">
<span for="sel1"> ${course.courseSemester}</span>
<table cellspacing='0' width="95%" align="center">
<thead>
	<tr>
		<th>Course Code</th>
		<th>Course Name</th>
		<th>Course Status</th>
		<th>Course Credit</th>
		<th>Grade</th>
	</tr>
	</thead>
<tbody>

	<tr>
		<td>${course.courseCode}</td>
		<td>${course.courseName}</td>
		<td>${course.courseStatus}</td>
		<td>${course.courseCredit}</td>
		<td>${course.courseGrade}</td>
	</tr>
</tbody>
</table></div></c:forEach>


</body>
</html>