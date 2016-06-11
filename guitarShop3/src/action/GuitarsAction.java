package action;

import java.sql.SQLException;
import entity.GuitarSpec;
import entity.Inventory;

//guitarAction类
public class GuitarsAction  extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	Inventory inventory=new Inventory();
	
	//查询所有guitar的动作
	@SuppressWarnings("static-access")
	public String init(){

		//放进session中
		session.setAttribute("guitars_list", inventory.getGuitars());
		return "query_success";
	}
	
	public String query(){

		//放进session中
		session.setAttribute("guitars_list", inventory.getAllGuitars());
		return "query_success";
	}
	
	public String add(){
		
		String serialNumber = request.getParameter("serialNumber");
		Double price =  Double.parseDouble(request.getParameter("price"));
		String builder = request.getParameter("builder");
		String type = request.getParameter("type");
		String backWood = request.getParameter("backWood");
		String topWood = request.getParameter("topWood");
		String model = request.getParameter("model");
		Integer numStrings = Integer.parseInt(request.getParameter("numStrings"));
		
		GuitarSpec spec = new GuitarSpec(builder,type, backWood, topWood);
		
		//放进session中
		session.setAttribute("add_list", inventory.addGuitar(serialNumber,price,model,numStrings,spec));
		return "add_success";
	}
	
	public String delete(){
		String serialNumber=request.getParameter("serialNumber");
		
		inventory.delete(serialNumber);		
		return "delete_success";
	}
	
	public String search() throws SQLException{
		
		String builder = request.getParameter("builder");
		String type = request.getParameter("type");
		String backWood = request.getParameter("backWood");
		String topWood = request.getParameter("topWood");

		//根据查询条件，封装成一个查询对象GuitarSpec
		GuitarSpec guitarspec = new GuitarSpec(builder,type,backWood,topWood);

		//放进session中
		session.setAttribute("guitars_list", inventory.searchGuitar(guitarspec));
		return "query_success";
	}
}
