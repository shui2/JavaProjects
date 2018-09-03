package pbdex;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		calculateBMI();
		calculateBMIImperial();
		calculateBMIImperial2();
	}
	
	public static void calculateBMI() {
		Scanner sc = new Scanner(System.in);
		
		double height;
		double weight;
		
		System.out.print("Your height in m: ");
		height = sc.nextDouble();
		System.out.print("Your weight in kg: ");
		weight = sc.nextDouble();
		
		double bodyMassIndex = (weight / height) / height;
		System.out.printf("%nYour BMI is %.2f%n", bodyMassIndex);
		System.out.println("BMI Category: " + category(bodyMassIndex));
	}
	
	public static void calculateBMIImperial() {
		Scanner sc = new Scanner(System.in);
		
		double height;
		double weight;
		
		System.out.print("Your height in inches: ");
		height = sc.nextDouble() / 39.370;
		System.out.print("Your weight in pounds: ");
		weight = sc.nextDouble() / 2.204;
		
		double bodyMassIndex = (weight / height) / height;
		System.out.printf("%nYour BMI is %.2f%n", bodyMassIndex);
		System.out.println("BMI Category: " + category(bodyMassIndex));
	}
	
	public static void calculateBMIImperial2() {
		Scanner sc = new Scanner(System.in);
		
		double heightF;
		double heightI;
		double weight;
		
		System.out.print("Your height (feet olny): ");
		heightF = sc.nextDouble() / 3.28;
		System.out.print("Your height (inches): ");
		heightI = sc.nextDouble() / 39.37;
		System.out.print("Your weight in pounds: ");
		weight = sc.nextDouble() / 2.204;
		
		double sum = heightF + heightI;
		double bodyMassIndex = (weight / sum) / sum;
		System.out.printf("%nYour BMI is %.2f%n", bodyMassIndex);
		System.out.println("BMI Category: " + category(bodyMassIndex));
	}
	
	private static String category(double bmi) {
		if (bmi < 15) {
			return "Very severely underweight";
		} else if (bmi <= 16) {
			return "Severely underweight";
		} else if (bmi < 18.5) {
			return "Underweight";
		} else if (bmi < 24.5) {
			return "Normal weight";
		} else if (bmi < 30) {
			return "Overweight";
		} else if (bmi < 35) {
			return "Moderately obese";
		} else if (bmi < 40) {
			return "Severely obese";
		} else {
			return "Very severely obese";
		}
	}
}