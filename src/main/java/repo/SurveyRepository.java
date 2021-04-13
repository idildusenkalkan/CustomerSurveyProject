package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
	
	 @Query("select * from #{#Survey}")
	 public List<Survey> findAllSurvey();

	 @Modifying
	 @Query(value = "insert into Survey (topic,score) VALUES (:topic,score)", nativeQuery = true)
	 @Transactional
	 public void saveSurvey(@Param("topic") String topic, @Param("score") Integer score);
	 

}
