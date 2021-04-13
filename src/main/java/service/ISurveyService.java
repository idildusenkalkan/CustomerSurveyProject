package service;

import java.util.List;

import model.Survey;

public interface ISurveyService {
		
	public void saveSurvey(Survey survey);

	public List<Survey> listSurveys();

}
