package ua.blog.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.blog.entity.Article;

public interface ArticleDao extends JpaRepository<Article, Integer> {

	
	@Transactional(propagation=Propagation.REQUIRED)
	@Query("select a from Article a where a.title=:mytitle")
	Article findOneByName(@Param(value = "mytitle") String mytitle);

	@Transactional(propagation=Propagation.REQUIRED)
	@Modifying
	@Query("delete from Article a where a.title=:mytitle")
	void deleteArticleByName(@Param(value = "mytitle") String mytitle);
	
	

}
