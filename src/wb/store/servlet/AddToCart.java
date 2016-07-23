package wb.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wb.store.model.Cart;

public class AddToCart extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart shoppingCart;
		shoppingCart = (Cart) session.getAttribute("cart");
		if(shoppingCart == null){
			shoppingCart = new Cart();
			session.setAttribute("cart", shoppingCart);
		}
		Integer id = Integer.parseInt(request.getParameter("item_id"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		shoppingCart.addToCart(id, quantity);
		session.setAttribute("cart", shoppingCart);
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}
}
