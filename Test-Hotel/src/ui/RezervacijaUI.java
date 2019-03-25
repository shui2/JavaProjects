package ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.RezervacijaDAO;
import dao.SobaDAO;
import model.Rezervacija;
import utilities.PomocnaKlasa;

public class RezervacijaUI {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void ispis() {
		Date odDatum;
		Date doDatum;

		System.out.print("Unesite pocetni period: ");
		odDatum = PomocnaKlasa.ocitajDatum();

		System.out.print("Unesite krajnji period: ");
		doDatum = PomocnaKlasa.ocitajDatum();

		if (odDatum.after(doDatum)) {
			System.out.println("Neispravan unos datuma");
			return;
		}

		System.out.printf("%-5s %-20s %-20s %-15s %-10s %s%n", "ID", "Datum ulaska", "Datum izlaska", "Gost", "Soba",
				"Ukupna vrednost");
		System.out.println("======== ================ ================ ============== ========= ===============");
		List<Rezervacija> rezervacije = RezervacijaDAO.getAll(ApplicationUI.conn);

		for (Rezervacija i : rezervacije) {
			if (i.getDatumUlaza().after(odDatum) && i.getDatumIzlaza().before(doDatum)) {
				long dani = i.getDatumIzlaza().getTime() - i.getDatumUlaza().getTime();
				int vrednost = (int) (dani / (1000 * 60 * 60 * 24));

				System.out.println(String.format("%-5d %-20s %-20s %-15s %-10s %.2f", i.getId(),
						sdf.format(i.getDatumUlaza()), sdf.format(i.getDatumIzlaza()), i.getGost(), i.getSoba().getId(),
						(vrednost * i.getSoba().getCena())));
			}
		}
		System.out.println("===================================================================================");
	}

	public static void izmena() {
		Rezervacija r = pretraga();

		if (r != null) {
			Date ulazak;
			Date izlazak;

			System.out.print("Unesite datum i vreme ulaska: ");
			ulazak = PomocnaKlasa.ocitajDatum();

			System.out.print("Unesite datum i vreme izlaska: ");
			izlazak = PomocnaKlasa.ocitajDatum();

			if (ulazak.after(izlazak)) {
				System.out.println("Datum i vreme ulaska nemogu biti posle datuma i vremena izlaska");
				return;
			}

			List<Rezervacija> rezervacije = RezervacijaDAO.getBySoba(ApplicationUI.conn, r.getSoba().getId());
			for (Rezervacija i : rezervacije) {
				if (i.equals(r))
					continue;
				
				if (!(i.getDatumIzlaza().before(ulazak)) && !(i.getDatumUlaza().after(izlazak))) {
					System.out.println("Greska! Izmene se preklapaju sa vec postojecom rezervacijom");
					return;
				}
			}

			r.setDatumUlaza(ulazak);
			r.setDatumIzlaza(izlazak);

			boolean success = RezervacijaDAO.update(ApplicationUI.conn, r);
			if (success)
				System.out.println("Izmene uspesno sacuvane\n");
			else
				System.out.println("Greska! Izmene neuspesne\n");
		}
	}

	public static void izvestavanje() {
		List<String> gosti = RezervacijaDAO.getDistinctGost(ApplicationUI.conn);
		List<String> sobe = SobaDAO.getDistinctTip(ApplicationUI.conn);
		List<Rezervacija> rezervacije = RezervacijaDAO.getAll(ApplicationUI.conn);
		
		for (String g : gosti) {
			StringBuilder sb = new StringBuilder();
			
			double ukupnaCena = 0;
			for (String s : sobe) {
				StringBuilder build = new StringBuilder();
				double cenaZaJednuSobu = 0;
				
				int nocenja = 0;
				for (Rezervacija r : rezervacije) {
					if (r.getGost().equals(g) && r.getSoba().getTip().equals(s)) {
						long dani = r.getDatumIzlaza().getTime() - r.getDatumUlaza().getTime();
						int jednaSoba = (int) (dani / (1000 * 60 * 60 * 24));
						nocenja += jednaSoba;
						cenaZaJednuSobu += jednaSoba * r.getSoba().getCena();
						ukupnaCena += cenaZaJednuSobu;
					}
				}
				
				build.append("\t" + s + ": " + nocenja + " nocenja, potroseno novca " + cenaZaJednuSobu);
				System.out.println(build);
			}
			sb.append("Gost hotela " + g + " je potrosio ukupno " + ukupnaCena + "\n");
			System.out.println(sb);
		}
	}

	public static Rezervacija pretraga() {
		Rezervacija rezervacija = null;
		System.out.print("Unesite ID rezervacije: ");
		int id = PomocnaKlasa.ocitajCeoBroj();

		rezervacija = RezervacijaDAO.getByID(ApplicationUI.conn, id);
		if (rezervacija == null)
			System.out.println("Rezervacija sa navedenim ID-om nepostoji");

		return rezervacija;
	}
}
