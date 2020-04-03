package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stackTest {

	@Test
	void test() {

	stack s =new stack();
	s.push(1);
	s.push(2);
	assertEquals(s.pop(),2);
	
	assertEquals(s.pop(),1);
	assertEquals(s.isEmpty(),true);
	
	s.push(3);
	s.push(7);
	s.push(999);
	assertEquals(s.size(),3);
	
	assertEquals(s.isEmpty(),false);
  
	
	assertEquals(s.pop(),999);
	
	s.push(null);
	
	assertEquals(s.pop(),null);

	assertEquals(s.size(),2);


	
	
	}
	
	
	@Test
	void test1() {
	stack s =new stack();
		Exception e = assertThrows(IllegalArgumentException.class, () -> {s.pop();});
	
		String st = "Stack is empty.";
	    String str = e.getMessage();
	    assertTrue(str.contains(st));
	

	    
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {s.peek();});
		
		String st2 = "Stack is empty.";
	    String str2 = e2.getMessage();
	    assertTrue(str2.contains(st2));
	
	
	
	
	
	}
}
