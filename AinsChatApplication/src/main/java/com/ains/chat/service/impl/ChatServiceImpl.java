/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.service.impl
 */
package com.ains.chat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ains.chat.dao.ChatDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.model.Chat;
import com.ains.chat.model.PrivateChat;
import com.ains.chat.service.ChatService;
import com.ains.chat.utill.AppConstant;

/**
 * @author Tharaka Chandralal
 */
@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDao chatDao;
	
	@Value("${app.data.hour}")
	private String dataHouers;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#deleteMassage(java.lang.String)
	 */
	@Override
	public String deleteMassage(String chatId) throws Exception {
		
		Chat chat = chatDao.findOneByChatIdAndStatus(chatId,AppConstant.ACTIVE);
		chat.setStatus(AppConstant.DEACTIVE);
		if (chat !=null) {
			chatDao.save(chat);
			return "Chat Delete Succsess . . !";
		}else {
			return "Chat Delete Error Try Again . . !";
		}
	
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#getAllMassageUsingType()
	 */
	@Override
	public List<ChatDto> getAllMassageUsingType(String chatType) throws Exception {
		
		List<Chat>chats = chatDao.findAllByChatTypeAndStatus(chatType, AppConstant.ACTIVE);
		ArrayList<ChatDto>chatDtos = new ArrayList<>();
		chats.forEach(each->{
			try {
				chatDtos.add(getChats(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return chatDtos;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#getAllMassage()
	 */
	@Override
	public List<ChatDto> getAllMassage() throws Exception {
		
		List<Chat>chats = chatDao.findAllByStatus(AppConstant.ACTIVE);
		ArrayList<ChatDto>chatDtos = new ArrayList<>();
		
		chats.forEach(each->{
			try {
				chatDtos.add(getChats(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return chatDtos;
	}

	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#getAllChatTypes()
	 */
	@Override
	public ArrayList<String> getAllChatTypes() throws Exception {
		
		ArrayList<String>chatTypes = new ArrayList<>();
		chatTypes.add(AppConstant.PRIVATE_CHAT);
		chatTypes.add(AppConstant.PUBLIC_CHAT);
		chatTypes.add(AppConstant.GROUP_CHAT);
		
		return chatTypes;
	}
	
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.ChatService#removeChats()
	 */
	@Override
	public String removeChats() throws Exception {
		
		List<Chat>chats = chatDao.findAllByStatus(AppConstant.ACTIVE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		Integer hour = Integer.parseInt(dataHouers);
		
		chats.forEach(each->{
			if (each.getDate().getHours() > hour) {
				each.setStatus(AppConstant.DEACTIVE);
				chatDao.save(each);
				System.out.println("Expierd . . !");
			}else {
				System.out.println("Valided . . !");
			}
		});
		return "Worked . . !";
	}

	private ChatDto getChats(Chat chat)throws Exception{
		ChatDto chatDto = new ChatDto();
		chatDto.setChatId(chat.getChatId());
		chatDto.setChatType(chat.getChatType());
		chatDto.setDate(chat.getDate());
		chatDto.setUserName(chat.getUserName());
		chatDto.setMassage(chat.getMassage());
		chatDto.setTime(chat.getTime());
		
		return chatDto;
	}

}
