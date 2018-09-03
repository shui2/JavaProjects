package dnd.diceroller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//	Needs work as contains a lot of bugs
public class Main {
	
	public static void main(String[] args) {
		intro();
		startRolling();
	}
	
	//	Core method
	public static void startRolling() {
		Scanner sc = new Scanner(System.in);
		
		int times;
		int sides;
		
		System.out.print("Please type in the dice you wish to use (5d6, 10d8 etc...): ");
		String temp = sc.nextLine();
		
		if (!temp.contains("d")) {
			System.out.println("Error! Invalid input");
			return;
		}
		
		String[] info = temp.split("d");
		
		if (!isTimesValid(info[0])) return;
		if (!isSideValid(info[1])) return;
		
		times = Integer.parseInt(info[0]);
		sides = Integer.parseInt(info[1]);
		
		Die die = new Die(sides);
		List<Integer> rolls = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			rolls.add(rollADie(die));
		}
		
		System.out.println("Your result is: " + total(rolls));
		System.out.println(rolls);
		
		repeat();
	}
	
	//	Ask the user if he would like to repeat the rolling
	public static void repeat() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("\nRoll again (y/n) ? ");
			String input = sc.nextLine();
			
			if (input.equalsIgnoreCase("n")) break;
			if (input.equalsIgnoreCase("y")) startRolling();
		}
	}
	
	//	Small introductory message
	private static void intro() {
		String introduction = "Welcome to a D&D dice thrower app";
		System.out.println("\n" + introduction);
		for (int i = 0; i < introduction.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	//	Sum of all the collected rolls
	public static int total(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i);
		return sum;
	}
	
	//	Single roll method
	public static int rollADie(Die die) {
		return die.roll();
	}
	
	//	Multi roll method
	public static int rollADie(Die die, int times) {
		int sum = 0;
		for (int i = 0; i < times; i++)
			sum += die.roll();
		
		return sum;
	}
	
	//	Validation methods, to see if the values given for integer values are valid
	public static boolean isTimesValid(String a) {
		try {
			int n = Integer.parseInt(a);
			
			if (n < 1 || n > 100) {
				System.out.println("Error! Number of dice cannot be less than 1 or greater than 100");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error! Invalid input");
			return false;
		}
	}
	
	public static boolean isSideValid(String a) {
		try {
			int n = Integer.parseInt(a);
			
			if (n < 2 || n > 100) {
				System.out.println("Error! Side of the die cannot be less than 2 or greater than 100");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error! Invalid input");
			return false;
		}
	}
}