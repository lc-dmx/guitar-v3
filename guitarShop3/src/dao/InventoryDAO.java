package dao;

import java.util.List;

import entity.Guitar;
import entity.GuitarSpec;

//������ҵ���߼��ӿ�
public interface InventoryDAO {
	
	// ��ȡ����guitar
	public abstract List<Guitar> getAllGuitars();
	
	// ���guitar
	public abstract boolean addGuitar(String serialNumber, double price, String model, int numStrings, GuitarSpec spec);
	
	// ɾ��guitar
	public abstract boolean deleteGuitar(String serialNumber);


}
