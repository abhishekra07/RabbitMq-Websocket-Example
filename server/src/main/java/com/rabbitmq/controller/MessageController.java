package com.rabbitmq.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.rabbitmq.dto.DeviceStatus;

@Controller
public class MessageController {

	@MessageMapping("/send-status")
    @SendTo("/topic/status")
    public DeviceStatus greeting(DeviceStatus status) throws Exception {
		System.out.println("message reveived!!");
        Thread.sleep(1000); // simulated delay
        return status;
    }
}
