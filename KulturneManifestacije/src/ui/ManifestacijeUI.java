package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.GradDAO;
import dao.ManifestacijaDAO;
import model.Grad;
import model.Manifestacija;
import utilities.PomocnaKlasa;

public class ManifestacijeUI {

	private static void opcije() {
		System.out.println("------- MANIFESTACIJA OPCIJE -------");
		System.out.println("1. Ispis kulturnih manifestacija");
		System.out.println("2. Pretraga kulturne manifestacije");
		System.out.println("3. Unos nove kulturne manifestacije");
		System.out.println("4. Izmena kulturne manifestacije");
		System.out.println("5. Brisanje kulturne manifestacije");
		System.out.println("6. Pisanje izvestaja za kulturne manifestacije u fajl");
		System.out.println("7. Citanje izvestaja za kulturne manifestacije iz fajla");
		System.out.println("0. Izlaz");
		System.out.print("\n> ");
	}

	public static void meni() {
		File file = new File("." + File.separator + "data" + File.separator + "manifestacije.txt");

		int odluka = -1;
		while (odluka != 0) {
			opcije();
			odluka = PomocnaKlasa.ocitajCeoBroj();

			switch (odluka) {
			case 1:
				ispis();
				break;
			case 2:
				pretraga();
				break;
			case 3:
				unos();
				break;
			case 4:
				izmena();
				break;
			case 5:
				brisanje();
				break;
			case 6:
				izvestajWrite(file);
				break;
			case 7:
				izvestajRead(file);
				break;
			default:
				System.out.println("Navedena opcija nepostoji");
			}
		}
	}

	public static void ispis() {
		List<Manifestacija> manifestacije = ManifestacijaDAO.getAll(ApplicationUI.conn);

		System.out.printf("%n%-4s %-15s %-10s %s%n", "ID", "Naziv", "Broj posetilaca", "Grad");
		System.out.println("===  ==============  =============== =========");
		for (Manifestacija i : manifestacije) {
			System.out.println(String.format("%-4d %-15s %-15d %s", i.getId(), i.getNaziv(), i.getBrojPosetioca(),
					i.getGrad().getNaziv()));
		}
		System.out.println("==============================================\n");
	}

	public static void pretraga() {
		Manifestacija m = pretragaPoID();
		if (m != null) {
			System.out.printf("%n%-4s %-15s %-10s %s%n", "ID", "Naziv", "Broj posetilaca", "Grad");
			System.out.println("===  ==============  =============== =========");
			System.out.println(String.format("%-4d %-15s %-15d %s", m.getId(), m.getNaziv(), m.getBrojPosetioca(), m.getGrad().getNaziv()));
			System.out.println("==============================================\n");
		}
	}

	private static Manifestacija pretragaPoID() {
		Manifestacija retVal = null;
		System.out.print("Unesite ID manifestacije: ");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = ManifestacijaDAO.getByID(ApplicationUI.conn, id);

		if (retVal == null)
			System.out.println("Manifestacija sa navedenim ID-om nepostoji\n");

		return retVal;
	}

	public static void unos() {
		String naziv;
		int brPosetioca;
		Grad grad;
		
		System.out.print("Unesite naziv manifestacije: ");
		naziv = PomocnaKlasa.ocitajTekst();
		
		System.out.print("Unesite broj posetilaca: ");
		brPosetioca = PomocnaKlasa.ocitajCeoBroj();
		
		System.out.print("Unesite PTT grada: ");
		int ptt = PomocnaKlasa.ocitajCeoBroj();
		
		grad = GradDAO.getByID(ApplicationUI.conn, ptt);
		if (grad == null) {
			System.out.println("Grad sa navedenim PTT-om nepostoji!");
			return;
		}
		
		Manifestacija manifestacija = new Manifestacija(0, naziv, brPosetioca, grad);
		boolean success = ManifestacijaDAO.insert(ApplicationUI.conn, manifestacija);
		if (success)
			System.out.println("Manifestacija uspesno dodata\n");
		else
			System.out.println("Dodavanje manifestacije je bilo neuspesno\n");
	}

	public static void izmena() {
		Manifestacija m = pretragaPoID();
		
		if (m != null) {
			String naziv;
			int brPosetioca;
			Grad grad;
			
			System.out.print("Unesite novi naziv: ");
			naziv = PomocnaKlasa.ocitajTekst();
			
			System.out.print("Unesite broj posetilaca: ");
			brPosetioca = PomocnaKlasa.ocitajCeoBroj();
			
			System.out.print("Unesite PTT grada: ");
			int ptt = PomocnaKlasa.ocitajCeoBroj();
			
			grad = GradDAO.getByID(ApplicationUI.conn, ptt);
			if (grad == null) {
				System.out.println("Grad sa navedenim PTT-om nepostoji");
				return;
			}
			
			m.setNaziv(naziv);
			m.setBrojPosetioca(brPosetioca);
			m.setGrad(grad);
			boolean success = ManifestacijaDAO.update(ApplicationUI.conn, m);
			if (success)
				System.out.println("Izmena uspesno izvrsena\n");
			else
				System.out.println("Greska! Izmena neuspesna\n");
		}
	}

	public static void brisanje() {
		Manifestacija m = pretragaPoID();
		
		if (m != null) {
			boolean success = ManifestacijaDAO.delete(ApplicationUI.conn, m);
			if (success)
				System.out.println("Brisanje uspesno\n");
			else
				System.out.println("Greska! Brisanje neuspesno\n");
		}
	}

	public static void izvestajWrite(File file) {
		List<Manifestacija> manifestacije = ManifestacijaDAO.getAll(ApplicationUI.conn);
		
		int brPosetioca = -1;
		Manifestacija m = null;
		for (Manifestacija i : manifestacije) {
			if (i.getBrojPosetioca() > brPosetioca) {
				brPosetioca = i.getBrojPosetioca();
				m = i;
			}
		}
		
		if (brPosetioca != -1 && m != null) {
			if (file.exists()) {
				try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
					pw.println(m.toFileRepresentation());
					pw.flush();
					System.out.println("Pisanje izvestaja uspesno!\n");
				} catch (IOException e) {
					System.out.println("Greska pri ucitavanju datoteke");
					e.printStackTrace();
				}
			} else {
				System.out.println("Greska! Datoteka " + file.getName() + " nije pronadjena");
			}
		}
	}

	public static void izvestajRead(File file) {
		String line;
		
		if (file.exists()) {
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				if ((line = br.readLine()) != null) {
					System.out.println("Kulturna manifestacija sa najvecim brojem posteioca");
					System.out.println("---------------------------------------------------");
					System.out.println("\t\t" + line);
					System.out.println("---------------------------------------------------\n");
				}
			} catch (FileNotFoundException e) {
				System.out.println("Greska pri ucitavanju datoteke");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Greska pri ucitavanju datoteke");
				e.printStackTrace();
			}
		} else {
			System.out.println("Greska! Datoteka " + file.getName() + " nije pronadjena.");
		}
		
		
		
	}
}
