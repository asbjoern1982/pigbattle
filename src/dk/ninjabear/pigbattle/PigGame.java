package dk.ninjabear.pigbattle;

public class PigGame {
	
    /**
     * Simulates playing one game of Pig.
     */
    public int[] play(Player p1, Player p2) {
    	boolean print = false;
    	
    	Die die = new Die();
    	int totalPointP1 = 0;
    	int totalPointP2 = 0;
    	boolean player1sturn = true;
    	
		int maxPoints = 100;
		
    	if (print) System.out.println();
    	while(totalPointP1 < maxPoints && totalPointP2 < maxPoints) {
    		int numberOfThrows = 0;
    		int currentPointSum = 0;
    		int points = 0;
    		boolean continueTurn = true;
    		
    		if (print) System.out.printf("It is now player %d's turn\n", (player1sturn ? 1 : 2));
    		
    		while (continueTurn) {
    			points = throwDie(die);
    			
    			if (points == 1) {
    				if (print) System.out.println("You threw 1, you lost your point");
    				break;
    			}
    			
    			currentPointSum += points;
    			if (print)
    				System.out.printf("You threw a %d'er, your have %d points and would get %d if you stoped now. \n",
    					points, currentPointSum, currentPointSum + (player1sturn ? totalPointP1 : totalPointP2));
    			
    			
    			if (player1sturn) {
    				continueTurn = p1.continueTurn(new GameState(numberOfThrows, points, currentPointSum, totalPointP1, totalPointP2));
    			} else {
    				continueTurn = p2.continueTurn(new GameState(numberOfThrows, points, currentPointSum, totalPointP2, totalPointP1));
    			}
    			numberOfThrows++;
    		}
    		
    		if (points != 1) {
    			if (player1sturn)
    				totalPointP1 += currentPointSum;
    			else
    				totalPointP2 += currentPointSum;
    			
    		}
    		
    		player1sturn = !player1sturn;
    		if (print)
    			System.out.printf("Player 1 has %d points and Player 2 has %d points\n",
    				totalPointP1, totalPointP2);
    	}
    	if (print) 
    		System.out.printf("Someone won, congratz, Player 1 got %d points and Player 2 got %d points\n", 
				totalPointP1, totalPointP2);
    	
		return new int[]{totalPointP1, totalPointP2};
    }
    
    private int throwDie(Die die) {
    	die.roll();
    	return die.getFaceValue();
    }
    
    /**
     * Prints the rules of pigs.
     */
    public void printRules() {
    	int lineLength = 80;
    	String rules = "The game is played by two players. The players take "
    			+ "turns, throwing one die until he/she throws 1, or until "
    			+ "he/she decides to stop throwing. The player accumulates "
    			+ "points (the face value of the die) on each throw, but if "
    			+ "he/she throws 1, all points in this turn is lost. If the "
    			+ "player stops before throwing a 1, the points of this turn "
    			+ "is added to the points of earlier turns. The player that "
    			+ "reaches a chosen number of points after a turn, is the winner.";
    	
    	while(true) {
        	int pos = rules.substring(0, lineLength).lastIndexOf(" ") + 1;
    		System.out.println(rules.substring(0, pos));
    		rules = rules.substring(pos);
    		
    		if (lineLength > rules.length()) {
    			System.out.println(rules);
    			break;
    		}
    	}
    }
}
