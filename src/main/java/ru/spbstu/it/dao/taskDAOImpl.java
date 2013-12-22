package ru.spbstu.it.dao;

import java.util.List;

import ru.spbstu.it.domain.Task;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class taskDAOImpl implements taskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addTask(Task task){
		sessionFactory.getCurrentSession().save(task);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> listTask(){
		return sessionFactory.getCurrentSession().createQuery("from Task").list();
	}
	
	public void completeTask(Integer id){
		Task task = (Task) sessionFactory.getCurrentSession().load(Task.class, id);		
		if (null!=task){
			task.setCompleted(true);
			sessionFactory.getCurrentSession().update(task);
		}
	}
}
