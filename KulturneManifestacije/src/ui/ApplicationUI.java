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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manifestacijedb", "root", "root");
		} catch (Exception e) {
			System.out.println("Greska! Neuspela konekcija na bazu!");
			System.exit(0);
		}
	}
	
	private static void opcije() {
		System.out.println("-------------- Osnovne opcije --------------");
		System.out.println("1. Rad sa gradovima");
		System.out.println("2. Rad sa kulturnim manifestacijama");
		System.out.println("0. Izlaz");
		System.out.print("\n> ");
	}
	
	public static void main(String[] args) {
		int odluka = -1;
		while (odluka != 0) {
			opcije();
			odluka = PomocnaKlasa.ocitajCeoBroj();
			
			switch (odluka) {
			case 1:
				GradUI.meni();
				break;
			case 2:
				ManifestacijeUI.meni();
				break;
			case 0:
				break;
			default:
				System.out.println("Navedena opcija nepostoji");
			}
		}
		
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("Greska kod zatvaranje konekcije!");
			System.exit(0);
		}
	}
}
