package ua.blog.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.blog.entity.Message;
import ua.blog.repository.MessageRepository;
import ua.blog.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageDao;

	
	
	public void saveMessage(Message message ){
		messageDao.save(message);

	}

	public List<Message> getAllMessages() {

		return messageDao.findAll();
	}


	public Message findById(int id) {

		return messageDao.findOne(id);
	}

	
	public void deleteMessage(int id) {
		messageDao.delete(id);

	}

}
