package ua.blog.service;

import java.util.List;

import ua.blog.entity.Article;

public interface ArticleService {

	
	public void saveArticle(Article articleName);

	public List<Article> getAllArticles();

	public Article findById(int id);

	public void deleteArticle(int id);

	public void deleteArticleByName(String title);

	public void findeArticleByName(String title);
	
	
}
