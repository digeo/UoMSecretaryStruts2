<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="userDetails"
		action="${pageContext.request.contextPath}/professor/edit">
		<table border="0" cellpadding="2" cellspacing="2">
			<tr>
				<td>Username</td>
				<td><form:input path="username" readonly="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><form:input path="surname" /></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td><form:select path="sex">
						<form:option value="male">Male</form:option>
						<form:option value="female">Female</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><form:input path="birthday" readonly="true" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>