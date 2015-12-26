package gr.uom.uomsecretarystruts2.action;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

import gr.uom.uomsecretarystruts2.domain.Lesson;
import gr.uom.uomsecretarystruts2.domain.User;
import gr.uom.uomsecretarystruts2.domain.UserDetails;
import gr.uom.uomsecretarystruts2.service.LessonService;
import gr.uom.uomsecretarystruts2.service.UserDetailsService;
import gr.uom.uomsecretarystruts2.service.UserService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public class HomeAction extends ActionSupport {
	private static final String ROLE_SECRETARY = "ROLE_SECRETARY";

	private static final String ROLE_PROFESSOR = "ROLE_PROFESSOR";

	private static final long serialVersionUID = 1L;

	private LessonService lessonService;
	private List<Lesson> lessons;

	private UserService userService;
	private UserDetailsService userDetailsService;
	
	private List<UserDetails> professors;
	private List<UserDetails> secretaries;
	private UserDetails userDetails;
	private User user;

	public String lessons() {
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}

	public String professors() {
		this.setProfessors(userDetailsService.findByRole(ROLE_PROFESSOR));
		return SUCCESS;
	}

	public String secretaries() {
		this.setSecretaries(userDetailsService.findByRole(ROLE_SECRETARY));
		return SUCCESS;
	}

	public String myAccount() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}
	
	public String edit() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
		return SUCCESS;
	}
	
	public String changePassword() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUser(userService.findByUsername(username));
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
	
	public String updatePassword() {
		this.userService.update(user);
		return SUCCESS;
	}

	public List<UserDetails> getProfessors() {
		return professors;
	}
	public void setProfessors(List<UserDetails> professors) {
		this.professors = professors;
	}
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
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
	public List<UserDetails> getSecretaries() {
		return secretaries;
	}
	public void setSecretaries(List<UserDetails> secretaries) {
		this.secretaries = secretaries;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}