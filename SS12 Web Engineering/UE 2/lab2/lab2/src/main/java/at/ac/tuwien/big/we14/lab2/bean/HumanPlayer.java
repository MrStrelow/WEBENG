package at.ac.tuwien.big.we14.lab2.bean;

public class HumanPlayer extends Player {

	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public void addAnswer(PlayerQuestion playerQuestion) {
		addQuestionToPlayer(playerQuestion);
	}

}
