<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Employee Page</title>
    <style type="text/css">
        .empTable  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .empTable td{font-family:Arial, sans-serif;font-size:16px;padding:10px 5px;border-
                              style:solid;border-width:2px;overflow:hidden;word-break:normal;border-
                              color:#ccc;color:#050505;background-color:#89abf0;}
        .empTable th{font-family:Arial, sans-serif;font-size:16px;font-weight:normal;padding:10px
                              5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-
                              color:#ccc;color:#000000;background-color:#FF4500;}
        .empTable .empTable-4eph{background-color:#C0C0C0}
    </style>
</head>
<body>
<h3>Employee List</h3>
    <table class="empTable">
    <tr>
        <th width="80">ID</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Age</th>
        <th width="120">Education</th>
        <th width="60">Edit</th>
    </tr>
 
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.age}</td>
            <td>${employee.education}</td>
            <td><a href="<c:url value='/employee/view/${employee.id}' />" >View</a></td>
         </tr>
    </c:forEach>
    </table>
</body>
</html>