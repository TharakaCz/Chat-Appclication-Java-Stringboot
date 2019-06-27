/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.service.impl
 */
package com.ains.chat.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ains.chat.dao.ChatDao;
import com.ains.chat.dao.PublicChatDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.helper.PublicChatDto;
import com.ains.chat.model.Chat;
import com.ains.chat.model.PublicChat;
import com.ains.chat.service.PublicChatService;
import com.ains.chat.utill.AppConstant;

/**
 * @author Tharaka Chandralal
 */
@Service
public class PublicChatServiceImpl implements PublicChatService{

	@Autowired
	private PublicChatDao publicChatDao;
	
	@Autowired
	private ChatDao chatDao;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.PublicChatService#sendChat(com.ains.chat.helper.PublicChatDto)
	 */
	@Override
	public String sendChat(PublicChatDto publicChatDto) throws Exception {
		
		PublicChat publicChat = new PublicChat();
		
		
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
	    Chat chat = new Chat();
	    chat.setChatId(UUID.randomUUID().toString());
	    chat.setChatType(AppConstant.PUBLIC_CHAT);
	    chat.setDate(new Date());
	    chat.setMassage(publicChatDto.getChatDto().getMassage());
	    chat.setStatus(AppConstant.ACTIVE);
	    chat.setTime(formattedDate);
	    chat.setUserName(publicChatDto.getChatDto().getUserName());
	    
		publicChat.setPublicChatId(UUID.randomUUID().toString());
		publicChat.setStatus(AppConstant.ACTIVE);
		publicChat.setTime(formattedDate);
		publicChat.setDate(new Date());
		publicChat.setChat(chatDao.save(chat));
		
		publicChatDao.save(publicChat);
		
		return "Massege Send Succsess";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PublicChatService#editChat(com.ains.chat.helper.PublicChatDto)
	 */
	@Override
	public String editChat(PublicChatDto publicChatDto) throws Exception {
		
		
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
	    Chat chat = chatDao.findByChatIdAndStatusOrderByDateAsc(publicChatDto.getChatDto().getChatId(),AppConstant.ACTIVE);
	    chat.setDate(new Date());
	    chat.setTime(formattedDate);
	    chat.setMassage(publicChatDto.getChatDto().getMassage());
	  
	    PublicChat publicChat = publicChatDao.findOneByPublicChatId(publicChatDto.getPublicChatId());
	    publicChat.setDate(new Date());
	    publicChat.setTime(formattedDate);
		publicChat.setChat(chatDao.save(chat));
		publicChatDao.save(publicChat);
		
		return "Massage Edit Succsessfully . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PublicChatService#deleteChat(java.lang.String)
	 */
	@Override
	public String deleteChat(String publicChatId) throws Exception {
		
		PublicChat publicChat = publicChatDao.findOneByPublicChatId(publicChatId);
		Chat chat = chatDao.findByChatIdAndStatusOrderByDateAsc(publicChat.getChat().getChatId(),AppConstant.ACTIVE);
		
		chat.setStatus(AppConstant.DEACTIVE);
		publicChat.setStatus(AppConstant.DEACTIVE);
		
		if (publicChat != null) {
			publicChatDao.save(publicChat);
			chatDao.save(chat);
			
			return "Massage Delete Succsess . . !";
		}else {
			return "Massage Deletetion Faild Try Again . . !";
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.PublicChatService#getAllPublicChat()
	 */
	@Override
	public List<PublicChatDto> getAllPublicChat() throws Exception {
		
		List<PublicChat>publicChats = publicChatDao.findAllByStatusOrderByDateAsc(AppConstant.ACTIVE);
		ArrayList<PublicChatDto>publicChatDtos = new ArrayList<>();
		
		publicChats.forEach(each->{
			try {
				publicChatDtos.add(getPublicChat(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return publicChatDtos;
	}
	
	

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PublicChatService#searchChat(java.lang.String)
	 */
	@Override
	public PublicChatDto searchChat(String publicChatId) throws Exception {
		
		PublicChat publicChat = publicChatDao.findOneByPublicChatId(publicChatId);
		
		PublicChatDto publicChatDto = getPublicChat(publicChat);
		
		return publicChatDto;
	}
	
	private PublicChatDto getPublicChat(PublicChat publicChat)throws Exception{
		
		PublicChatDto publicChatDto = new PublicChatDto();
		Chat chat = chatDao.findByChatIdAndStatusOrderByDateAsc(publicChat.getChat().getChatId(),AppConstant.ACTIVE);
		ChatDto chatDto = new ChatDto();
		
		chatDto.setChatId(chat.getChatId());
		chatDto.setUserName(chat.getUserName());
		chatDto.setMassage(chat.getMassage());
		chatDto.setDate(chat.getDate());
		chatDto.setTime(chat.getTime());
		
		publicChatDto.setPublicChatId(publicChat.getPublicChatId());
		publicChatDto.setDate(publicChat.getDate());
		publicChatDto.setChatDto(chatDto);
		publicChatDto.setTime(publicChat.getTime());
		
		return publicChatDto;
	}
}
