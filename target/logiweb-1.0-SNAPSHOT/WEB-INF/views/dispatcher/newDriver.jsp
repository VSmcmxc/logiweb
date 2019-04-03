<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Driver</title>


</head>
<body>
<h1>Add driver</h1>

<h3>Driver details</h3>
<form:form method="POST"
           action="/dispatcher/newDriver/add" modelAttribute="driver">
    <table>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:textarea path="firstName" rows="1" cols="15" required="true"/></td>
        </tr>

        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:textarea path="lastName" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td>
                <form:select  path = "status" >
                    <option  value = "-" disabled="disabled"> - Please, choose </option>
                    <option  value = "VACATION" > Vacation </option>
                    <option  value = "FREE"  selected = "selected" > Free </option>
                    <option  value = "DRIVING" > Driving </option>
                    <option  value = "SECOND_DRIVER" > Second driver </option>
                </form:select></td>
        </tr>
        <%--<tr>
            <td><form:label path="curremtCity">Current city</form:label></td>
            <td><form:textarea path="currentCity" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td><form:label path="currentTruck">Current truck</form:label></td>
            <td><form:textarea path="currentTruck" rows="1" cols="15" required="true"/></td>
        </tr>--%>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>

    </table>
</form:form>
</body>
</html>
