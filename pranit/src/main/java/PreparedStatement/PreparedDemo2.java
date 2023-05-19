package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo2 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Connection con=null;
			
			PreparedStatement pstmt=null;
			
			String query="delete from productinfo where productid=(?)";
			
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
				
				pstmt=con.prepareStatement(query);
				
				pstmt.setInt(1, 4);
				
				int count1=pstmt.executeUpdate();

				System.out.println(count1+"RECORD DELETED");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

}
