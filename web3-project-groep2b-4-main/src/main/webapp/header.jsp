<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<nav class="topnav" id="myTopnav">
    <a ${param.actual eq 'Home'?"id = active":""} href="Controller?command=Home">Home</a>
    <a ${param.actual eq 'Overview'?"id = active":""} href="Controller?command=Overview">Users</a>
    <a ${param.actual eq 'AddUser'?"id = active":""} href="addUser.jsp">Add User</a>

    <a  ${param.actual eq 'projectsOverview'?"id = active":""} href="Controller?command=ProjectsOverview">Projects</a>
    <a href="#">Add Project</a>
    <a href="#">Work Orders</a>
    <a href="#">Add Work Order</a>

    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
</nav>


<script>
    function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }
</script>