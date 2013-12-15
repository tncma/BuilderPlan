package com.cma.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
/**Provides the core methods for handling database operations.
 * 
 * @author Vasanth
 *
 */
public class DataBase {
	
	private final static PropertyResourceBundle hcssProps = (PropertyResourceBundle) ResourceBundle.getBundle("BuilderPlan");
	/**
	 * Establishes connection to the specified Database driver
	 * provided by the hcssProps. This class will be called to open and close connection
	 * for each service to take place.
	 *   
	 * @return the connection object
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName(hcssProps.getString("DB.DRIVER"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return DriverManager.getConnection(hcssProps.getString("DB.URL"), hcssProps.getString("DB.USER"), hcssProps.getString("DB.PASS"));
		
	}
	/**Closes the ResultSet object
	 * 
	 * @param rs a result set that is to be closed
	 */
	public static void Close(ResultSet rs){
			
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
	/**Closes the Statement object
	 * 
	 * @param st the statement to be closed
	 */
	public static void Close(Statement st){
		
		if (st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**Closes the Database connection
	 * 
	 * @param conn the connection object to be closed
	 */
	public static void Close(Connection conn){
		
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
