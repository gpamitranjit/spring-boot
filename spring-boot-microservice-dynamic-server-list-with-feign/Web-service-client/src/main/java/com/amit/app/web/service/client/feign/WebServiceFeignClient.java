package com.amit.app.web.service.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("zuul-api-gateway")
public interface WebServiceFeignClient {

	@RequestMapping(path = "/web-service/v1.0/greeting/{userName}")
	public String greeting(@PathVariable("userName") String userName);
}
