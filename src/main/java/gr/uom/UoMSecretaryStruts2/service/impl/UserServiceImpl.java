package gr.uom.UoMSecretaryStruts2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gr.uom.UoMSecretaryStruts2.dao.UserDao;
import gr.uom.UoMSecretaryStruts2.domain.User;
import gr.uom.UoMSecretaryStruts2.service.UserService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void insert(User user) {
		userDao.insert(user);
	}

	@Transactional
	public void update(User user) {
		userDao.update(user);
	}

	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Transactional
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Transactional
	public List<User> findByRole(String role) {
		return userDao.findByRole(role);
	}

	@Transactional
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
