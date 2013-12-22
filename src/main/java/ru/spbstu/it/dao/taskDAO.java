package ru.spbstu.it.dao;

import java.util.List;
import ru.spbstu.it.domain.Task;

public interface taskDAO{
	
	public void addTask(Task task);
	
	public List<Task> listTask();
	
	public void completeTask(Integer id);
	
}
