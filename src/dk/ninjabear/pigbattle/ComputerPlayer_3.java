package dk.ninjabear.pigbattle;

public class ComputerPlayer_3 implements Player {

	@Override
	public boolean continueTurn(GameState game) {
		return game.getNumberOfThrows() < 3 && game.getScore() + game.getCurrentPointSum() < 100;
	}

	@Override
	public String getName() {return "ai_3turn";}
}
