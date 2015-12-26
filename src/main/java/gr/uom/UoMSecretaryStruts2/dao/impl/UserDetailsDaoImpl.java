package gr.uom.uomsecretarystruts2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import gr.uom.uomsecretarystruts2.dao.UserDetailsDao;
import gr.uom.uomsecretarystruts2.domain.UserDetails;

/**
 * @author Georgios Digkas <mai153@uom.edu.gr>
 *
 */
@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userDetails);
	}

	public void update(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userDetails);
	}

	public void delete(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userDetails);
	}

	public List<UserDetails> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UserDetails.findAll");
		return (List<UserDetails>) query.list();
	}

	public List<UserDetails> findByRole(String role) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UserDetails.findByRole");
		query.setString("role", role);
		return (List<UserDetails>) query.list();
	}

	public UserDetails findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UserDetails.findByUsername");
		query.setString("username", username);
		return  (UserDetails) query.uniqueResult();
	}

}
