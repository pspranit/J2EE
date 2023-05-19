package PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PreparedDemo1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		
		PreparedStatement pstmt=null;
		
		String query="insert into productinfo values(?,?,?)";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 1);
			pstmt.setString(2,"LAPTOP");
 			pstmt.setDouble(3, 50000.00);
 			
 			int count1=pstmt.executeUpdate();
 			
 			pstmt.setInt(1, 4);
 			pstmt.setString(2, "HEADPHONE");
 			pstmt.setDouble(3, 1500.00);
 			int count2=pstmt.executeUpdate();
			System.out.println(count1+"RECORD INSERTED");
 			
 		} catch (SQLException e) {
 		// TODO Auto-generated catch block
			e.printStackTrace();
	  }
		
		
	}

}
