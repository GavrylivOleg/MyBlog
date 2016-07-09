package ua.blog.service;

import java.util.List;

import ua.blog.entity.User;

public interface UserService {


	public void saveUser(User user);

	public List<User> getAllUsers();

	public User findById(int id);

	public void deleteUser(int id);

	public void deleteUserbyName(String userName);

	public User findOneByName(String userName);

	
}
