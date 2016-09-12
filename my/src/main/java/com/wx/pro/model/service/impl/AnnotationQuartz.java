package com.wx.pro.model.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnnotationQuartz {
	
	@Scheduled(cron="0/5 * *  * * ? ")//每5秒执行一次
	public void testSch(){
		System.out.println("哈哈哈哈哈**********************");
	}
}
