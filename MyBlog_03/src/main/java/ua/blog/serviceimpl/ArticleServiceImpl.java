package ua.blog.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.blog.dao.ArticleDao;
import ua.blog.entity.Article;
import ua.blog.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	
	public void saveArticle(Article articleName) {
		articleDao.save(articleName);

	}
	public List<Article> getAllArticles() {

		return articleDao.findAll();
	}
	public Article findById(int id) {

		return articleDao.findOne(id);
	}

	public void deleteArticle(int id) {
		articleDao.delete(id);

	}
	
	
	public void deleteArticleByName(String title) {
		articleDao.deleteArticleByName(title);
	}

	
	public void findeArticleByName(String title) {
		articleDao.findOneByName(title);
	}
}
