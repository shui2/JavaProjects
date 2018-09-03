package productapp;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		
		String input;
		do {
			System.out.println("======== MENU ========");
			System.out.println("1. Add a product");
			System.out.println("2. Change product info");
			System.out.println("3. Remove a product");
			System.out.println("4. Remove a desired quantity from a product");
			System.out.println("5. Print all products");
			System.out.println("6. Search a product by it's ID");
			System.out.println("7. Search all products with a price within a certain range");
			System.out.println("8. Search all products with the specified quantity");
			System.out.println("9. Search all products by the specified name");
			System.out.println("10. Print out inventory info");
			System.out.println("x - Exit");
			
			System.out.print("\nSelect your command: ");
			input = sc.nextLine();
			
			switch (input) {
				case "1":
					add(sc, inventory);
					break;
				case "2":
					change(sc, inventory);
					break;
				case "3":
					remove(sc, inventory);
					break;
				case "4":
					removeQuantity(sc, inventory);
					break;
				case "5":
					printAll(inventory);
					break;
				case "6":
					searchID(sc, inventory);
					break;
				case "7":
					searchPrice(sc, inventory);
					break;
				case "8":
					searchQuantity(sc, inventory);
					break;
				case "9":
					searchName(sc, inventory);
					break;
				case "10":
					printInventoryInfo(inventory);
					break;
				case "x":
					break;
				default:
					System.out.println("Unknown command");
					break;
			}
		} while (!input.equals("x"));
		sc.close();
	}
	
	private static void add(Scanner sc, Inventory inv) {
		int id;
		String name;
		double price;
		int quantity;
		
		String temp;
		
		do {
			System.out.print("Enter product ID: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		id = Integer.parseInt(temp);
		
		System.out.print("Enter product name: ");
		name = sc.nextLine();
		
		do {
			System.out.print("Enter product price: ");
			temp = sc.nextLine();
		} while (!isPriceValid(temp));
		price = Double.parseDouble(temp);
		
		do {
			System.out.print("Enter product quantity: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		quantity = Integer.parseInt(temp);
		
		Product product = new Product(id, name, price, quantity);
		System.out.println((inv.addProduct(product)) ? "\nProduct successfully added" : "\nUnable to add product. Product's ID matches with an existing one");
	}
	
	private static void change(Scanner sc, Inventory inv) {
		int id;
		String name;
		double price;
		int quantity;
		
		String temp;
		
		do {
			System.out.print("Enter product ID: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		id = Integer.parseInt(temp);
		
		if (!inv.doesProductExist(id)) {
			System.out.println("\nProduct with the specified ID does not exist");
			return;
		}
		
		System.out.print("Enter product name: ");
		name = sc.nextLine();
		
		do {
			System.out.print("Enter product price: ");
			temp = sc.nextLine();
		} while (!isPriceValid(temp));
		price = Double.parseDouble(temp);
		
		do {
			System.out.print("Enter product quantity: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		quantity = Integer.parseInt(temp);
		
		Product product = new Product(id, name, price, quantity);
		inv.changeProduct(product);
		System.out.println("\nChange successful");
	}
	
	private static void remove(Scanner sc, Inventory inv) {	
		int id;
		
		String temp;
		do {
			System.out.print("Enter product ID: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		id = Integer.parseInt(temp);
		
		System.out.println((inv.removeProduct(id)) ? "\nProduct successfully removed" : "\nProduct with the specified ID does not exist");
	}
	
	private static void removeQuantity(Scanner sc, Inventory inv) {
		int id;
		int amount;
		
		String temp;
		do {
			System.out.print("Enter product ID: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		id = Integer.parseInt(temp);
		
		if (!inv.doesProductExist(id)) {
			System.out.println("\nProduct with the specified ID does not exist");
			return;
		}
		
		do {
			System.out.print("Enter quantity amount to be removed: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		amount = Integer.parseInt(temp);
		
		System.out.println((inv.removeQuantity(id, amount)) ? "\nSpecified quantity successfully removed" : "\nRemoval failed. Specified amount is greater than the products quantity");
	}
	
	private static void printAll(Inventory inv) {
		inv.printAllProducts();
	}
	
	private static void searchID(Scanner sc, Inventory inv) {
		int id;
		
		String temp;
		do {
			System.out.print("Enter product ID: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		id = Integer.parseInt(temp);
		
		inv.searchByID(id);
	}
	
	private static void searchPrice(Scanner sc, Inventory inv) {
		double from;
		double to;
		
		String temp;
		
		do {
			System.out.print("Enter the minimum range: ");
			temp = sc.nextLine();
		} while (!isPriceValid(temp));
		from = Double.parseDouble(temp);
		
		do {
			System.out.print("Enter the maximum range: ");
			temp = sc.nextLine();
		} while (!isPriceValid(temp));
		to = Double.parseDouble(temp);
		
		if (!isRangeValid(from, to)) {
			System.out.println("\nError! Minimum range cannot be higher than the maximum range");
			return;
		}
		
		inv.searchByPrice(from, to);
	}
	
	private static void searchQuantity(Scanner sc, Inventory inv) {
		int quantity;
		
		String temp;
		
		do {
			System.out.print("Enter amount: ");
			temp = sc.nextLine();
		} while (!isNumberValid(temp));
		quantity = Integer.parseInt(temp);
		
		inv.searchByQuantity(quantity);
	}
	
	private static void searchName(Scanner sc, Inventory inv) {
		String name;
		
		System.out.print("Enter the name of the product: ");
		name = sc.nextLine();
		
		inv.searchByName(name);
	}
	
	private static void printInventoryInfo(Inventory inv) {
		System.out.println(inv);
	}
	
	//	Validation methods
	private static boolean isNumberValid(String n) {
		try {
			int i = Integer.parseInt(n);
			
			if (i < 1) {
				System.out.println("Error! Number cannot be less than 1");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error! Invalid number given");
			return false;
		}
	}
	
	private static boolean isPriceValid(String n) {
		try {
			double i = Double.parseDouble(n);
			
			if (i < 1) {
				System.out.println("Error! Price cannot be less than 1");
				return false;
			}
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Error! Invalid number given");
			return false;
		}
	}
	
	private static boolean isRangeValid(double from, double to) {
		if (from > to)
			return false;
		
		return true;
	}
}