package ua.blog.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.blog.entity.GroupArticles;

public interface GroupArticlesRepository extends JpaRepository<GroupArticles, Integer> {

	@Transactional(propagation=Propagation.REQUIRED)
	@Query("select a from GroupArticles a where a.groupName=:mytitle")
	GroupArticles findOneGroupArticlesByName(@Param(value = "mytitle") String mytitle);

	@Transactional(propagation=Propagation.REQUIRED)
	@Modifying
	@Query("delete from GroupArticles a where a.groupName=:mytitle")
	void deleteGroupArticlesByName(@Param(value = "mytitle") String mytitle);

}
