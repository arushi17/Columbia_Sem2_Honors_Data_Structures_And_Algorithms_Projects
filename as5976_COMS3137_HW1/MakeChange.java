import java.util.ArrayList;
import java.util.Arrays;

/**
 * HW1 problem 3: recursively determines the different combinations of quarter, dimes, 
 * and nickets to make change
 * @author Arushi Sahai as5976
 *
 */
public class MakeChange {

	public static void main (String[] args) {
		System.out.print("Change for " + CHANGE + " = ");
		if(!makeChange(CHANGE, validCoins.get(0), "")) {
			System.out.println("cannot be changed");
		}
	}
	
	/**
	 * Recursive method, returns true if change path found, false if not
	 * @param change
	 * @param coin
	 * @param currentSequence
	 */
	public static boolean makeChange(int change, int coin, String currentSequence) {
		int smallerCoin = -1;
		if (validCoins.size() != validCoins.indexOf(coin) + 1) {
			// a smaller coin exists
			smallerCoin = validCoins.get(validCoins.indexOf(coin) + 1);
		}
		
		int numFit = change / coin;
		boolean foundPath = false;
		for (int i = 0; i < numFit; i++) {
			if (smallerCoin != -1) {
				// try the current sequence with smaller coins for the rest of the change
				if(makeChange(change, smallerCoin, currentSequence)) {
					foundPath = true;
				}
			}
			change = change - coin;
			currentSequence += coin + " "; 
		}
		if (change > 0) {
			// have fit all of one coin into change as possible, but there is still change left 
			if (smallerCoin == -1) {
				return false;
			}
			else {
				if(makeChange(change, smallerCoin, currentSequence)) {
					foundPath = true;
				}
			}
		}
		else if (change == 0) {
			// base case: reached the bottom
			System.out.println(currentSequence);
			return true;
		}
		return foundPath;
	}
	
	private static final int CHANGE = 45;
	private static ArrayList<Integer> validCoins = new ArrayList<Integer>(Arrays.asList(25, 10, 5));
}
