/**
 * Jun 13, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.PrivateChat;
import com.ains.chat.model.PrivateChatDetails;

/**
 * @author Tharaka Chandralal
 */
public interface PrivateChatDetailsDao extends CrudRepository<PrivateChatDetails, String>{

	List<PrivateChatDetails>findAllByPrivateChatAndStatusOrderByDateAsc(PrivateChat privateChat,String status);
	
	PrivateChatDetails findOneByPrivateChatDetailsIdAndStatus(String privateChatDetailsId,String status);
}
