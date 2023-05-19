package Assignment;

import java.util.Scanner;

public class program1 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		
		boolean status=true;
		LoginAndSignup ls=new LoginAndSignup();
		while(status)
		{
			System.out.println();
			System.out.println("SELECT OPTION");
			System.out.println("1:LOGIN");
			System.out.println("2:SIGNUP");
			System.out.println("3:DELETE ACCOUNT");
			System.out.println("4:AVILABLE ACCOUNTS\n");
			System.out.println("CHOICE ANY ONE OPTION");
			
			int choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.println();
				System.out.println("ENTER USERNAME");
				String username=sc.next();
				System.out.println("ENTER PASSWORD");
				String password=sc.next();
				ls.login(username,password);
			}
			else if(choice==2)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER USERNAME");
				String username=sc.next();
				
				System.out.println("ENTER PASSWORD");
				String password=sc.next();
				
				ls.signup(id, username, password);
			}
			else if(choice==3)
			{
				ls.deleteAccount();
			}
			else if(choice==4)
			{
				ls.availableInfo();
			}
			else
			{
				System.out.println("INVALID CHOICE");
			}
		}
	}

}
