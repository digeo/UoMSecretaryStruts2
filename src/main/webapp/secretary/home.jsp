<%@include file="/header.jsp"%>

	<div class="jumbotron">
	<div class="container">
	<h1>Hello, </h1>
	<p>This is the Admin panel for the secretary</p>
	</div>
</div>

	<a class="btn btn-default" href="${pageContext.request.contextPath}/secretary/listLessons">List lessons</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/secretary/createLessonForm">Create lesson</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/secretary/listUsers">List users</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/secretary/createUserForm">Create user</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/secretary/professors">Assign lessons to proffesor</a>

<%@ include file="/footer.jsp"%>
