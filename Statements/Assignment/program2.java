package Assignment;

import java.sql.SQLException;
import java.util.Scanner;

public class program2 {

	public static void main(String[] args) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		BikeOperations bo=new BikeOperations();
		boolean status=true;
		while (status)
		{
			System.out.println();
			System.out.println("SELECT OPTION");
			System.out.println("1:ADD BIKE");
			System.out.println("2:GET BIKE BY MODEL");
			System.out.println("3:GET BIKE BY COMPANY");
			System.out.println("4:GET ALL BIKE");
			System.out.println("5:UPDATE OPERATION");
			
			System.out.println();
			
			System.out.println("ENTER CHOICE");
			int choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				System.out.println("ENTER MODEL");
				String model=sc.next();
				
				System.out.println("ENTER COMPANY");
				String company=sc.next();
				
				System.out.println("ENTER PRICE");
				Double price=sc.nextDouble();
				bo.addbike(id,model,company,price);
			}
			else if(choice==2)
			{
				bo.modelInfo();
			}
			else if(choice==3)
			{
				bo.companyInfo();
			}
			else if(choice==4)
			{
				bo.displayBikeTable();
			}
			else if(choice==5)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER UPDATE DATA");
				String updateData=sc.next();
				
				System.out.println("ENTER COLNAME");
				String colname=sc.next();
				
				bo.updateInfo(id,updateData,colname);
			}
		}
	}
}
