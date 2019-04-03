<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Trucks Page</title>

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
<a href="<c:url value="/dispatcher/addTruck"/>" >Add truck</a>
<br/>
<br/>

<h1>Truck List</h1>

<c:if test="${!empty listTrucks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Truck number</th>
            <th width="120">Max Drivers in truck</th>
            <th width="120">Truck capacity</th>
            <th width="120">Truck status</th>
            <th width="120">Truck current city</th>
            <th width="120">Truck driver shift</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTrucks}" var="truck">
            <tr>
                <td>${truck.id}</td>
                <td>${truck.number}</td>
                <td>${truck.driverCapacity}</td>
                <td>${truck.truckSize}</td>
                <td>${truck.truckStatus}</td>
                <td>${truck.currentCity}</td>
                <td>${truck.truckShift}</td>


               <%-- <td>${user.id}</td>
                <td><a href="userdata/${user.id}" target="_blank">${user.userName}</a></td>
                <td>${user.role}</td>
                <td> <a href="<c:url value="/admin/editUser/${user.id}"/>">Edit</a></td>
                    &lt;%&ndash; <td><a href="<c:url value="admin/editUser/${user.id}"/>" target="_blank">Edit</a></td>&ndash;%&gt;
                <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>
