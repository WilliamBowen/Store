package wb.store.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import wb.store.helper.DBMethods;
import wb.store.model.Item;

public class DisplayItemsServlet extends HttpServlet {
	@Resource(name="jdbc/store")
	private DataSource ds;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		ArrayList<Item> items = DBMethods.getAllItems(ds);
		request.setAttribute("items", items);
		RequestDispatcher view = request.getRequestDispatcher("itemDisplay.jsp");
		view.forward(request, response);
	}
}
