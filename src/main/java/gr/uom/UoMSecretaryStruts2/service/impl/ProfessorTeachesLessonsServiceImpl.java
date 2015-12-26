package gr.uom.uomsecretarystruts2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gr.uom.uomsecretarystruts2.dao.ProfessorTeachesLessonsDao;
import gr.uom.uomsecretarystruts2.domain.ProfessorTeachesLessons;
import gr.uom.uomsecretarystruts2.service.ProfessorTeachesLessonsService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Service
public class ProfessorTeachesLessonsServiceImpl implements ProfessorTeachesLessonsService {

	private ProfessorTeachesLessonsDao professorTeachesLessonsDao;

	public void setProfessorTeachesLessonsDao(ProfessorTeachesLessonsDao professorTeachesLessonsDao) {
		this.professorTeachesLessonsDao = professorTeachesLessonsDao;
	}

	@Transactional
	public void insert(ProfessorTeachesLessons professorTeachesLessons) {
		professorTeachesLessonsDao.insert(professorTeachesLessons);
	}

	@Transactional
	public void update(ProfessorTeachesLessons professorTeachesLessons) {
		professorTeachesLessonsDao.update(professorTeachesLessons);
	}

	@Transactional
	public void delete(ProfessorTeachesLessons professorTeachesLessons) {
		professorTeachesLessonsDao.delete(professorTeachesLessons);
	}

	@Transactional
	public void insert(List<ProfessorTeachesLessons> professorTeachesLessons) {
		professorTeachesLessonsDao.insert(professorTeachesLessons);
	}

	@Transactional
	public void update(List<ProfessorTeachesLessons> professorTeachesLessons) {
		professorTeachesLessonsDao.update(professorTeachesLessons);
	}

	@Transactional
	public void delete(List<ProfessorTeachesLessons> professorTeachesLessons) {
		professorTeachesLessonsDao.delete(professorTeachesLessons);
	}

	@Transactional
	public ProfessorTeachesLessons findByProfessorAndLessonId(String professor, Integer lessonId) {
		return professorTeachesLessonsDao.findByProfessorAndLessonId(professor, lessonId);
	}

}
