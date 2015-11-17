<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<s:form action="updateEnrolledLessons.action">
	<s:iterator value="lessons">
		<s:checkbox name="checkedLessons" fieldValue="%{id}" label="%{name}" />
	</s:iterator>

	<s:submit value="Enroll" />
</s:form>
<%@ include file="/footer.jsp"%>