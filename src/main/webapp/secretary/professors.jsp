<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<td>Assign</td>
				<td>Revoke</td>
				<td>Professor's Lessons</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="professor" step="1" value="professors">
				<tr>
					<td><a class="btn btn-info" href="<s:url action="assignLessonsToProfessor.action" > <s:param name="username"><s:property value="username" /></s:param> </s:url>">Username: ${professor.username}</a></td>
					<td><a class="btn btn-danger" href="<s:url action="revokeLessonsFromProfessor.action" > <s:param name="username"><s:property value="username" /></s:param> </s:url>">Username: ${professor.username}</a></td>
					<td><a class="btn btn-default" href="<s:url action="professorLessons.action" > <s:param name="username"><s:property value="username" /></s:param> </s:url>">Username: ${professor.username}</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
<%@ include file="/footer.jsp"%>