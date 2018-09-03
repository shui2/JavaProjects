package pbdex;

import java.util.Scanner;

public class Comparing {

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		
		String fWord;
		String sWord;
		
		System.out.print("Type in first word: ");
		fWord = sc.nextLine();
		
		System.out.print("Type in second word: ");
		sWord = sc.nextLine();
		
		System.out.println("Comparing \"" + fWord + "\" with \"" + sWord + "\" produces: " + calculate(fWord, sWord));
	}
	
	private static int calculate(String first, String second) {
		return first.compareTo(second);
	}
}