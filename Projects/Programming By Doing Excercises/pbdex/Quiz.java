package pbdex;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.begin();
	}
	
	public void begin() {
		Scanner sc = new Scanner(System.in);
		
		String answer = null;
		do {
			System.out.print("Are you ready for a quiz (Y/N)? ");
			answer= sc.nextLine().trim();
		
			switch (answer) {
				case "N":
					System.out.println("See you next time!");
					break;
				case "Y":
					start(sc);
					System.exit(0);
					break;
				default:
					System.out.println("Only Y/N is accepted");
					break;
			}
		} while (!answer.equals("N"));
	}
	
	private void start(Scanner sc) {
		int correct = 0;
		int incorrect = 0;
		String answer;
		
		System.out.println("Okay, here it comes!\n");
		System.out.println("Q1) What is the capital of Alaska?");
		System.out.print("\t1) Melbourne\n\t2) Anchorage\n\t3) Juneau\n> ");
		answer = sc.nextLine().trim();
		
		if (correctAnswer(3, answer)) {
			System.out.println("That's right!\n");
			correct++;
		} else {
			System.out.println("Wrong answer!\n");
			incorrect++;
		}
		
		System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
		System.out.print("\t1) Yes\n\t2) No\n> ");
		answer = sc.nextLine().trim();
		
		if (correctAnswer(2, answer)) {
			System.out.println("That's right!\n");
			correct++;
		} else {
			System.out.println("Wrong answer!\n");
			incorrect++;
		}
		
		System.out.println("Q3) What is the result of 9+6/3?");
		System.out.print("\t1) 5\n\t2) 11\n\t3) 15/3\n> ");
		answer = sc.nextLine().trim();
		
		if (correctAnswer(2, answer)) {
			System.out.println("That's right!\n");
			correct++;
		} else {
			System.out.println("Wrong answer!\n");
			incorrect++;
		}
		
		System.out.println("Overall, you got " + correct + " out of 3 correct.");
		System.out.println("Thanks for playing!");
	}

	private boolean correctAnswer(int number, String answer) {
		try {
			int n = Integer.parseInt(answer);
			return n == number;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}