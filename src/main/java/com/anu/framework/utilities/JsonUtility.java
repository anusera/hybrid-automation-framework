package com.anu.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.anu.framework.constants.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {

	public static Object[][] getJsonData() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		//mapper.readValue(Constants.JSON_TESTDATA_FILE_PATH, Object[][].class);
		File file = new File(Constants.JSON_TESTDATA_FILE_PATH);
		JsonNode rootNode = mapper.readTree(file);
		//rootNode represents the entire JSON document.
		JsonNode users = rootNode.get("invalidUsers");
		//Here users is a JsonNode that represents the array of user objects under the "invalidUsers" key in the JSON file.
		
		/*JsonNode firstUser = users.get(0);
		//firstUser is a JsonNode that represents the first user object in the "invalidUsers" array.
		JsonNode usernameNode = firstUser.get("username");
		//usernameNode is a JsonNode that represents the value of the "username" key in the first user object.
		usernameNode.asText(); // This will give you the username value as a String.
		users.size()//users.size() will give you the number of user objects in the "invalidUsers" array, which is the number of rows in your Object[][] data provider.
		*/
		
		
		Object[][] data = new Object[users.size()][2]; //
		for (int i=0; i < users.size(); i++) {
			
			data[i][0] = users.get(i).get("username").asText();
			data[i][1] = users.get(i).get("password").asText();
		}
		
			return data;		
	}
	
	/*public static void main(String[] args) throws IOException {
		Object[][] data = getJsonData();
		System.out.println(Arrays.deepToString(data));
	}*/
}
