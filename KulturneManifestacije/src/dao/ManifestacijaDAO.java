package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Grad;
import model.Manifestacija;

public class ManifestacijaDAO {

	public static List<Manifestacija> getAll(Connection conn) {
		List<Manifestacija> manifestacije = new ArrayList<>();
		
		String query = "SELECT * FROM manifestacije";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){
			while (rs.next()) {
				int index = 1;
				
				int id = rs.getInt(index++);
				String naziv = rs.getString(index++);
				int brPosetioca = rs.getInt(index++);
				Grad grad = GradDAO.getByID(conn, rs.getInt(index++));
				
				Manifestacija m = new Manifestacija(id, naziv, brPosetioca, grad);
				if (grad != null)
					grad.getKulturneManifestacije().add(m);
				
				manifestacije.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Greska pri SQL upitu!");
			e.printStackTrace();
		}
		
		return manifestacije;
	}
	
	public static Manifestacija getByID(Connection conn, int id) {
		Manifestacija manifestacija = null;
		
		String query = "SELECT * FROM manifestacije WHERE id = ?";
		ResultSet rs = null;
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int index = 1;
				
				int mID = rs.getInt(index++);
				String naziv = rs.getString(index++);
				int brPosetioca = rs.getInt(index++);
				Grad grad = GradDAO.getByID(conn, rs.getInt(index++));
				
				manifestacija = new Manifestacija(mID, naziv, brPosetioca, grad);
				if (grad != null)
					grad.getKulturneManifestacije().add(manifestacija);
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
		return manifestacija;
	}
	
	public static boolean insert(Connection conn, Manifestacija manifestacija) {
		boolean retVal = false;
		
		String query = "INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES (?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			int index = 1;
			
			ps.setString(index++, manifestacija.getNaziv());
			ps.setInt(index++, manifestacija.getBrojPosetioca());
			ps.setInt(index++, manifestacija.getGrad().getPtt());
			
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println("Greska kod SQL brisanja");
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public static boolean update(Connection conn, Manifestacija manifestacija) {
		boolean retVal = false;
		
		String query = "UPDATE manifestacije SET naziv = ?, brPosetioca = ?, grad = ? WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			int index = 1;
			
			ps.setString(index++, manifestacija.getNaziv());
			ps.setInt(index++, manifestacija.getBrojPosetioca());
			ps.setInt(index++, manifestacija.getGrad().getPtt());
			ps.setInt(index++, manifestacija.getId());
			
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println("Grska kod SQL izmene");
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public static boolean delete(Connection conn, Manifestacija manifestacija) {
		boolean retVal = false;
		
		String query = "DELETE FROM manifestacije WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, manifestacija.getId());
			
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println("Greska kod SQL brisanja");
			e.printStackTrace();
		}
		
		return retVal;
	}
}
