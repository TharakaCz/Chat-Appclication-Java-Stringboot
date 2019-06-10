/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.PrivateChat;

/**
 * @author Tharaka Chandralal
 */
public interface PrivateChatDao extends CrudRepository<PrivateChat, String>{

}
