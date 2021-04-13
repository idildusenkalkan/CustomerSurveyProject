package controller;

import org.springframework.web.bind.annotation.RestController;

import model.Survey;
import service.SurveyServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/survey")
@RestController
public class SurveyController {

	private final SurveyServiceImpl surveyService;

	public SurveyController(SurveyServiceImpl surveyService) {
		this.surveyService = surveyService;
	}
	

	@PostMapping
	public void saveSurvey(@RequestBody Survey survey) {

	}

	@GetMapping
	public List<Survey> findAllSurveys() {
		return surveyService.listSurveys();
	}
}
