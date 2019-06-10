/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.service
 */
package com.ains.chat.service;

import java.util.List;

import com.ains.chat.helper.PublicChatDto;

/**
 * @author Tharaka Chandralal
 */
public interface PublicChatService {

	public String sendChat(PublicChatDto publicChatDto)throws Exception;
	
	public String editChat(PublicChatDto publicChatDto)throws Exception;
	
	public String deleteChat(String publicChatId)throws Exception;
	
	public PublicChatDto searchChat(String publicChatId)throws Exception;
	
	public List<PublicChatDto>getAllPublicChat()throws Exception;
}
