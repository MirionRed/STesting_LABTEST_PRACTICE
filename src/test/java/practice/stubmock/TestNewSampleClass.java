package practice.stubmock;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class TestNewSampleClass{
	NewSampleClass nsc;
	@Test
	public void TestNewSampleClass(){
		StubFileReaderClass stub = new StubFileReaderClass(new int []{1,2,3,4,5});
		MockFileWriterClass mock = new MockFileWriterClass();
		nsc = new NewSampleClass(stub, mock);
		stub.countReset();
		nsc.sampleMethod();
		int [] expectedResult = new int []{1,2,3,4,5};
		int [] result = mock.getArrayInt();
		
		assertArrayEquals(expectedResult, result);
	}
	
	
}

@RunWith(value = Suite.class)
@SuiteClasses(value = {TestNewSampleClass.class})
class DemoTestSuite{
	
}
