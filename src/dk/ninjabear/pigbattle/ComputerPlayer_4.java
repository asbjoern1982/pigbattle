package dk.ninjabear.pigbattle;

public class ComputerPlayer_4 implements Player {

	@Override
	public boolean continueTurn(GameState game) {
		return game.getNumberOfThrows() < 4 && game.getScore() + game.getCurrentPointSum() < 100;
	}

	@Override
	public String getName() {return "ai_4turn";}
}
