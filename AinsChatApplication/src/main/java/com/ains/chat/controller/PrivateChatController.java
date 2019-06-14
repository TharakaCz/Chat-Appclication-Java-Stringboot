/**
 * Jun 11, 2019	
 * AinsChatApplication
 * com.ains.chat.controller
 */
package com.ains.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ains.chat.helper.PrivateChatDto;
import com.ains.chat.service.PrivateChatService;


/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/ains/chat/private")
public class PrivateChatController {

	@Autowired
	private PrivateChatService privateChatService;
	
	
	@PostMapping(value="/createPrivateChat")
	public ResponseEntity<Object>createPrivateChat(@RequestBody PrivateChatDto privateChatDto){
		try {
			return new ResponseEntity<Object>(privateChatService.createPrivateChat(privateChatDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/sendPrivateChat")
	public ResponseEntity<Object>sendPrivateChat(@RequestBody PrivateChatDto privateChatDto){
		try {
			return new ResponseEntity<Object>(privateChatService.sendPrivateChat(privateChatDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/editPrivateChat")
	public ResponseEntity<Object>editPrivateChat(@RequestBody PrivateChatDto privateChatDto){
		try {
			return new ResponseEntity<Object>(privateChatService.editPrivateChat(privateChatDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deletePrivateChat/{privateChatId}")
	public ResponseEntity<Object>deletePrivateChat(@PathVariable("privateChatId") String privateChatId){
		try {
			return new ResponseEntity<Object>(privateChatService.deletePrivateChat(privateChatId),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllPrivateChats/{user:.+}")
	public ResponseEntity<Object>getAllPrivateChat(@PathVariable("user")String user){
		try {
			return new ResponseEntity<Object>(privateChatService.getAllPrivateChat(user),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchPrivateChat/{privateChatId}")
	public ResponseEntity<Object>searchPrivateChat(@PathVariable("privateChatId")String privateChatId){
		try {
			return new ResponseEntity<Object>(privateChatService.searchPrivateChat(privateChatId),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
