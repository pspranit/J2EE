package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class groceryService {

	public double calCulateBill(String itemType, String groceryType, Connection con) throws SQLException {
		
		double regular=30;
		double quik=20;
		
		Statement stmt=null;
		ResultSet res=null;
		
		double totalAmt=0;
		String query="select g_name,g_price from grocery_item";
		
		stmt=con.createStatement();
		
		res=stmt.executeQuery(query);
		
		while(res.next())
		{
			String name=res.getString(1);
			double price=res.getDouble(2);
			
			if(groceryType.equals("regular") && itemType.equals(name))
			{
				totalAmt=price*regular;
				break;
			}
			
			else if(groceryType.equals("quik") && itemType.equals(name))
			{
				totalAmt=price+quik;
				break;
			}
		}
		
		return totalAmt;
	}

}
