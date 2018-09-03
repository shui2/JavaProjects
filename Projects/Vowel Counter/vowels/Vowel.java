package vowels;

import java.util.Scanner;

public class Vowel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input a word: ");
		System.out.println(countVowels(sc.nextLine()));
	}

	public static String countVowels(String word) {
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		
		for (int j = 0; j < word.length(); j++) {
		
			if (word.charAt(j) == 'a' || word.charAt(j) == 'A'){
				a++;
				continue;
			}
		
			if (word.charAt(j) == 'e' || word.charAt(j) == 'E') {
				e++;
				continue;
			}
			
			if (word.charAt(j) == 'i' || word.charAt(j) == 'I') {
				i++;
				continue;
			}
		
			if (word.charAt(j) == 'o' || word.charAt(j) == 'O') {
				o++;
				continue;
			}
		
			if (word.charAt(j) == 'u' || word.charAt(j) == 'U') {
				u++;
			}
		}
		
		int sum = a + e + i + o + u;
		return String.format("Number of vowels in the text: %d%nA: %d%nE: %d%nI: %d%nO: %d%nU: %d", sum, a, e, i, o, u);
	}
}