/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.service
 */
package com.ains.chat.service;

import java.util.List;

import com.ains.chat.helper.ChatDto;

/**
 * @author Tharaka Chandralal
 */
public interface ChatService {

	public String sendMassage(ChatDto chatDto)throws Exception;
	
	public String deleteMassage(String chatId)throws Exception;
	
	public String editMassage(ChatDto chatDto)throws Exception;
	
	public List<ChatDto> getAllMassageUsingType()throws Exception;
	
	public List<ChatDto>getAllMassage()throws Exception;
}
