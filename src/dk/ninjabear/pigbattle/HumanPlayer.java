package dk.ninjabear.pigbattle;

import java.util.Scanner;

public class HumanPlayer implements Player {

	@Override
	public boolean continueTurn(GameState game) {
		System.out.printf("You have throw %d number of times, you have %d points and a score of %d\n", 
				game.getNumberOfThrows(), game.getCurrentPointSum(), game.getScore());
		System.out.println("Do you want to continiue (Y/n):");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		boolean continueTurn = !str.equals("n");
		//s.close(); <- can not use it again, so i commented it out
		return continueTurn;
	}

	@Override
	public String getName() {return "Player";}
}
