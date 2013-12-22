package ru.spbstu.it.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

import ru.spbstu.it.dao.taskDAO;
import ru.spbstu.it.domain.Task;

@Service
public class taskServiceImpl implements taskService {
	
	@Autowired
	private taskDAO taskDAO;
	
	@Transactional
	public void addTask(Task task){
		taskDAO.addTask(task);
	}
	
	@Transactional
	public List<Task> listTask(){
		return taskDAO.listTask();
	}
	
	@Transactional
	public void completeTask(Integer id){
		taskDAO.completeTask(id);
	}
}