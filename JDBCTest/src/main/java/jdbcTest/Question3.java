package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class DeleteOperation{
	static Connection con=null;
	static PreparedStatement pstmt=null;
	
	static {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	public void deleteRecord(int cont) {
		
		String query="delete from employeeinfo where cont_no=(?)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, cont);
			
			int count=pstmt.executeUpdate();
			System.out.println(count+" :RECORD DELETED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
}

public class Question3 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		DeleteOperation del=new DeleteOperation();
		
		System.out.println("ENTER CONT_NO");
		int cont=sc.nextInt();
		
		del.deleteRecord(cont);

	}

}
