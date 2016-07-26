package wb.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import wb.store.model.UserBean;

public class UserDAO {
	private Connection myConn;
	
	public UserDAO(Connection myConn){
		this.myConn = myConn;
	}
	
	public UserBean login(UserBean bean) throws SQLException{
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		String query = "select * from users where username='" + username 
				+ "' and password='" + password + "'";
		
		try(Statement stmt = myConn.createStatement();
				ResultSet rs = stmt.executeQuery(query);){
			boolean more = rs.next();
			if (!more){
				bean.setValid(false);;
			}
			else if(more){
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
		} 
		return bean;
	}
	
	public UserBean newUser(UserBean bean) throws SQLException{
		String username = bean.getUsername();
		
		String query = "select * from users where username = '" + username + "'";
		try(Statement stmt = myConn.createStatement();
				ResultSet rs = stmt.executeQuery(query);){
			boolean exists = rs.next();
			if(exists){
				bean.setValid(false);
			} else {
				String password = bean.getPassword();
				String firstName = bean.getFirstName();
				String lastName = bean.getLastName();
				
				query = "insert into users (username, password, firstName, lastName) "
						+ "values ('" + username + "', '" + password + "', '"
						+ firstName + "', '" + lastName + "')";
				stmt.executeQuery(query);
				bean.setValid(true);
			}
		}
		return bean;
	}
}
