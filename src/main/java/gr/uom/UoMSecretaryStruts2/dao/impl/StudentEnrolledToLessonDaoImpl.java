package gr.uom.uomsecretarystruts2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import gr.uom.uomsecretarystruts2.dao.StudentEnrolledToLessonDao;
import gr.uom.uomsecretarystruts2.domain.StudentEnrolledToLesson;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Repository
public class StudentEnrolledToLessonDaoImpl implements StudentEnrolledToLessonDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(StudentEnrolledToLesson studentEnrolledToLessons) {
		Session session = this.sessionFactory.getCurrentSession();
		if (checkIfExists(studentEnrolledToLessons))
			session.persist(studentEnrolledToLessons);
	}

	public void update(StudentEnrolledToLesson studentEnrolledToLessons) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(studentEnrolledToLessons);
	}

	public void delete(StudentEnrolledToLesson studentEnrolledToLessons) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(studentEnrolledToLessons);
	}

	public void insert(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		for (StudentEnrolledToLesson studentEnrolledToLesson : studentEnrolledToLessons) {
			this.insert(studentEnrolledToLesson);
		}
	}

	public void update(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		for (StudentEnrolledToLesson studentEnrolledToLesson : studentEnrolledToLessons) {
			this.update(studentEnrolledToLesson);
		}
	}

	public void delete(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		for (StudentEnrolledToLesson studentEnrolledToLesson : studentEnrolledToLessons) {
			this.delete(studentEnrolledToLesson);
		}
	}

	public List<StudentEnrolledToLesson> findByStudent(String student) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("StudentEnrolledToLesson.findByStudent");
		query.setString("student", student);
		return (List<StudentEnrolledToLesson>) query.list();
	}

	public StudentEnrolledToLesson findByStudentAndLessonId(String student, Integer lessonId) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("StudentEnrolledToLesson.findByStudentAndLessonId");
		query.setInteger("lessonId", lessonId);
		query.setString("student", student);
		return (StudentEnrolledToLesson) query.uniqueResult();
	}

	public List<StudentEnrolledToLesson> findByLessonId(int lessonId) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("StudentEnrolledToLesson.findByLessonId");
		query.setInteger("lessonId", lessonId);
		return (List<StudentEnrolledToLesson>) query.list();
	}

	private boolean checkIfExists(StudentEnrolledToLesson studentEnrolledToLessons) {
		StudentEnrolledToLesson tmpStudentEnrolledToLessons = findByStudentAndLessonId(studentEnrolledToLessons.getStudentEnrolledToLessonPK().getStudent(), studentEnrolledToLessons.getStudentEnrolledToLessonPK().getLessonId());
		return tmpStudentEnrolledToLessons == null;
	}

}
