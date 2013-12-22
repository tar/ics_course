package ru.spbstu.it.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 


import ru.spbstu.it.dao.userDAO;
import ru.spbstu.it.domain.User;

@Service
public class userServiceImpl implements userService {
	
	@Autowired
	private userDAO userDAO;
	
	@Transactional
	public User getUser(String name)
	{
		return userDAO.getUser(name);
	}
	
	@Transactional
	public List<User> getAllUsers()
	{
		return userDAO.getAllUsers();		
	}
}

