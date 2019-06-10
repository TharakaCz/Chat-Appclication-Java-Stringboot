/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.service.impl
 */
package com.ains.chat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ains.chat.dao.ChatDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.service.ChatService;

/**
 * @author Tharaka Chandralal
 */
@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDao chatDao;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#sendMassage(com.ains.chat.helper.ChatDto)
	 */
	@Override
	public String sendMassage(ChatDto chatDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#deleteMassage(java.lang.String)
	 */
	@Override
	public String deleteMassage(String chatId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#editMassage(com.ains.chat.helper.ChatDto)
	 */
	@Override
	public String editMassage(ChatDto chatDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#getAllMassageUsingType()
	 */
	@Override
	public List<ChatDto> getAllMassageUsingType() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#getAllMassage()
	 */
	@Override
	public List<ChatDto> getAllMassage() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
