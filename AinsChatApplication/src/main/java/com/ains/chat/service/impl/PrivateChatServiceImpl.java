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
import com.ains.chat.dao.PrivateChatDetailsDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.helper.PrivateChatDetailsDto;
import com.ains.chat.helper.PrivateChatDto;
import com.ains.chat.model.Chat;
import com.ains.chat.model.PrivateChat;
import com.ains.chat.model.PrivateChatDetails;
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
	private PrivateChatDetailsDao privateChatDetailsDao;
	
	@Autowired
	private ChatDao chatDao;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#createPrivateChat(com.ains.chat.helper.PrivateChatDto)
	 */
	@Override
	public String createPrivateChat(PrivateChatDto privateChatDto) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	
		PrivateChat privateChat = new PrivateChat();
		
		privateChat.setPrivateChatId(UUID.randomUUID().toString());
		privateChat.setDate(date);
		privateChat.setStatus(AppConstant.ACTIVE);
		privateChat.setTime(formattedDate);
		privateChat.setPrivateUserOne(privateChatDto.getPrivateUserOne());
		privateChat.setPrivateUserTwo(privateChatDto.getPrivateUserTwo());
		
		privateChatDao.save(privateChat);
		return "Private Chat Start Ok . . !";
	}
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#sendPrivateChat(com.ains.chat.helper.PrivateChatDto)
	 */
	@Override
	public String sendPrivateChat(PrivateChatDto privateChatDto) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatIdAndStatus(privateChatDto.getPrivateChatId(), AppConstant.ACTIVE);
		PrivateChatDetails privateChatDetails = new PrivateChatDetails();
		
		if (privateChat.getPrivateUserOne().equals(privateChatDto.getPrivateUserOne())&& privateChat.getPrivateUserTwo().equals(privateChatDto.getPrivateUserTwo()) ||
				privateChat.getPrivateUserTwo().equals(privateChatDto.getPrivateUserOne()) && privateChat.getPrivateUserOne().equals(privateChatDto.getPrivateUserTwo())) {
			
			privateChatDto.getPrivateChatDetailsDtos().forEach(each->{
				
				Chat chat = new Chat();
				
				chat.setChatId(UUID.randomUUID().toString());
				chat.setChatType(AppConstant.PRIVATE_CHAT);
				chat.setDate(date);
				chat.setTime(formattedDate);
				chat.setMassage(each.getChatDto().getMassage());
				chat.setStatus(AppConstant.ACTIVE);
				chat.setUserName(privateChatDto.getPrivateUserOne());
				
				privateChatDetails.setPrivateChatDetailsId(UUID.randomUUID().toString());
				privateChatDetails.setDate(date);
				privateChatDetails.setTime(formattedDate);
				privateChatDetails.setStatus(AppConstant.ACTIVE);
				privateChatDetails.setChat(chat);
				privateChatDetails.setPrivateChat(privateChat);
				privateChatDetails.setUserName(privateChatDto.getPrivateUserOne());
				
			});
			
			privateChatDetailsDao.save(privateChatDetails);
			
			return "Private Chat Send Succsess . . !";
		}else {
			
			return "Un Authorized . . !";
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#editPrivateChat(com.ains.chat.helper.PrivateChatDto)
	 */
	@Override
	public String editPrivateChat(PrivateChatDto privateChatDto) throws Exception {
		
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatIdAndStatus(privateChatDto.getPrivateChatId(), AppConstant.ACTIVE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		
		PrivateChatDetails privateChatDetails = new PrivateChatDetails();
		
		privateChatDto.getPrivateChatDetailsDtos().forEach(each->{
			Chat chat = chatDao.findOneByChatId(each.getChatDto().getChatId());
			chat.setMassage(each.getChatDto().getMassage());
			chat.setTime(formattedDate);
			chat.setDate(date);
			privateChatDetails.setChat(chat);
			
		});
		privateChatDetailsDao.save(privateChatDetails);
		
		return "Chat Edited Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#deletePrivateChat(java.lang.String)
	 */
	@Override
	public String deletePrivateChat(String privateChatId) throws Exception {
		
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatIdAndStatus(privateChatId, AppConstant.ACTIVE);
		
		privateChat.setStatus(AppConstant.DEACTIVE);
		if (privateChat != null) {
			privateChatDao.save(privateChat);
			return "Chat Succsessfully Deleted . . !";
		}else {
			return "Chat Delete Faild Pleace Try Again . . !";
		}
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#searchPrivateChat(java.lang.String)
	 */
	@Override
	public PrivateChatDto searchPrivateChat(String privateChatId) throws Exception {
		
		PrivateChat privateChat = privateChatDao.findOneByPrivateChatIdAndStatus(privateChatId, AppConstant.ACTIVE);
		PrivateChatDto privateChatDto = getPrivateChat(privateChat);
		return privateChatDto;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.PrivateChatService#getAllPrivateChat(java.lang.String, java.lang.String)
	 */
	@Override
	public List<PrivateChatDto> getAllPrivateChat(String user) throws Exception {
		
		List<PrivateChat>privateChats = privateChatDao.findAllByPrivateUserOneOrPrivateUserTwoAndStatus(user, user, AppConstant.ACTIVE);
		ArrayList<PrivateChatDto>privateChatDtos = new ArrayList<>();
		
		privateChats.forEach(each->{
			try {
				privateChatDtos.add(getPrivateChatList(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
	return privateChatDtos;
		
	}

	
	private PrivateChatDto getPrivateChatList(PrivateChat privateChat)throws Exception{
		
		PrivateChatDto privateChatDto = new  PrivateChatDto();
		
		privateChatDto.setPrivateChatId(privateChat.getPrivateChatId());
		privateChatDto.setDate(privateChat.getDate());
		privateChatDto.setPrivateUserOne(privateChat.getPrivateUserOne());
		privateChatDto.setPrivateUserTwo(privateChat.getPrivateUserTwo());
		privateChatDto.setStatus(privateChat.getStatus());
		privateChatDto.setTime(privateChat.getTime());
		
		return privateChatDto;
	}
	

	private PrivateChatDto getPrivateChat(PrivateChat privateChat)throws Exception{
		
		PrivateChatDto privateChatDto = new  PrivateChatDto();
		ArrayList<PrivateChatDetailsDto>privateChatDetailsDtos = new ArrayList<>();
		
		privateChatDto.setPrivateChatId(privateChat.getPrivateChatId());
		privateChatDto.setDate(privateChat.getDate());
		privateChatDto.setPrivateUserOne(privateChat.getPrivateUserOne());
		privateChatDto.setPrivateUserTwo(privateChat.getPrivateUserTwo());
		privateChatDto.setStatus(privateChat.getStatus());
		privateChatDto.setTime(privateChat.getTime());
		
		privateChat.getPrivateChatDetails().forEach(each->{
			try {
				System.out.println("each");
				privateChatDetailsDtos.add(getPrivateChatDetails(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		privateChatDto.setPrivateChatDetailsDtos(privateChatDetailsDtos);
		
		return privateChatDto;
	}
	
	private PrivateChatDetailsDto getPrivateChatDetails(PrivateChatDetails privateChatDetails)throws Exception{
		
		PrivateChatDetailsDto privateChatDetailsDto = new PrivateChatDetailsDto();
		
		Chat chat = chatDao.findOneByChatId(privateChatDetails.getChat().getChatId());
		ChatDto chatDto = new ChatDto();
		
		chatDto.setChatId(chat.getChatId());
		chatDto.setChatType(chat.getChatType());
		chatDto.setMassage(chat.getMassage());
		chatDto.setDate(chat.getDate());
		chatDto.setTime(chat.getTime());
		chatDto.setUserName(chat.getUserName());
		
		privateChatDetailsDto.setPrivateChatDetailsId(privateChatDetails.getPrivateChatDetailsId());
		privateChatDetailsDto.setDate(privateChatDetails.getDate());
		privateChatDetailsDto.setTime(privateChatDetails.getTime());
		privateChatDetailsDto.setUserName(privateChatDetails.getUserName());
		privateChatDetailsDto.setChatDto(chatDto);
		
		return privateChatDetailsDto;
		
	}
}

