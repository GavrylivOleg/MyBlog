package ua.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.blog.entity.Message;

public interface MessageDao extends JpaRepository<Message, Integer> {

}
