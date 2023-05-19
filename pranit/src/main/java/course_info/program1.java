package course_info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class program1 {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		String query="insert into course_info(c_name,c_image) values(?,?)";
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setString(1, "java");
		fin=new FileInputStream("C:\\Users\\Admin\\Desktop\\QSPIDERS\\java.jpg");
		pstmt.setBinaryStream(2, fin);
		pstmt.executeUpdate();
		
		pstmt.setString(1,"SQL");
		fin=new FileInputStream("C:\\Users\\Admin\\Desktop\\QSPIDERS\\sql.jpg");
		pstmt.setBinaryStream(2, fin);
		pstmt.executeUpdate();
		
		System.out.println("INSERTED SUCCESSFULLY");
		
		
		
		

	}

}
