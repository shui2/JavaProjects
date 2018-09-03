package game;

import java.util.Random;
import java.util.Scanner;

public class Number {
	public static void main(String[] args) {
		intro();
		start();
	}
	
	private static void intro() {
		String intro = "Welcome the number guessing game!";
		System.out.println(intro);
		for (int i = 0; i < intro.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
		
		System.out.printf("%nThe rules are simple, I think of a number between 1-100 and you try to guess which number that is.%n" 
		+ "When you guess correctly, your score will be printed along with the number of guesses you took.%nGood luck!%n");
		System.out.println();
	}
	
	private static void start() {
		Scanner sc = new Scanner(System.in);
		Random rng = new Random();
		int number = rng.nextInt(100) + 1;
		int guesses = 0;
		
		System.out.println("I have thought of a number. Which one is it?");
		while (true) {
			String guess;
			do {
				System.out.print("> ");
				guess = sc.nextLine();
			} while (!isNumberValid(guess));
			int answer = Integer.parseInt(guess);
			
			if (answer < 0 || answer > 100) {
				System.out.println("Out of bounds, try again");
			} else if (answer < number) {
				System.out.println("Incorrect! The number is greater than " + answer + ".\n");
				guesses++;
			} else if (answer > number) {
				System.out.println("Incorrect! The number is less than " + answer + ".\n");
				guesses++;
			}
			if (answer == number) {
				System.out.println("\nCorrect! The number I thought of was " + number);
				guesses++;
				break;
			}
		}
		System.out.println("Number of guesses: " + guesses);
		System.out.println("Result: " + getResult(guesses));
		sc.close();
	}
	
	private static String getResult(int guesses) {
		if (guesses == 1) {
			return "Perfect!!!";
		} else if (guesses <= 3) {
			return "Amazing!";
		} else if (guesses <= 5) {
			return "Great!";
		} else if (guesses <= 10) {
			return "Okay";
		}
		return "Poor";
	}
	
	private static boolean isNumberValid(String number) {
		try {
			int n = Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input given. Please try again!");
			return false;
		}
	}
}