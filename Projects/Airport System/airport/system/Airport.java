package airport.system;

import java.util.Scanner;
import java.util.HashMap;

public class Airport {
	
	private static HashMap<String, Airplane> planes = new HashMap<>();
	private static HashMap<String, Flight> flights = new HashMap<>();
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		airportPanel(sc);
		System.out.println();
		flightPanel(sc);
	}
	
	public static void airportPanel(Scanner sc) {
		System.out.println("Airport panel");
		System.out.println("--------------------\n");
		
		String input;
		do {
			System.out.print("Choose operation:\n[1] Add airplane\n[2] Add flight\n[x] Exit\n> ");
			input = sc.nextLine();
			
			switch (input) {
				case "1":
					addPlane(sc);
					break;
				case "2":
					addFlight(sc);
					break;
			}
		} while (!input.equals("x"));
	}
	
	public static void flightPanel(Scanner sc) {
		System.out.println("Flight service");
		System.out.println("--------------------\n");
		
		String input;
		do {
			System.out.print("Choose operation:\n[1] Print planes\n[2] Print flights\n[3] Print plane info\n[x] Quit\n> ");
			input = sc.nextLine();
			
			switch (input) {
				case "1":
					printPlanes();
					break;
				case "2":
					printFlights();
					break;
				case "3":
					searchPlane(sc);
					break;
			}
		} while (!input.equals("x"));
	}
	
	public static void addPlane(Scanner sc) {
		String id;
		int capacity;
		
		String temp;
		
		System.out.print("Give plane ID: ");
		id = sc.nextLine();
		
		do {
			System.out.print("Give plane capacity: ");
			temp = sc.nextLine();
		} while(!isNumberValid(temp));
		capacity = Integer.parseInt(temp);
		
		Airplane plane = new Airplane(id, capacity);
		planes.put(id, plane);
	}
	
	public static void addFlight(Scanner sc) {
		String id;
		String depCode;
		String desCode;
		
		do {
			System.out.print("Give plane ID: ");
			id = sc.nextLine();
		} while (!doesPlaneExist(id));
		
		do {
			System.out.print("Give departure airport code: ");
			depCode = sc.nextLine();
		} while(!isCodeValid(depCode));
		
		do {
			System.out.print("Give destination airport code: ");
			desCode = sc.nextLine();
		} while(!isCodeValid(desCode));
		
		Airplane plane = planes.get(id); 
		Flight flight = new Flight(plane, depCode, desCode);
		flights.put(flight.toString(), flight);
	}
	
	public static void printPlanes() {
		
		if (planes.isEmpty()) {
			System.out.println("No planes found");
			return;
		}
		
		for (Airplane i : planes.values()) {
			System.out.println(i);
		}
	}
	
	public static void printFlights() {
		for (Flight i : flights.values()) {
			System.out.println(i);
		}
	}
	
	public static void searchPlane(Scanner sc) {
		
		String id;
		
		System.out.print("Give plane ID: ");
		id = sc.nextLine();
		
		if (planes.get(id) == null) {
			System.out.println("No plane found");
			return;
		}
		
		System.out.println(planes.get(id));
	}
	
	public static boolean doesPlaneExist(String id) {
		return planes.containsKey(id);
	}
	
	public static boolean isCodeValid(String code) {
		
		if (code.length() == 0 || code == null) {
			return false;
		}
		
		for(int i = 0; i < code.length(); i++) {
			if (Character.isDigit(code.charAt(i))) {
				System.out.println("Error! Code cannot contain numbers");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isNumberValid(String number) {
		try {
			int n = Integer.parseInt(number);
			
			if (n < 0) {
				System.out.println("Error! Capacity cannot be less than zero");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error! Invalid number given");
			return false;
		}
	}
}