package com.amit.app.models;

import java.util.Map;

import com.amit.app.jackson.deserializer.MyPairDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
*
* @author Amit Patil
*
**/
public class ClassWithAMap {

	@JsonProperty("map")
	@JsonDeserialize(keyUsing = MyPairDeserializer.class)
	private Map<MyPair, String> map;
	
	@JsonProperty("anotherAttribute")
	private String anotherAttribute;

	@JsonCreator
	public ClassWithAMap(@JsonProperty("map") Map<MyPair, String> map,@JsonProperty("anotherAttribute") String anotherAttribute) {
		super();
		this.map = map;
		this.anotherAttribute = anotherAttribute;
	}

	public Map<MyPair, String> getMap() {
		return map;
	}

	public void setMap(Map<MyPair, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "ClassWithAMap [map=" + map + ", anotherAttribute=" + anotherAttribute + "]";
	}

}
