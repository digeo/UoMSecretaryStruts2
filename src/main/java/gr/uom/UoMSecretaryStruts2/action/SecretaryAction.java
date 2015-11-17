/**
 * 
 */
package gr.uom.UoMSecretaryStruts2.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import gr.uom.UoMSecretaryStruts2.domain.Lesson;
import gr.uom.UoMSecretaryStruts2.domain.ProfessorTeachesLessons;
import gr.uom.UoMSecretaryStruts2.domain.ProfessorTeachesLessonsPK;
import gr.uom.UoMSecretaryStruts2.domain.User;
import gr.uom.UoMSecretaryStruts2.domain.UserDetails;
import gr.uom.UoMSecretaryStruts2.service.LessonService;
import gr.uom.UoMSecretaryStruts2.service.ProfessorTeachesLessonsService;
import gr.uom.UoMSecretaryStruts2.service.UserDetailsService;
import gr.uom.UoMSecretaryStruts2.service.UserService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public class SecretaryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private LessonService lessonService;
	private UserService userService;
	private UserDetailsService userDetailsService;
	private ProfessorTeachesLessonsService professorTeachesLessonsService;

	private List<Lesson> lessons;
	private List<UserDetails> usersDetails;
	private List<UserDetails> professors;

	private UserDetails userDetails;
	private User user;
	private Lesson lesson;
	private String username;
	private String checkedLessons;
	private int id;


	//	SELECT
	public String listUsers() {
		this.setUsersDetails(userDetailsService.findAll());
		return SUCCESS;
	}

	public String listLessons() {
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}

	public String professors() {
		this.setProfessors(userDetailsService.findByRole("ROLE_PROFESSOR"));
		return SUCCESS;
	}

	public String professorLessons() {
		this.setLessons(lessonService.findByTeachProfessor(username));
		return SUCCESS;
	}

	public String assignLessonsToProfessor() {
		this.setUsername(username);
		this.setUser(userDetailsService.findByUsername(getUsername()).getUser());
		this.setLessons(lessonService.findByNotTeachProfessor(getUsername()));
		return SUCCESS;
	}

	public String revokeLessonsFromProfessor() {
		this.setUsername(username);
		this.setUser(userDetailsService.findByUsername(getUsername()).getUser());
		this.setLessons(lessonService.findByTeachProfessor(getUsername()));
		return SUCCESS;
	}

	//	INSERT
	public String createUser() {
		userService.insert(userDetails.getUser());
		userDetails.setUser(userService.findByUsername(userDetails.getUser().getUsername()));
		userDetails.setUsername(userDetails.getUser().getUsername());
		userDetailsService.insert(userDetails);
		this.setUsersDetails(userDetailsService.findAll());
		return SUCCESS;
	}

	public String createLesson() {
		lessonService.insert(lesson);
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}


	//	UPDATE
	public String editUser() {
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}

	public String editLesson() {
		this.setLesson(lessonService.findById(id));
		return SUCCESS;
	}


	//	STORE UPDATE
	public String updateUser() {
		User usr = userDetails.getUser();
		userDetails.setUsername(usr.getUsername());
		this.userDetailsService.update(userDetails);
		this.userService.update(usr);
		this.setUsersDetails(userDetailsService.findAll());
		return SUCCESS;
	}

	public String updateLesson() {
		this.lessonService.update(lesson);
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}

	public String assignLessons() {
		List<Integer> checkedLsns = toIntegerList(checkedLessons);
		List<ProfessorTeachesLessons> professorTeachesLessonsList = new ArrayList<ProfessorTeachesLessons>();

		this.setUser(userService.findByUsername(getUsername()));
		this.setLessons(lessonService.findByIds(checkedLsns));

		for (Lesson lesson : lessons) {
			ProfessorTeachesLessons professorTeachesLesson = new ProfessorTeachesLessons(getUser().getUsername(), lesson.getId());
			professorTeachesLesson.setProfessorTeachesLessonsPK(new ProfessorTeachesLessonsPK(getUser().getUsername(), lesson.getId()));
			professorTeachesLesson.setLesson(lesson);
			professorTeachesLesson.setUser(getUser());
			professorTeachesLesson.setStartedFrom(new Date());
			professorTeachesLessonsList.add(professorTeachesLesson);
		}

		professorTeachesLessonsService.insert(professorTeachesLessonsList);
		this.setProfessors(userDetailsService.findByRole("ROLE_PROFESSOR"));
		return SUCCESS;
	}
	
	public String revokeLessons() {
		List<Integer> checkedLsns = toIntegerList(checkedLessons);
		List<ProfessorTeachesLessons> professorTeachesLessonsList = new ArrayList<ProfessorTeachesLessons>();

		this.setUser(userService.findByUsername(getUsername()));
		this.setLessons(lessonService.findByIds(checkedLsns));

		for (Lesson lesson : lessons) {
			ProfessorTeachesLessons professorTeachesLesson = new ProfessorTeachesLessons(getUser().getUsername(), lesson.getId());
			professorTeachesLesson.setProfessorTeachesLessonsPK(new ProfessorTeachesLessonsPK(getUser().getUsername(), lesson.getId()));
			professorTeachesLesson.setLesson(lesson);
			professorTeachesLesson.setUser(getUser());
			professorTeachesLesson.setStartedFrom(new Date());
			professorTeachesLessonsList.add(professorTeachesLesson);
		}

		professorTeachesLessonsService.delete(professorTeachesLessonsList);
		this.setProfessors(userDetailsService.findByRole("ROLE_PROFESSOR"));
		return SUCCESS;
	}


	//	DELETE
	public String deleteUser() {
		userDetailsService.delete(userDetailsService.findByUsername(getUsername()));
		userService.delete(userService.findByUsername(getUsername()));
		this.setUsersDetails(userDetailsService.findAll());
		return SUCCESS;
	}

	public String deleteLesson() {
		lessonService.delete(getId());
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}

	public List<UserDetails> getUsersDetails() {
		return usersDetails;
	}

	public void setUsersDetails(List<UserDetails> usersDetails) {
		this.usersDetails = usersDetails;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<UserDetails> getProfessors() {
		return professors;
	}

	public void setProfessors(List<UserDetails> professors) {
		this.professors = professors;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCheckedLessons() {
		return checkedLessons;
	}

	public void setCheckedLessons(String checkedLessons) {
		this.checkedLessons = checkedLessons;
	}

	public void setProfessorTeachesLessonsService(ProfessorTeachesLessonsService professorTeachesLessonsService) {
		this.professorTeachesLessonsService = professorTeachesLessonsService;
	}

	private List<Integer> toIntegerList(String string) {
		List<Integer> intArray = new ArrayList<Integer>();
		List<String> tmpArray = Arrays.asList(checkedLessons.split(",\\s*"));

		for (String string2 : tmpArray) 
			intArray.add(Integer.valueOf(string2));

		return intArray;
	}

}
