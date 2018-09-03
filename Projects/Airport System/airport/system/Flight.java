package airport.system;

public class Flight {
	
	private String depCode;
	private String desCode;
	private Airplane plane;
	
	public Flight() {
		depCode = "";
		desCode = "";
		plane = new Airplane();
	}
	
	public Flight(Airplane plane, String depCode, String desCode) {
		this.plane = plane;
		this.depCode = depCode;
		this.desCode = desCode;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s-%s)", plane, depCode, desCode);
	}
}