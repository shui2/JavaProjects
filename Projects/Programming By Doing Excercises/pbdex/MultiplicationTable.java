package pbdex;

public class MultiplicationTable {
	public static void main(String[] args) {
		String intro = "x |\t1\t2\t3\t4\t5\t6\t7\t8\t9";
		System.out.println(intro);
		for (int i = 0; i < (intro.length() + (11*5)); i++)
			System.out.print("=");
		
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			System.out.print(i + " |\t");
			for (int j = 1; j <= 9; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}
}