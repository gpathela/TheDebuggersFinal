package dice;
/**
*@reviewer Chiranjivi Bashyal
*@course Master of Information Technology
*@subject Programming in Java 2
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
*/

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** Start of the class Game */
public class Game {
	/** Declare, initialise variables that will be used in the code */
	private List<Dice> dice;
	private List<DiceValue> values;
	
	/** Construct a Game object with a parameter of 3 dice */ 	
	public Game(Dice die1, Dice die2, Dice die3) {
		if (die1 == null || die2 == null || die3 == null) throw new IllegalArgumentException("Dice cannot be null.");
		dice = new ArrayList<Dice>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		values = new ArrayList<DiceValue>();
	}

	public List<DiceValue> getDiceValues() {
		values.clear();
		for (Dice d : dice) {
			values.add(d.getValue());
		}
		return Collections.unmodifiableList(values);
	}	
	
	public int playRound(Player player, DiceValue pick, int bet ) {		
		if (player == null) throw new IllegalArgumentException("Player cannot be null.");
		if (pick == null) throw new IllegalArgumentException("Pick cannot be negative.");
		if (bet <= 0) throw new IllegalArgumentException("Bet cannot be negative.");
		
		
		    
		int matches = 0;
		for ( Dice d : dice) {
			d.roll();
			if (d.getValue().equals(pick)) { 
				matches += 1;
			}
		}
		
		int winnings = matches * bet;

		if (matches > 0) {			
			player.receiveWinnings(winnings);
		}else {
			player.takeBet(bet);
		}
        return winnings;		
	}
	
}// End of the class Game