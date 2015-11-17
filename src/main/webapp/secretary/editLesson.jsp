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
	<s:form action="updateLesson.action">

		<s:textfield readonly="true" label="ID" name="lesson.id" />
		<s:textfield label="Name" name="lesson.name" />
		<s:textarea label="Description" name="lesson.description" cols="20" rows="5" />
		<s:textfield label="ECTS" name="lesson.ects" />
		<s:textfield label="Semester" name="lesson.semester" />

		<s:submit />
	</s:form>
</body>
</html>