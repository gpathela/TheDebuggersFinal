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
	
	/** The getValue method returns the value of the Dice object */
	public DiceValue getValue() {
		return value;
	}
	
	/** The roll method returns a random value of the Dice object */
	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	/** The method toString returns the details of a Dice object */
	public String toString() {
		return value.toString();
	}//End of toString method
}// End of the Dice class 
