package at.ac.tuwien.big.we14.lab2.bean;

public class PlayerQuestion {
	private boolean correct;
	private long time;
	
	public PlayerQuestion(boolean correct, long time) {
		super();
		this.correct = correct;
		this.time = time;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
	public long getTime() {
		return time;
	}
	
	
}
