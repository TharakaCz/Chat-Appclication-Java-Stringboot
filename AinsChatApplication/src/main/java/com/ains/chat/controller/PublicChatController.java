/**
 * Jun 10, 2019	
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

import com.ains.chat.helper.PublicChatDto;
import com.ains.chat.service.PublicChatService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/ains/chat/public")
public class PublicChatController {

	@Autowired
	private PublicChatService publicChatService;
	
	@PostMapping(value="/sendPublicChat")
	public ResponseEntity<Object>sendPublicChat(@RequestBody PublicChatDto publicChatDto){
		try {
			return new ResponseEntity<Object>(publicChatService.sendChat(publicChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/editPublicChat")
	public ResponseEntity<Object>editPublicChat(@RequestBody PublicChatDto publicChatDto){
		try {
			return new ResponseEntity<Object>(publicChatService.editChat(publicChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deletePublicChat/{publicChatId}")
	public ResponseEntity<Object>deletePublicChat(@PathVariable("publicChatId") String publicChatId){
		try {
			return new ResponseEntity<Object>(publicChatService.deleteChat(publicChatId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllPublicChat")
	public ResponseEntity<Object>getAllPublicChat(){
		try {
			return new ResponseEntity<Object>(publicChatService.getAllPublicChat(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchPublicChat/{publicChatId}")
	public ResponseEntity<Object>searchPublicChat(@PathVariable("publicChatId") String publicChatId){
		try {
			return new ResponseEntity<Object>(publicChatService.searchChat(publicChatId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
