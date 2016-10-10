/** Import some Java libraries and specify the package in which the classes are organized */
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
*@reviewer Gourav Pathela
*@course Master of Information Technology
*@subject Programming Principle Practice
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
*
*The class Main is the program that contains the code to run the game and make note of win lose.  
*/

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	   BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 100, 18);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues();

        int totalWins = 0;
        int totalLosses = 0;

        while (true)
        {
            int winCount = 0;
            int loseCount = 0;
            
            for (int i = 0; i < 100; i++)
            {
            	String name = "Fred";
            	int balance = 100;
            	int limit = 0;
            	int age = 18;
                player = new Player(name, balance, age);
                player.setLimit(limit);
                int bet = 5;

                System.out.println(String.format("Start Game %d: ", i));
                System.out.println(String.format("%s starts with balance %d, limit %d", 
                		player.getName(), player.getBalance(), player.getLimit()));

                int turn = 0;
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
                {
                    turn++;                    
                	DiceValue pick = DiceValue.getRandom();
                   
                	System.out.printf("Turn %d: %s bet %d on %s\n",
                			turn, player.getName(), bet, pick); 
                	
                	int winnings = game.playRound(player, pick, bet);
                    cdv = game.getDiceValues();
                    
                    
                    System.out.printf("Rolled %s, %s, %s\n",
                    		cdv.get(0),cdv.get(1),cdv.get(2));
                    
                    		
                    if (winnings > 0) {
	                    System.out.printf("%s won %d, balance now %d\n\n",
	                    		player.getName(), winnings, player.getBalance());
	                	winCount++; 
                    }
                    else {
	                    System.out.printf("%s lost, balance now %d\n\n",
	                    		player.getName(), player.getBalance());
	                	loseCount++;
                    }
                    
                    System.out.println("Make choice : q to Quit or any other key to continue");
                    //Scanner scanner = new Scanner(System.in);
                    char c = (char) System.in.read();
                    System.out.println(c);
                    if (c == 'q'){
                    	System.out.println("Thanks for playing with us. Bye");
                    	i = 100;
                    	break;
                    }
                    
                } //while

                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                System.out.println(i);
            } //for
            
            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
            totalWins += winCount;
            totalLosses += loseCount;

            String ans = console.readLine();
            if (ans.equals("q")) break;
        } //while true
        
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
	}

}
