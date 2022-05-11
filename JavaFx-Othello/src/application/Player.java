package application;

public abstract class Player {
	private int chipCount = 32;
	private String name;
	private boolean myTurn;
	private int score = 0;
	
	Player (int chipCount, String name, boolean myTurn, int score) {
		this.chipCount = chipCount;
		this.name = name;
		this.myTurn = myTurn;
		this.score = score;
	}
	
	public void setChipCount(int chipCount) {
		this.chipCount = chipCount;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getChipCount() {
		return chipCount;
	}
	
	public boolean myTurn() {
		return myTurn;
	}
	
	
}
