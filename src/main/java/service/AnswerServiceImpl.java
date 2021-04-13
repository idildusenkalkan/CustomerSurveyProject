package service;

import java.util.List;

import model.Answer;
import model.Survey;
import repo.AnswerRepository;
import repo.SurveyRepository;

public class AnswerServiceImpl implements IAnswerService {
	private  AnswerRepository answerRepository;

	private  SurveyRepository surveyRepository;

	public AnswerServiceImpl(AnswerRepository answerRepository, SurveyRepository surveyRepository) {
		this.answerRepository = answerRepository;
		this.surveyRepository = surveyRepository;
	}

	public Answer saveAnswer(Answer answer) {
		// TODO Auto-generated method stub
		Survey survey = answer.getSurvey();
		if (survey == null || survey.getId() == null || survey.getId() == 0) {
			throw new RuntimeException("Survey Topic cant be empty");
		} else if (answer.getScore() < 0 || answer.getScore() > 10) {
			throw new RuntimeException("Score error; Score range is 0-10. Please check score");
		}

		survey = surveyRepository.getOne(survey.getId());

		List<Answer> answers = answerRepository.findAllSurveyWithId(survey.getId());
		answers.add(answer);
		int answerCount = answers.size();
		if (answerCount != 0) {
			int promoter = 0;
			int detractor = 0;
			for (Answer answ : answers) {
				if (answ.getScore() >= 9) {
					promoter++;
				} else if (answ.getScore() <= 6) {
					detractor++;
				}
			}
			int npmScore = (int) (answerCount * ((float) (promoter - detractor) / 100));
			survey.setScore(npmScore);
			surveyRepository.save(survey);
		}
		return answerRepository.save(answer);	}

	public List<Answer> getAnswersByTopic(Long topicId) {
		// TODO Auto-generated method stub
		return answerRepository.findAllSurveyWithId(topicId);
	}

	public List<Answer> getAnswers() {
		// TODO Auto-generated method stub
		return answerRepository.findAll();
	}

}
