/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.Chat;

/**
 * @author Tharaka Chandralal
 */
public interface ChatDao extends CrudRepository<Chat, String>{

	Chat findOneByChatIdAndStatus(String chatId,String status);
	
	List<Chat> findAllByStatus(String status);
	List<Chat> findAllByChatTypeAndStatus(String chatType,String status);
	
}
