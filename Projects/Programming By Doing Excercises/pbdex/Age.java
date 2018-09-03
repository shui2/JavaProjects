package pbdex;

import java.util.Scanner;

public class Age {

	public static void main(String[] args) {
		getAge();	
	}
	
	public static void getAge() {
		Scanner sc = new Scanner(System.in);
		
		String name;
		System.out.print("Hey, what's your name? ");
		name = sc.nextLine();
		
		System.out.print("Ok, " + name + " how old are you? ");
		int age = sc.nextInt();
		
		if (age < 16) {
			System.out.println("You can't drive");
		}
		
		if (age < 18) {
			System.out.println("You can't vote");
		}
		
		if (age < 25) {
			System.out.println("You can't rent a car");
		}
		
		if (age >= 25) {
			System.out.println("You can do anything that's legal");
		}
	}
}