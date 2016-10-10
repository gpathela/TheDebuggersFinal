/**
*@reviewer Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Programming Principle Practice
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
*
*The class Dice is the program that contains the code to create 
*/

/** Start of the class Dice */
public class Dice {
	/** Declare a variables of type DiceValue that will be used in the code */			
	private DiceValue value;
	
	/** A no-args constructor for a Dice object */ 
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	/** The getValue method returns the value of the Dice object */
	public DiceValue getValue() {
		return value;
	}

	/** The roll returns a random value of the value of the Dice object */
	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	
	/** The toString method returns a string of the value of the Dice object */
	public String toString() {
		return value.toString();
	}
} // End of the Dice class 