/** Import the libraries that the class will need */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
*@reviewer Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Programming Principle Practice
*@lecturer Dr Recep Arif Ulusoy
*@due date 07.10.2016
*@version 1.1
*
*The DiceValue enum is a special Java class type used to define collections of constants.
*It contains several constants and two methods to create and get random values of a dice. 
*/

/** Start of the enum DiceValue */
public enum DiceValue {
	CROWN, ANCHOR, HEART, DIAMOND, CLUB, SPADE;
	
	private static Random RANDOM = new Random();
	
	private static final Map<DiceValue, String> VALUE_REPR_MAP= new HashMap<DiceValue, String>();
    
	static {
		VALUE_REPR_MAP.put(DiceValue.CROWN, "Crown");
		VALUE_REPR_MAP.put(DiceValue.ANCHOR, "Anchor");
		VALUE_REPR_MAP.put(DiceValue.HEART, "Heart");
		VALUE_REPR_MAP.put(DiceValue.DIAMOND, "Diamond");
		VALUE_REPR_MAP.put(DiceValue.CLUB, "Club");
		VALUE_REPR_MAP.put(DiceValue.SPADE, "Spade");
	}
	
	public String toString(DiceValue value) {
		return VALUE_REPR_MAP.get(value);
	}
	
	public static DiceValue getRandom() {
		int random = RANDOM.nextInt(DiceValue.SPADE.ordinal() + 1);
		return values()[random];
	}
} // End of the enum DiceValue