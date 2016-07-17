package wb.store.servlet;

import java.io.IOException;
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

public class EditItemServlet extends HttpServlet{

	@Resource(name="jdbc/store")
	private DataSource ds;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("item_id"));
		
		try{
			ItemService is = new ItemService(ds);
			Item item = (Item)is.getItem(id);
			request.setAttribute("item", item);
			RequestDispatcher view = request.getRequestDispatcher("editForm.jsp");
			view.forward(request, response);
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
