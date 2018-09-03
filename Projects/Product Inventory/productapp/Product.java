package productapp;

public class Product {

	private String name;
	private int id;
	private double price;
	private int quantity;
	
	public Product(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getID() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return String.format("%nID: %d%nName: %s%nPrice: %,.2f%nQuantity: %d", id, name, price, quantity);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null) return false;
		
		if (!(o instanceof Product)) return false;
		
		Product other = (Product) o;
		
		return id == other.id;
	}
	
	@Override
	public int hashCode() {
		return (7 * name.hashCode()) 
			+ (11 * Integer.hashCode(id)) 
			+ (13 * Double.hashCode(price)) 
			+ (15 * Integer.hashCode(quantity));
	}
}