<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Employee Page</title>
</head>
<body>
	<c:url var="addAction" value="/employee/add"></c:url>

	<form:form action="${addAction}" modelAttribute="employee">
		<table>
		<tr>
				<td><form:label path="firstName">
              First Name
            </form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">
               Last Name
            </form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="age">
               Age
            </form:label></td>
				<td><form:input path="age" /></td>
			</tr>

			<tr>
				<td><form:label path="education">
              Education
            </form:label></td>
				<td><form:input path="education" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>

		</table>
	</form:form>

</body>

</html>