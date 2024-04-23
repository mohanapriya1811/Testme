package utils;
import com.github.miachm.sods.Sheet;
import com.github.miachm.sods.SpreadSheet;
import com.github.miachm.sods.Range;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
public class ReadExcelData {

	public static Object[][] readData(String fileName, String sheetName) throws IOException, InterruptedException{
		SpreadSheet spread = new SpreadSheet(new File("./data/" + fileName + ".ods"));
		Sheet sheet = spread.getSheet(sheetName);
		int row = sheet.getMaxRows();
		//System.out.println(row);
		int col = sheet.getMaxColumns();
		
		Object[][] data = new Object[row-1][1];
		Range range = sheet.getDataRange();
		Map<Object, Object> map;
		for(int i = 1; i<row; i++) {
			 map = new HashMap<>();
			for(int j = 0; j<col; j++) {
				//data[i-1][j] = range.getCell(i, j).getValue().toString();

				String key = range.getCell(0, j).getValue().toString();
				String value = range.getCell(i, j).getValue().toString();
				map.put(key, value);
			}
			data[i-1][0] = map;
		//System.out.println(data[i-1][0]);
		}
		
		return data;
	}
	
	
	
}

