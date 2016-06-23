package ua.blog.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.blog.entity.GroupArticles;

public interface GroupArticlesDao extends JpaRepository<GroupArticles, Integer> {

	@Query("select a from GroupArticles a where a.groupName=:mytitle")
	GroupArticles findOneGroupArticlesByName(@Param(value = "mytitle") String mytitle);

	@Transactional
	@Modifying
	@Query("delete from GroupArticles a where a.groupName=:mytitle")
	void deleteGroupArticlesByName(@Param(value = "mytitle") String mytitle);

}
