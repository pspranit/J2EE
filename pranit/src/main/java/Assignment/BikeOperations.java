package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BikeOperations 
{
	
	static Connection con=null;
	static PreparedStatement pstmt=null;
	ResultSet res=null;
	
	static
	{
		try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void addbike(int id ,String model, String company, Double price) throws SQLException 
	{
		
		String query="insert into bikeinfo2 values(?,?,?,?)";
		
		
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			pstmt.setString(2,model);
			pstmt.setString(3, company);
			pstmt.setDouble(4, price);
			
			int count1=pstmt.executeUpdate();
			
			System.out.println(count1+" : RECORD INSERTED");
		
	}

	public void modelInfo() throws SQLException 
	{
	String query="select model from bikeinfo2";
	
	pstmt=con.prepareStatement(query);
	
	res=pstmt.executeQuery();
	System.out.println("MODEL");
	System.out.println("===========");
	
	while(res.next())
	{
		String modelNo=res.getString(1);
		System.out.println(modelNo);
	}
		
}

	public void companyInfo() throws SQLException 
	{
	String query="select company from bikeinfo2";
	
	pstmt=con.prepareStatement(query);
	
	res=pstmt.executeQuery();
	System.out.println("COMPANY");
	System.out.println("=============");
	while(res.next())
	{
		String companyName=res.getString(1);
		System.out.println(companyName);
	}
		
	}

	public void updateInfo(int id,String updateData,String colname) throws SQLException
	{
		String query="update bikeinfo2 set "+colname+"=(?) where bike_id=(?)";
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setInt(2,id);
		 pstmt.setString(1,updateData);
		
        
        int count=pstmt.executeUpdate();
        
        System.out.println(count+" :UPDATED");
	}

	public void displayBikeTable() throws SQLException {
		
		String query="select * from bikeinfo2";
		
		pstmt=con.prepareStatement(query);
		res=pstmt.executeQuery();
		
		System.out.println("bike_id \t model \t\tcompany \tprice");
		System.out.println("=================================================================");
		
		while(res.next())
		{
			int id=res.getInt(1);
			String model=res.getString(2);
			String company=res.getString(3);
			double price=res.getDouble(4);
			
			System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+price);
		}
		
	}
	
}
