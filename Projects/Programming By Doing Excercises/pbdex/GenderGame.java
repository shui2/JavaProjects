package pbdex;

import java.util.Scanner;

public class GenderGame {

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is your gender (M or F): ");
		String gender = sc.nextLine().trim();
		
		String fName;
		String lName;
		int age;
		
		System.out.print("First name: ");
		fName = sc.nextLine();
		System.out.print("Last name: ");
		lName = sc.nextLine();
		System.out.print("Age: ");
		age = Integer.parseInt(sc.nextLine());
		
		if (gender.equals("F")) {
			if (age >= 20) {
				
				System.out.print("Are you married, " + fName + " (Y/N)? ");
				String answer = sc.nextLine().trim();
			
				if (answer.equals("Y")) {
					System.out.println("Then I shall call you Mrs. " + lName);
				} else {
					System.out.println("Then I shall call you " + fName + " " + lName);
				}
			} else
				System.out.println("Then I shall call you Ms. " + lName);
		} else {
			if (age >= 20) System.out.println("Then I shall call you Mr. " + lName);
			else System.out.println("Then I shall call you " + fName + " " + lName);
		}
	}
}