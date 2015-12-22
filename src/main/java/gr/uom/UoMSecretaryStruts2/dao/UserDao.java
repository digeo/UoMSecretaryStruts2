package gr.uom.UoMSecretaryStruts2.dao;

import java.util.List;

import gr.uom.UoMSecretaryStruts2.domain.User;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public interface UserDao {
	void insert(User user);
	void update(User user);
	void delete(User user);
	List<User> findAll();
	List<User> findByRole(String role);
	User findByUsername(String username);

}
