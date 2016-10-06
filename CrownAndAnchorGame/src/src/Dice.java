/**
* @reviewer Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 07.10.2016
* @version 1.1
*
*/

/** Start of the class Dice */
public class Dice {
	
	/** Declare the variables with private access modifiers */
	private DiceValue value;
	
	/** A non-argument constructor for a Dice object */ 
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
