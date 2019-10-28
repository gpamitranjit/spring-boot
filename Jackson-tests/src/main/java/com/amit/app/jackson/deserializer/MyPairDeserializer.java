package com.amit.app.jackson.deserializer;

import java.io.IOException;

import com.amit.app.models.MyPair;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

/**
 *
 * @author Amit Patil
 *
 **/
public class MyPairDeserializer extends KeyDeserializer {

	@Override
	public MyPair deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		System.out.println("[MyPairDeserializer] processing the json-data for deseserialization");
		return new MyPair(key);
	}
}
