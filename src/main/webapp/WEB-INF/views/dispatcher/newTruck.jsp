<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add truck</title>


</head>
<body>
<h1>Add truck</h1>

<h3>Truck details</h3>
<form:form method="POST"
           action="/dispatcher/trucks/newTruck/add" modelAttribute="truck">
    <table>
        <tr>
            <td><form:label path="number">Number</form:label></td>
            <td><form:textarea path="number" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td><form:label path="driverCapacity">Max drivers in truck</form:label></td>
            <td><form:textarea path="driverCapacity" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td><form:label path="truckSize">Truck capacity in tons</form:label></td>
            <td><form:textarea path="truckSize" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td>Truck status</td>
            <td>
                <form:select path="truckStatus">
                    <option value="-" disabled="disabled"> - Please, choose</option>
                    <option value="WORKED" selected="selected"> Worked</option>
                    <option value="MULFUNCTIONED"> Mulfunctioned</option>
                </form:select></td>
        </tr>

        <tr>
            <td><form:label path="truckShift">Driver shift</form:label></td>
            <td><form:textarea path="truckShift" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td><form:label path="currentCity">Current City</form:label></td>
            <td><form:select path="currentCity">
                <c:forEach var="city" items="${listCities}">
                    <option value="<c:out value='${city}'/>"
                            <c:if test="${param.selectValue == city})"> selected </c:if> >
                        <c:out value="${city}"/>
                    </option>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>


</form:form>
</body>
</html>
