package com.amit.app.tracing.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
*
* @author Amit Patil
*
* @apiNote
* You can also register the InstantiationTracingBeanPostProcessor programatically using
* ConfigurableBeanFactory by using the addBeanPostProcessor method,
* This can be useful when you need to evaluate conditional logic before registration
**/
@Configuration
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

//	Simply return the instantiated bean without any customization on it.
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

//	add Logging tracing about the Instantiation of each bean from IOC container.
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '"+ beanName +"' created: " + bean.toString());
		return bean;
	}
}
