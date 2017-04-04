package practice.mockito;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Matchers.anyString;

@RunWith(JUnitParamsRunner.class)
public class NewWorkingWithStringsTest {
	
	@Test 
	public void Mockito(){
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		StuffFunctionality nsow = mock(StuffFunctionality.class);
		
		NewWorkingWithStrings nwws = new NewWorkingWithStrings(nsow);
		nwws.checkStringLength(strArray, 4);
		
		verify(nsow, times(2)).doOtherStuff(anyString());
	}
	
	@Test
	public void WithoutInterface(){
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		SomeOtherWork swMock = mock(SomeOtherWork.class);
		
		WorkingWithStrings nww2 = new WorkingWithStrings(swMock);
		nww2.checkStringLength(strArray, 4);
		
		verify(swMock, times(2)).doOtherStuff(anyString());
	}
	
	@Test
	public void InOrderMock(){
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		SomeOtherWork swMock = mock(SomeOtherWork.class);
		
		WorkingWithStrings ws = new WorkingWithStrings(swMock);
		ws.checkStringLength(strArray, 4);
		
		InOrder inOrder = inOrder(swMock);
		
		inOrder.verify(swMock).doOtherStuff("houses");
		inOrder.verify(swMock).doOtherStuff("elephant");
	}
	
	private Object[] getParamsForMockitoTest() {

		return new Object[] {
			new Object[] {new String[]{"cat", "houses", "dog", "elephant", "rat"}, 4, new String[]{"houses", "elephant"}},
			new Object[] {new String[]{"11", "Peter", "22"}, 3, new String[] {"Peter"}},
			new Object[] {new String[]{"11", "22"}, 10, new String[] {}}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForMockitoTest")
	public void Param (String [] strArray, int strLimit, String [] expectedResult){
		SomeOtherWork swMock = mock(SomeOtherWork.class);
		
		WorkingWithStrings ws = new WorkingWithStrings(swMock);
		ws.checkStringLength(strArray, 4);
		InOrder inOrder = inOrder(swMock);
		for (int i = 0; i < expectedResult.length; i++){
			inOrder.verify(swMock).doOtherStuff(expectedResult[i]);
		}
		
	}
}
