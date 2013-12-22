package ru.spbstu.it.dao;
import java.util.List;

import ru.spbstu.it.domain.User;

public interface userDAO{
	
	public User getUser(String name);
	
	public List<User> getAllUsers();
}

