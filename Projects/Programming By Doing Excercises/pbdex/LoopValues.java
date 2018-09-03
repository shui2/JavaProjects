package pbdex;

import java.util.Scanner;

public class LoopValues {
	public static void main(String[] args) {
		int value = sumUp();
		System.out.println("\nThe total is: " + value);
	}
	
	private static int sumUp() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		System.out.println("I wil;l add up the numbers you give me until you enter '0'");
		while (true) {
			System.out.print("Number: ");
			int value = sc.nextInt();
			if (value == 0) break;
			sum += value;
			System.out.println("The total so far is " + sum);
		}
		return sum;
	}
}