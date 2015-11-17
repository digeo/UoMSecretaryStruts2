<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<s:form action="updateGradesToStudents.action">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Student's name</th>
					<th>Student's surname</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="studentsEnrolledToLessonList" status="ctr">
					<tr>
						<td><s:textfield readonly="true" theme="simple" name="studentsEnrolledToLessonList[%{#ctr.index}].user.userDetails.name" /></td>
						<td><s:textfield readonly="true" theme="simple" name="studentsEnrolledToLessonList[%{#ctr.index}].user.userDetails.surname" /></td>
						<td><s:textfield theme="simple" name="studentsEnrolledToLessonList[%{#ctr.index}].grade" /></td>
						
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].studentEnrolledToLessonPK.student" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].studentEnrolledToLessonPK.lessonId" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].lesson.id" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].lesson.description" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].lesson.ects" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].lesson.name" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].lesson.semester" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].user.username" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].user.password" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].user.role" />
						<s:hidden name="studentsEnrolledToLessonList[%{#ctr.index}].user.enabled" />
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:submit class="btn btn-info" value="Set grades" />
	</s:form>
</div>
<%@ include file="/footer.jsp"%>