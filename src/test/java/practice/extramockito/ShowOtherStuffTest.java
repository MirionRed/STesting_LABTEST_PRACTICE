package practice.extramockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ShowOtherStuffTest {
	@Test 
	public void testSomeMethod(){
		MoreStuff msMock = mock(MoreStuff.class);
		Student stud = new Student("Peter");
		int [] intArray = {1, 3, 5, 7};
		
		when(msMock.getIntArray()).thenReturn(intArray);
		when(msMock.getStudent()).thenReturn(stud).thenReturn(new Student("Paul"));
		when(msMock.firstMethod()).thenThrow(new RuntimeException()).thenReturn(5);
		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setMoreStuff(msMock);
		
		int result = sos.someMethod();
		assertEquals(4, result);
		
		result = sos.someMethod();
		assertEquals(15,result);
	}
	
	@Test
	public void testNumTimesCalled(){
		MoreStuff msMock = mock(MoreStuff.class);
		ReturnStuff rsMock = mock(ReturnStuff.class);
		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setMoreStuff(msMock);
		sos.setReturnStuff(rsMock);
		sos.anotherMethod();
		verify(msMock, atLeastOnce()).secondMethod("Great");
		verify(msMock, atLeast(3)).secondMethod("cat");
		verify(msMock,atMost(2)).secondMethod("dog");
		verify(msMock, never()).secondMethod("bird");
		verify(msMock,never()).thirdMethod(anyString());
		
		verifyZeroInteractions(rsMock);
		
	}
	
	@Test
	public void testDemoArgumentMatchers(){
		ReturnStuff rsMock = mock(ReturnStuff.class);
		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setReturnStuff(rsMock);
		
		when(rsMock.methodWithArgs(anyInt(), anyString(), anyString())).thenReturn("something else");
		when(rsMock.methodWithArgs(anyInt(), eq("great"), anyString())).thenReturn("a");
		when(rsMock.methodWithArgs(eq(5), startsWith("cat"), anyString())).thenReturn("b");
		when(rsMock.methodWithArgs(anyInt(), contains("love"), endsWith("dog"))).thenReturn("c");
		
		sos.demoArgumentMatchers(400, "great", "wonderful");
		sos.demoArgumentMatchers(400, "great", "wonderful");
		sos.demoArgumentMatchers(5, "catnap", "sleep");
		sos.demoArgumentMatchers(-3, "loveboat", "bigdog");
		sos.demoArgumentMatchers(5, "catlove", "bigdog");
		sos.demoArgumentMatchers(2, "catnap", "anything");
		
		
	}
}
