import java.util.Comparator;

/**
 * HW1 problem 1: Comparator method for Problem 1, compares by area
 * @author Arushi Sahai as5976
 *
 */

public class CompareByArea implements Comparator<Rectangle>{

	/**
	 * Comparator method implementation 
	 */
	public int compare(Rectangle rect1, Rectangle rect2) {
		int area1 = rect1.getLength() * rect1.getWidth();
		int area2 = rect2.getLength() * rect2.getWidth();
		return area1 - area2;
	}
}
