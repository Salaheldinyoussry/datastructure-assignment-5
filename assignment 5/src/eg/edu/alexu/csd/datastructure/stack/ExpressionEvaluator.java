package eg.edu.alexu.csd.datastructure.stack;

public class ExpressionEvaluator implements IExpressionEvaluator {

	/**
	 * the methods checks if a character can be an operand or part of operand 
	 * a valid operand consist of alphabetical or integer characters 
	 * note $ or ^ or% or! for example are not valid operands 
	 * @param x  the character which will be checked
	 * @return true if it is a valid operand or part of operand and return else otherwise 
	 */
	public boolean checkForOperand(char x) {
		if((x>='a' && x<='z') || (x>='A' && x<='Z') || (x>='0' && x<='9')) {
			return true;
		}
		return false;
	}
	/**
	 * the method check if a infix expression is valid or not
	 * @param x the infix expression in form of string  to be checked
	 * @return true if the expression is valid and false otherwise
	 */
	public boolean checkInfixExpression(String x) {
		stack y =new stack();
		int i=0;
		int size=x.length();
		x+="   ";
		int j=0;
		while(i<size) {
			
			if (((x.charAt(i)>='0')&&(x.charAt(i)<='9'))  &&   (  ((x.charAt(i+1)>='a') && (x.charAt(i+1)<='z'))  || ( (x.charAt(i+1)>='A') && (x.charAt(i+1)<='Z')) )){
				return false;

			}
			if (( ((x.charAt(i)>='a') && (x.charAt(i)<='z'))  || ( (x.charAt(i)>='A') && (x.charAt(i)<='Z'))) 
					&&   (  ((x.charAt(i+1)>='a') && (x.charAt(i+1)<='z'))  || ( (x.charAt(i+1)>='A') && (x.charAt(i+1)<='Z')) )){
				return false;

			}
			
			if(x.charAt(i)=='(') {y.push('(');
			if (x.charAt(i+2)==')') {return false;}}
			else if (x.charAt(i)==')') {y.pop();}
			 if (x.charAt(i)=='*' || x.charAt(i)=='/') {
				if(x.charAt(i+2)=='*' || x.charAt(i+2)=='/') {
					return false;
				}
			}
				 
			     if (x.charAt(i)=='*' || x.charAt(i)=='/' || x.charAt(i)=='+' ) {
					if(x.charAt(i+2)==' ' ||  i==0) {	
						return false;
					}
					 if( ! (checkForOperand(x.charAt(i-2)) ||  x.charAt(i-2)==')')) {	
				          return false;
						}	
					else if( ! (checkForOperand(x.charAt(i+2)) ||  x.charAt(i+2)=='(')) {	
				         return false;
					}
				}
			     else if(x.charAt(i)=='-') {
			    	 
			    	 if((x.charAt(i+1)==' ' &&  (! (checkForOperand(x.charAt(i+2)) ||  x.charAt(i+2)=='(')))){
			    		 return false;
			    	 }
			    	 if(x.charAt(i+1)==' ' && x.charAt(i+2)==' ') {
			    		 return false;
			    	 }
			    	 
			     }
			
			
				i++;
		}
		if(!y.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * the method separates the operands from the operators by single space in the expression
	 * it also removes extra spaces
	 * @param z the expression in form of string 
	 * @return the expression after conversion in form of string
	 */
	public String toSingleSpaceExpression(String z) {
		int i=0;
		z+=" ";
	  /**
	   * string variable which will be returned
	   */
		String x="";
		while(i<z.length()-1) {
	    	  if(checkForOperand(z.charAt(i))) {
	    		  while(checkForOperand(z.charAt(i))) {
	    			  x+=z.charAt(i);
	    		      i++;	  
	    		  }
	    	      i--;
	    		  x+=" ";
	    	  }
	    	  else if(z.charAt(i)!=' '){
	    		  x+=z.charAt(i)+" ";
	    	  }
			i++;}
		return x;	
	}
	
	/**
	 * the method puts the infix expression in the best form :
	 * examples:
	 * it changes a+-b  to a-b
	 * it changes a--b  to a+b *
	 * it also makes the negative operands in the form of -x or in a better way it makes a negative number noticeable
	 * by removing the space between the negative sign and the operand	
	 * @param z the infix expression in form of string 
	 * @return the better infix expression in form of string
	 */
	public String fixExpression (String z) {
      /**
       * changing the input expression to single space separator by using the method 
       * toSingleSpaceExpression
       * and storing the value in x w
       */
		String x= toSingleSpaceExpression(z);
       int i=0;
       /**
        * The expression which will be returned
        */
       String y="";
		int size=x.length();
         x+="  ";
		while(i<size) {
			if(x.charAt(i)=='-') {
			
				if(i==0) {
				    if (x.charAt(i+2)=='(') {
				    	y+="0"+" " +"-" + " ";
				    }
					else if(x.charAt(i+2)!='-') {y+="-";}
					else {
						y+="-" + "&";
						i=i+3;}
					
					
				}
				else if(x.charAt(i+2)=='-') {
				   y+="+"+" ";
				   i=i+3;
			   }
			   else if(x.charAt(i+2)=='+') {
				   y+="-"+" ";
				   i=i+3;
			   }
			   else {
				   y+=x.charAt(i)+" ";
			   }
			}
			else if(x.charAt(i)=='+') {
				
			   if(x.charAt(i+2)=='-') {
				   y+="-"+" ";
				   i=i+3;
			   }
			   else  if(x.charAt(i+2)=='+') {
				   y+="+"+" ";
				   i=i+3;
			   } 
			   else {
				   y+="+"+" ";
			   }
			     }
		       
			else if(x.charAt(i)=='*' || x.charAt(i)=='/') {
		
			   if(x.charAt(i+2)=='-') {
				  if(x.charAt(i)=='*') { y+="*"+" " +"-";}
				  else {y+="/"+" " +"-";}
				   i=i+3;}
			   else if(x.charAt(i+2)=='+') {
						  if(x.charAt(i)=='*') { y+="*"+" ";}
						  else {y+="/"+" ";}
						   i=i+3;
					   }
				   
				   else {
				   if(x.charAt(i)=='*') {   y+="*"+" ";}
				   else { y+="/"+" ";}
			   }
			     } 
			    
			else if (x.charAt(i)=='(') {
		
				if(x.charAt(i+2)=='-') {
					y+="("+' '+"-";
					   i=i+3;
				}
				else {
					y+="("+" ";
				}
			}
			else if(x.charAt(i)==')') {
			
				y+=")"+" ";
				
			}
			else if (x.charAt(i)!=' '){
				while(x.charAt(i)!=' ') {        
					y+=x.charAt(i);
					i++;
				}
			   y+=" ";
			}
		i++;
		}
		
		return y;	
	}
	/**
	 * it change the negative numbers to another form using dummy zeroes
	 * for example :  -a to  0-b
	 * @param x the postfix string to be changed
	 * @return the expression after adding the dummy zeroes in form of string
	 */
	
	public String replaceNegativeSignWithDummyZero(String x) {
		 /**
	        * The expression which will be returned
	        */
		String y="";
		int i=0;
		while(i<x.length()) {
			if(x.charAt(i)=='-' && checkForOperand(x.charAt(i+1))) {
				y+="0"+" ";
				i++;
				while(checkForOperand(x.charAt(i))) {
					y+=x.charAt(i);
					i++;
				}
				i--;
				y+=" "+"-";
			}
			
			else {
				y+=x.charAt(i);
			}
			i++;
		}
		
		return y;
	}
	
	
	
	@Override
	/** 
	 * Takes a symbolic/numeric infix expression as input and converts it to 
	 * postfix notation. There is no assumption on spaces between terms or the 
	 * length of the term (e.g., two digits symbolic or numeric term) 
	 * 
	 * @param expression 
	 *   infix expression 
	 *@return postfix expression 
	 *  */
	
	public String infixToPostfix(String expression) {
		/**
		 * the stack which will store the operators
		 */
		stack s =new stack();
		/**
		 * the string variable will store the value of the expression after putting it in the best form by the method fixExpression
		 */
		
		expression=fixExpression(expression);		

		if(!checkInfixExpression(expression)) {
         throw new IllegalArgumentException("invalid infix expression");
		}
		int size =expression.length();
		int i=0;
		String x="";
		expression+="  ";
		int flag=1;
		while(i<size) {
			flag=1;
			if(( expression.charAt(i)=='-' || expression.charAt(i)=='+') &&(checkForOperand(expression.charAt(i+1))) ||(checkForOperand(expression.charAt(i))))  {
				if( expression.charAt(i)=='-' || expression.charAt(i)=='+') {
				  x+=expression.charAt(i);
				  flag=1;
				  i++;}
				
				  while(checkForOperand(expression.charAt(i))) {
					x+=expression.charAt(i);

					i++;
				 
				  }
					x+=" ";

			
				  i--;
			}		
			 else if(expression.charAt(i)=='(') {
				s.push(expression.charAt(i));
				
			}
			else if(expression.charAt(i)==')') {
				char y;
				while(!s.isEmpty()) {

					y=(char)s.pop();	

					if(y=='(') {

					break;
				}
				else {
					x+=y;
					x+=" ";

				}
				}
			}
			else if (expression.charAt(i)=='/' || expression.charAt(i)== '*' || expression.charAt(i)=='-' || expression.charAt(i)=='+'){
				while(flag==1) {
			      flag=0;
				if(s.isEmpty()) { s.push(expression.charAt(i)); }	
			  else if(((char)s.peek()=='/' || (char)s.peek()=='*') && (expression.charAt(i)=='/' || expression.charAt(i)=='*' )) {
				  x+=s.pop();
				  s.push(expression.charAt(i));
					x+=" ";

			  }
			  else if(((char)s.peek()=='/' || (char)s.peek()=='*') && (expression.charAt(i)=='+' || expression.charAt(i)=='-' )){
				  x+=s.pop()+" ";
				  flag=1;
				  
			  }
			  else if(((char)s.peek()=='+' || (char)s.peek()=='-') && (expression.charAt(i)=='/' || expression.charAt(i)=='*')) {
				  s.push(expression.charAt(i));
				 // x+=expression.charAt(i)+ " "+s.pop();
				  
			  }
			  else if(((char)s.peek()=='+' || (char)s.peek()=='-') && (expression.charAt(i)=='+' || expression.charAt(i)=='-')) {
				  x+=s.pop();
				  s.push(expression.charAt(i));				  
			     x+=" ";
			  }
			  else {
				  s.push(expression.charAt(i));
				  
			  }}
			}
			else if(expression.charAt(i)!=' ') {
		         throw new IllegalArgumentException("invalid infix expression");
			}
			
		
		i++;
		
		
		}
		while(!s.isEmpty()) {
			x+=s.pop();
			x+=" ";
		}
		x=replaceNegativeSignWithDummyZero(x);
		String z="";
		// remove extra space at last place
		for(int n=0; n<x.length()-1; n++) {
			z+=x.charAt(n);
		}
		return z;
	}

	/** 
	 *  Evaluate a postfix numeric expression, with a single space separator 
	 *  @param expression 
	 *  postfix expression 
	 *  @return the expression evaluated value */
	public int evaluate(String expression) {
	/**
	 * the stack which will store the operands
	 */
		stack s =new stack();
		double op1,op2;
		double res = 0;
		int i=0;
	//	 expression=toSingleSpaceExpression(expression);
		int size =expression.length();

			expression+="     ";
		while(i<size) {			
			String x="";
		
				if((expression.charAt(i)>='0' && expression.charAt(i)<='9') || ((expression.charAt(i)=='-' )&& 
						((expression.charAt(i+1)>='0') && (expression.charAt(i+1)<='9')))) {
				   if(expression.charAt(i)=='-') {
					   x+="-";
				    i=i+1;
				   }
					while(expression.charAt(i)>='0' && expression.charAt(i)<='9') {
					x+=expression.charAt(i);
					i++;
				}
				i--;
				   s.push(Double.parseDouble(x));
			}
		//="234*+"	
			else if((expression.charAt(i)=='/' || expression.charAt(i)== '*' || expression.charAt(i)=='-' || expression.charAt(i)=='+') ) {
				if(s.isEmpty()) {
					throw new IllegalArgumentException("the expression is not valid the expression should be with a single space separator  and numeric(integers) ");
	
					}
				op2=(double) s.pop();
				if(s.isEmpty()) {
					throw new IllegalArgumentException("the expression is not valid the expression should be with a single space separator  and numeric(integers) ");
				}
					op1=(double) s.pop();
				
				
				if(expression.charAt(i)=='/') {
					if(op2==0) {
						throw new ArithmeticException("Error division by zero ");
					}
					res=(double)op1/op2;}
				else if (expression.charAt(i)=='*') {res=(double)op1*op2;}
				else if(expression.charAt(i)=='+') {res=(double)op1+op2;}
				else if(expression.charAt(i)=='-') {res=(double)op1-op2;}
			
				s.push((double)res);
				
				
			}
			else if(expression.charAt(i)!=' ') {
				throw new IllegalArgumentException("the expression is not valid the expression should be with a single space separator  and numeric(integers) ");
			}
		i++;
		}
		double ans =(double) s.pop();
		if(!s.isEmpty()) {
			throw new IllegalArgumentException("the expression is not valid the expression should be with a single space separator  and numeric(integers) ");
			}
		return  (int)ans;
	}
	
}
