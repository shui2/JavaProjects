package pbdex;

import java.util.Scanner;

public class RightTriangle {
	public static void main(String[] args) {
		run();
	}
	
	private static void run() {
		Scanner sc = new Scanner(System.in);
		
		int[] sides = new int[3];
		int position = 0;
		
		System.out.println("Enter three integers:");
		while (true) {
			System.out.print("Side " + (position+1) + ": ");
			sides[position] = sc.nextInt();
			if (position != 0 && sides[position] < sides[position-1]) {
				System.out.println(sides[position] + " is smaller than " + sides[position-1] + ". Try again.");
				continue;
			}
			
			if (position == 2) break;
			position++;
		}
		System.out.println();
		System.out.printf("Your three sides are %d %d %d%n", sides[0], sides[1], sides[2]);
		System.out.println((sides[0] < sides[1] && sides[1] < sides[2]) ? "These sides *do* make a right triangle." : "No. These sides do not make a right triangle.");
	}
}