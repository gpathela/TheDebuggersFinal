/**
*@author Gourav Pathela
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@version 1.0
*
*		The TestTwoDice class is a program to test condition 2 of the game.
*		Here I will try to make object of game with 2 dices only.  
*/

/** Start of the class TestTwoDice */
public class TestTwoDice {

	public static void main(String[] args) {
		
		
		Dice d1 = new Dice();
        Dice d2 = new Dice();
        
        //Game object with two dices shall not run 
        //It shall give message that dice can't be null
        Game testGame = new Game(d1,d2, null);
        
        System.out.println("This should never be printed.There should be an error instead");
        

	}

}
