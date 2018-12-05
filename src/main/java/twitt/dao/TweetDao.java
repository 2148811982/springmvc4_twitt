package twitt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import twitt.domain.Tweet;

public interface TweetDao extends JpaRepository<Tweet, Long> {

//	List<Twitt> findAll();
	List<Tweet> findByTitle(String title);
	
	@Query("select t from Twitt t where t.publishTime > :time")//Twitt及其字段对应的是java类及其属性
	List<Tweet> queryAfter(@Param("time") Date time);
}
