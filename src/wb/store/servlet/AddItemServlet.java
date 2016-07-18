package wb.store.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import wb.store.model.Item;
import wb.store.service.ItemService;

public class AddItemServlet extends HttpServlet{

	@Resource(name="jdbc/store")
	private DataSource ds;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//check if id already exists
		if(request.getParameter("action") == "update"){
			//redirect to edit servlet
			RequestDispatcher rd = request.getRequestDispatcher("edit");
			rd.forward(request, response);
		}
		
		//retrieve parameters from the request
		String name = request.getParameter("item_name");
		String description = request.getParameter("item_description");
		String price = request.getParameter("item_price");
		
		Item item = new Item(name, description, Float.valueOf(price));
		try{
			ItemService is = new ItemService(ds);
			Long id = (Long)is.addItem(item);
			request.setAttribute("id", id);
			RequestDispatcher view = request.getRequestDispatcher("ItemOutput.jsp");
			view.forward(request, response);
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
