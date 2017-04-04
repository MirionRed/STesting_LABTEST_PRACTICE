
package practice.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class NewRandomFindLargestTest {
	@Test
	public void testFindLargestNumberInRandomArrayMockity(){
		ArrayGeneratorClass agc = mock(ArrayGeneratorClass.class);
		when(agc.getRandomInteger(anyInt())).thenReturn(11,12,13,14);
		
		NewRandomFindLargest nrfl = new NewRandomFindLargest(agc);
		int result = nrfl.findLargestNumberInRandomArray(6, 50);
		assertEquals(14, result);
	}
	
	@Test
	public void testFindLargestNumberInRandomArrayWithoutInterface(){
		RandomGeneratorClass rgc = mock(RandomGeneratorClass.class);
		when(rgc.getRandomInteger(anyInt())).thenReturn(21,22,23,24);
		
		RandomFindLargest rfl = new RandomFindLargest(rgc);
		int result = rfl.findLargestNumberInRandomArray(4, 60);
		assertEquals(24,result);
	}
}
