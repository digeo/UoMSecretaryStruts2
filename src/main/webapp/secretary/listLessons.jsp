<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>description</td>
				<td>ECTS</td>
				<td>Semester</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="lesson" step="1" value="lessons">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="ects" /></td>
					<td><s:property value="semester" /></td>
					<td><a class="btn btn-warning"
						href="<s:url action="editLesson.action" > <s:param name="id"><s:property value="id" /></s:param> </s:url>">edit</a>
					</td>
					<td><a class="btn btn-danger"
						href="<s:url action="deleteLesson.action" > <s:param name="id"><s:property value="id" /></s:param> </s:url>"
						onclick="return confirm('Are you sure?')">delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<a class="btn btn-primary" href="<s:url value="createLessonForm" />">create</a>
</div>
<%@ include file="/footer.jsp"%>