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
	
	@PostMapping(value="/sendPrivateChat")
	public ResponseEntity<Object>sendPrivateChat(@RequestBody PrivateChatDto privateChatDto){
		try {
			return new ResponseEntity<Object>(privateChatService.sendPrivateChat(privateChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updatePrivateChat")
	public ResponseEntity<Object>editPrivateMassage(@RequestBody PrivateChatDto privateChatDto){
		try {
			return new ResponseEntity<Object>(privateChatService.editPrivateChat(privateChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping(value="/deletePrivateChat/{privateChatId}")
	public ResponseEntity<Object>deletePrivateMassage(@PathVariable("privateChatId") String privateChatId){
		try {
			return new ResponseEntity<Object>(privateChatService.deletePrivateChat(privateChatId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/searchPrivateMassage/{privateChatId}")
	public ResponseEntity<Object>searchPrivateMassage(@PathVariable("privateChatId")String privateChatId){
		try {
			return new ResponseEntity<Object>(privateChatService.deletePrivateChat(privateChatId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllPrivateMassage/{one:.+}/{two:.+}")
	public ResponseEntity<Object>getPrivateMassages(@PathVariable("one")String one,@PathVariable("two")String two){
		try {
			return new ResponseEntity<Object>(privateChatService.getAllPrivateChat(one, two),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
