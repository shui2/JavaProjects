package pbdex;

import java.util.Scanner;

public class Schedule {

	public static void main(String[] args) {
		displaySchedule();
	}
	
	public static void displaySchedule() {
		Scanner sc = new Scanner(System.in);
		
		String[] courses = new String[8];
		System.out.println("Input info for courses");
		for (int i = 0; i < courses.length; i++) {
			courses[i] = sc.nextLine();
		}
		
		System.out.println("Input info for teachers");
		String[] teachers = new String[8];
		for (int i = 0; i < teachers.length; i++) {
			teachers[i] = sc.nextLine();
		}
		
		printLines();
		
		for (int i = 0; i < courses.length; i++) {
			System.out.printf("|%d|%26s|%15s|%n", i+1, courses[i], teachers[i]);
		}
		
		printLines();
	}
	
	private static void printLines() {
		System.out.print("+");
		for (int i = 0; i < 50; i++)
			System.out.print("-");
		System.out.println("+");
	}
}