package practice.spy;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class SampleClassTest {
	@Test 
	public void testSampleMethod(){
		FileReaderClass frc = new FileReaderClass();
		FileWriterClass fwc = new FileWriterClass();
		FileReaderClass readSpy = spy(frc);
		FileWriterClass writeSpy = spy(fwc);
		
		when(readSpy.getNumberFromFile()).thenReturn(100);
		when(readSpy.someTest()).thenReturn(100);
		
		SampleClass sc = new SampleClass(readSpy, writeSpy);
		sc.sampleMethod();
		frc.someTest();
		
		verify(writeSpy, times(5)).writeDataToFile(100);
	}
}
