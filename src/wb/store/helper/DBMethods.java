package wb.store.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import wb.store.model.Item;

public class DBMethods {
	
	
	public static ArrayList<Item> getAllItems(DataSource ds){
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		ArrayList<Item> items = new ArrayList<>();
		try {
			//Get a connection to the database
			myConn = ds.getConnection();
			
			// Prepare statement
			myStmt = myConn.createStatement();
			String sql = "select * from items";
			// Execute SQL query
			myRS = myStmt.executeQuery(sql);
			//process the result set
			while (myRS.next()) {
				Item item = new Item(myRS.getString("item_name"), 
									myRS.getString("item_description"),
									Float.valueOf(myRS.getString("item_price")));
				items.add(item);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try { myStmt.close(); } catch (Exception e) {/* ignored */ }
			try { myConn.close(); } catch (Exception e) {/* ignored */ }
			try { myRS.close(); } catch (Exception e) {/* ignored */ }
		}
		return items;
	}
}
