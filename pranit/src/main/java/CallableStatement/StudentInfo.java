package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class StudentInfo {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet res=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		cstmt=con.prepareCall("{call studentinfo(?,?,?,?)}");
	
		res=cstmt.executeQuery();
		System.out.println("s_id\ts_add\tage\tcont");
		while(res.next()) 
		{
			int id=res.getInt(1);
			String add=res.getString(2);
			int age=res.getInt(3);
			int cont=res.getInt(4);
			
			System.out.println(id+"\t"+add+"\t"+age+"\t"+cont);
		}

		
		System.out.println("OPERATION SUCCESS");

	}

}
