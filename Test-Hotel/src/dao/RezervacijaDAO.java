package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Rezervacija;
import model.Soba;

public class RezervacijaDAO {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static List<Rezervacija> getAll(Connection conn) {
		List<Rezervacija> rezervacije = new ArrayList<>();
		
		String query = "SELECT * FROM rezervacije";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int index = 1;
				
				int id = rs.getInt(index++);
				int sobaID = rs.getInt(index++);
				Soba soba = SobaDAO.getByID(conn, sobaID);
				Date ulazak = sdf.parse(rs.getString(index++));
				Date izlazak = sdf.parse(rs.getString(index++));
				String gost = rs.getString(index++);
				
				rezervacije.add(new Rezervacija(id, soba, ulazak, izlazak, gost));
			}
		} catch (Exception e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return rezervacije;
	}
	
	public static Rezervacija getByID(Connection conn, int id) {
		Rezervacija retVal = null;
		
		String query = "SELECT * FROM rezervacije WHERE id = " + id;
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			if (rs.next()) {
				int index = 1;
				
				int rID = rs.getInt(index++);
				int idSobe = rs.getInt(index++);
				Soba soba = SobaDAO.getByID(conn, idSobe);
				Date ulazak = sdf.parse(rs.getString(index++));
				Date izlazak = sdf.parse(rs.getString(index++));
				String gost = rs.getString(index++);
				
				retVal = new Rezervacija(rID, soba, ulazak, izlazak, gost);
			}
		} catch (Exception e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public static List<Rezervacija> getBySoba(Connection conn, int soba) {
		List<Rezervacija> rezervacije = new ArrayList<>();
		
		String query = "SELECT * FROM rezervacije WHERE soba = " + soba;
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				int index = 1;
				
				int id = rs.getInt(index++);
				int sobaID = rs.getInt(index++);
				Soba s = SobaDAO.getByID(conn, sobaID);
				Date ulazak = sdf.parse(rs.getString(index++));
				Date izlazak = sdf.parse(rs.getString(index++));
				String gost = rs.getString(index++);
				
				rezervacije.add(new Rezervacija(id, s, ulazak, izlazak, gost));
			}
		} catch (Exception e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return rezervacije;
	}
	
	public static List<String> getDistinctGost(Connection conn) {
		List<String> gosti = new ArrayList<>();
		
		String query = "SELECT DISTINCT(gost) FROM rezervacije";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next())
				gosti.add(rs.getString(1));
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu");
			e.printStackTrace();
		}
		
		return gosti;
	}
	
	public static boolean update(Connection conn, Rezervacija rezervacija) {
		boolean retVal = false;
		
		String query = "UPDATE rezervacije SET ulazak = ?, izlazak = ? WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, sdf.format(rezervacija.getDatumUlaza()));
			ps.setString(2, sdf.format(rezervacija.getDatumIzlaza()));
			ps.setInt(3, rezervacija.getId());
			
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println("Greska kod SQL izmene");
			e.printStackTrace();
		}
		
		return retVal;
	}
}
