/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.controller
 */
package com.ains.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value="/getAllChatTypes")
	public ResponseEntity<Object>getAllChatTypes(){
		try {
			return new ResponseEntity<Object>(chatService.getAllChatTypes(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllMassage")
	public ResponseEntity<Object>getAllMassage(){
		try {
			return new ResponseEntity<Object>(chatService.getAllMassage(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getMassageUsingTypes/{chatType}")
	public ResponseEntity<Object>getAllMassageUsingType(@PathVariable("chatType")String chatTypes){
		try {
			return new ResponseEntity<Object>(chatService.getAllMassageUsingType(chatTypes),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/validDays")
	public ResponseEntity<Object>validDays(){
		try {
			return new ResponseEntity<Object>(chatService.removeChats(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
