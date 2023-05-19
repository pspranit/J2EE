package productOperation;


import java.util.Scanner;


public class program2 
{
	
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("SELECT OPTION");
		System.out.println("ADD PRODUCT");
		System.out.println("DELETE PRODUCT");
		System.out.println("DISPLAY PRODUCT");
		System.out.println("SELECT CHOICE");
		int choice=sc.nextInt();
		
		MyProduct ps=new MyProduct();
		
		if(choice==1)
		{
			System.out.println("ENTER ID");
			int productid=sc.nextInt();
			
			System.out.println("ENETR PRODUCT NAME");
			String productname=sc.next();
			
			System.out.println("ENTER PRODUCT PRICE");
			double productprice=sc.nextDouble();
			
			ps.addProduct(productid, productname, productprice);
		}
		else if(choice==2) {

			System.out.println("ENTER ID");
			int productid=sc.nextInt();
		
			ps.deleteProduct(productid);
		}
		else if(choice==3) {
			ps.displayProduct();
		}
		else {
			System.out.println("INVALID CHOICE");
		}
	}

}
