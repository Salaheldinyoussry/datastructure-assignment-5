package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

public class ApplicationUserInterface {
	public static void main(String[] args) {

	
	Scanner in =new Scanner(System.in);
	ExpressionEvaluator l =new ExpressionEvaluator();
	int flag=0;
	while(flag!=1) {
		
		System.out.println("==================================");
		System.out.println("enter the number of your choice !");
		System.out.println("1.change infix expression to postfix");
		System.out.println("2.evaluate a postfix expression");
		System.out.println("3.exit");
		
		
		System.out.println("==================================");
  		
		String choice=in.next();	
		

		

		
	
		switch (choice) {
	case "1" :
	{  		System.out.println("enter the expression:");
	
	

		int flagType =0;;
		Scanner ss=new Scanner(System.in);
	    String str=ss.nextLine();
    
	  try { String x= l.infixToPostfix(str);
		System.out.println(x);

	  }catch(Exception e ) {
			System.out.println("the infix expression is not valid !!");
 
	  }
		 
		 break;
	}
	
	case "2" : {
		System.out.println("enter the expression:");
		Scanner ss=new Scanner(System.in);
	    String str=ss.nextLine();
		  try { 
			
		 int x= l.evaluate(str);
			System.out.println(x);

		  }catch(Exception e ) {
				System.out.println("the postfix expression is not valid !!");
				System.out.println("a valid expression has single space and consist of integers ");
	 
		 }
		break;
		
	}
	
	case "3" :{
		flag=1;
		break;
		
	}
	default: {
		System.out.println("enter a valid choice !");
		
	}
		
		}


	}}}
