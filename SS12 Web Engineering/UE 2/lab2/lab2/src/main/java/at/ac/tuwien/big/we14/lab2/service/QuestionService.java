package at.ac.tuwien.big.we14.lab2.service;

import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import at.ac.tuwien.big.we14.lab2.api.Category;
import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.api.impl.ServletQuizFactory;
import at.ac.tuwien.big.we14.lab2.exception.EmptyException;

/**
 * The QuestionService loads the questions for the quiz and provides them to the
 * BigQuizServlet. The provided question are randomly taken.
 */
public class QuestionService {
	private List<Category> categories;
	private List<Question> questions;

	public QuestionService(ServletContext context) {
		ServletQuizFactory factory = new ServletQuizFactory(context);
		categories = factory.createQuestionDataProvider().loadCategoryData();
	}

	/**
	 * Loads a new set of questions.
	 * 
	 * @return the limit of possible questions.
	 */
	public int loadNewCategory() throws EmptyException {
		if (categories.isEmpty()) {
			throw new EmptyException();
		}
		int categoryIndex = getRandom(0, categories.size() - 1);
		Category category = categories.get(categoryIndex);
		categories.remove(categoryIndex);
		questions = category.getQuestions();
		return questions.size();
	}

	/**
	 * Returns a random question.
	 * 
	 * @return A random question.
	 */
	public Question getQuestion() throws EmptyException {
		System.out.println(questions);
		if (questions.isEmpty()) {
			throw new EmptyException();
		}
		int questionIndex = getRandom(0, questions.size() - 1);
		Question question = questions.get(questionIndex);
		questions.remove(questionIndex);
		return question;
	}

	/**
	 * Checks if the given answer was correct.
	 * 
	 * @param question
	 *            The question.
	 * @param answers
	 *            The answer.
	 * @return True if the answer was correct or false if it was incorrect.
	 */
	public boolean calculatePoints(Question question, List<Choice> answers) {
		List<Choice> correctChoices = question.getCorrectChoices();
		if (answers.size() != correctChoices.size()) {
			return false;
		}
		for (Choice answer : answers) {
			boolean markedAsCorrect = false;
			for (Choice correctChoice : correctChoices) {
				if (correctChoice.getText().equals(answer.getText())) {
					markedAsCorrect = true;
					System.out.println("++answer=" + answer.getText() + " just got marked as correct");
				}
				System.out.println("++correctChoice=" + correctChoice.getText());
			}
			System.out.println("++answer=" + answer.getText());
			System.out.println("++markedAsCorrect=" + markedAsCorrect);
			if (!markedAsCorrect) {
				return false;
			}
		}
		return true;
	}

	private int getRandom(int min, int max) {
		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
	}
}
