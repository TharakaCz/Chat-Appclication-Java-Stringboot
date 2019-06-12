/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.GroupChat;

/**
 * @author Tharaka Chandralal
 */
public interface GroupChatDao extends CrudRepository<GroupChat, String>{

	GroupChat findOneByGroupIdAndStatus(String groupId,String status);
	
	List<GroupChat> findAllByGroupIdAndStatus(String groupId,String status);
}
