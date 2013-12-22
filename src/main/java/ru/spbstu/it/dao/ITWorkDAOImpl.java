package ru.spbstu.it.dao;

import java.util.List;

import ru.spbstu.it.domain.ITWork;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ITWorkDAOImpl implements ITWorkDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addITWork(ITWork itwork){
		sessionFactory.getCurrentSession().save(itwork);		
	}
	
	@SuppressWarnings("unchecked")
	public List<ITWork> listITWork(){
		return sessionFactory.getCurrentSession().createQuery("from ITWork").list();

	}
	
	public void completeITWork(Integer id){
		ITWork itwork = (ITWork) sessionFactory.getCurrentSession().load(ITWork.class, id);		
		if (null!=itwork){
			itwork.setCompleted(true);
			sessionFactory.getCurrentSession().update(itwork);
		}
	}
}
