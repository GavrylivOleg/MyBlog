package ua.blog.service;

import java.util.List;

import ua.blog.entity.GroupArticles;

public interface GroupArticlesService {

	public void saveGroupArticles(GroupArticles groupName);

	public List<GroupArticles> getAllGroupArticles();

	public GroupArticles findById(int id);

	public void deleteGroupArticles(int id);

	public void deleteGroupArticlesByName(String groupName);

	public GroupArticles findOneGroupArticlesByName(String groupName);

	
}
