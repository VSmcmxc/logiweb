<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Drivers Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="<c:url value="/dispatcher"/>">Back to main menu</a>
<%--<a href="<c:url value="/admin/newUser"/>" >Add Driver</a>--%>
<br/>
<br/>

<h1>Drivers List</h1>

<c:if test="${!empty listDrivers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">First name</th>
            <th width="120">Last name</th>
            <th width="120">Status</th>
            <th width="120">Current city</th>
            <th width="120">Current truck</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDrivers}" var="driver">
            <tr>
                <td>${driver.id}</td>
                <td>${driver.firstName}</td>
                <td>${driver.lastName}</td>
                <td>${driver.status}</td>
                <td>${driver.currentCity}</td>
                <%--<td>${driver.currentCity}</td>
                <td>${driver.currentTruck}</td>--%>

            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>
