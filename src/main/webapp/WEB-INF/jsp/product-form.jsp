<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Employee Page</title>
</head>
<body>
	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" modelAttribute="product">
		<table>
			<tr>
				<td><form:label path="itemCode">
              Item Code
            </form:label></td>
				<td><form:input path="itemCode" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
              Price
            </form:label></td>
				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
               Description
            </form:label></td>
				<td><form:input path="description" /></td>
			</tr>

			<tr>
				<td><form:label path="type">
               Type
            </form:label></td>
				<td><form:input path="type" /></td>
			</tr>

			<tr>
				<td><form:label path="tax">
              Tax
            </form:label></td>
				<td><form:radiobutton path="tax" value="0"/> Yes <form:radiobutton path="tax" value="-1"/> No</td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
			

		</table>
	</form:form>

</body>

</html>