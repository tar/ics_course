package ru.spbstu.it.service;

import java.util.List;
import ru.spbstu.it.domain.Task;

public interface taskService {
	
	public void addTask(Task task);
	
	public List<Task> listTask();
	
	public void completeTask(Integer id);
	
}