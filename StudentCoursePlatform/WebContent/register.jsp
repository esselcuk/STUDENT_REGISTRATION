<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="resources/css/register.css">
<title>Insert title here</title>
<script>
	function addRow(tableID,ccode,name,status,credit){
		var table = document.getElementById(tableID);

		var rowCount=table.rows.lenght;
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);

		cell1.innerHTML=ccode;
		cell1.innerHTML+="<input type='hidden' class='input-field' name='adress' value="+ ccode+ " />"

		var cell2 = row.insertCell(1);
		cell2.innerHTML=name;
		var cell3 = row.insertCell(2);
		cell3.innerHTML=status;
		var cell4 = row.insertCell(3);
		cell4.innerHTML=credit;
		var cell5=row.insertCell(4);
		cell5.innerHTML="<input type ='button' value='Delete Course' onclick='delRow(this)'/>";	
	
	
		
	}

		function delRow(i){
			
			var j = i.parentNode.parentNode.rowIndex;
			document.getElementById('dataTable').deleteRow(j);
			table.deleteRow(i);
			
		}
</script>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/courses"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="info">
select t1.user_id,t1.first_name,t1.last_name,t3.faculty_name,t4.department_name
from t_user t1, t_university t2,t_dic_faculty t3,t_dic_department t4
where t1.user_id = t2.user_id and t4.department_id = t2.department
and t3.faculty_id = t2.faculty and t1.user_id = ?
<sql:param value='${sessionScope.userid}'/>
</sql:query>

<sql:query dataSource="${snapshot}" var="course">
select * from t_course where course_status='1'

</sql:query>

<table cellspacing='0' width="95%" align="center"> <!-- cellspacing='0' is important, must stay -->
	<!-- Table Header -->
	<thead>
		<tr >
			<th>Name</th>
			<th>Surname</th>
			<th>Student Number</th>
			<th>Faculty</th>
			<th>Department</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<c:forEach var="row" items="${info.rows}">
		<tr>
			<td>${row.user_id}</td>
			<td>${row.first_name}</td>
			<td>${row.last_name}</td>
			<td>${row.faculty_name}</td>
			<td>${row.department_name}</td>
		</tr><!-- Table Row -->
</c:forEach>
	</tbody>
	<!-- Table Body -->
</table>
<span > Available Courses </span>
<table cellspacing='0' width="95%" align="center"> <!-- cellspacing='0' is important, must stay -->
	<!-- Table Header -->
	<thead>
		<tr >
			<th>Course Code </th>
			<th>Course Name</th>
			<th>Course Status</th>
			<th>Course Credit</th>
			<th>Operation</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<c:forEach var="row" items="${course.rows}">
		<tr>
			<td>${row.course_code}</td>
			<td>${row.course_name}</td>
			<td>${row.course_status}</td>
			<td>${row.course_credit}</td>
			<td><input type="button" value ="Add Course" onClick="addRow('dataTable','${row.course_code}','${row.course_name}','${row.course_status}','${row.course_credit}')"/></td>
		</tr><!-- Table Row -->
</c:forEach>
	</tbody>
	<!-- Table Body -->
</table>
<span > Added Courses </span>
<form action="AddCoursesServlet" method="post">	<tbody>
<table cellspacing='0' width="95%" align="center" id="dataTable"> <!-- cellspacing='0' is important, must stay -->
	<!-- Table Header -->
	<thead>
		<tr >
			<th>Course Code </th>
			<th>Course Name</th>
			<th>Course Status</th>
			<th>Course Credit</th>
			<th>Operation</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->

	
	</tbody>
	<!-- Table Body -->


</table>	
	<label><span>&nbsp;</span><input type="submit" value="Send to Approve" /></label>
</form>


</body>
</html>