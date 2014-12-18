<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <title>Bulls and Cows</title>
</head>

    <body>

        <a href="/">Main Menu</a><br><br>

        <c:forEach var="number" items="${numbers}">

            ${number}<br>

        </c:forEach>

        <form method="get" action="riddle">
        <input type="text" name="number" />
        <input type="submit" value="Enter next number"/>
        </form>
    </body>

</html>