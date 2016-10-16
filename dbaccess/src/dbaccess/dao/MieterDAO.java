package dbaccess.dao;
import dbaccess.core.Mieter;

import java.sql.Connection;
import java.util.Properties;

import java.util.*;
import java.sql.*;
import java.io.*;

/**
 * 
 * @author viktor fefelov
 *
 */
public class MieterDAO {

	private Connection myConn;
	
	public MieterDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("dbaccess.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public List<Mieter> getAllMieters() throws Exception {
		List<Mieter> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = myConn.createStatement();
			rs = stmt.executeQuery("select * from Mieter");
			
			while (rs.next()) {
				Mieter tempMieter = convertRowToMieter(rs);
				list.add(tempMieter);
				//System.out.println(tempMieter);
			}

			return list;		
		}
		finally {
			close(stmt, rs);
		}
	}
	
	public List<Mieter> searchMieter(String lastName) throws Exception {
		List<Mieter> list = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			lastName += "%";
			stmt = myConn.prepareStatement("select * from Mieter where M_ID like ?");
			
			stmt.setString(1, lastName);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Mieter tempMieter = convertRowToMieter(rs);
				list.add(tempMieter);
			}
			
			return list;
		}
		finally {
			close(stmt, rs);
		}
	}
	
	private Mieter convertRowToMieter(ResultSet rs) throws SQLException {
		
		int mid = rs.getInt("M_ID");
		String mname = rs.getString("M_Name");
		String mstrasse = rs.getString("M_Strasse");
		String mplz = rs.getString("M_PLZ");
		String mort = rs.getString("M_Ort");
		String mtel = rs.getString("M_Telefon");
		
		Mieter tempMieter = new Mieter(mid, mname, mstrasse, mplz, mort, mtel);
		
		return tempMieter;
	}

	
	private static void close(Connection myConn, Statement stmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (stmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement stmt, ResultSet myRs) throws SQLException {
		close(null, stmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		
		MieterDAO dao = new MieterDAO();
//		System.out.println(dao.searchMieter("thom"));

//		System.out.println(dao.getAllMieters());
	}
}

