<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Product Page</title>
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
<h3>Product List</h3>
    <table class="empTable">
    <tr>
        <th width="80">Item Code</th>
        <th width="120">Price</th>
        <th width="120">Description</th>
        <th width="120">Type</th>
        <th width="120">Tax</th>
        <th width="60">Edit</th>
    </tr>
 
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.itemCode}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.type}</td>
            <td>${product.tax}</td>
            <td><a href="<c:url value='/product/view/${product.itemCode}' />" >View</a></td>
         </tr>
    </c:forEach>
    </table>
</body>
</html>