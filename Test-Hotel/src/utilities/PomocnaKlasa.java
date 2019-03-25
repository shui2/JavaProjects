package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PomocnaKlasa {
	
	private static final Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	private PomocnaKlasa() {}
	
	// citanje promenljive Date
	public static Date ocitajDatum() {
		String tekst = "";
		boolean formatirano = false;
		Date datum = null;
		while (!formatirano || tekst.equals("") || tekst == null) {
			tekst = sc.nextLine();
			try {
				datum = sdf.parse(tekst);
				formatirano = true;
			} catch (ParseException pe) {
				System.out.println("Niste uneli podatak validno. Pokusajte ponovo.");
			}
		}
		return datum;
	}

	// Tekstualna validacija
	public static String ocitajTekst() {
		String tekst = sc.nextLine();
		while (tekst == null || tekst.equals("")) {
			System.out.println("GRESKA! Pogresno unesena vrednost, pokusajte ponovo: ");
			tekst = sc.nextLine();
		}

		return tekst;
	}

	// Validacija broja
	public static int ocitajCeoBroj() {
		while (!sc.hasNextInt()) {
			System.out.println("GRESKA! - Pogresno unesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		int ceoBroj = sc.nextInt();
		sc.nextLine(); // cisti sve sa ulaza sto nije broj ili ostatak teste posla broja
		return ceoBroj;
	}

	// Validacija realnog broja
	public static double ocitajRealanBroj() {
		while (!sc.hasNextDouble()) {
			System.out.println("GRESKA! - Pogresno unesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		double realanBroj = sc.nextDouble();
		sc.nextLine(); // cisti sve sa ulaza sto nije broj ili ostatak teste posla broja
		return realanBroj;
	}

	// Validacija karaktera
	public static char ocitajKarakter() {
		String text;
		while ((text = sc.next()) == null || text.length() != 1) {
			System.out.println("GRESKA! - Pogresno unesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		char karakter = text.charAt(0);
		return karakter;
	}

	// Validacija odluke
	public static char ocitajOdlukuOPotvrdi(String tekst) {
		System.out.print("Da li zelite " + tekst + " [Y/N]:");
		char odluka = '\u0000';
		while (!(odluka == 'Y' || odluka == 'N')) {
			odluka = ocitajKarakter();
			if (!(odluka == 'Y' || odluka == 'N')) {
				System.out.println("GRESKA! - Opcije su Y ili N");
			}
		}
		return odluka;
	}
}
