/**
 * 
 */
package gr.uom.UoMSecretaryStruts2.action;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

import gr.uom.UoMSecretaryStruts2.domain.Lesson;
import gr.uom.UoMSecretaryStruts2.domain.UserDetails;
import gr.uom.UoMSecretaryStruts2.service.LessonService;
import gr.uom.UoMSecretaryStruts2.service.UserDetailsService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private LessonService lessonService;
	private List<Lesson> lessons;

	private UserDetailsService userDetailsService;
	private List<UserDetails> professors;
	private List<UserDetails> secretaries;
	private UserDetails userDetails;

	public String lessons() throws Exception {
		this.setLessons(lessonService.findAll());
		return SUCCESS;
	}

	public String professors() throws Exception {
		this.setProfessors(userDetailsService.findByRole("ROLE_PROFESSOR"));
		return SUCCESS;
	}

	public String secretaries() throws Exception {
		this.setSecretaries(userDetailsService.findByRole("ROLE_SECRETARY"));
		return SUCCESS;
	}

	public String myAccount() throws Exception {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		this.setUserDetails(userDetailsService.findByUsername(username));
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

}
