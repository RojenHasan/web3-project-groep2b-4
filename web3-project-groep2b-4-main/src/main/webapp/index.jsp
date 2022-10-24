<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeenh
  Date: 23/09/2022
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Css/style.css">


    <c:choose>
        <c:when test="${sessionScope.loggedInUser == null}">
            <title>Log in</title>
        </c:when>
        <c:otherwise>
            <title>Log out</title>
        </c:otherwise>
    </c:choose>
</head>
<body>


<jsp:include page="header.jsp">
    <jsp:param name="actual" value="Home"/>
</jsp:include>



<main class="container">

    <c:choose>
        <c:when test="${sessionScope.loggedInUser == null}">
            <h3>Log in</h3>
            <c:if test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${errors}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form action="Controller?command=LogIn" method="post" class="form-container">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" placeholder="Your email.."
                       value="${emailPreviousValue}" class="${emailClass eq "hasError"? 'error' : ''}">

                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Your password.."
                       class="${emailClass eq "hasError"? 'error' : ''}">
                <a href="addUser.jsp">Not a member ? sign up here</a><br>

                <input type="submit" value="Log in" id="submit">
            </form>
        </c:when>
        <c:otherwise>
            <h3>Welcom ${sessionScope.loggedInUser.firstname}</h3>
            <a href="Controller?command=LogOut"><button id="log-out-btn">Log out</button></a>
        </c:otherwise>
    </c:choose>



</main>

</body>
</html>