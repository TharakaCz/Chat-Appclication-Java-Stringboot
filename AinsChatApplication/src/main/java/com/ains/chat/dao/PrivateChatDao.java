/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.PrivateChat;

/**
 * @author Tharaka Chandralal
 */
public interface PrivateChatDao extends CrudRepository<PrivateChat, String>{

	List<PrivateChat>findAllByStatus(String status);
	
	PrivateChat findOneByPrivateChatId(String privateChatId);
	
	List<PrivateChat>findAllByUserOneAndUserTwoAndStatus(String one,String two,String status);

}
