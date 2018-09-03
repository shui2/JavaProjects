package blackjack;

import java.util.Random;

public class Blackjack {
	public static void main(String[] args) {
		intro();
		play();
	}
	
	private static void play() {
		Random numbers = new Random();
		int card1 = numbers.nextInt(10) + 1;
		int card2 = numbers.nextInt(10) + 1;
		int playerTotal = card1 + card2;
		
		int dealer1 = numbers.nextInt(10) + 1;
		int dealer2 = numbers.nextInt(10) + 1;
		int dealerTotal = dealer1 + dealer2;
		
		System.out.printf("You drew %d and %d%n", card1, card2);
		System.out.printf("Your total is %d%n", playerTotal);
		
		System.out.printf("%nThe dealer has %d and %d%n", dealer1, dealer2);
		System.out.printf("Dealer's total is %d%n", dealerTotal);
		
		if (playerTotal > dealerTotal)
			System.out.println("\nYOU WIN!");
		else
			System.out.println("\nYOU LOSE!");
	}
	
	private static void intro() {
		String intro = "Welcome to Blackjack!";
		System.out.println("\n" + intro);
		for (int i = 0; i < intro.length(); i++)
			System.out.print("=");
		System.out.println("\n");
	}
}