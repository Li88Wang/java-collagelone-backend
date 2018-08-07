package com.lonedog.platform.common.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class ApplicationContextUtils {

	private ApplicationContextUtils(){}
	private static  ApplicationContext context;
	
	public static <T> T getBean(Class<T> clazz){
		return  context.getBean(clazz);
	}
	
	public static Object getBean(String name){
		return  context.getBean(name);
	}
	public static class ContextBean implements ApplicationContextAware {		
		@Override
		public void setApplicationContext(ApplicationContext applicationContext)
				throws BeansException {
			if(context==null){
				context=applicationContext;		
			} 
			
		}
	}
}