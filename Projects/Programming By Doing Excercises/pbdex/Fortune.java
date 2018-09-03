package pbdex;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Fortune {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(getFortune(rand));
		System.out.println(getLottoNumbers(rand));
	}
	
	private static String getFortune(Random rng) {
		String[] array = {"\"You will find happiness with a new love\"",
						"\"Stick with your wife\"",
						"\"Use a fireball spell on a lot of enemies grouped together\"",
						"\"Deposit money in your account\"",
						"\"Use polymorphism when classes share a common type/interface\"",
						"\"Executables are programs containing the machine code of the instructions you've written within the source code\""};
		String fortune = array[rng.nextInt(6)];
		return "Fortune cookie says: " + fortune;
	}
	
	private static List getLottoNumbers(Random rng) {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() != 6) {
			int a = rng.nextInt(54) + 1;
			if (!doesNumberExist(numbers, a))
				numbers.add(a);
		}
		return numbers;
	}
	
	private static boolean doesNumberExist(List<Integer> nums, int number) {
		for (int i : nums) {
			if (i == number) return true;
		}
		return false;
	}
}