package ua.blog.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.blog.entity.Article;

public interface ArticleDao extends JpaRepository<Article, Integer> {

	@Query("select a from Article a where a.title=:mytitle")
	Article findOneByName(@Param(value = "mytitle") String mytitle);

	@Transactional
	@Modifying
	@Query("delete from Article a where a.title=:mytitle")
	void deleteArticleByName(@Param(value = "mytitle") String mytitle);

}
