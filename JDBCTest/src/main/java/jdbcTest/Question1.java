package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class EmployeeOperations{
	Scanner sc=new Scanner(System.in);
	static Connection con=null;
	static PreparedStatement pstmt=null;
	ResultSet res=null;
	
	static {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertRecord(String username, String password, int age, int cont, String city) {
		
		String query="insert into employeeinfo values(?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setInt(3, age);
			pstmt.setInt(4, cont);
			pstmt.setString(5, city);
			
			int count=pstmt.executeUpdate();
			System.out.println(count+" :RECORD INSERTED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void displayRecord() {
		
		
		String query="select * from employeeinfo";
		try {
			pstmt=con.prepareStatement(query);
			res=pstmt.executeQuery();
			System.out.println("uName\t\tpass\t\tage\t\tcont\t\tcity");
			System.out.println("============================================================================");
			while(res.next())
			{
				String uName=res.getString(1);
				String pass=res.getString(2);
				int age=res.getInt(3);
				int cont=res.getInt(4);
				String city=res.getString(5);
				
				System.out.println(uName+"\t\t"+pass+"\t\t"+age+"\t\t"+cont+"\t\t"+city);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}


public class Question1 {

	public static void main(String[] args) throws SQLException {
		
		EmployeeOperations eo=new EmployeeOperations();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("SELECT OPTION");
		System.out.println("1:INSERT RECORD");
		System.out.println("2:DISPLAY RECORD");
		
		System.out.println("ENTER CHOICE");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("ENTER USERNAME");
			String username=sc.next();
			
			System.out.println("ENTER PASSWORD");
			String password=sc.next();
			
			System.out.println("ENTER AGE");
			int age=sc.nextInt();
			
			System.out.println("ENTER CONT_NO");
			int cont=sc.nextInt();
			
			System.out.println("ENTER CITY NAME");
			String city=sc.next();
			
			eo.insertRecord(username,password,age,cont,city);
		}
		else if(choice==2)
		{
			eo.displayRecord();
		}
	}

}
