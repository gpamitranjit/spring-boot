package com.amit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
*
* Amit Patil
*
**/
@Configuration
public class AppHttpMessageBindingConfig {

//	Customize the jackson object mapper when binding the json vlaue to javaBeans!
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		jacksonConverter.setObjectMapper(jacksonObjectMapper);
		return jacksonConverter;
	}
}
