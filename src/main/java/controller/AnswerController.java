package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Answer;
import service.AnswerServiceImpl;

@RequestMapping("/answer")
@RestController
public class AnswerController {

	private AnswerServiceImpl answerService;

	public AnswerController(AnswerServiceImpl answerService) {
		this.answerService = answerService;
	}

	@GetMapping
	public List<Answer> findAllAnswers() {
		return answerService.getAnswers();
	}

	@GetMapping("/topic/{id}")
	public List<Answer> listAnswersByTopic(@PathVariable Long id) {
		return answerService.getAnswersByTopic(id);
	}

	@PostMapping
	public Answer saveAnswer(@RequestBody Answer answer) {
		return answerService.saveAnswer(answer);
	}
}
