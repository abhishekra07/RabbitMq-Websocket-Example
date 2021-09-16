package com.rabbitmq.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.dto.DeviceStatus;
import com.rabbitmq.util.Constants;

@RestController
@RequestMapping("/api/v1/publish")
public class MessagePublisher {

	@Autowired
    private RabbitTemplate template;
	
	@GetMapping("/")
	public String publish() {
		DeviceStatus status = new DeviceStatus();
		status.setDeviceStatus("Online");
		status.setProductType("ESRS-VE");
		status.setSerialNumber(UUID.randomUUID().toString().substring(0,15));
		template.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, status);
		return "Message is published";
	}
}
