package testService;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import dao.InventoryDAO;
import dao.dataAccess;
import entity.Guitar;


public class InventoryServiceTest {

	@Test
	public void test() {
		InventoryDAO i = dataAccess.createInstrumentDao();
		List<Guitar> list = i.getAllGuitars();
		assertEquals(13,list.size());
	}

}
