package com.amit.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
*
* @author Amit Patil
*
**/
public class Jackson_Map_Deserialization_MainApp {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
//		Deserialize the Map<String, String> using jackson library
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map;
		
		String jsonData = "{\"key\": \"value\", \"key2\": \"value2\"}";
		
		TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String,String>>() {};
		
		map = objectMapper.readValue(jsonData, typeReference);
		
//		print the map toString vlaue
		System.out.println("map: " + map);
	}

}
