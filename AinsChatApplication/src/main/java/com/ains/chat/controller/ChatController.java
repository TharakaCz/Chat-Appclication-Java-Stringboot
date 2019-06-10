/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.controller
 */
package com.ains.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ains.chat.service.ChatService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/ains/chat")
public class ChatController {

	@Autowired
	private ChatService chatService;
}
