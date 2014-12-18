<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <title>Bulls and Cows</title>
</head>

    <body>

    <h1>WON</h1>

        <a href="/">Main Menu</a><br><br>

        <c:forEach var="number" items="${numbers}">

             ${number}<br>

        </c:forEach>

    </body>

</html>