package wb.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import wb.store.model.Item;

public class ItemDAOTest {
	private Connection conn;
	private Savepoint save;

	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "test", "Password1");
		conn.setAutoCommit(false);
		save = conn.setSavepoint();
	}

	@After
	public void tearDown() throws Exception {
		conn.rollback(save);
		conn.close();
	}

	@Test
	public void addItemTest() throws SQLException {
		ItemDAO dao = new ItemDAO(conn);
		Long id = (Long)dao.addItem(new Item("abcd", "First three letters", 0.75f));
		assertNotNull(id);
	}
	
	@Test
	public void getItemsTest() throws SQLException {
		
	}
	
	

}
