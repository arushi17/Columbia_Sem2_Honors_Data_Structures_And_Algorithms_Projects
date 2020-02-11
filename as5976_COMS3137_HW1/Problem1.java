import java.util.*;

/**
 * HW 1 Problem 1: contains findMax method and methods for testing an array of Rectangles
 * @author Arushi Sahai as5976
 *
 */
public class Problem1 {

	public static void main (String[] args) {
		rects = new Rectangle[NUM_RECTS];
		
		// randomly populates an array of rectangles using the final variables below
		Random rand = new Random();
		System.out.println("New rectangles:");
		for (int i = 0; i < rects.length; i++) {
			int length = rand.nextInt(MAX_RECT_SIZE + 1 - MIN_RECT_SIZE) + MIN_RECT_SIZE;
			int width = rand.nextInt(MAX_RECT_SIZE + 1 - MIN_RECT_SIZE) + MIN_RECT_SIZE;
			rects[i] = new Rectangle(length, width);
			System.out.println("Length: " + length + ", Width: " + width + ", Area: " + 
			(length * width) + ", Perimeter: " + (2 * length + 2 * width));
		}
		System.out.println();
		
		// for testing purposes, prints the max by area and perimeter
		System.out.println("Maximum by area: " + findMax(rects, new CompareByArea()));
		System.out.println("Maximum by perimeter: " + findMax(rects, new CompareByPerimeter()));
	}
	
	// findMax method from textbook
	private static <AnyType> AnyType findMax(AnyType [ ] arr, Comparator<? super AnyType> cmp) {
		int maxIndex = 0;
		for(int i = 1; i < arr.length; i++)
		if(cmp.compare(arr[i], arr[maxIndex]) > 0)
			maxIndex = i;
		return arr[maxIndex];
	}
	
	private static Rectangle[] rects;
	private static final int NUM_RECTS = 5;
	private static final int MIN_RECT_SIZE = 2;
	private static final int MAX_RECT_SIZE = 30;
}
