package dao;

import java.util.List;

import entity.Guitar;
import entity.GuitarSpec;

//吉他的业务逻辑接口
public interface InventoryDAO {
	
	// 获取所有guitar
	public abstract List<Guitar> getAllGuitars();
	
	// 添加guitar
	public abstract boolean addGuitar(String serialNumber, double price, String model, int numStrings, GuitarSpec spec);
	
	// 删除guitar
	public abstract boolean deleteGuitar(String serialNumber);


}
