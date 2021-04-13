package service;

import java.util.List;

import model.Survey;
import repo.SurveyRepository;

public class SurveyServiceImpl implements ISurveyService{
	
	private SurveyRepository surveyRepository;

	public void saveSurvey(Survey survey) {
		// TODO Auto-generated method stub
		surveyRepository.saveSurvey(survey.getTopic(), survey.getScore());
	}

	public List<Survey> listSurveys() {
		// TODO Auto-generated method stub
		return surveyRepository.findAllSurvey();
	}
	

}
