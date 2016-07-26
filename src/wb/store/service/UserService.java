package wb.store.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import wb.store.dao.UserDAO;
import wb.store.model.UserBean;

public class UserService {

private DataSource ds;
	
	public UserService(DataSource ds){
		this.ds = ds;
	}
	
	public UserBean login(UserBean bean) throws SQLException{
		try(Connection conn = ds.getConnection();){
			UserDAO dao = new UserDAO(conn);
			return dao.login(bean);
		}
	}
	
	public UserBean newUser(UserBean bean) throws SQLException{
		try(Connection conn = ds.getConnection();){
			UserDAO dao = new UserDAO(conn);
			return dao.newUser(bean);
		}
	}
}
