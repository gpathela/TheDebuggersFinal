/** Import some libraries to be used in the code */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 07.10.2016
* @version 1.2
*
*/

/** Start of Game class */
public class Game {

    /**
     * Declare and initialize the variable for the class with private visibility
     */
    private List<Dice> dice;
    private List<DiceValue> values;

    /**
     * Construct an Game object with the specified attribute.
     */
    public Game(Dice die1, Dice die2, Dice die3) {
        if (die1 == null || die2 == null || die3 == null) {
            throw new IllegalArgumentException("Dice cannot be null.");
        }
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

    public int playRound(Player player, DiceValue pick, int bet) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        if (pick == null) {
            throw new IllegalArgumentException("Pick cannot be negative.");
        }
        if (bet < 0) {
            throw new IllegalArgumentException("Bet cannot be negative.");
        }

        

        int matches = 0;
        for (Dice d : dice) {
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

}//End of Game class
