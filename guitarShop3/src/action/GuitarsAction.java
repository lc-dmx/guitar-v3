package action;

import java.sql.SQLException;
import entity.GuitarSpec;
import entity.Inventory;

//guitarAction��
public class GuitarsAction  extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	Inventory inventory=new Inventory();
	
	//��ѯ����guitar�Ķ���
	@SuppressWarnings("static-access")
	public String init(){

		//�Ž�session��
		session.setAttribute("guitars_list", inventory.getGuitars());
		return "query_success";
	}
	
	public String query(){

		//�Ž�session��
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
		
		//�Ž�session��
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

		//���ݲ�ѯ��������װ��һ����ѯ����GuitarSpec
		GuitarSpec guitarspec = new GuitarSpec(builder,type,backWood,topWood);

		//�Ž�session��
		session.setAttribute("guitars_list", inventory.searchGuitar(guitarspec));
		return "query_success";
	}
}
