<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile - VolunteerNow!</title>

    <%@include file="header.jsp" %>
</head>

<body>

<%@include file="navigation.jsp" %>

<div class="container">
    <h2>Profile</h2>
    ${memberProfile.displayName}
    <%@include file="footer.jsp" %>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
