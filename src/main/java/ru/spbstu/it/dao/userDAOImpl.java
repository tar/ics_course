package ru.spbstu.it.dao;




import java.math.BigInteger;
import java.util.List;

import ru.spbstu.it.domain.User;







import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userDAOImpl implements userDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User getUser(String name){
		User user=new User();
		user.setUsername(name);
		
		
		
		user.setId((BigInteger)sessionFactory.getCurrentSession().createSQLQuery("select u.\"user_id\" from users u where u.\"username\"='"+name+"'").list().get(0));
		user.setSkill((String)sessionFactory.getCurrentSession().createSQLQuery("select u.\"skill\" from users u where u.\"username\"='"+name+"'").list().get(0));
		return user;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}

