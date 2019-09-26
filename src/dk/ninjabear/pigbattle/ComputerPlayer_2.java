package dk.ninjabear.pigbattle;

public class ComputerPlayer_2 implements Player {

	@Override
	public boolean continueTurn(GameState game) {
		return game.getNumberOfThrows() < 2 && game.getScore() + game.getCurrentPointSum() < 100;
	}

	@Override
	public String getName() {return "ai_2turn";}
}
