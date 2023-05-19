package TransactionMangJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RollbackCommit {

	public static void main(String[] args) throws SQLException {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENETR PRODUCT_ID");
		int id=sc.nextInt();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from productdemo1 where pid=?";
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		
		int count=0;
		
		while(true)
		{	
		con.setAutoCommit(false);
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, id);
		count=pstmt.executeUpdate();
		
		System.out.println("WAN'T TO UNDO");
		System.out.println("1:YES\t\t2:NO");
		
		System.out.println("SELECT CHOICE");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			con.rollback();
			System.out.println("TRANSACTION ROLLBACK");
		}
		else if(choice==2) {
			con.commit();
			System.out.println(count+" :PRODUCT DELETED");
		}

		}
	}

}
