package pbdex;

import java.util.Random;

public class DiceDoubles {
	public static void main(String[] args) {
		rollEm();
	}
	
	private static void rollEm() {
		Random rng = new Random();
		int rollOne = 0;
		int rollTwo = 0;
		
		System.out.println("HERE COMES THE DICE!");
		do {
			rollOne = rng.nextInt(6) + 1;
			rollTwo = rng.nextInt(6) + 1;
			
			System.out.printf("%nRoll #1: %d%nRoll #2: %d%nThe total is %d!%n", rollOne, rollTwo, rollOne + rollTwo);
		} while (rollOne != rollTwo);
	}
}