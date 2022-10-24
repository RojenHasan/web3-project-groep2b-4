<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Users</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="projectsOverview"/>
</jsp:include>

<main class="container">
    <h3>Project overview</h3>
    <table class="table">
        <tr>
            <th>Project id</th>
            <th>Name</th>
            <th>Team</th>
            <th>Start</th>
            <th>End</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="project" items="${allProjects}">
            <tr>
                <td>${project.projectid}</td>
                <td>${project.name}</td>
                <td>${project.team}</td>
                <td>${project.start}</td>
                <td>${project.end}</td>
                <td><a id="edit${project.userid}" href="Controller?command=Edit&id=${project.userid}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
                <td class="btn-delete"><a href="Controller?command=Delete&id=${project.userid}" ><i class="fa fa-trash" aria-hidden="true"></i>
                </a></td>

            </tr>
        </c:forEach>

    </table>
</main>

</body>
</html>
