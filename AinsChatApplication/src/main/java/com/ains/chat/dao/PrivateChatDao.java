/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.PrivateChat;

import ch.qos.logback.core.status.Status;

/**
 * @author Tharaka Chandralal
 */
public interface PrivateChatDao extends CrudRepository<PrivateChat, String>{

	PrivateChat findOneByPrivateChatIdAndStatus(String privateChatId,String status);
	
	PrivateChat findOneByPrivateUserOneAndStatus(String user,String status);
	
	PrivateChat findOneByPrivateUserTwoAndStatus(String user,String status);
	
	PrivateChat findOneByPrivateUserOneAndPrivateUserTwoAndStatus(String userOne,String userTwo,String status);
	
	List<PrivateChat> findAllByPrivateUserOneAndStatus(String user,String status);
	
	List<PrivateChat> findAllByPrivateUserTwoAndStatus(String user,String status);
	
	List<PrivateChat> findAllByPrivateUserOneOrPrivateUserTwoAndStatus(String userOne,String userTwo,String status);
	
	
	
	
}
