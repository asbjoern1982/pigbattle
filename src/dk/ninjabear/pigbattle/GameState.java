package dk.ninjabear.pigbattle;

public class GameState {
	private int numberOfThrows;
	private int dieFaceValue;
	private int currentPointSum;
	private int score;
	private int scoreOpponent;
	
	/**
	 * This class is made only to parse the state of the game to the Player-object.
	 * @param numberOfThrows amount of dicethorws the player have done this turn
	 * @param dieFaceValue faceValue of the last roll
	 * @param currentPointSum how many points earned this turn so far, including the last roll
	 * @param score score the amount of points the player have without this turn
	 * @param scoreOpponent true if the player wants to continue the turn
	 */
	public GameState(int numberOfThrows, int dieFaceValue, int currentPointSum, int score, int scoreOpponent) {
		this.numberOfThrows = numberOfThrows;
		this.dieFaceValue = dieFaceValue;
		this.currentPointSum = currentPointSum;
		this.score = score;
		this.scoreOpponent = scoreOpponent;
	}

	public int getNumberOfThrows() {
		return numberOfThrows;
	}

	public int getDieFaceValue() {
		return dieFaceValue;
	}

	public int getCurrentPointSum() {
		return currentPointSum;
	}

	public int getScore() {
		return score;
	}

	public int getScoreOpponent() {
		return scoreOpponent;
	}

}
