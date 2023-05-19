package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Product;

public class ProductDAO {
	static Connection con;
	ResultSet res=null;
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addProduct(Product p) 
	{
		PreparedStatement pstmt=null;
		
		int count=0;
		
		String query="insert into productdemo1(pname,pprice) values(?,?)";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, p.getpName());
			pstmt.setDouble(2, p.getpPrice());
			
			count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public String deleteProduct(Product p) throws SQLException
	{
		PreparedStatement pstmt=null;
		Statement stmt = null;
		
		String query1="select * from productdemo1";
		stmt=con.createStatement();
		
		 res=stmt.executeQuery(query1);
		
		while(res.next())
		{
			if(p.getpId()==res.getInt(1))
			{
				String query="delete from productdemo1 where pid=(?)";
				
				try {
					pstmt=con.prepareStatement(query);
					pstmt.setInt(1, p.getpId());
					
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return "DELETE_SUCCESSFULLY";
			}	
		}	
		return "INVALID ID" ;	
	}
	
	public ArrayList<Product> displayProduct()
	{
		Statement stmt=null;
		ResultSet res=null;
		ArrayList<Product> products=new ArrayList<Product>();
		
		String query="select * from productdemo1";
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			
			while(res.next())
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				double price=res.getDouble(3);
				
//				add values to object
				
				Product p1=new Product();
				p1.setpId(id);
				p1.setpName(name);
				p1.setpPrice(price);
				
//				add object to arraylist
				
				products.add(p1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}
//	public ResultSet displayProduct(Product p)
//	{
//		PreparedStatement pstmt=null;
//		
//		String str="select * from productdemo1";
//		
//		try {
//			pstmt=con.prepareStatement(str);
//			res=pstmt.executeQuery();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
}
