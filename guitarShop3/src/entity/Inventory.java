package entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.InventoryDAO;
import dao.dataAccess;
import entity.Guitar;
import entity.GuitarSpec;
import sqliteDao.InventoryDAOImpl;

public class Inventory {
	private static List<Guitar> guitars = new ArrayList<Guitar>();
	
	InventoryDAO gdao = dataAccess.createInstrumentDao();
	
	public Inventory() {
		init();
	}
	public void init(){
		try {
			guitars.addAll(gdao.getAllGuitars());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Guitar> getAllGuitars(){
		return gdao.getAllGuitars();
	}
	
	public boolean addGuitar(String serialNumber, double price, String model, int numStrings, GuitarSpec spec) {
		return gdao.addGuitar(serialNumber, price, model, numStrings, spec);
	}
	
	public boolean delete(String serialNumber) {
		return gdao.deleteGuitar(serialNumber);		
	}
	
	public List<Guitar> searchGuitar(GuitarSpec searchGuitar) throws SQLException {
		InventoryDAO gdao = new InventoryDAOImpl();
		List<Guitar> guitars = gdao.getAllGuitars();
	    List<Guitar> matchingGuitars = new LinkedList<Guitar>();
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchGuitar))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  }
	
	public static List<Guitar> getGuitars() {
		return guitars;
	}

	public static void setGuitars(List<Guitar> guitars) {
		Inventory.guitars = guitars;
	}
}