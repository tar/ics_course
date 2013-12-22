package ru.spbstu.it.service;
import java.util.List;

import ru.spbstu.it.domain.User;
public interface userService {
	public User getUser(String name);
	public List<User> getAllUsers();
}
