/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

import java.util.Date;
import java.util.List;

/**
 * @author Tharaka Chandralal
 */
public class ChatDto {

	private String chatId;
	private String massage;
	private String chatType;
	private String userName;
	private Date date;
	private String time;
	private List<GroupChatDetailsDto>groupChatDetailsDtos;
	private List<PublicChatDto>publicChatDtos;
	private List<privateChatDto>privateChatDtos;
	
	public ChatDto() {
		
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<GroupChatDetailsDto> getGroupChatDetailsDtos() {
		return groupChatDetailsDtos;
	}

	public void setGroupChatDetailsDtos(List<GroupChatDetailsDto> groupChatDetailsDtos) {
		this.groupChatDetailsDtos = groupChatDetailsDtos;
	}

	public List<PublicChatDto> getPublicChatDtos() {
		return publicChatDtos;
	}

	public void setPublicChatDtos(List<PublicChatDto> publicChatDtos) {
		this.publicChatDtos = publicChatDtos;
	}

	public List<privateChatDto> getPrivateChatDtos() {
		return privateChatDtos;
	}

	public void setPrivateChatDtos(List<privateChatDto> privateChatDtos) {
		this.privateChatDtos = privateChatDtos;
	}

	
}
