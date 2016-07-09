package ua.blog.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Transactional(propagation=Propagation.REQUIRED)
	@Query("select u from User u where u.userName=:name")
	User findOneByName(@Param(value = "name") String name);

	@Transactional(propagation=Propagation.REQUIRED)
	@Modifying
	@Query("delete from User u where u.userName=:name")
	void deleteUserByName(@Param(value = "name") String name);
}
