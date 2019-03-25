package ui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utilities.PomocnaKlasa;

public class ApplicationUI {
	protected static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "root");
		} catch (Exception e) {
			System.out.println("Greska! Neuspela konekcija na bazu");
			System.exit(0);
		}
	}
	
	private static void opcije() {
		System.out.println("---------------- Osnovne opcije ---------------- ");
		System.out.println("\tOpcija broj 1 - Ispis svih soba");
		System.out.println("\tOpcija broj 2 - Ispis svih rezervacija za zadati vremenski period");
		System.out.println("\tOpcija broj 3 - Izmena datuma za postojecu rezervaciju");
		System.out.println("\tOpcija broj 4 - Izvestavanje");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void main(String[] args) {	
		int odluka = -1;
		while(odluka!= 0) {
			opcije();
			System.out.print("> ");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					SobaUI.ispis();
					break;
				case 2:
					RezervacijaUI.ispis();
					break;
				case 3:
					RezervacijaUI.izmena();
					break;
				case 4:
					RezervacijaUI.izvestavanje();
					break;
				default:
					System.out.println("Nepostojeca komanda");
			}
		}
		
		try {conn.close();} 
		catch (SQLException e) {
			System.out.println("Greska pri zatvaranju konekcije!");
		}
	}
}
