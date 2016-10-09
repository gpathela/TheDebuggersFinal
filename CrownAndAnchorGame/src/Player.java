/**
* @reviewer Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 07.10.2016
* @version 1.1
*
*/

/** Start of player class */
public class Player {
	
	/** Declare the variables with private access modifiers */
	private String name;
	private int balance;
	private int limit;
	
	/** Construct an Player object with the specified attribute. */
	public Player(String name, int balance) {
		if (name == null || name .isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
		if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		this.name = name;
		this.balance = balance;
		this.limit = 0;
	}
	
	/** The method getName returns the name of an object */	
	public String getName() {
		return name; 
	}
	
	/** The method getBalance returns the balance of an object */
	public int getBalance() { 
	return balance;
	}
	
	/** The method getLimit returns the limit of an object */
	public int getLimit() { 
	return limit;
	}
	
	/** The method setLimit sets the limit of a player object */
	public void setLimit(int limit) {
		if (limit < 0) throw new IllegalArgumentException("Limit cannot be negative.");
		if (limit > balance)  throw new IllegalArgumentException("Limit cannot be greater than balance.");
		this.limit = limit;
	}
	
	/** The method balanceExceedsLimit returns true or false if the balance is greater than the limit */
	public boolean balanceExceedsLimit() {
		return (balance > limit);
	}
	
	/** 
	* The method balanceExceedsLimitBy returns true or false if the difference between the balance and the
	* amount is greater than the limit 
	*/
	public boolean balanceExceedsLimitBy(int amount) {
		return (balance - amount >= limit);
	}
	
	/** The method takeBet takes an int amount value as a bet and sets the balance */
	public void takeBet(int bet) {
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
                //if (bet == 0) throw new IllegalArgumentException("Bet cannot be Zero.");
		if (!balanceExceedsLimitBy(bet)) throw new IllegalArgumentException("Placing bet would go below limit.");
		balance = balance - bet;
	}
	
	/** The method receiveWinnings takes an int value as a win and sets the balance */
	public void receiveWinnings(int winnings) {
		if (winnings < 0) throw new IllegalArgumentException("Winnings cannot be negative.");
		balance = balance + winnings;		
	}
	
	/** The method toString returns the details of a Player object */
	public String toString() {
		return String.format("Player: %s, Balance: %d, Limit: %d", name, balance, limit);
	}
}	//End of Player class
