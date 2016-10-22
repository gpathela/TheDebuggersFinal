/**
*@reviewer Gourav Pathela
*@course Master of Information Technology
*@subject Programming Principle Practice
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
*
*The class Dice is the program that contains the code to create a dice a related methods 
*/

public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
		value =  DiceValue.getRandom();
		return value;
	}		
	
	public String toString() {
		return value.toString();
	}
}
