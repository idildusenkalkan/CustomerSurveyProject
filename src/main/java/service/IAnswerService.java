package service;

import java.util.List;

import model.Answer;

public interface IAnswerService {
	
	Answer saveAnswer(Answer answer);

	List<Answer> getAnswersByTopic(Long topicId);

	List<Answer> getAnswers();
}
