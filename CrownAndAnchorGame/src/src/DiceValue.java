/**
*@reviewer Chiranjivi Bashyal
*@course Master of Information Technology
*@subject Programming in Java 2
*@lecturer Dr Recep Ulusoy
*@due date 07.10.2016
*@version 1.1
*/
package dice;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
		int random = RANDOM.nextInt(DiceValue.SPADE.ordinal());
		return values()[random];
	}
} // End of the enum DiceValue