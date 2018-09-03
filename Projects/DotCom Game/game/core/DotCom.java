package game.core;

import java.util.ArrayList;

public class DotCom {

	private ArrayList<String> locationCells = new ArrayList<>();
	private int numberOfHits = 0;
	private String name;
	
	public DotCom() {
		name = "";
	}
	
	public DotCom(String name) {
		this.name = name;
	}
	
	public DotCom(ArrayList<String> location, String name) {
		locationCells = location;
		this.name = name;
	}
	
	public String checkYourself(String guess) {
		
		int index = locationCells.indexOf(guess);
		
		if (index != -1) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				return "kill";
			} else {
				numberOfHits++;
				return "hit";
			}
		}
		
		return "miss";	
	}

	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}

	public int getNumberOfHits() {
		return numberOfHits;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return String.format("Name: %s%nTimes hit: %d%n", name, numberOfHits);
	}
}
