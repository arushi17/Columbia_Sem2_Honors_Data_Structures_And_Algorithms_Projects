import java.util.Comparator;

/**
 * HW1 problem 1: Comparator method for Problem 1, compares by perimenter
 * @author Arushi Sahai as5976
 *
 */
public class CompareByPerimeter implements Comparator<Rectangle>{

	/**
	 * Comparator method implementation, compares by perimeter
	 */
	public int compare(Rectangle rect1, Rectangle rect2) {
		int perimeter1 = 2 * rect1.getLength() + 2 * rect1.getWidth();
		int perimeter2 = 2 * rect2.getLength() + 2 * rect2.getWidth();
		return perimeter1 - perimeter2;
	}
}