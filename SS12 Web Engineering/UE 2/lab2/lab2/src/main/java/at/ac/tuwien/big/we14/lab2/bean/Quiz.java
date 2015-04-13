package at.ac.tuwien.big.we14.lab2.bean;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.exception.EmptyException;
import at.ac.tuwien.big.we14.lab2.service.QuestionService;

/**
 * Quiz represents one game.
 */
public class Quiz {
	private int round;
	private int question;
	private Player player1;
	private Player player2;
	private QuestionService service;
	private Question lastQuestion;

	public Quiz() {
	} // TODO

	/**
	 * @param player1
	 *            Name of player1.
	 * @param player2
	 *            Name of player2.
	 */
	public Quiz(String player1, String player2, QuestionService service)
			throws EmptyException {
		this.player1 = new HumanPlayer(player1);
		this.player2 = new HumanPlayer(player2);
		this.service = service;
		service.loadNewCategory();
	}

	/**
	 * @param player1
	 *            Name of player1.
	 */
	public Quiz(String player1, QuestionService service) throws EmptyException {
		this.player1 = new HumanPlayer(player1);
		this.player2 = new KIPlayer("Spieler 2");
		this.service = service;
		service.loadNewCategory();
	}

	public int getRounds() {
		return round;
	}

	public int getCurrentRound() {
		return round + 1;
	}

	public boolean isKiQuiz() {
		if (player2 instanceof KIPlayer) {
			return true;
		}
		return false;
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
	public boolean calculate(Question question, List<Choice> answers) {
		return service.calculatePoints(question, answers);
	}

	/**
	 * Returns a random question.
	 * 
	 * @return A random question.
	 */
	public Question getQuestion() throws EmptyException {
		if(question == 0) {
			player1.resetPlayer();
			player2.resetPlayer();
		}
		lastQuestion = service.getQuestion();
		return lastQuestion;
	}

	public Question getLastQuestion() {
		return lastQuestion;
	}

	public int currentQuestion() {
		return question;
	}

	/**
	 * Adds a question if player2 is a computer.
	 * 
	 * @param answerPlayer1
	 *            Answer of player1.
	 * @return Returns a the result of the operation as a string.
	 *         <p>
	 *         <ul>
	 *         <li>If its the 3. question or the 5. round the method returns the
	 *         name of the winner.</li>
	 *         <li>If its the 3. question or the 5. round the method returns the
	 *         string "Its a draw" if no one wins.</li>
	 *         <li>If a question is added and there are more then 5 rounds an
	 *         error is returned.</li>
	 *         <li>In any other case the string "Just a normal Question." is
	 *         returned.</li>
	 *         </ul>
	 *         </p>
	 */
	public String addQuestion(PlayerQuestion answerPlayer1)
			throws EmptyException {
		return addQuestion(answerPlayer1, null);
	}

	/**
	 * Adds a question if player2 is human.
	 * 
	 * @param answerPlayer1
	 *            Answer of player1.
	 * @param answerPlayer2
	 *            Answer of player2.
	 * @return Returns a the result of the operation as a string.
	 *         <p>
	 *         <ul>
	 *         <li>If its the 3. question or the 5. round the method returns the
	 *         name of the winner.</li>
	 *         <li>If its the 3. question or the 5. round the method returns the
	 *         string "Its a draw" if no one wins.</li>
	 *         <li>If a question is added and there are more then 5 rounds an
	 *         error is returned.</li>
	 *         <li>In any other case the string "Just a normal Question." is
	 *         returned.</li>
	 *         </ul>
	 *         </p>
	 */
	public String addQuestion(PlayerQuestion answerPlayer1,
			PlayerQuestion answerPlayer2) throws EmptyException {
		question++;
		String winner = "Just a normal Question.";
		player1.addAnswer(answerPlayer1);
		player2.addAnswer(answerPlayer2);
		Player playerWin = null;

		if (question == 3) {
			if (player1.getCorrectAnswers() == player2.getCorrectAnswers()) {
				if (player1.getTime() == player2.getTime()) {
					winner = "Its a draw.";
				} else {
					winner = "Player ";
					winner += (player1.getTime() > player2.getTime()) ? player2
							.getName() : player1.getName();
					winner += " wins.";
					playerWin = (player1.getTime() > player2.getTime()) ? player2
							: player1;
				}
			} else {
				winner = "Player ";
				winner += (player1.getCorrectAnswers() < player2
						.getCorrectAnswers()) ? player2.getName() : player1
						.getName();
				winner += " wins.";
				playerWin = (player1.getCorrectAnswers() < player2
						.getCorrectAnswers()) ? player2 : player1;
			}
			question = 0;
			round++;
			if(round != 5) {
				service.loadNewCategory();
			}
		}

		if (round == 5) {
			if (player1.getPoints() == player2.getPoints()) {
				winner = "Unentschieden";
			} else {
				winner = "Player ";
				winner += (player1.getPoints() < player2.getPoints()) ? player2
						.getName() : player1.getName();
				winner += " wins.";
				playerWin = (player1.getCorrectAnswers() < player2
						.getCorrectAnswers()) ? player2 : player1;
			}
		}

		if (round > 5) {
			winner = "Something went wrong. The game should be already over!";
		}

		if(playerWin != null) {
			playerWin.addPoint();
		}
		
		return winner;
	}

	public String getNamePlayer1() {
		return player1.getName();
	}

	public String getNamePlayer2() {
		return player2.getName();
	}

	public ArrayList<Boolean> getAnswersPlayer1() {
		return player1.getAnswers();
	}

	public ArrayList<Boolean> getAnswersPlayer2() {
		return player2.getAnswers();
	}

	public int getPointsPlayer1() {
		return player1.getPoints();
	}

	public int getPointsPlayer2() {
		return player2.getPoints();
	}
}
