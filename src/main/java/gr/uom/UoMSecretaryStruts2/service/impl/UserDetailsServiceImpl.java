package gr.uom.uomsecretarystruts2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gr.uom.uomsecretarystruts2.dao.UserDetailsDao;
import gr.uom.uomsecretarystruts2.domain.UserDetails;
import gr.uom.uomsecretarystruts2.service.UserDetailsService;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDetailsDao userDetailsDao;

	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

	@Transactional
	public void insert(UserDetails userDetails) {
		userDetailsDao.insert(userDetails);
	}

	@Transactional
	public void update(UserDetails userDetails) {
		userDetailsDao.update(userDetails);
	}

	@Transactional
	public void delete(UserDetails userDetails) {
		userDetailsDao.delete(userDetails);
	}

	@Transactional
	public List<UserDetails> findAll() {
		return userDetailsDao.findAll();
	}

	@Transactional
	public List<UserDetails> findByRole(String role) {
		return userDetailsDao.findByRole(role);
	}

	@Transactional
	public UserDetails findByUsername(String username) {
		return userDetailsDao.findByUsername(username);
	}

}
