package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

public class stackUserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		stack s= new stack();
		
		Scanner in =new Scanner(System.in);
		String st; 
		int flag=0;
		while(flag!=1) {
			
			System.out.println("==================================");
			System.out.println("enter the number of your choice !");
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.peek");
			System.out.println("4.get size");
			System.out.println("5.check if empty");
			System.out.println("6.Exit");
			
			System.out.println("==================================");
      		
			String choice=in.next();	
			
	
			

			
		
			switch (choice) {
		case "1" :
		{
			System.out.println("enter the value:");
			flag=0;
			Scanner sc =new Scanner(System.in);
 
			String str=sc.next();
	         	try {
	          		int x=Integer.parseInt(str);

	         		s.push(x);
	         	}catch(Exception e) {
	         		try {	    	
		          		double x=Double.parseDouble(str);

		          	
		         		s.push(x);
		          		
		          	}catch(Exception e2) {
		               s.push(str);
		          	}
	         		}
	         	
	         	
	          
	   
	          break;
	          
		}
		
		case "2" : {
			try {
			System.out.println(s.pop());
		
			}catch(IllegalArgumentException e) {
				System.out.println("the stack is empty");

			}
			
			
			
			
			break;
			
		}
		
		case "3" :{
			
			try {
				System.out.println(s.peek());
			
				}catch(IllegalArgumentException e) {
					System.out.println("the stack is empty");

				}
				
			break;
			
		}
		case "4":{
			
			System.out.println(s.size());
			break;
			
		}
		case "5":
		{			System.out.println(s.isEmpty());
                  break;
		}
		
		case "6":
		{
			flag=1;
		  break ;
		}
			
		default: {
			System.out.println("enter a valid choice !");
			
		}
			
			
			
			
			}
		}
		
		
	
		
		
}
		
		
	
	

}
