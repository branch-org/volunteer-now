<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    final UserService userService = UserServiceFactory.getUserService();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>VolunteerNow!</title>

    <%@include file="header.jsp" %>

    <%-- Insert LoginRadius --%>
    <%--<script src="https://hub.loginradius.com/include/js/LoginRadius.js"></script>--%>
    <script type="text/javascript">
    </script>
</head>

<body>

<%@include file="navigation.jsp" %>

<div class="container">
    <h2>Sign in using..</h2>

    <br/>

    <a class="btn btn-default" href="${loginUrl}">Google</a>

    <%@include file="footer.jsp" %>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
