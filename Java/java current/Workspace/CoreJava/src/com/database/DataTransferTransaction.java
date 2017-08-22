package com.database;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;
public class DataTransferTransaction {
	public static BasicDataSource createConnections() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("rajo123");
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(10);
		dataSource.setMaxOpenPreparedStatements(100);
	
		return dataSource;		
	}
	public static Connection setConnections() {
		
		try(BasicDataSource dataSource = createConnections()) {			
			Connection dbcon = dataSource.getConnection();
			return dbcon;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void batchUpdates(Connection dbcon)  {
		
		try(PreparedStatement readData = dbcon.prepareStatement("Select * from EMP")) {
			PreparedStatement insertData = dbcon.prepareStatement("INSERT INTO EMP3 VALUES (?,?,?,?,?,?,?,?)");
			ResultSet set = readData.executeQuery();
			try {
				dbcon.setAutoCommit(false);
				while(set.next()) {
					insertData.setInt(1, set.getInt("EMPNO"));
					insertData.setString(2, set.getString("ENAME"));
					insertData.setString(3, set.getString("JOB"));
					insertData.setInt(4, set.getInt("MGR"));
					insertData.setDate(5, set.getDate("HIREDATE"));
					insertData.setInt(6, set.getInt("SAL"));
					insertData.setInt(7, set.getInt("COMM"));
					insertData.setInt(8, set.getInt("DEPTNO"));
					insertData.addBatch();					
				}
				insertData.executeBatch();
				System.out.println("Executed batch");				
				dbcon.commit();
			}catch(Exception e) {
				System.out.println("Could no update");
			}
			finally {
				dbcon.setAutoCommit(true);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Creating connection...");
		Connection dbcon = setConnections();
		System.out.println("Connection established");
		
		batchUpdates(dbcon);

		try {
			System.out.println("Closing connection");
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
