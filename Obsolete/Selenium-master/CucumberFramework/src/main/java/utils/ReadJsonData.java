package utils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class ReadJsonData {
	private final static String filePath = "src/main/resources/companydetails.json";
	public static Object[][] readJsonData() throws FileNotFoundException {
		JsonParser json = new JsonParser();
		
		FileReader file = new FileReader(filePath);
		
		JsonObject jsonObject  = (JsonObject) json.parse(file);
		JsonArray jsonArray = (JsonArray) jsonObject.get("createlead");
		
		Object[][] data = new Object[jsonArray.size()][1];
		Map<Object, Object> map = new HashMap<>();
		
		for(int i = 0; i<jsonArray.size(); i++) {
			JsonObject innerObj = (JsonObject)jsonArray.get(i);
			map = new HashMap<>();
			Set<Entry<String, JsonElement>> set =innerObj.entrySet();
			for(Entry<String, JsonElement> ele:set) {
				
				String key = ele.getKey();
				String value = ele.getValue().getAsString();
				map.put(key, value);
				map.put("Username", jsonObject.get("Username").getAsString());
				map.put("Username", jsonObject.get("Password").getAsString());
			}
			data[i][0] = map;
			//System.out.print(data[i][0]);
		}
		return data;
		}
				
	
		/*
		 * public static void main(String[] args) throws FileNotFoundException {
		 * readJsonData(); }
		 */
}

