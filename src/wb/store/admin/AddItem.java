package wb.store.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class AddItem extends HttpServlet{

	@Resource(name="jdbc/store")
	private DataSource ds;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//retrieve parameters from the request
		String name = request.getParameter("item_name");
		String description = request.getParameter("item_description");
		String price = request.getParameter("item_price");
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//Get a connection to the database
			myConn = ds.getConnection();
			
			// Prepare statement
			myStmt = myConn.prepareStatement("insert into items "
					+ "(item_name, item_description, item_price) "
					+ "values (?, ?, ?)");
			
			// Set the parameters
			myStmt.setString(1, name);
			myStmt.setString(2, description);
			myStmt.setFloat(3, Float.valueOf(price));
			
			// Execute SQL query
			myStmt.executeUpdate();
			
			request.setAttribute("result", "Item successfully Added to the database.");
			RequestDispatcher view = request.getRequestDispatcher("addItem.jsp");
			view.forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("result", "Something went wrong");
			RequestDispatcher view = request.getRequestDispatcher("addItem.jsp");
			view.forward(request, response);
			
			e.printStackTrace();
		} finally {
			try { myStmt.close(); } catch (Exception e) {/* ignored */ }
			try { myConn.close(); } catch (Exception e) {/* ignored */ }
		}
	}
}
