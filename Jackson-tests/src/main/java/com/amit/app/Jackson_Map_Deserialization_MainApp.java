package com.amit.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.amit.app.models.ClassWithAMap;
import com.amit.app.models.MyPair;
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
		
		
//		=======================================================
//		Deserialize the json data into Map<MyPair, String>
		
		ObjectMapper objectMapper_2 = new ObjectMapper();
		String jsonInput = "{\"map\": {\"Amit and Patil\":\"Employee\", \"Amit and Patil\":\"Employee\"}, \"anotherAttribute\": \"someValue\"}";
		
		ClassWithAMap classWithAMap = objectMapper_2.readValue(jsonInput, ClassWithAMap.class);
		System.out.println("classWithAMap toString value: " + classWithAMap);
		
		
		
//		Deserailize the json data into Map<Maypair, MyPair>
		
		ObjectMapper objectMapper_3 = new ObjectMapper();
		Map<MyPair, MyPair> map_3;
		String jsonInput_2 = "{\"Amit and Patil\": \"Employee and verygood\"}";
		TypeReference<HashMap<MyPair, MyPair>> typeReference_3 = new TypeReference<HashMap<MyPair,MyPair>>() {};
		
		map_3 = objectMapper_3.readValue(jsonInput_2, typeReference_3);
		System.out.println("Map<MyPair, MyPair> toString value: " + map_3);
	}

}
