package ua.blog.service;

import java.util.List;

import ua.blog.entity.Message;

public interface MessageService {

	public void saveMessage(Message message );

	public List<Message> getAllMessages();

	public Message findById(int id);

	public void deleteMessage(int id);

}
