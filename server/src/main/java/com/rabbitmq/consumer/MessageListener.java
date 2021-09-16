package com.rabbitmq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	
	@Autowired
	private SimpMessagingTemplate template;
	
//	@RabbitListener(queues = Constants.QUEUE)
//	public void consumeMessageFromQueue(DeviceStatus status) {
//		System.out.println("Message received from queue : " + status);
//		try {
//			template.convertAndSend("/topic/status", status);
//		} catch (Exception e) {
//			System.out.println("exception received!! " + e.getMessage());
//		}
//	}
}
