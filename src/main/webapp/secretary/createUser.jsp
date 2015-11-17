<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="createUser.action">
		<s:textfield label="Username" name="userDetails.user.username" />
		<s:password label="Password" name="userDetails.user.password" />
		<s:textfield label="Name" name="userDetails.name" />
		<s:textfield label="Surname" name="userDetails.surname" />
		<s:select label="Sex" list="#{'male':'Male', 'female':'Female'}" name="userDetails.sex" />
		<s:textfield label="Telephone" name="userDetails.telephone" />
		<s:textfield label="Address" name="userDetails.address" />
		<s:textfield label="Birthday MM/dd/yy" name="userDetails.birthday" />
		<s:select label="Role" list="#{'ROLE_SECRETARY':'Secretary', 'ROLE_PROFESSOR':'Professor', 'ROLE_STUDENT':'Student'}" name="userDetails.user.role" />
		<s:select label="Enabled" list="#{'true':'true', 'false':'false'}" name="userDetails.user.enabled" />

		<s:submit />
	</s:form>
</body>
</html>