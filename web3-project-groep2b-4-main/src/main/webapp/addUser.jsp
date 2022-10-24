<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Add user</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value="AddUser"/>
</jsp:include>
<main class="container">


<h3>Register User</h3>

<div>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form action="Controller?command=AddUser" method="post" class="form-container">
        <label for="firstname">Firstname</label>
        <input type="text" id="firstname" name="firstname" placeholder="Your name.."
               value="${firstnamePreviousValue}" class="${firstnameClass eq "hasError"? 'error' : ''}">

        <label for="lastname">Lastname</label>
        <input type="text" id="lastname" name="lastname" placeholder="Your last name.."
               value="${lastnamePreviousValue}" class="${lastnameClass eq "hasError"? 'error' : ''}">

        <label for="email">Email</label>
        <input type="text" id="email" name="email" placeholder="Your email.."
               value="${emailPreviousValue}" class="${emailClass eq "hasError"? 'error' : ''}">

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Your password.."
               class="${passwordClass eq "hasError"? 'error' : ' '}">

        <label for="team">Team</label>
        <select id="team" name="team">
            <option value="alpha">alpha</option>
            <option value="beta">beta</option>
            <option value="gamma">gamma</option>
            <option value="delta">delta</option>
            <option value="epsilon">epsilon</option>
        </select>
        <!--
        <label for="role">Role</label>
        <select id="role" name="role">
            <option value="director">director</option>
            <option value="teamleader">teamleader</option>
            <option value="employee">employee</option>
        </select>-->

        <input type="submit" value="Submit" id="submit">

    </form>
</div>
</main>
</body>
</html>
