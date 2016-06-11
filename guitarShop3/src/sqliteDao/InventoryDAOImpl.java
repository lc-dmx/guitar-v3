package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.InventoryDAO;
import db.DBUtil;
import entity.Guitar;
import entity.GuitarSpec;

public class InventoryDAOImpl implements InventoryDAO{
	
	// 取得所有吉他
	public List<Guitar> getAllGuitars() {
		Connection conn = DBUtil.open();
		List<Guitar> guitars = new LinkedList<Guitar>();
		String sql = "select * from Guitar";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				Double price = rs.getDouble("price");
				String builder = rs.getString("builder");
				String model = rs.getString("model");
				int numStrings = rs.getInt("numStrings");
				String type = rs.getString("type");
				String backWood = rs.getString("backWood");
				String topWood = rs.getString("topWood");
				GuitarSpec spec = new GuitarSpec(builder,type, backWood, topWood);
				Guitar guitar = new Guitar(serialNumber,price,model, numStrings,spec);
				guitars.add(guitar);
					
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return guitars;
	}
	
	public boolean addGuitar(String serialNumber, double price, String model, int numStrings, GuitarSpec spec) {
		Connection conn = DBUtil.open();
		int i=0;
		String sql = "insert into Guitar(serialNumber, price, builder, type, backWood, topWood,model,numStrings) values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, serialNumber);
			ps.setDouble(2, price);
			ps.setString(3, spec.getBuilder().toString());
			ps.setString(4, spec.getType().toString());
			ps.setString(5, spec.getBackWood().toString());
			ps.setString(6, spec.getTopWood().toString());
			ps.setString(7, model);
			ps.setInt(8, numStrings);

			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0;
	}
	
	public boolean deleteGuitar(String serialNumber) {
		Connection conn = DBUtil.open();
		String sql = "delete from Guitar where serialNumber=?" ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,serialNumber); 
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
