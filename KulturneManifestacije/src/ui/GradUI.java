package ui;

import java.util.List;

import dao.GradDAO;
import model.Grad;
import utilities.PomocnaKlasa;

public class GradUI {
	
	private static void opcije() {
		System.out.println("------- GRAD OPCIJE -------");
		System.out.println("1. Ispis svih gradova");
		System.out.println("2. Izmena grada");
		System.out.println("3. Brisanje grada");
		System.out.println("0. Izlaz");
		System.out.print("\n> ");
	}
	
	public static void meni() {
		int odluka = -1;
		while (odluka != 0) {
			opcije();
			odluka = PomocnaKlasa.ocitajCeoBroj();
			
			switch (odluka) {
			case 1:
				ispis();
				break;
			case 2:
				izmena();
				break;
			case 3:
				brisanje();
				break;
			default:
				System.out.println("Navedena opcija nepostoji");
			}
		}
	}
	
	public static void ispis() {
		List<Grad> gradovi = GradDAO.getAll(ApplicationUI.conn);
		
		System.out.printf("%n%-5s %s%n", "PTT", "Naziv");
		System.out.println("===== ============");
		for (Grad i : gradovi) {
			System.out.println(String.format("%-5d %s", i.getPtt(), i.getNaziv()));
		}
		System.out.println("==================\n");
	}
	
	public static void izmena() {
		Grad grad = pretragaGrada();
		
		if (grad != null) {
			String naziv;
			
			System.out.print("Unesite novi naziv grada: ");
			naziv = PomocnaKlasa.ocitajTekst();
			
			grad.setNaziv(naziv);
			boolean success = GradDAO.update(ApplicationUI.conn, grad);
			if (success)
				System.out.println("Izmene uspesno izvrsene\n");
			else
				System.out.println("Greska! Izmena neuspesna\n");
		}
	}
	
	public static void brisanje() {
		Grad grad = pretragaGrada();
		
		if (grad != null) {
			boolean success = GradDAO.delete(ApplicationUI.conn, grad);
			if (success)
				System.out.println("Brisanje uspesno izvrseno\n");
			else
				System.out.println("Greska! Brisanje neuspesno");
		}
	}
	
	private static Grad pretragaGrada() {
		Grad grad = null;
		System.out.print("Unesite PTT grada: ");
		int ptt = PomocnaKlasa.ocitajCeoBroj();
		grad = GradDAO.getByID(ApplicationUI.conn, ptt);
		
		if (grad == null)
			System.out.println("Grad sa navedenim PTT-om nepostoji\n");
		
		return grad;
	}
}
