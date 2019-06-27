/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.PublicChat;

/**
 * @author Tharaka Chandralal
 */
public interface PublicChatDao extends CrudRepository<PublicChat, String>{

	PublicChat findOneByPublicChatId(String publicChatId);
	
	List<PublicChat> findAllByStatusOrderByDateAsc(String status);
}
