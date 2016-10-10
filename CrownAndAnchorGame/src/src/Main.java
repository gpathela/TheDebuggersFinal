/** Import the libraries that the class will need */
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
*@reviewer Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Programming Principle Practice
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.2
*
*The Main class is the program that contains the code to create 
*/

/** Start of the class Main */
public class Main {
	/** Start of the main method */
	public static void main(String[] args) throws Exception {
		/** Declare, initialise variables that will be used in the code and create instances*/
	   	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	   	int totalWins = 0;
       	int totalLosses = 0;
       	String firstName;
       	int balance, age; // Add the variable age to the class
		Scanner input = new Scanner(System.in);

    	Dice d1 = new Dice(); // Create an instance d1 of the Dice class
        Dice d2 = new Dice(); // Create an instance d2 of the Dice class
        Dice d3 = new Dice(); // Create an instance d3 of the Dice class

		System.out.println("Welcome to our Crown and Anchor game.");
        System.out.println("Only players 18 or above are allowed to play this game.");
        System.out.print("Enter your first name: ");
        firstName = input.next();
        System.out.print("Enter your balance: ");
        balance = input.nextInt();
        System.out.print("Enter your age: ");
        age = input.nextInt();

        //Player player = new Player("Fred", 100); // Create an instance player of the Player class
        Player player = new Player(firstName, balance, age); // Create an instance player of the Player class based of the input
        Game game = new Game(d1, d2, d3); // Create an instance game of the Game class
        List<DiceValue> cdv = game.getDiceValues();

		/** Check the age of the player */
		if (age < 18) {
            System.out.println("Sorry the age limit is 18. Goodbye!");
            System.exit(0);
        } else {
        	/** Start of the infinite while loop */
			while (true) {
				int winCount = 0;
				int loseCount = 0;
			
				for (int i = 0; i < 100; i++){
					//String name = "Fred";
					//int balance = 100;
					int limit = 0;
					player = new Player(firstName, balance, age);
					player.setLimit(limit);
					int bet = 5;

					System.out.println(String.format("Start Game %d: ", i));
					System.out.println(String.format("%s starts with balance %d, limit %d", 
							player.getName(), player.getBalance(), player.getLimit()));

					int turn = 0;
					while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200) {
						turn++;                    
						DiceValue pick = DiceValue.getRandom();
				   
						System.out.printf("Turn %d: %s bet %d on %s\n",
								turn, player.getName(), bet, pick); 
					
						int winnings = game.playRound(player, pick, bet);
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
					} // End of the infinite while loop
					System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
					System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
				} // End of the for loop
			
				System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", 
				winCount, loseCount, (float) winCount/(winCount+loseCount)));
				System.out.println("To keep playing, press enter. \nTo quit the game, type the letter q, " +
				"and press enter."); // Display the message for the user to know how to quite the game.
				totalWins += winCount;
				totalLosses += loseCount;

				String ans = console.readLine();
				if (ans.equals("q")) break;
			} // End of the infinite while loop 
        } // End of the else statement    
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
	} // End of the main method
} // End of the class Main