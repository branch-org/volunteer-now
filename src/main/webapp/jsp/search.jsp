<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>VolunteerNow!</title>

    <%@include file="header.jsp" %>
</head>

<body>

<%@include file="navigation.jsp" %>

<div class="container">
    <%@include file="search_bar.jsp" %>

    <c:choose>
        <c:when test="${empty searchResults}">
            <div class="alert alert-danger">Oh snap!</div>
        </c:when>
        <c:otherwise>
            <table class="table table-striped table-hover">
                <tr>
                    <th>Title</th>
                    <th>Organization</th>
                    <th>Location</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="result" items="${searchResults}">
                    <tr>
                        <td>${result.title}</td>
                        <td>${result.organization}</td>
                        <td>${result.location}</td>
                        <td>${result.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <%@include file="footer.jsp" %>
</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
