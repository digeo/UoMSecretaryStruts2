/**
 * 
 */
package gr.uom.UoMSecretaryStruts2.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

import gr.uom.UoMSecretaryStruts2.domain.Lesson;
import gr.uom.UoMSecretaryStruts2.domain.StudentEnrolledToLesson;
import gr.uom.UoMSecretaryStruts2.domain.StudentEnrolledToLessonPK;
import gr.uom.UoMSecretaryStruts2.domain.User;
import gr.uom.UoMSecretaryStruts2.domain.UserDetails;
import gr.uom.UoMSecretaryStruts2.service.LessonService;
import gr.uom.UoMSecretaryStruts2.service.StudentEnrolledToLessonService;
import gr.uom.UoMSecretaryStruts2.service.UserDetailsService;
import gr.uom.UoMSecretaryStruts2.service.UserService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private LessonService lessonService;
	private UserService userService;
	private UserDetailsService userDetailsService;
	private StudentEnrolledToLessonService studentEnrolledToLessonService;

	private List<Lesson> lessons;
	private List<StudentEnrolledToLesson> studentEnrolledToLessonsList;

	private UserDetails userDetails;
	private User user;
	private String checkedLessons;

	//	SELECT
	public String home() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String myLessons() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setStudentEnrolledToLessonsList(studentEnrolledToLessonService.findByStudent(username));
		return SUCCESS;
	}

	public String edit() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String enroll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setLessons(lessonService.findByNotEnrolledStudent(username));
		return SUCCESS;
	}

	public String disenroll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setLessons(lessonService.findByEnrolledStudent(username));
		return SUCCESS;
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

	public String updateEnrolledLessons() {
		List<Integer> checkedLsns = toIntegerList();
		List<StudentEnrolledToLesson> studentEnrolledToNewLessonsList = new ArrayList<>();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUser(userService.findByUsername(username));
		this.setLessons(lessonService.findByIds(checkedLsns));

		for (Lesson lesson : lessons) {
			StudentEnrolledToLesson studentEnrolledToLesson = new StudentEnrolledToLesson(getUser().getUsername(), lesson.getId());
			studentEnrolledToLesson.setStudentEnrolledToLessonPK(new StudentEnrolledToLessonPK(getUser().getUsername(), lesson.getId()));
			studentEnrolledToLesson.setLesson(lesson);
			studentEnrolledToLesson.setUser(getUser());
			studentEnrolledToNewLessonsList.add(studentEnrolledToLesson);
		}
		studentEnrolledToLessonService.insert(studentEnrolledToNewLessonsList);
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String updateDisenrolledLessons() {
		List<Integer> checkedLsns = toIntegerList();
		List<StudentEnrolledToLesson> studentEnrolledToNewLessonsList = new ArrayList<>();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUser(userService.findByUsername(username));
		this.setLessons(lessonService.findByIds(checkedLsns));

		for (Lesson lesson : lessons)
			studentEnrolledToNewLessonsList.add(studentEnrolledToLessonService.findByStudentAndLessonId(username, lesson.getId()));

		studentEnrolledToLessonService.delete(studentEnrolledToNewLessonsList);
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	private List<Integer> toIntegerList() {
		List<Integer> intArray = new ArrayList<>();
		List<String> tmpArray = Arrays.asList(checkedLessons.split(",\\s*"));

		for (String string2 : tmpArray) 
			intArray.add(Integer.valueOf(string2));

		return intArray;
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
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public void setStudentEnrolledToLessonService(StudentEnrolledToLessonService studentEnrolledToLessonService) {
		this.studentEnrolledToLessonService = studentEnrolledToLessonService;
	}
	public List<StudentEnrolledToLesson> getStudentEnrolledToLessonsList() {
		return studentEnrolledToLessonsList;
	}
	public void setStudentEnrolledToLessonsList(List<StudentEnrolledToLesson> studentEnrolledToLessonsList) {
		this.studentEnrolledToLessonsList = studentEnrolledToLessonsList;
	}
	public String getCheckedLessons() {
		return checkedLessons;
	}
	public void setCheckedLessons(String checkedLessons) {
		this.checkedLessons = checkedLessons;
	}

}
