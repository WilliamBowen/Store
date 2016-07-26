package wb.store.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import wb.store.model.UserBean;
import wb.store.service.UserService;

public class LoginServlet extends HttpServlet{
	@Resource(name="jdbc/store")
	private DataSource ds;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
		try {
			UserBean user = new UserBean();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			UserService us = new UserService(ds);
			
			user = us.login(user);
			
			if(user.isValid()) {
				HttpSession session = request.getSession();
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("userLogged.jsp");
			}
			else{
				response.sendRedirect("invalidLogin.jsp");
			}
		} catch(Throwable e){
			e.printStackTrace();
		}
	}
}
