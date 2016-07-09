package ua.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.blog.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	
}
