package dk.ninjabear.pigbattle;

import java.text.NumberFormat;

public class PigApp {
    public static void main(String[] args) {
    	// switch to your AI: 
        Player p1 = new ComputerPlayer_Optimal();
        Player p2 = new ComputerPlayer_3();
    	
    	System.out.println("Welcome to the game of Pig.");

        PigGame game = new PigGame();
        game.printRules();
        
    	int[] stats_p1 = new int[11];
    	int[] stats_p2 = new int[11];
        int p1_won = 0;
        int p2_won = 0;
        int numberOfGames = 100000;
        
        System.out.println("\nRunning the game " + NumberFormat.getInstance().format(numberOfGames) 
        		+ " times with " + p1.getName() + " vs " + p2.getName());
        
        // P1 is playing first
        for (int i = 0; i < numberOfGames/2; i++) {
        	int[] points = game.play(p1, p2);
        	if (points[0] > points[1])
        		p1_won++;
        	else
        		p2_won++;
        	stats(points, stats_p1, stats_p2);
        }
        
        // let P2 play first
        for (int i = 0; i <= numberOfGames/2; i++) {
        	int[] points = game.play(p2, p1);
        	if (points[0] > points[1])
        		p2_won++;
        	else
        		p1_won++;
        	stats(points, stats_p1, stats_p2);
        }
        
        System.out.println();
        System.out.printf("The winner is: %s with %.1f procent\n", 
        		(p1_won > p2_won ? p1.getName() : p2.getName()), 100-100 * 
        		(p1_won > p2_won ? (double) p2_won/p1_won : (double)p1_won/p2_won));
        
        System.out.println("P1: " + p1.getName() + " got " + p1_won + " wins");
        System.out.println("P2: " + p2.getName() + " got " + p2_won + " wins");

        // print statistics
        System.out.print("P1: ");
        for (int i = 0; i < stats_p1.length; i++)
        	System.out.print(stats_p1[i] + " ");
        System.out.print("\nP2: ");
        for (int i = 0; i < stats_p2.length; i++)
        	System.out.print(stats_p2[i] + " ");
        
        System.out.println("\nThank you for playing Pig.");
    }
    
    public static void stats(int[] score, int[] p1_stats, int[] p2_stats) {
    	for (int i = 0; i < 10; i ++)
    		if (score[0] >= i*10 && score[0] < (1+i)*10)
    			p1_stats[i]++;
    	for (int i = 0; i < 10; i ++)
    	    if (score[1] >= i*10 && score[1] < (1+i)*10)
    	    	p2_stats[i]++;

    	if (score[0] == 0) p1_stats[10]++; // if zero
    	if (score[1] == 0) p2_stats[10]++; // if zero
    }
}
