/**
*@reviewer Chiranjivi Bashyal
*@course Master of Information Technology
*@subject Programming in Java 2
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
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
		return DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
