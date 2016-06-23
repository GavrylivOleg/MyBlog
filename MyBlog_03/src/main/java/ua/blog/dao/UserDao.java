package ua.blog.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.blog.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.userName=:name")
	User findOneByName(@Param(value = "name") String name);

	@Transactional
	@Modifying
	@Query("delete from User u where u.userName=:name")
	void deleteUserByName(@Param(value = "name") String name);
}
