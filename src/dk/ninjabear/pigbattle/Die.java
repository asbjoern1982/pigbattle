package dk.ninjabear.pigbattle;


public class Die {

	// number of faces
	private int faceCount;
	// value of upper face
	private int faceValue;

	/**
	 * Creates a die with the given face count and a random face value.
	 */
	public Die(int faceCount) {
		this.faceCount = faceCount;
		roll();
	}

	/**
	 * Creates a die with 6 faces and a random face value.
	 */
	public Die() {
		this(6);
	}

	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Rolls the die, resulting in a new face value.
	 */
	public void roll() {
		faceValue = 1 + (int) (faceCount * Math.random());
	}
}