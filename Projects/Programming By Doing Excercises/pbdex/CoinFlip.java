package pbdex;

import java.util.Scanner;
import java.util.Random;

public class CoinFlip {
	public static void main(String[] args) {
		flipACoin();
	}
	
	private static void flipACoin() {
		Scanner sc = new Scanner(System.in);
		Random rng = new Random();
		
		String answer = null;
		do {
			int coin = rng.nextInt(2);
			String side;
			if (coin == 1) {
				side = "TAILS";
			} else {
				side = "HEADS";
			}
			
			System.out.println("You flip a coin and it is... " + side);
			System.out.print("Would you like to flip again (y/n)? ");
			answer = sc.nextLine();
		} while (answer.equals("y"));
	}
}