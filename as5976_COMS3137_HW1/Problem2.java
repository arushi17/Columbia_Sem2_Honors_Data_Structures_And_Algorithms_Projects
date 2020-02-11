import java.util.Arrays;
import java.util.Random;

/**
 * HW 1 problem 2: implements binary search on an array of rectangle objects
 * @author Arushi Sahai as5976
 *
 */
public class Problem2 {
	
	public static void main (String[] args) {
		rects = new Rectangle[NUM_RECTS];
		
		// randomly generates rectangle objects into array
		Random rand = new Random();
		System.out.println("New rectangles:");
		for (int i = 0; i < rects.length; i++) {
			int length = rand.nextInt(MAX_RECT_SIZE + 1 - MIN_RECT_SIZE) + MIN_RECT_SIZE;
			int width = rand.nextInt(MAX_RECT_SIZE + 1 - MIN_RECT_SIZE) + MIN_RECT_SIZE;
			rects[i] = new Rectangle(length, width);
			System.out.println("Length: " + length + ", Width: " + width + ", Area: " + 
			(length * width) + ", Perimeter: " + (2 * length + 2 * width));
		}
		
		System.out.println("\nSorted array:");
		Arrays.sort(rects);
		for (int i = 0; i < rects.length; i++) {
			System.out.println("Length: " + rects[i].getLength() + ", Width: " + rects[i].getWidth() + ", Area: " + 
			(rects[i].getLength() * rects[i].getWidth()) + ", Perimeter: " + (2 * rects[i].getLength() + 2 * rects[i].getWidth()));
		}
		
		int randRectIndex = rand.nextInt(NUM_RECTS);
		System.out.print("\nTesting: given a Rectangle, find index of Rectangle in array with index " + randRectIndex + ": ");
		System.out.println(binarySearch(rects, rects[randRectIndex]));
	}
	
	/**
	 * binary search method, uses a helper
	 * @param <AnyType>
	 * @param a
	 * @param x
	 * @return
	 */
	public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x) {
		return binarySearchRecursive(a, x, 0, a.length - 1);
	}
	
	// helper for binary search method
	private static <AnyType extends Comparable<AnyType>> int binarySearchRecursive(AnyType[] a, AnyType x, int start, int end) {
		int middle = (start + end) / 2;
		
		if (end < start) {
			return -1;
		}
		
		if (x.compareTo(a[middle]) < 0) {
			return binarySearchRecursive(a, x, start, middle - 1);
		}
		
		if (x.compareTo(a[middle]) > 0) {
			return binarySearchRecursive(a, x, middle + 1, end);
		}
		
		if (x.compareTo(a[middle]) == 0) {
			return middle;
		}
		
		return -1;
	}
	
	private static Rectangle[] rects;
	private static final int NUM_RECTS = 7;
	private static final int MIN_RECT_SIZE = 2;
	private static final int MAX_RECT_SIZE = 30;

}
