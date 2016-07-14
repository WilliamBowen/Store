package wb.store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeFormProcessor extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		
		request.setAttribute("full_name", first_name + " " + last_name);
		
		RequestDispatcher view = request.getRequestDispatcher("greeting.jsp");
		view.forward(request,  response);
	}

}
