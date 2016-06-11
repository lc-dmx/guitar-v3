package dao;

import java.io.IOException;
import java.util.Properties;

public class dataAccess {
	private static Properties pros = new Properties();
	static {
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static InventoryDAO createInstrumentDao() {
		String DB = pros.getProperty("db");
		InventoryDAO result = null;
		switch (DB) {
		case "sqlite":
			result = new sqliteDao.InventoryDAOImpl();
			break;
		case "mysql":
			result = new sqliteDao.InventoryDAOImpl();
			break;

		}
		return result;
	}

}
