/**
 * 
 */
package gr.uom.UoMSecretaryStruts2.dao;

import java.util.List;

import gr.uom.UoMSecretaryStruts2.domain.UserDetails;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
public interface UserDetailsDao {
	void insert(UserDetails userDetails);
	void update(UserDetails userDetails);
	void delete(UserDetails userDetails);
	List<UserDetails> findAll();
	List<UserDetails> findByRole(String role);
	UserDetails findByUsername(String username);

}
