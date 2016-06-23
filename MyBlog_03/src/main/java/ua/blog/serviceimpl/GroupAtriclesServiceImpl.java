package ua.blog.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.blog.dao.GroupArticlesDao;
import ua.blog.entity.GroupArticles;
import ua.blog.service.GroupArticlesService;

@Service("groupArticlesService")
public class GroupAtriclesServiceImpl implements GroupArticlesService {

	@Autowired
	private GroupArticlesDao groupArticlesDao;

	public void saveGroupArticles(GroupArticles groupName) {
		groupArticlesDao.save(groupName);

	}

	public List<GroupArticles> getAllGroupArticles() {

		return groupArticlesDao.findAll();
	}

	public GroupArticles findById(int id) {

		return groupArticlesDao.findOne(id);
	}

	public void deleteGroupArticles(int id) {
		groupArticlesDao.delete(id);

	}

	public void deleteGroupArticlesByName(String groupName) {
		groupArticlesDao.deleteGroupArticlesByName(groupName);
	}

	public GroupArticles findOneGroupArticlesByName(String groupName) {
		return groupArticlesDao.findOneGroupArticlesByName(groupName);
	}

}
