/**
 * HW1 problem 1: Defines a rectangle object that implements Comparable
 * @author Arushi Sahai as5976
 *
 */

public class Rectangle implements Comparable<Rectangle> {

	/**
	 * Constructor
	 * @param length
	 * @param width
	 */
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Getter for length
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Getter for width
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Overrides the default toString method
	 */
	public String toString() {
		return "Length: " + length + ", Width: " + width;
	}
	
	/**
	 * Comparable interface implementation 
	 */
	public int compareTo(Rectangle rectComp) {
		int areaRect = width * length;
		int areaRectComp = rectComp.width * rectComp.length;
		return areaRect - areaRectComp;
	}
	
	private int length;
	private int width;
	
}
