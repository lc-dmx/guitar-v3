package testSqliteDao;

import static org.junit.Assert.*;
import org.junit.Test;

public class InventoryDAOImplTest {

	@Test
	public void test(){
		sqliteDao.InventoryDAOImpl impl = new sqliteDao.InventoryDAOImpl();
		assertEquals(13,impl.getAllGuitars().size());
	}


}
