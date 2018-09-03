package pbdex;

import java.util.Scanner;

public class SqrRoot {
	public static void main(String[] args) {
		calculate();
	}
	
	private static void calculate() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("SQUARE ROOT!");
		int number = 0;
		do {
			System.out.print("Enter a number: ");
			number = sc.nextInt();
			
			if (number < 0) 
				System.out.println("You can't take the square root of a negative number");
			else
				System.out.println("The square root of " + number + " is " + (Math.sqrt(number)));
		} while (number < 0);
	}
}