package ua.blog.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.blog.entity.User;
import ua.blog.repository.UserRepository;
import ua.blog.service.UserService;

@Service("userDetailService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userDao;

	
	public void saveUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);

	}

	
	public List<User> getAllUsers() {

		return userDao.findAll();
	}


	public User findById(int id) {

		return userDao.findOne(id);
	}

	
	public void deleteUser(int id) {
		userDao.delete(id);

	}

	
	public void deleteUserbyName(String userName) {
		userDao.deleteUserByName(userName);
	}

	public User findOneByName(String userName) {
		return userDao.findOneByName(userName);
	}

	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user;

		try {
			user = userDao.findOneByName(userName);

		} catch (NoResultException e) {
			return null;

		}

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);

	}

}
