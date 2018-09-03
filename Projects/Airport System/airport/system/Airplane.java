package airport.system;

public class Airplane {
	
	private String id;
	private int capacity;
	
	public Airplane() {
		id = "noid";
		capacity = 0;
	}
	
	public Airplane(String id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	public String getID() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d ppl)", id, capacity);
	}
}