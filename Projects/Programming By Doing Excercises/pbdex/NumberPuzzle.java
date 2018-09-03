package pbdex;

public class NumberPuzzle {
	public static void main(String[] args) {
		for (int i = 10; i < 100; i++) {
			for (int j = 10; j < 100; j++) {
				if (j + i == 60 && Math.abs(j-i) == 14)
					System.out.println(i + " " + j);
			}
		}
	}
}