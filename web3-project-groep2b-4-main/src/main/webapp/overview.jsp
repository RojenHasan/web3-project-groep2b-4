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
  <jsp:param name="actual" value="Overview"/>
</jsp:include>

<main class="container">
  <h3>User overview</h3>
  <table class="table">
    <tr>
      <th>User id</th>
      <th>Email</th>
      <th>First name </th>
      <th>Last name</th>
      <th>Team</th>
      <th>Role</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">
      <tr>
        <td>${user.userid}</td>
        <td>${user.firstname}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>

        <td>${user.team}</td>
        <td>${user.role}</td>
        <td><a id="edit${user.userid}" href="Controller?command=Edit&id=${user.userid}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
        <td class="btn-delete"><a href="Controller?command=Delete&id=${user.userid}" ><i class="fa fa-trash" aria-hidden="true"></i>
        </a></td>

      </tr>
    </c:forEach>

  </table>
</main>

</body>
</html>
