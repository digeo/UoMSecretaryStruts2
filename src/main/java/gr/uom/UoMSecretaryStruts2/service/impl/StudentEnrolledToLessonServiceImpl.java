package gr.uom.UoMSecretaryStruts2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gr.uom.UoMSecretaryStruts2.dao.StudentEnrolledToLessonDao;
import gr.uom.UoMSecretaryStruts2.domain.StudentEnrolledToLesson;
import gr.uom.UoMSecretaryStruts2.service.StudentEnrolledToLessonService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Service
public class StudentEnrolledToLessonServiceImpl implements StudentEnrolledToLessonService {

	private StudentEnrolledToLessonDao studentEnrolledToLessonDao;

	public void setStudentEnrolledToLessonDao(StudentEnrolledToLessonDao studentEnrolledToLessonDao) {
		this.studentEnrolledToLessonDao = studentEnrolledToLessonDao;
	}

	@Transactional
	public void insert(StudentEnrolledToLesson studentEnrolledToLessons) {
		studentEnrolledToLessonDao.insert(studentEnrolledToLessons);
	}

	@Transactional
	public void update(StudentEnrolledToLesson studentEnrolledToLessons) {
		studentEnrolledToLessonDao.update(studentEnrolledToLessons);
	}

	@Transactional
	public void delete(StudentEnrolledToLesson studentEnrolledToLessons) {
		studentEnrolledToLessonDao.delete(studentEnrolledToLessons);
	}

	@Transactional
	public void insert(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		studentEnrolledToLessonDao.insert(studentEnrolledToLessons);
	}

	@Transactional
	public void update(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		studentEnrolledToLessonDao.update(studentEnrolledToLessons);
	}

	@Transactional
	public void delete(List<StudentEnrolledToLesson> studentEnrolledToLessons) {
		studentEnrolledToLessonDao.delete(studentEnrolledToLessons);
	}

	@Transactional
	public List<StudentEnrolledToLesson> findByStudent(String student) {
		return studentEnrolledToLessonDao.findByStudent(student);
	}

	@Transactional
	public StudentEnrolledToLesson findByStudentAndLessonId(String student, Integer lessonId) {
		return studentEnrolledToLessonDao.findByStudentAndLessonId(student, lessonId);
	}

	@Transactional
	public List<StudentEnrolledToLesson> findByLessonId(int lessonId) {
		return studentEnrolledToLessonDao.findByLessonId(lessonId);
	}

}
