package gr.uom.uomsecretarystruts2.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

import gr.uom.uomsecretarystruts2.domain.Lesson;
import gr.uom.uomsecretarystruts2.domain.StudentEnrolledToLesson;
import gr.uom.uomsecretarystruts2.domain.User;
import gr.uom.uomsecretarystruts2.domain.UserDetails;
import gr.uom.uomsecretarystruts2.service.LessonService;
import gr.uom.uomsecretarystruts2.service.StudentEnrolledToLessonService;
import gr.uom.uomsecretarystruts2.service.UserDetailsService;
import gr.uom.uomsecretarystruts2.service.UserService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public class ProfessorAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private LessonService lessonService;
	private UserService userService;
	private UserDetailsService userDetailsService;
	private StudentEnrolledToLessonService studentEnrolledToLessonService;

	private UserDetails userDetails;
	private int lessonId;
	private List<Lesson> lessons;
	private List<StudentEnrolledToLesson> studentsEnrolledToLessonList;

	//	SELECT
	public String home() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String edit() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String myLessons() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setLessons(lessonService.findByTeachProfessor(username));
		return SUCCESS;
	}

	public String setGrades() {

		this.setStudentsEnrolledToLessonList(studentEnrolledToLessonService.findByLessonId(lessonId));
		if (this.getStudentsEnrolledToLessonList().isEmpty())
			return SUCCESS;
		return NONE;
	}

	//	STORE UPDATE
	public String updateUser() {
		User usr = userDetails.getUser();
		userDetails.setUsername(usr.getUsername());
		this.userDetailsService.update(userDetails);
		this.userService.update(usr);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String updateGradesToStudents() {
		List<StudentEnrolledToLesson> updateGradesList = new ArrayList<>();
		studentsEnrolledToLessonList = this.getStudentsEnrolledToLessonList();

		for (StudentEnrolledToLesson studentEnrolledToLesson : studentsEnrolledToLessonList)
			if (studentEnrolledToLesson.getGrade() != null)
				updateGradesList.add(studentEnrolledToLesson);

		studentEnrolledToLessonService.update(updateGradesList);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	public void setStudentEnrolledToLessonService(StudentEnrolledToLessonService studentEnrolledToLessonService) {
		this.studentEnrolledToLessonService = studentEnrolledToLessonService;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public List<StudentEnrolledToLesson> getStudentsEnrolledToLessonList() {
		return studentsEnrolledToLessonList;
	}
	public void setStudentsEnrolledToLessonList(List<StudentEnrolledToLesson> studentsEnrolledToLessonList) {
		this.studentsEnrolledToLessonList = studentsEnrolledToLessonList;
	}

}
