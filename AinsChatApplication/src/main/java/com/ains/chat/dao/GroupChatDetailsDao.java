/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.helper.GroupChatDetailsDto;
import com.ains.chat.model.GroupChat;
import com.ains.chat.model.GroupChatDeatails;

/**
 * @author Tharaka Chandralal
 */
public interface GroupChatDetailsDao extends CrudRepository<GroupChatDeatails, String>{

	GroupChatDeatails findOneByGroupDetailsId(String groupDetailsId);
	
	List<GroupChatDeatails> findAllByGroupChatAndStatusOrderByDateAsc(GroupChat groupChat,String status);
}
