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
import com.ains.chat.dao.PrivateChatDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.helper.PrivateChatDto;
import com.ains.chat.model.Chat;
import com.ains.chat.model.PrivateChat;
import com.ains.chat.service.PrivateChatService;
import com.ains.chat.utill.AppConstant;

/**
 * @author Tharaka Chandralal
 */
@Service
public class PrivateChatServiceImpl implements PrivateChatService{

	@Autowired
	private PrivateChatDao privateChatDao;

	@Autowired
	private ChatDao chatDao;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#sendPrivateChat(com.ains.chat.helper.PrivateChatDto)
	 */
	@Override
	public String sendPrivateChat(PrivateChatDto privateChatDto) throws Exception {
		
		PrivateChat privateChat = new PrivateChat();
		Chat chat = new Chat();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
	    chat.setChatId(UUID.randomUUID().toString());
	    chat.setChatType(AppConstant.PRIVATE_CHAT);
	    chat.setDate(date);
	    chat.setMassage(privateChatDto.getChatDto().getMassage());
	    chat.setStatus(AppConstant.ACTIVE);
	    chat.setTime(formattedDate);
	    chat.setUserName(privateChatDto.getChatDto().getUserName());
	    
		privateChat.setPrivateChatId(UUID.randomUUID().toString());
		privateChat.setSenderName(privateChatDto.getChatDto().getUserName());
		privateChat.setResiverName(privateChatDto.getResiverName());
		privateChat.setDate(date);
		privateChat.setTime(formattedDate);
		privateChat.setChat(chatDao.save(chat));
		privateChat.setStatus(AppConstant.ACTIVE);
		privateChat.setUserOne(privateChatDto.getUserOne());
		privateChat.setUserTwo(privateChatDto.getUserTwo());
		privateChatDao.save(privateChat);
		
		return "Private Chat Send Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#editPrivateChat(com.ains.chat.helper.PrivateChatDto)
	 */
	@Override
	public String editPrivateChat(PrivateChatDto privateChatDto) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatId(privateChatDto.getPrivateChatId());
		Chat chat = chatDao.findOneByChatId(privateChatDto.getChatDto().getChatId());
		
		chat.setDate(date);
		chat.setMassage(privateChatDto.getChatDto().getMassage());
		chat.setTime(formattedDate);
		
		privateChat.setTime(formattedDate);
		privateChat.setDate(date);
		privateChat.setChat(chatDao.save(chat));
		privateChatDao.save(privateChat);
		return "Massage Update Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#deletePrivateChat(java.lang.String)
	 */
	@Override
	public String deletePrivateChat(String privateChatId) throws Exception {
		
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatId(privateChatId);
		Chat chat = chatDao.findOneByChatId(privateChat.getChat().getChatId());
		
		privateChat.setStatus(AppConstant.DEACTIVE);
		chat.setStatus(AppConstant.DEACTIVE);
		
		if (privateChat != null) {
			
			privateChatDao.save(privateChat);
			chatDao.save(chat);
			return "Massage Delete Succsess . . !";
		}else {
			
			return "Massage Delete Faild Pleace Try Again . . !";
		}
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#searchPrivateChat(java.lang.String)
	 */
	@Override
	public PrivateChatDto searchPrivateChat(String privateChatId) throws Exception {
		
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatId(privateChatId);
		PrivateChatDto privateChatDto = getAllPrivateChat(privateChat);
		return privateChatDto;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#getAllPrivateChat()
	 */
	@Override
	public List<PrivateChatDto> getAllPrivateChat(String uone,String utwo) throws Exception {
		List<PrivateChat>privateChats = privateChatDao.findAllByUserOneAndUserTwoAndStatus(uone, utwo, AppConstant.ACTIVE);
		ArrayList<PrivateChatDto>privateChatDtos = new ArrayList<>();
		
		privateChats.forEach(each->{
			try {
				privateChatDtos.add(getAllPrivateChat(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return privateChatDtos;
	}
	
	private PrivateChatDto getAllPrivateChat(PrivateChat privateChat)throws Exception{
		Chat chat = chatDao.findOneByChatId(privateChat.getChat().getChatId());
		ChatDto chatDto = new ChatDto();
		chatDto.setChatId(chat.getChatId());
		chatDto.setDate(chat.getDate());
		chatDto.setMassage(chat.getMassage());
		chatDto.setTime(chat.getTime());
		chatDto.setUserName(chat.getUserName());
		
		PrivateChatDto privateChatDto = new PrivateChatDto();
		privateChatDto.setPrivateChatId(privateChat.getPrivateChatId());
		privateChatDto.setDate(privateChat.getDate());
		privateChatDto.setTime(privateChat.getTime());
		privateChatDto.setChatDto(chatDto);
		
		return privateChatDto;
	}

	
}
