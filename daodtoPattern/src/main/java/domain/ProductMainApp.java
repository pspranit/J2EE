package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDAO;
import dto.Product;

public class ProductMainApp {

	static Scanner sc=new Scanner(System.in);
	static Product p1=new Product();
	static ProductDAO d1=new ProductDAO();
	
	public static void main(String[] args) throws SQLException {

		while(true) {
		System.out.println("==============================================");
		
		System.out.println("SELECT MODE OF OERATIONS");
		System.out.println("1:ADD PRODUCT");
		System.out.println("2:DELETE PRODUCT");
		System.out.println("3:DISPLAY PRODUCT");
		
		System.out.println("CHOICE OPERATION");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			addProduct();
		}
		else if(choice==2)
		{
			removeProduct();
		}
		else if(choice==3)
		{
			showProduct();
		}
		else {
			System.out.println("INVALID CHOICE");
		}
	 }
	}
	static void showProduct() {
		
		ArrayList<Product> data=d1.displayProduct();
		System.out.println("prod_id prod_name prod_price");
		System.out.println("=================================");
		
		for(Product p:data)
		{
			System.out.println(p);
		}
	
		
	}
	 static void removeProduct() throws SQLException {
		
		System.out.println("ENTER ID ");
		int id=sc.nextInt();
		
		p1.setpId(id);
		String mssg=d1.deleteProduct(p1);
		
		System.out.println(mssg);	
		
	}
	 static void addProduct() {
		System.out.println("ENTER PRODUCT NAME");
		String productName=sc.next();
		
		System.out.println("ENTER PRODUCT PRICE");
		double productPrice=sc.nextDouble();
		
		//add data to DTO object
	
		p1.setpName(productName);
		p1.setpPrice(productPrice);
		
		//pass DTO object as argument to addProduct() method
		
		int count=d1.addProduct(p1);
		System.out.println(count+" :RECORD INSERTED");			
		
	}

}

//ResultSet res=d1.displayProduct(p1);
//System.out.println("prod_id\t\tprod_name\tprod_price");
//System.out.println("============================================");
//try {
//	while(res.next())
//	{
//		int id=res.getInt(1);
//		String name=res.getString(2);
//		double price=res.getDouble(3);
//		
//		System.out.println(id+"\t\t"+name+"\t\t"+price);
//	}
//} catch (SQLException e) {
//	e.printStackTrace();
//}
