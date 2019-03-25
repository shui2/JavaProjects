package ui;

import java.util.List;

import dao.SobaDAO;
import model.Soba;

public class SobaUI {
	
	public static void ispis() {
		List<Soba> sobe = SobaDAO.getAllByList(ApplicationUI.conn);
		
		System.out.println(String.format("%-3s %-15s %-10s %s", "ID", "Tip", "Broj kreveta", "Cena"));
		System.out.println("=== =============== ============ ======");
		for (Soba i : sobe) {
			System.out.printf("%-3d %-10s %-10d %.2f%n", i.getId(), i.getTip(), i.getBrojKreveta(), i.getCena());
		}
		System.out.println();
		System.out.println("========================================");
	}
}
