/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.service
 */
package com.ains.chat.service;

import java.util.List;

import com.ains.chat.helper.GroupChatDetailsDto;
import com.ains.chat.helper.GroupChatDto;
import com.ains.chat.helper.MembersDto;
import com.ains.chat.model.Members;

/**
 * @author Tharaka Chandralal
 */
public interface GroupChatService {

	public String createGroup(GroupChatDto groupChatDto)throws Exception;
	
	public String addMembers(GroupChatDto groupChatDto)throws Exception;
	
	public String deleteGroup(String groupId,String memberName)throws Exception;
	
	public String removeUser(String groupId,String memberName,String userId)throws Exception;
	
	public String sendGroupChat(GroupChatDto groupChatDto)throws Exception;
	
	public List<GroupChatDto> getAllGroupsNames(String membersName)throws Exception;
	
	public List<GroupChatDto>getAllGroupChat(String groupId,String memberName)throws Exception;
	
	public String editGroupName(GroupChatDto groupChatDto,String memberName)throws Exception;
	
	public String editChat(GroupChatDto groupChatDto)throws Exception;
	
	public GroupChatDto searchGroupChat(String groupId)throws Exception;
	
	public String promoteMember(String memberId)throws Exception;
	
	public List<MembersDto>getAllMembers(String groupId)throws Exception; 
	
	public List<GroupChatDetailsDto>loardAllGroupChat(String groupId)throws Exception;
}
