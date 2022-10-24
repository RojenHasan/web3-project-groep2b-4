
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Delete</title>
</head>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="Overview"/>
</jsp:include>

<main class="container">
    <c:if test="${UserToDelete != null}" >

        <h2 >Do you want to delete ${ UserToDelete.firstname}   ${UserToDelete.lastName} ?</h2>

        <p>
                ${UserToDelete.email}
        </p>
        <form action="Controller?command=DeleteConfirmation" method="POST" class="formStyle" >
            <button type="submit" id="submit">Yes</button>
            <a href="Controller?command=Overview"><button type="button" id="cancel">No</button></a>
            <input type="hidden" name="userId" value=${UserToDelete.userid}>
        </form>

    </c:if>

</main>

</body>
</html>
