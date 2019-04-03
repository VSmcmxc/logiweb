<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>


</head>
<body>
<h1>Add user</h1>

<h3>User details</h3>
<form:form method="POST"
           action="/admin/newUser/add" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="userName">Name</form:label></td>
            <td><form:textarea path="userName" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
            <form:select  path = "role" >
                <option  value = "-" disabled="disabled"> - Please, choose </option>
                <option  value = "ROLE_ADMIN" > Admin </option>
                <option  value = "ROLE_DISPATCHER"  selected = "selected" > Dispatcher </option>
                <option  value = "ROLE_DRIVER" > Driver </option>
            </form:select></td>
        </tr>
        <tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:textarea path="password" rows="1" cols="15" required="true"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>

    </table>
</form:form>
    </body>
    </html>
