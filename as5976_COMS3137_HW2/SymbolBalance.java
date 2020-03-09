import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * HW2 Problem 1 (programming)
 * @author Arushi Sahai as5976
 *
 */
public class SymbolBalance {

	public static void main (String[] args) {
		System.out.println("Please input the name of the file (without the extension) "
				+ "that you would like to check.");
		Scanner console = new Scanner(System.in);
		String fileName = console.nextLine(); 
		
		readFile(fileName);
		balance();
	}
	
	private static void readFile(String fileName) {
		// NOTE: change the filepath here by hand to test on a different computer
		File file = new File("/Users/arushi/Desktop/" + fileName + ".java"); 
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader buffRead = new BufferedReader(fileReader); 
			String currentLine = "";
			tryCatchReadFile(currentLine, buffRead);
			System.out.println("Loaded from file: " + file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in directory.");
		}
		System.out.println("Lines in file read: " + fileText.size());
	}
	
	private static void tryCatchReadFile(String currentLine, BufferedReader buffRead) {
		try { 
			while((currentLine = buffRead.readLine()) != null) {
				fileText.add(currentLine);
            }
            buffRead.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}
	
	private static void balance() {
		for (int i = 0; i < fileText.size(); i++) {
			boolean inQuote = false;
			boolean inChar = false;
			for (int j = 0; j < fileText.get(i).length(); j++) {
				char current = fileText.get(i).charAt(j);
				if (j > 0 && current == '/' && fileText.get(i).charAt(j-1) == '/') {
					if (!inComment && !inQuote && !inChar) {
						break;
					}
				}
				if (!inComment && !inChar && current == '"') {
					inQuote = !inQuote;
					continue;
				}
				else if (!inComment && !inQuote && current == '\'') {
					inChar = !inChar;
				}
				else if (!inQuote && j > 0) {
					checkComment(current, i, j);
				}
				if (inQuote || inComment || inChar) {
					continue;
				}
				switchOnStacks(current, i);
			}
			if (inQuote) {
				System.out.println("Matching \" not found at line " + (i + 1));
				foundError = true;
			}
			if (inChar) {
				System.out.println("Matching ' not found at line " + (i + 1));
				foundError = true;
			}
		}
		checkClosing();
	}
	
	private static void checkComment(char current, int i, int j) {
		if (current == '*' && fileText.get(i).charAt(j-1) == '/') {
			inComment = true;
		}
		else if (current == '/' && fileText.get(i).charAt(j-1) == '*') {
			if (!inComment) {
				System.out.println("Matching /* not found for */ at line " + (i+1));
				foundError = true;
			}
			inComment = false;
		}
	}
	
	private static void switchOnStacks(char current, int i) {
		switch(current) {
		case '{':
			curlyStack.push(current);
			break;
		case '}':
			if (curlyStack.empty()) {
				System.out.println("Matching { not found for } at line " + (i + 1));
				foundError = true;
			}
			else {
				curlyStack.pop();
			}
			break;
		case '<':
			diamondStack.push(current);
			break;
		case '>':
			if (diamondStack.empty()) {
				System.out.println("Matching < not found for > at line " + (i + 1));
				foundError = true;
			}
			else {
				diamondStack.pop();
			}
			break;
		case '[':
			squareStack.push(current);
			break;
		case ']':
			if (squareStack.empty()) {
				System.out.println("Matching [ not found for ] at line " + (i + 1));
				foundError = true;
			}
			else {
				squareStack.pop();
			}
			break;
		case '(':
			parenStack.push(current);
			break;
		case ')':
			if (parenStack.empty()) {
				System.out.println("Matching ( not found for ) at line " + (i + 1));
				foundError = true;
			}
			else {
				parenStack.pop();
			}
			break;
		}
	}
	
	private static void checkClosing() {
		if (!curlyStack.empty()) {
			System.out.println("Matching } not found for {");
			foundError = true;
		}
		else if (!diamondStack.empty()) {
			System.out.println("Matching > not found for <");
			foundError = true;
		}
		else if (!squareStack.empty()) {
			System.out.println("Matching ] not found for [");
			foundError = true;
		}
		else if (!parenStack.empty()) {
			System.out.println("Matching ) not found for (");
			foundError = true;
		}
		else if (inComment) { 
			System.out.println("Matching */ not found for /*");
			foundError = true;
		}
		else if (!foundError) {
			System.out.println("No errors found. Syntax correct.");
		}
	}
	
	private static ArrayList<String> fileText = new ArrayList<String>(); // stores each line as a String
	private static Stack curlyStack = new Stack();
	private static Stack diamondStack = new Stack();
	private static Stack squareStack = new Stack();
	private static Stack parenStack = new Stack();
	private static boolean inComment = false;
	private static boolean foundError = false;
}
