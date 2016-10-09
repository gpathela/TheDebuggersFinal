/** Import some libraries to be used in the code */
import java.util.List;
import java.io.*;

/**
* @reviewer Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 07.10.2016
* @version 1.1
*
*/

/** Start of Main class */
public class Main {
	
	/** Start of main method */
	public static void main(String[] args) throws Exception {
	   
	   /** Declare and initialise variables with public access modifiers */
	   BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dice d1 = new Dice(); // Create an instance d1 of the Dice class
        Dice d2 = new Dice(); // Create an instance d2 of the Dice class
        Dice d3 = new Dice(); // Create an instance d3 of the Dice class
		
		/** Create an instance player of the Player class */
        Player player = new Player("Fred", 100);
		
		/** Create an instance game of Game class */
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues();

        int totalWins = 0;
        int totalLosses = 0;

        while (true)	//Start of while loop
        {
            int winCount = 0;
            int loseCount = 0;
            
            for (int i = 0; i < 100; i++)	//Start of for loop
            {
            	String name = "Fred";
            	int balance = 100;
            	int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;
                
                Scanner input = new Scanner(System.in);
                //System.out.println("Enter your betting amount");
                //bet = input.nextInt();
                //while (bet<=0)
               // {
                    //System.out.println("Betting amount should be more than zero");
                    //System.out.println("Enter your betting amount");
                    //bet = input.nextInt();
                //} 
                

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
                        d1=new Dice();
                        d2=new Dice();
                        d3=new Dice();
                        game=new Game(d1,d2,d3);
                        
                    cdv = game.getDiceValues();
                    
                    System.out.printf("Rolled %s, %s, %s\n",
                    		cdv.get(0), cdv.get(1), cdv.get(2));
                    
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
                    
                } //while

                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                
            } //End of for loop
            
            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
            totalWins += winCount;
            totalLosses += loseCount;

            //System.out.println("press 'q' to quit the program");
            String ans = console.readLine();
            if (ans.equals("q")) break;
            
        } //End of while loop
        
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
	} //End of main method

}	//End of main class



