package at.ac.tuwien.big.we14.lab2.bean;

import java.util.ArrayList;

/**
 * Base class of a player.
 */
public abstract class Player {
	private String name;
	private int points;
	private int correctAnswers;

	private ArrayList<PlayerQuestion> playerQuestions;

	public Player(String name) {
		playerQuestions = new ArrayList<PlayerQuestion>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public long getTime() {
		long sum = 0;
		for (PlayerQuestion question : playerQuestions) {
			sum += question.getTime();
		}
		return sum;
	}

	public void addPoint() {
		points++;
	}

	protected void addQuestionToPlayer(PlayerQuestion question) {
		playerQuestions.add(question);
		if (question.isCorrect()) {
			correctAnswers++;
		}
	}

	public void resetPlayer() {
		playerQuestions = new ArrayList<PlayerQuestion>();
		correctAnswers = 0;
	}

	/**
	 * Returns the answers.
	 * 
	 * @return The answers as an array of boolean values.
	 */
	public ArrayList<Boolean> getAnswers() {
		System.out.println("getAnswers() wird aufgerufen");
		ArrayList<Boolean> output = new ArrayList<Boolean>();
		for (PlayerQuestion question : playerQuestions) {
			if (question.isCorrect()) {
				output.add(true);
			} else {
				output.add(false);
			}
		}
		System.out.println(output);
		System.out.println("getAnswers() wird verlassen");
		return output;
	}

	/**
	 * Adds an answer to the player.
	 * 
	 * @param playerQuestion
	 *            The answer.
	 */
	public abstract void addAnswer(PlayerQuestion playerQuestion);

}
