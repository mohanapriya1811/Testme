package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class DataUsingCsv {

	public static Object[][] getData() throws IOException {
		FileReader reader = new FileReader("./data/ReadDataCsv.csv");

		CSVReader csv = new CSVReader(reader);
		
		List<String[]> stringArray = csv.readAll();
		
		int length = stringArray.size();
		
		Object[][] data = new Object[length - 1][1];
		Map<Object, Object> map;
		
		for (int i = 1; i < length; i++) {
			String[] arr = stringArray.get(i);
			String[] header = stringArray.get(0);
			map = new HashMap<>();
			for (int j = 0; j < arr.length; j++) {
				map.put(header[j], arr[j]);
				//System.out.println(map);
			}
			data[i - 1][0] = map;
			System.out.println(data[i - 1][0]);
		}
		return data;
	}
	
	  public static void main(String[] args) throws IOException { getData(); }
	 
}
