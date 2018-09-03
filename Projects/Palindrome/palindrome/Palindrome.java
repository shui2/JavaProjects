package palindrome;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input;
		while (true) {
			System.out.print("Type in the text to check if it is palindrome (x to exit): ");
			input = sc.nextLine();
			
			if (input.equals("x")) break;
			
			System.out.println("Is palindrome: " + (isPalindrome(input) ? "Yes" : "No"));
		}
	}
	
	public static boolean isPalindrome(String text) {
	
		String reverse = "";
		for (int i = text.length() - 1; i >= 0; i--)
			reverse += text.charAt(i);
		
		return reverse.equals(text);
	}
}