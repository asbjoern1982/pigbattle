package dk.ninjabear.pigbattle;

public interface Player {

	/**
	 * The player should decide whether to continue to roll or end the turn given the state of the game.
	 * @param game The state of the game, contains all relevant parameters
	 * @return the whether to continue or stop
	 */
	public boolean continueTurn(GameState game);
	
	/**
	 * The player should have a name so it is easy to identify.
	 * If it is your AI it could be ai_<your name>
	 * @return the name of the player
	 */
	public String getName();
}
