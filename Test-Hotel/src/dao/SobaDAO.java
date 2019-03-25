package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Soba;

public class SobaDAO {

	public static List<Soba> getAllByList(Connection conn) {
		List<Soba> sobe = new ArrayList<>();
		
		String query = "SELECT * FROM sobe";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int index = 1;
				
				int id = rs.getInt(index++);
				String tip = rs.getString(index++);
				int brojKreveta = rs.getInt(index++);
				double cena = rs.getDouble(index++);
				
				sobe.add(new Soba(id, tip, brojKreveta, cena));
			}
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return sobe;
	}
	
	public static Soba getByID(Connection conn, int id) {
		Soba soba = null;
		
		String query = "SELECT * FROM sobe WHERE id = " + id;
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			if (rs.next()) {
				int index = 1;
				
				int sID = rs.getInt(index++);
				String tip = rs.getString(index++);
				int brojKreveta = rs.getInt(index++);
				double cena = rs.getDouble(index);
				
				soba = new Soba(sID, tip, brojKreveta, cena);
			}
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return soba;
	}

	public static List<String> getDistinctTip(Connection conn) {
		List<String> sobe = new ArrayList<>();
		
		String query = "SELECT DISTINCT(tip) FROM sobe";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next())
				sobe.add(rs.getString(1));
			
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return sobe;
	}
}
