package productapp;

import java.util.HashMap;
import java.util.Map;

//	Remember to save the contents into a file
public class Inventory {

	private Map<Integer, Product> products = new HashMap<>();
	
	public Inventory() {
		
	}
	
	public boolean addProduct(Product product) {
		if (doesProductExist(product.getID())) return false;
		
		products.put(product.getID(), product);
		return true;
	}
	
	public void changeProduct(Product product) {
		products.put(product.getID(), product);
	}
	
	public boolean removeQuantity(int id, int amount) {
		
		int quantity = products.get(id).getQuantity();
		if (quantity - amount < 0) return false;
		
		products.get(id).setQuantity(quantity - amount);
		return true;
	}
	
	public boolean removeProduct(int id) {
		if (!doesProductExist(id)) return false;
		products.remove(id);
		return true;
	}
	
	public void printAllProducts() {
		if (products.isEmpty()) {
			System.out.println("No products exist");
			return;
		}
		
		for (Product i : products.values()) {
			System.out.println(i);
		}
	}
	
	public void searchByID(int id) {
		if (!doesProductExist(id)) {
			System.out.println("No product found");
			return;
		}
		
		System.out.println(products.get(id));
	}
	
	public void searchByPrice(double from, double to) {
		boolean flag = false;
		for (Product i : products.values()) {
			if (i.getPrice() >= from && i.getPrice() <= to) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if (!flag)
			System.out.println("No product found");
	}
	
	public void searchByQuantity(int quantity) {
		boolean flag = false;
		for (Product i : products.values()) {
			if (i.getQuantity() == quantity) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if (!flag)
			System.out.println("No product found");
	}
	
	public void searchByName(String name) {
		boolean flag = false;
		for (Product i : products.values()) {
			if (i.getName().equals(name)) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if (!flag)
			System.out.println("No product found");
	}
	
	public boolean doesProductExist(int id) {
		Product temp = products.get(id);
		
		if (temp == null) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%n------------------ Inventory information ------------------%nNumber of products: %d%nInventory worth: $%,.2f%n", products.size(), calculateInventoryValue());
	}
	
	private double calculateInventoryValue() {
		double total = 0;
		for (Product i : products.values())
			total += i.getPrice();
		
		return total;
	}
}