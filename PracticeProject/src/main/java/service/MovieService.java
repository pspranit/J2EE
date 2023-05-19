package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class MovieService {

	public double calculateBill(String movieName, int ticket, Connection con) throws SQLException {
		Statement stmt=null;
		stmt=con.createStatement();
		
		String query="select * from movie";
		
		ResultSet res=stmt.executeQuery(query);
		
		double totalTicketAmt=0.0;
		
		
		while(res.next())
		{
			String name=res.getString(2);
			int no_of_tickets=res.getInt(4);
			double price=res.getDouble(5);
			
			if(ticket <=no_of_tickets && movieName.equals(name)){
				double ps =ticket*price;
				totalTicketAmt=ps+=ps*0.18;
				
				int decreaseTicket=no_of_tickets-ticket;
				UpdateTicket ut=new UpdateTicket();
				int count=ut.updateTicket(decreaseTicket,ticket,movieName,con); 
				
				
				break;
			}
			else {
				
				totalTicketAmt=0;
			}
		}
		return totalTicketAmt;
	}
	
	
	
}


