package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main(
      	"is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLineSplit(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

	@Test
    public void testNewDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }    

    @Test
	    public void testNegativeInput(){
	    	//RuntimeException exception = null;
	    	try{
	    		Calculator.add("2,-4,3,-5");
	    	}
	    	catch(Exception e){
	    		final String exp = "Negatives not allowed: -4,-5";
	    		assertEquals(exp, e.getMessage());
	    	}	
    }

    @Test
    public void testNewDelimiter(){
    	assertEquals(2, Calculator.add("1001,2"));
    }
}