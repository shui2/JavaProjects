package mainpackage;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int n;
		int guess;
		int count = 0;
		System.out.println(
				"=============================== Welcome to the 'Guess the Number' game ===============================");
		System.out.println(
				"The rules are simple, you type in the number between 0-100, and I tell you whether my number is less or greater than your number.");
		System.out.println();
		
		System.out.print("Ready ? Y/N ");
		String answer = sc.nextLine();
		
		if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes")) {
			n = r.nextInt(100);
			 while (true) {
				System.out.print("Type a number: ");
				guess = Integer.parseInt(sc.nextLine());
				
				if (n >= 0) {
					if (guess < 0) {
						System.out.println("There are no negative numbers in the game, try again.");
					}
					
					if (guess > 100) {
						System.out.println("That one is out of bounds, try again.");
					}
				}
				if (guess < n && !(guess < 0)) {
					count++;
					System.out.println("The number is greater than " + guess + ", " + count + " guesses made");
				} else if (guess > n && !(guess > 100)) {
					count++;
					System.out.println("The number is less than " + guess + ", " + count + " guesses made");
				} else if (guess == n) {
					System.out.println("You got it!");
					System.out.print("Play again ? Y/N");
					answer = sc.nextLine();
					if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes")) {
						count = 0;
						break;
					} else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")) {
						System.out.println("Thanks for playing !");
						System.exit(0);
					}
				}
			}
		} else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")) {
			System.out.println("Oh, well. Maybe next time.");
			System.exit(0);
		}
		
	sc.close();
	}

}
