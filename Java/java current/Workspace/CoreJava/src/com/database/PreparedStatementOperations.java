package com.database;
import java.sql.*;

public class PreparedStatementOperations {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection dbcon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "rajo123"); 
		PreparedStatement st = dbcon.prepareStatement("SELECT * FROM DEPT");
		
//		PreparedStatement stup = dbcon.prepareStatement("UPDATE DEPT set DNAME=? where DNAME=? ");
//		stup.setString(1, "SALES");
//		stup.setString(2, "HR");
//		PreparedStatement stInsert= dbcon.prepareStatement("INSERT INTO DEPT VALUES(?,?,?)");
//		stInsert.setInt(1, 80);
//		stInsert.setString(2, "TEST");
//		stInsert.setString(3, "MUMBAI");
//		stInsert.executeUpdate();
		PreparedStatement stDelete= dbcon.prepareStatement("DELETE FROM DEPT WHERE DNAME=? ");
		stDelete.setString(1, "TNP");
		stDelete.executeUpdate();
		ResultSet set = st.executeQuery();
		System.out.println("Records updates: ");
		while(set.next()) {
			System.out.println(set.getInt("DEPTNO")+ " "+ set.getString("DNAME")+ " "+ set.getString("LOC"));
		}
		
		st.close();
		dbcon.close();
		
		
	}

}

