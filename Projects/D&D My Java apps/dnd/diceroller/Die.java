package dnd.diceroller;

import java.util.Random;

public class Die {
	
	private int sides = 6;
	private int[] numbers;
	private Random random = new Random();
	
	public Die() {
		numbers = assignNumbers(6);
	}
	
	public Die(int sides) {
		if (sides > 1) {
			this.sides = sides;
			numbers = assignNumbers(sides);
		}
	}
	
	private int[] assignNumbers(int sides) {
		int[] numbers = new int[sides];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
		}
		return numbers;
	}
	
	public int roll() {
		return random.nextInt(sides) + 1;
	}
	
	@Override
	public String toString() {
		return String.format("%d-sided die (%d-%d)", sides, numbers[0], numbers[numbers.length - 1]);
	}
}
