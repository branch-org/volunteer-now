<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Profile - VolunteerNow!</title>

    <%@include file="header.jsp" %>

    <script>
        $(document).ready(function () {
        });
    </script>
</head>

<body>

<%@include file="navigation.jsp" %>

<div class="container col-lg-pull-6">
    <h2>Profile</h2>
    Please enter profile information before continuing to VolunteerNow!
    <form:form role="form" modelAttribute="memberProfile" action="edit" method="post">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="email">Email address</label>
                <form:input path="email" type="email" class="form-control" id="email" placeholder="youremail@domain.com"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="firstName">First name</label>
                <form:input path="firstName" type="text" class="form-control" id="firstName"/>

                <label for="lastName">Last name</label>
                <form:input path="lastName" type="text" class="form-control" id="lastName"/>
            </div>
        </div>
        <button type="submit" class="btn btn-default">Save</button>
    </form:form>
    <%@include file="footer.jsp" %>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
