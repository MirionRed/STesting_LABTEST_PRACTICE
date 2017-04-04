package practice.stubmock;

import java.util.ArrayList;

interface iFileReaderClass{
	public int getNumberFromFile();
}
class OriginalFileReaderClass implements iFileReaderClass{
	public int getNumberFromFile(){
		int numberToReturn = 10;
		return numberToReturn;
	}
}
class StubFileReaderClass implements iFileReaderClass{
	int [] intArray;
	int count = 0;
	public StubFileReaderClass(int [] intArray){
		this.intArray = intArray;
	}
	public int getNumberFromFile(){
		return intArray[count++];
	}
	public void countReset(){
		count = 0;
	}
}


interface iFileWriterClass{
	public void writeDataToFile(int dataToWrite);
}
class OriginalFileWriterClass implements iFileWriterClass{
	public void writeDataToFile(int dataToWrite){
		
	}
}
class MockFileWriterClass implements iFileWriterClass{
	ArrayList<Integer>arrayInt;
	public MockFileWriterClass(){
		arrayInt = new ArrayList<Integer>();
	}
	public void writeDataToFile(int dataToWrite){
		arrayInt.add(dataToWrite);
	}
	public int[] getArrayInt(){
		int[]returnInt = new int[arrayInt.size()];
		for (int i = 0; i < arrayInt.size(); i++){
			//System.out.println(arrayInt.get(i));
			returnInt[i] = arrayInt.get(i);
		}
		return returnInt;
	}
}

public class NewSampleClass {
	iFileReaderClass frc;
	iFileWriterClass fwc;
	public NewSampleClass(iFileReaderClass frc, iFileWriterClass fwc){
		this.frc = frc;
		this.fwc = fwc;
	}
	
	public void sampleMethod(){
		int[]numsFromFile = new int [5];
		for(int i = 0; i<5; i++)
			numsFromFile[i] = frc.getNumberFromFile();
		
		for(int i = 0; i<5; i++)
			fwc.writeDataToFile(numsFromFile[i]);
	}
}
