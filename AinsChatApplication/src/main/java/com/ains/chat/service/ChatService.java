/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.service
 */
package com.ains.chat.service;

import java.util.ArrayList;
import java.util.List;

import com.ains.chat.helper.ChatDto;

/**
 * @author Tharaka Chandralal
 */
public interface ChatService {

	public String deleteMassage(String chatId)throws Exception;
	
	public List<ChatDto> getAllMassageUsingType(String chatType)throws Exception;
	
	public List<ChatDto>getAllMassage()throws Exception;
	
	public ArrayList<String> getAllChatTypes()throws Exception;
	
	public String removeChats()throws Exception;
}
