package dk.ninjabear.pigbattle;

public class ComputerPlayer_Optimal implements Player {
    int goal;
    boolean[][][] computed;
    double[][][] p;
    boolean[][][] roll;
    
    public ComputerPlayer_Optimal() {
    	init(100);
    }
    
    // code taken from http://cs.gettysburg.edu/~tneller/nsf/pig/
    // http://cs.gettysburg.edu/~tneller/nsf/pig/PPigSolver.java
    public void init(int goal) {
        this.goal = goal;
        computed = new boolean[goal][goal][goal];
        p = new double[goal][goal][goal];
        roll = new boolean[goal][goal][goal];
        for (int i = 0; i < goal; i++) // for all i
            for (int j = 0; j < goal; j++) // for all j
                for (int k = 0; i + k < goal; k++) // for all k
                    pWin(i, j, k);
    }
    

    public double pWin(int i, int j, int k) {
        if (i + k >= goal) return 1.0;
        if (j >= goal) return 0.0;
        if (computed[i][j][k]) return p[i][j][k];

        // Compute the probability of winning with a roll
        double pRoll = 1.0 - pWin(j, i + 1, 0);
        for (int roll = 2; roll <= 6; roll++)
            pRoll += pWin(i, j, k + roll);
        pRoll /= 6.0;

        // Compute the probability of winning with a hold
        double pHold;
        if (k == 0) 
            pHold = 1.0 - pWin(j, i + 1, 0);
        else 
            pHold = 1.0 - pWin(j, i + k, 0);

        // Optimal play chooses the action with the greater win probability
        roll[i][j][k] = pRoll > pHold;
        if (roll[i][j][k])
            p[i][j][k] = pRoll;
        else
            p[i][j][k] = pHold;
        computed[i][j][k] = true;
        return p[i][j][k];
    }

	
    @Override
	public boolean continueTurn(GameState game) {
    	// if it is far behind, it will try to catch up, if it is at zero point and the opponent
    	// is close to 100 it sometimes rolls 25+ times in a single turn and get over 100 points
    	if (game.getCurrentPointSum() >= 100)
    		return false;
		return roll[game.getScore()][game.getScoreOpponent()][game.getCurrentPointSum()];
	}
    

	@Override
	public String getName() {return "ai_optimal";}
}
