package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Grad;

public class GradDAO {
	
	public static List<Grad> getAll(Connection conn) {
		List<Grad> gradovi = new ArrayList<>();
		
		String query = "SELECT * FROM grad";
		try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int index = 1;
				
				int ptt = rs.getInt(index++);
				String naziv = rs.getString(index++);
				
				Grad grad = new Grad(ptt, naziv);
				gradovi.add(grad);
			}
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu!");
			e.printStackTrace();
		}
		
		return gradovi;
	}
	
	public static Grad getByID(Connection conn, int ptt) {
		Grad grad = null;
		
		String query = "SELECT * FROM grad WHERE ptt = ?";
		ResultSet rs = null;
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, ptt);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int index = 1;
				
				int id = rs.getInt(index++);
				String naziv = rs.getString(index++);
				
				grad = new Grad(id, naziv);
			}
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return grad;
	}
	
	public static boolean update(Connection conn, Grad grad) {
		boolean retVal = false;
		
		String query = "UPDATE grad SET naziv = ? WHERE ptt = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, grad.getNaziv());
			ps.setInt(2, grad.getPtt());
			
			if (ps.executeUpdate() == 1)
				retVal = true;
		} catch (SQLException e) {
			System.out.println("Greska kod SQL izmene");
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public static boolean delete(Connection conn, Grad grad) {
		boolean retVal = false;
		
		String query = "DELETE FROM grad WHERE ptt = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, grad.getPtt());
			
			if (ps.executeUpdate() == 1)
				retVal = true;
		} catch (SQLException e) {
			System.out.println("Greska kod SQL brisanja");
			e.printStackTrace();
		}
		
		return retVal;
	}
}
