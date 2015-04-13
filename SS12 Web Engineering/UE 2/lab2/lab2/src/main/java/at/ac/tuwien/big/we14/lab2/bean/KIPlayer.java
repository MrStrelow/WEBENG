package at.ac.tuwien.big.we14.lab2.bean;

import java.util.Random;

public class KIPlayer extends Player {

	public KIPlayer(String name) {
		super(name);
	}

	@Override
	public void addAnswer(PlayerQuestion playerQuestion) {
		Random nr = new Random();
		if (nr.nextBoolean()) {
			addQuestionToPlayer(new PlayerQuestion(true, 5));
		} else {
			addQuestionToPlayer(new PlayerQuestion(false, 5));
		}
	}

}
