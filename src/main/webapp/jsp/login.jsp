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
</head>

<body>

<%@include file="navigation.jsp" %>

<div class="container">
    Sign in using

    <a href="<%=userService.createLoginURL("login")%>">Google</a>
    <a href="<%=userService.createLoginURL("login", null, "facebook.com", null)%>">Facebook</a>

    <%@include file="footer.jsp" %>
</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
