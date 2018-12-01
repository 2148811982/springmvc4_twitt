package twitt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import twitt.domain.Twitt;

public interface TwittDao extends JpaRepository<Twitt, Long> {

//	List<Twitt> findAll();
	Twitt findByTitle(String title);
	
	@Query("select t from Twitt t where t.publishTime > :time")//Twitt�����ֶζ�Ӧ����java�༰������
	List<Twitt> queryAfter(@Param("time") Date time);
}
