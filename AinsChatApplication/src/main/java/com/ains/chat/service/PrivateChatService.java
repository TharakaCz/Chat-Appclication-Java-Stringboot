/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.service
 */
package com.ains.chat.service;

import java.util.List;

import com.ains.chat.helper.PrivateChatDto;

/**
 * @author Tharaka Chandralal
 */
public interface PrivateChatService {

	public String sendPrivateChat(PrivateChatDto privateChatDto)throws Exception;
	
	public String editPrivateChat(PrivateChatDto privateChatDto)throws Exception;
	
	public String deletePrivateChat(String privateChatId)throws Exception;
	
	public PrivateChatDto searchPrivateChat(String privateChatId)throws Exception;
	
	public List<PrivateChatDto>getAllPrivateChat(String uone,String utwo)throws Exception;

}
