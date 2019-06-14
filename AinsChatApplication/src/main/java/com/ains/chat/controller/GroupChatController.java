/**
 * Jun 12, 2019	
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

import com.ains.chat.helper.GroupChatDto;
import com.ains.chat.service.GroupChatService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/ains/chat/group")
public class GroupChatController {

	@Autowired
	private GroupChatService groupChatService;
	
	@PostMapping(value="/createGroup")
	public ResponseEntity<Object>createGroup(@RequestBody GroupChatDto groupChatDto){
		try {
			return new ResponseEntity<Object>(groupChatService.createGroup(groupChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addMembers")
	public ResponseEntity<Object>addMembers(@RequestBody GroupChatDto groupChatDto){
		try {
			return new ResponseEntity<Object>(groupChatService.addMembers(groupChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}    
	}
	
	@DeleteMapping(value="/deleteGroup/{groupId}/{memberName:.+}")
	public ResponseEntity<Object>deleteGroup(@PathVariable("groupId")String groupId, @PathVariable("memberName")String memberName){
		try {
			return new ResponseEntity<Object>(groupChatService.deleteGroup(groupId, memberName),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/removeUser/{groupId}/{memberName:.+}/{userId}")
	public ResponseEntity<Object>removeUser(@PathVariable("groupId")String groupId,@PathVariable("memberName")String memberName,@PathVariable("userId")String userId){
		try {
			return new ResponseEntity<Object>(groupChatService.removeUser( groupId,memberName,userId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/sendGroupChat")
	public ResponseEntity<Object>sendGroupChat(@RequestBody GroupChatDto groupChatDto){
		try {
			return new ResponseEntity<Object>(groupChatService.sendGroupChat(groupChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllGroupChat/{groupId}/{memberName:.+}")
	public ResponseEntity<Object>getAllGroupChat(@PathVariable("groupId")String groupId, @PathVariable("memberName")String memberName){
		try {
			return new ResponseEntity<Object>(groupChatService.getAllGroupChat(groupId, memberName),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllGroups/{memberName:.+}")
	public ResponseEntity<Object>getAllGroupsByMember(@PathVariable("memberName") String memberName){
		try {
			return new ResponseEntity<Object>(groupChatService.getAllGroupsNames(memberName),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchGroupChat/{groupId}")
	public ResponseEntity<Object>searchGroupChat(@PathVariable("groupId")String groupId){
		try {
			return new ResponseEntity<Object>(groupChatService.searchGroupChat(groupId),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/editGroupChat")
	public ResponseEntity<Object>editChat(@RequestBody GroupChatDto groupChatDto){
		try {
			return new ResponseEntity<Object>(groupChatService.editChat(groupChatDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
