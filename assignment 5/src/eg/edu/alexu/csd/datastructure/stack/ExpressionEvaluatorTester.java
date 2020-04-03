package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTester {

	@Test
	void test() {
		ExpressionEvaluator l =new ExpressionEvaluator();
		
		
		
		assertEquals(l.infixToPostfix("2+3*4"),"2 3 4 * +");
		
		assertEquals(l.infixToPostfix("a*b+5"),"a b * 5 +");
		assertEquals(l.infixToPostfix("(1+2)*7"),"1 2 + 7 *");
		assertEquals(l.infixToPostfix("(a / (b - c + d)) * (e - a) * c"),"a b c - d + / e a - * c *");
		assertEquals(l.infixToPostfix("a / b - c + d * e - a * c"),"a b / c - d e * + a c * -");

		
		assertEquals(l.infixToPostfix("b"),"b");
		
		assertEquals(l.infixToPostfix("x1 + x2 - x3"),"x1 x2 + x3 -");

		assertEquals(l.infixToPostfix("-(1 +2) - - 2"),"0 1 2 + - 2 +");

		assertEquals(l.infixToPostfix("-(1 +2) + - 2"),"0 1 2 + - 2 -");

		assertEquals(l.infixToPostfix("-a+b"),"0 a - b +");

		assertEquals(l.infixToPostfix("2347829 + 86543456 *37229"),"2347829 86543456 37229 * +");
	
		
		
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {l.infixToPostfix("1 ** 2");});
		
		String st = "invalid infix expression";
	    String str = e.getMessage();
	    assertTrue(str.contains(st));

	    

		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {l.infixToPostfix("1 + * 2");});
		
	    String str2 = e2.getMessage();
	    assertTrue(str2.contains(st));
		
		

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> {l.infixToPostfix("ab + m");});
		
	    String str3 = e3.getMessage();
	    assertTrue(str3.contains(st));
		
	    
		
	}

	@Test
	void test2() {
		
		ExpressionEvaluator l =new ExpressionEvaluator();

		assertEquals(-24,l.evaluate("1 2 / 3 - 4 5 * + 6 7 * -"));
		
		assertEquals(-8,l.evaluate("12 3 5 - 67 + / 4 5 - * 45 *"));

		assertEquals(400,l.evaluate("20 40 * 2 /"));
		
		
		assertEquals(21,l.evaluate("1 2 + 7 *"));
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {l.evaluate("1 2 * *");});
		
		String st = "the expression is not valid the expression should be with a single space separator  and numeric(integers) ";
	    String str = e.getMessage();
	    assertTrue(str.contains(st));
	
	    
Exception e2 = assertThrows(IllegalArgumentException.class, () -> {l.evaluate("1 2 ");});
		
	    String str2 = e.getMessage();
	    assertTrue(str2.contains(st));
	
	    
	    
	    
	    

		assertEquals(23,l.evaluate("23"));

	}
		
		
		
		
	
	
	
	
	
}
