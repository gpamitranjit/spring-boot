package com.amit.app;

import java.util.HashMap;
import java.util.Map;

import com.amit.app.jackson.serializer.MyPairSerializer;
import com.amit.app.models.MyPair;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

/**
*
* @author Amit Patil
*
**/
public class Jackson_Map_Serialization_MainApp {

	@JsonSerialize(keyUsing =  MyPairSerializer.class)
	private static final Map<MyPair, String> map = new HashMap<MyPair, String>();
	
	@JsonSerialize(keyUsing = MapSerializer.class)
	private static final Map<MyPair, MyPair> map2 = new HashMap<MyPair, MyPair>();
	
	@JsonSerialize(keyUsing = MyPairSerializer.class)
	private static final MyPair map2_Key = new MyPair("Amit", "Ranjit");
	
	@JsonSerialize(keyUsing = MyPairSerializer.class)
	private static final MyPair map2_value = new MyPair("Ashu", "Vaini");
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("deprecation")
		SimpleModule simpleModule = new SimpleModule("simleModule", new Version(1, 0, 0, null));
		simpleModule.addSerializer(MyPair.class, new MyPairSerializer());
		objectMapper.registerModule(simpleModule);
		
		MyPair myPair = new MyPair("Amit", "Patil");
		map.put(myPair, "good employee");
		String jsonResult = objectMapper.writerWithDefaultPrettyPrinter()
										.writeValueAsString(map);
		
		System.out.println("using custom MyPairSerializer for serializing the Map<MyPair, String>");
		System.out.println("jsonResult: " + jsonResult);
		
//		=======================================================================
		
		ObjectMapper objectMaper_map2 = new ObjectMapper();
		
		map2.put(map2_Key, map2_value);
		String jsonResult_map2 = objectMaper_map2.writerWithDefaultPrettyPrinter()
												 .writeValueAsString(map2);
		
		System.out.println("map2 jsonResult: " + jsonResult_map2);
	}
}
