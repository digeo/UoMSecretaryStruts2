/**
 * 
 */
package gr.uom.UoMSecretaryStruts2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.uom.UoMSecretaryStruts2.dao.LessonDao;
import gr.uom.UoMSecretaryStruts2.domain.Lesson;
import gr.uom.UoMSecretaryStruts2.service.LessonService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Service
public class LessonServiceImpl implements LessonService {

	private LessonDao lessonDao;

	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}

	@Transactional
	public void insert(Lesson lesson) {
		lessonDao.insert(lesson);
	}

	@Transactional
	public void update(Lesson lesson) {
		lessonDao.update(lesson);
	}

	@Transactional
	public void delete(Lesson lesson) {
		lessonDao.delete(lesson);
	}

	@Transactional
	public void delete(int id) {
		lessonDao.delete(id);
	}

	@Transactional
	public Lesson findById(int id) {
		return lessonDao.findById(id);
	}

	@Transactional
	public List<Lesson> findAll() {
		return lessonDao.findAll();
	}

	@Transactional
	public List<Lesson> findByIds(List<Integer> ids) {
		return lessonDao.findByIds(ids);
	}

	@Transactional
	public List<Lesson> findByNotEnrolledStudent(String student) {
		return lessonDao.findByNotEnrolledStudent(student);
	}

	@Transactional
	public List<Lesson> findByEnrolledStudent(String student) {
		return lessonDao.findByEnrolledStudent(student);
	}

	@Transactional
	public List<Lesson> findByNotTeachProfessor(String professor) {
		return lessonDao.findByNotTeachProfessor(professor);
	}

	@Transactional
	public List<Lesson> findByTeachProfessor(String professor) {
		return lessonDao.findByTeachProfessor(professor);
	}

}
