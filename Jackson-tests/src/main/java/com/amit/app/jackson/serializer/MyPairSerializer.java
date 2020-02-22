package com.amit.app.jackson.serializer;

import java.io.IOException;
import java.io.StringWriter;

import com.amit.app.models.MyPair;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 *
 * @author Amit Patil
 *
 **/
public class MyPairSerializer extends JsonSerializer<MyPair> {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public void serialize(MyPair value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		System.out.println("[MyPairSerializer] processing serialization process in custom serializer");
		StringWriter stringWriter = new StringWriter();
		objectMapper.writeValue(stringWriter, value);
		gen.writeFieldName(value.toString());
	}
}
