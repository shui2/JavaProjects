package pbdex;

import java.util.Scanner;

public class NumberPuzzleII {
	public static void main(String[] args) {
		start();
	}
	
	private static void start() {
		Scanner sc = new Scanner(System.in);
		String answer = null;
		
		do {
			System.out.println("\n1) Find two digit numbers <= 56 with sums of digits > 10");
			System.out.println("2) Find two digit numbers minus number reversed which equals sum of digits");
			System.out.println("3) Quit\n");
			System.out.print("> ");
			answer = sc.nextLine().trim();
			
			switch (answer) {
				case "1": lessThan56Sum10();break;
				case "2": minusReversed();break;
				case "3": break;
				default: System.out.println("Unknown command\n");
			}
		} while(!answer.equals("3"));
	}
	
	private static void lessThan56Sum10() {
		for (int i = 10; i < 100; i++) {
			int sum = (i % 10) + (i / 10);
			if (i <= 56 && sum > 10) System.out.println(i);
		}
	}
	
	private static void minusReversed() {
		for (int i = 10; i < 100; i++) {
			int reversed = Integer.parseInt("" + (i % 10) + (i / 10));
			int sum = (i % 10) + (i / 10);
			if (Math.abs(i - reversed) == sum) System.out.println(i);
		}
	}
}