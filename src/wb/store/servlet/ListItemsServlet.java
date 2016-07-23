package wb.store.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import wb.store.model.Item;
import wb.store.service.ItemService;

public class ListItemsServlet extends HttpServlet {

	@Resource(name="jdbc/store")
	private DataSource ds;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		try {
			ItemService is = new ItemService(ds);
			List<Item> items = is.getItems();
			request.setAttribute("items", items);
			RequestDispatcher view = request.getRequestDispatcher("ItemList.jsp");
			view.forward(request, response);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		
	}
}
