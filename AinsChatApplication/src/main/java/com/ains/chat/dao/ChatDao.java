/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;


import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.Chat;

/**
 * @author Tharaka Chandralal
 */
public interface ChatDao extends CrudRepository<Chat, String>{

	Chat findOneByChatId(String chatId);
}
