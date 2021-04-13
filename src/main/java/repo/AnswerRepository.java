package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Answer;
import model.Survey;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
	
	List<Answer> findAllSurveyWithId(Long Id);

}
