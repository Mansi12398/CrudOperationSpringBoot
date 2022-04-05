<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="css/student.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4"><h2>Student <b>Details</b></h2></div>
                    <div class="col-sm-4">
                    	<c:if test="${role == 'A'}">
	                        <a href="addStudent">  <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button></a>
                        </c:if>
                    </div>
                    <div class="col-sm-4">
                       <a href="logout"> <button type="button" class="btn btn-info add-new">logout</button></a>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="thWidth">FirstName</th>
                        <th class="thWidth">LastName</th>
                        <th class="thWidth">UserName</th>
                        <th class="thWidth">Maths</th>
                        <th class="thWidth">English</th>
                        <th class="thWidth">Gujarati</th>
                        <th class="thWidth">Total</th>
                        <th class="thWidth">Percentage</th>
                        <c:if test="${role != 'S'}">
	                        <th class="thWidth">Action</th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                <c:when test="${role == 'A' || role == 'T'}">
               		<c:forEach var="stud" items="${studentDetails}">
	                    <tr>
						<td>${stud.firstName}</td>
						<td>${stud.lastName}</td>
						<td>${stud.userName}</td>
						<td>${stud.maths}</td>
						<td>${stud.english}</td>
						<td>${stud.gujarati}</td>
						<td>${stud.total}</td>
						<td>${stud.per}%</td>
						<td>
							<a href="updateStudent?id=${stud.studentId}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">edit</i></a> 
							<a href="deleteStudent?id=${stud.studentId}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">delete</i></a>
						</td>
					</tr>      
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.userName}</td>
						<td>${student.maths}</td>
						<td>${student.english}</td>
						<td>${student.gujarati}</td>
						<td>${student.total}</td>
						<td>${student.per}%</td>
					</tr>      
				</c:otherwise>
				</c:choose>	
                </tbody>
            </table>
        </div>
    </div>    