package practice.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class NewRandomAddNumbersTest {
	
	@Test 
	public void testAddTwoNumberMockito(){
		RandomNumberFunctionality rnMock = mock(RandomNumberFunctionality.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(5);
		
		NewRandomAddNumbers nr1 = new NewRandomAddNumbers(rnMock);
		
		int result = nr1.addTwoNumbers(3);
		assertEquals(8, result);
	}
	
	@Test
	public void testAddTwoNumbersWithoutInterface(){
		RandomGeneratorClass rnMock = mock(RandomGeneratorClass.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(5);
		
		RandomAddNumbers nr1 = new RandomAddNumbers(rnMock);
		int result = nr1.addTwoNumbers(3);
		assertEquals(8,result);
		
	}
	
}
