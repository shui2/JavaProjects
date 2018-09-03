package pbdex;

import java.util.Scanner;

public class CollatzSequence {
	public static void main(String[] args) {
		start();
	}
	
	private static void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int steps = 0;
		int largest = number;
		
		System.out.print(number + "\t");
		do {
			if (number % 2 == 0)
				number /= 2;
			else
				number = (number * 3) + 1;
			
			if (largest < number) largest = number;
			System.out.print(number + "\t");
			steps++;
		} while (number != 1);
		
		System.out.println();
		System.out.println("\nTerminated after " + steps + " steps. The largest value was " + largest);
	}
}